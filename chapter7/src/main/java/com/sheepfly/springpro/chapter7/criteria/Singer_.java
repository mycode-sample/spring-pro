package com.sheepfly.springpro.chapter7.criteria;

import com.sheepfly.springpro.chapter7.entity.Album;
import com.sheepfly.springpro.chapter7.entity.Instrument;
import com.sheepfly.springpro.chapter7.entity.Singer;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Singer.class)
public class Singer_ {
    public static volatile SingularAttribute<Singer, String> lastName;
    public static volatile SetAttribute<Singer, Album> albums;
    public static volatile SetAttribute<Singer, Instrument> instruments;
    public static volatile SingularAttribute<Singer, Long> id;
    public static volatile SingularAttribute<Singer, Integer> version;
    public static volatile SingularAttribute<Singer, Date> birthDate;
}
