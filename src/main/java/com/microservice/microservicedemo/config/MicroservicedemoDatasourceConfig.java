package com.microservice.microservicedemo.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sql.DataSource;

@Slf4j
@Configuration
public class MicroservicedemoDatasourceConfig {

    @Value("${spring.microservicedemo.db.enabled}")
    private boolean enabled;

    @Value("${spring.microservicedemo.driverName}")
    private String driverName;

    @Value("${spring.microservicedemo.url}")
    private String dbUrl;

    @Value("${spring.microservicedemo.username}")
    private String dbUserName;

    @Value("${spring.microservicedemo.password}")
    private String dbPassword;

    @Value("${spring.microservicedemo.hikari.connectionTimeout}")
    private long connectionTimeout;

    @Value("${spring.microservicedemo.hikari.maximum-pool-size}")
    private int maximumPoolSize;

    private HikariConfig getHikariConfigProperties() {
        log.info("DB enabled {}", enabled);
        if (enabled) {
            HikariConfig hikariConfig = new HikariConfig();


            log.info("microservicedemo dbUrl {}", dbUrl);
            log.info("microservicedemo driverName {}", driverName);
            log.info("microservicedemo connectionTimeout {}", connectionTimeout);
            log.info("microservicedemo maximumPoolSize {}", maximumPoolSize);

            hikariConfig.setDriverClassName(driverName);
            hikariConfig.setJdbcUrl(dbUrl);
            hikariConfig.setUsername(dbUserName);
            hikariConfig.setPassword(dbPassword);
            hikariConfig.setConnectionTimeout(connectionTimeout);
            hikariConfig.setMaximumPoolSize(maximumPoolSize);

            return hikariConfig;
        } else {
            return new HikariConfig();
        }
    }

    //@Primary
    @Bean(name = "microservicedemodatasource")
    public DataSource dataSource() {

        if (enabled) {
            return new HikariDataSource(getHikariConfigProperties());
        } else {
            return new HikariDataSource();
        }
    }


    //@Primary
    @Bean(name = "microservicedemojdbctemplate")
    public JdbcTemplate jdbcTemplateForProductMapDS(@Qualifier("microservicedemodatasource") DataSource dataSource) {
        log.info("MicroservicedemoDatasourceConfig Datasource {} ", dataSource);
        return new JdbcTemplate(dataSource);
    }


   /* @Bean(name="entityManagerFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        return sessionFactory;
    }*/
}
