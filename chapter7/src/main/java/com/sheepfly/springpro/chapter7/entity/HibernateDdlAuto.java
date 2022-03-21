package com.sheepfly.springpro.chapter7.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "TEST_USER")
public class HibernateDdlAuto {
    @Id
    @Column(name = "ID")
    private long id;
    @Version
    @Column(name = "VERSION")
    private int version;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
