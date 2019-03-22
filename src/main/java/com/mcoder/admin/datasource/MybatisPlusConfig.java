package com.mcoder.admin.datasource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author liuheng
 * @Description: TODO
 * @date 2018/11/8 14:04
 */
@Data
@Configuration
@Component
@ConfigurationProperties(prefix = "mybatis-plus")
public class MybatisPlusConfig {
    @NestedConfigurationProperty
    private GlobalConfig global;

    @Data
    public static class GlobalConfig {
        private boolean refresh = false;
    }

}
