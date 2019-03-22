package com.mcoder.admin.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.incrementer.OracleKeyGenerator;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author 1194688733@qq.com
 * @Description: TODO
 * @date 2019-01-09 17:43:50
 */
@Configuration
@MapperScan(basePackages = "com.mcoder.admin.mapper", sqlSessionTemplateRef = "sqlSessionTemplate")
public class DatasourceConfiguration {
    @Resource
    private MybatisPlusConfig mybatisPlusConfig;

    @Bean
    public DataSource dataSource(DruidConfiguration druidConfiguration) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(druidConfiguration.getUrl());
        dataSource.setUsername(druidConfiguration.getUsername());
        dataSource.setPassword(druidConfiguration.getPassword());
        dataSource.setName(druidConfiguration.getName());
        dataSource.setInitialSize(druidConfiguration.getInitialSize());
        dataSource.setMaxActive(druidConfiguration.getMaxActive());
        dataSource.setMinIdle(druidConfiguration.getMinIdle());
        dataSource.setTestOnReturn(druidConfiguration.isTestOnReturn());
        dataSource.setValidationQuery(druidConfiguration.getValidationQuery());
        dataSource.setTimeBetweenEvictionRunsMillis(druidConfiguration.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(druidConfiguration.getMinEvictableIdleTimeMillis());
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(druidConfiguration.getMaxPoolPreparedStatementPerConnectionSize());
        dataSource.setRemoveAbandoned(druidConfiguration.isRemoveAbandoned());
        dataSource.setRemoveAbandonedTimeout(druidConfiguration.getRemoveAbandonedTimeoutMillis());
        dataSource.setLogAbandoned(druidConfiguration.isLogAbandoned());
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource, Environment environment) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);

        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);
        sqlSessionFactory.setConfiguration(configuration);
        sqlSessionFactory.setGlobalConfig(globalConfig());

        //分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        Interceptor[] plugins = new Interceptor[]{pageHelper};
        sqlSessionFactory.setPlugins(plugins);

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactory.setMapperLocations(resolver.getResources(environment.getProperty("mybatis.mapperLocations")));
        return sqlSessionFactory.getObject();
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
        return template;
    }

    private GlobalConfig globalConfig() {
        GlobalConfig conf = new GlobalConfig();
        conf.setDbConfig(new GlobalConfig.DbConfig()
                .setDbType(DbType.ORACLE)
                .setKeyGenerator(new OracleKeyGenerator())
                .setIdType(IdType.INPUT));
        conf.setRefresh(mybatisPlusConfig.getGlobal().isRefresh());
        return conf;
    }
}
