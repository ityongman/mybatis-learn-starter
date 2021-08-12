package com.ityongman.mybatis.config;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Properties;


/**
 * @Author shedunze
 * @Date 2021/8/4 11:55 下午
 * @Description 自定义对象工厂, 用于处理查询返回数据
 */
public class CustomizeObjectFactory extends DefaultObjectFactory {
    private static final Logger log = Logger.getLogger(CustomizeObjectFactory.class);

    @Override
    public <T> T create(Class<T> type) {
        log.info("使用定制对象工厂的create方法构建单个对象. ");
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        log.info("使用定制对象工厂的create方法构建列表对象. ");
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }

    @Override
    public void setProperties(Properties properties) {
        log.info("定制属性: " + properties);
        super.setProperties(properties);
    }
}
