package com.sheepfly.springpro.chapter10.bean;

public class ConnectionPool {
    private SpringDataSource dataSource;

    public SpringDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(SpringDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String toString() {
        return "ConnectionPool{" +
                "dataSource=" + dataSource +
                '}';
    }
}
