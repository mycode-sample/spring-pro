package com.sheepfly.springpro.chapter8.service;

import com.sheepfly.springpro.chapter7.entity.Singer;
import com.sheepfly.springpro.chapter7.entity.Singer_;
import com.sheepfly.springpro.chapter8.pojo.SingerSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Service
@Repository
@Transactional(rollbackFor = {Throwable.class})
public class SingerServiceImpl implements SingerService {
    private static final Logger log = LoggerFactory.getLogger(SingerServiceImpl.class);
    private static final String ALL_SINGER_NATIVE_QUERY = "select id, first_name, last_name, birth_date, version from singer";

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findByCriteriaQuery(String firstName, String lastName) {
        log.info(firstName + lastName);
        // 1.获取条件查询实例
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        // 2.创建类型化查询
        CriteriaQuery<Singer> criteriaQuery = criteriaBuilder.createQuery(Singer.class);
        // 3.调用from来生成查询用的根对象。根对象构成查询中路径表达式的基础
        Root<Singer> singerRoot = criteriaQuery.from(Singer.class);
        // 4.调用fetch方法进行关联，相当于在查询中使用left join
        singerRoot.fetch(Singer_.albums, JoinType.LEFT);
        singerRoot.fetch(Singer_.instruments, JoinType.LEFT);
        // 5.传入根对象作为结果类型，使用distinct来去重
        criteriaQuery.select(singerRoot).distinct(true);
        // 6.构建Predicate实例，并使用条件方法来增加查询时的限制条件
        Predicate predicate = criteriaBuilder.conjunction();
        if (firstName != null) {
            Predicate p = criteriaBuilder.equal(singerRoot.get(Singer_.firstName), firstName);
            // 合并条件，也可以时or或其他关键字
            predicate = criteriaBuilder.and(predicate, p);
        }
        if (lastName != null) {
            Predicate p = criteriaBuilder.equal(singerRoot.get(Singer_.lastName), lastName);
            predicate = criteriaBuilder.and(predicate, p);
        }
        // 7.Predicate构造完成后，作为where子句传给查询。
        criteriaQuery.where(predicate);
        // 8.构造查询并返回结果
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> queryAllSinger() {
        return entityManager.createNamedQuery(ALL_SINGER_NATIVE_QUERY, Singer.class).getResultList();
    }

    @Override
    public List<Singer> findAll() {
        return entityManager.createNamedQuery("Singer.findAll", Singer.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAllWithAlbum() {
        return entityManager.createNamedQuery("Singer.findAllWithAlbum", Singer.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Singer findById(long id) {
        TypedQuery<Singer> namedQuery = entityManager.createNamedQuery("Singer.findById", Singer.class);
        namedQuery.setParameter("id", id);
        return namedQuery.getSingleResult();
    }

    @Override
    public Singer save(Singer singer) {
        if (singer.getId() == null) {
            log.info("新增对象：" + singer);
            entityManager.persist(singer);
        } else {
            log.info("更新对象:" + singer);
            entityManager.merge(singer);
        }
        return singer;
    }

    @Override
    public Singer update(Singer singer) {
        return entityManager.merge(singer);
    }

    @Override
    public void delete(Singer singer) {
        Singer mergedSinger = entityManager.merge(singer);
        entityManager.remove(mergedSinger);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAllByNativeQuery() {
        String sql = "select * from singer";
        return entityManager.createNativeQuery(sql, Singer.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public void displayAllSingerSummary() {
        String query = "select s.firstName, s.lastName, a.title from Singer s " + "left join s.albums a " + "where a.releaseDate = (select max ( a2.releaseDate )" + "from Album a2 where a2.singer.id = s.id)";
        List resultList = entityManager.createQuery(query).getResultList();
        Iterator iterator = resultList.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Object[] next = (Object[]) iterator.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("value:").append(next[0]).append(",").append(next[1]).append(",").append(next[2]);
            log.info(stringBuilder.toString());
        }
        log.info(String.valueOf(resultList.size()));
    }

    @Override
    public List<SingerSummary> findAllUsePojo() {
        String jpql = "select new com.sheepfly.springpro.chapter8.pojo.SingerSummary(s.firstName, s.lastName, a.title)" + "from Singer s " + "left join s.albums a " + "where a.releaseDate = (select max (a2.releaseDate)" + "from Album a2 " + "where a2.singer.id = s.id)";
        return entityManager.createQuery(jpql, SingerSummary.class).getResultList();
    }

    @Override
    public Singer findSingerWithMaxId() {
        List<Singer> allWithAlbum = findAllWithAlbum();
        allWithAlbum.sort(Comparator.comparing(Singer::getId));
        return update(allWithAlbum.get(allWithAlbum.size() - 1));
    }
}
