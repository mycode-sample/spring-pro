package com.sheepfly.springpro.chapter10.config;

import com.sheepfly.springpro.chapter10.bean.SpringDataSource;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import java.beans.PropertyEditorSupport;

public class DataSourceEditorConfigurer implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(SpringDataSource.class, new DataSourceEditor());
    }

    private static class DataSourceEditor extends PropertyEditorSupport {
        @Override
        public void setValue(Object value) {
            SpringDataSource dataSource = (SpringDataSource) value;
            String url = "jdbc:" + dataSource.getProtocol() + "://" +
                    dataSource.getIp() + ":" +
                    dataSource.getPort();
            dataSource.setUrl(url);
            super.setValue(dataSource);
        }
    }
}
