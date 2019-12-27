package com.ittest.springdemo.mybatis.mapper.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注解的方式开启mybatis的驼峰命名匹配规则
 */
@Configuration
public class MybatisConfig {

    @Bean
    public ConfigurationCustomizer configCustomizer(){

        ConfigurationCustomizer configurationCustomizer = new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };

        return configurationCustomizer;
    }

}
