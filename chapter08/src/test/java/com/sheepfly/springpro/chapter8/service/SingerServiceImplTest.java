package com.sheepfly.springpro.chapter8.service;

import com.sheepfly.springpro.chapter7.entity.Album;
import com.sheepfly.springpro.chapter7.entity.Singer;
import com.sheepfly.springpro.chapter8.pojo.SingerSummary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ContextConfiguration("classpath:jpa.xml")
@RunWith(SpringRunner.class)
public class SingerServiceImplTest {
    @Resource(name = "singerServiceImpl")
    private SingerService singerService;

    @Test
    public void testFindAll() {
        List<Singer> all = singerService.findAll();
        System.out.println(all.size());
        all.forEach(System.out::println);
    }

    @Test
    public void testFindAllWithAlbum() {
        List<Singer> allWithAlbum = singerService.findAllWithAlbum();
        allWithAlbum.forEach(System.out::println);
    }

    @Test
    public void testFindById() {
        System.out.println(singerService.findById(1));
    }

    @Test
    public void testDisplayAllSingerSummary() {
        singerService.displayAllSingerSummary();
    }

    @Test
    public void testFindAllUsePojo() {
        List<SingerSummary> list = singerService.findAllUsePojo();
        System.out.println(list.size());
    }

    @Test
    public void testSave() {
        Singer singer = new Singer();
        singer.setFirstName("张");
        singer.setLastName("三" + System.currentTimeMillis());
        singer.setBirthDate(new Date());

        Album album = new Album();
        album.setSinger(singer);
        album.setReleaseDate(new Date());
        album.setTitle("张三李四的专辑" + System.currentTimeMillis());
        Album album1 = new Album();
        album1.setSinger(singer);
        album1.setReleaseDate(new Date());
        album1.setTitle("张三李四的专辑" + System.currentTimeMillis());

        Set<Album> albumList = new HashSet<>();
        albumList.add(album);
        albumList.add(album1);
        singer.setAlbums(albumList);

        Singer save = singerService.save(singer);
        List<Singer> allWithAlbum = singerService.findAllWithAlbum();
        System.out.println(allWithAlbum.size());

        System.out.println(save.toString());
        singerService.save(singer);
    }

    @Test
    public void testUpdate() {
        Singer singer = singerService.findSingerWithMaxId();
        Album album = null;
        for (Album ele : singer.getAlbums()) {
            album = ele;
        }
        if (album != null) {
            singer.getAlbums().remove(album);
        }
        singer.setFirstName("张三" + System.currentTimeMillis());
        Singer updatedSinger = singerService.update(singer);
        System.out.println(updatedSinger);
    }

    @Test
    public void testDelete() {
        singerService.delete(singerService.findSingerWithMaxId());
    }

    @Test
    public void testFindAllByNativeQuery() {
        List<Singer> singerList = singerService.findAllByNativeQuery();
        System.out.println(singerList.size());
    }

    @Test
    public void testFindByCriteriaQuery() {
        List<Singer> list = singerService.findByCriteriaQuery("张", "三");
        list.forEach(System.out::println);
    }

    @Test
    public void testFindByFirstName() {
        List<Singer> list = singerService.findByFirstName("张");
        list.forEach(System.out::println);
    }
}