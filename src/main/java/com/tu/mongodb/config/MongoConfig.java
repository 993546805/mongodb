package com.tu.mongodb.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * @author tu
 * @date 2022-11-11 17:09
 */
@Configuration
public class MongoConfig {

    /**
     * 更改默认的 MongoDB 映射转换器,取消'_class'字段
     * @param factory MongoDB 工厂对象
     * @param context MongoDB 映射上下文
     * @param beanFactory springBean 工厂
     * @return MongoDB 映射转换器
     */
    @Bean
    public MappingMongoConverter mappingMongoConverter(MongoDbFactory factory, MongoMappingContext context, BeanFactory beanFactory) {
        DbRefResolver defaultDbRefResolver = new DefaultDbRefResolver(factory);
        MappingMongoConverter mappingMongoConverter = new MappingMongoConverter(defaultDbRefResolver, context);
        try {
            mappingMongoConverter.setCustomConversions(beanFactory.getBean(CustomConversions.class));
        } catch (NoSuchBeanDefinitionException ignore) {
        }

        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return mappingMongoConverter;
    }
}
