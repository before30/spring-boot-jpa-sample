package cc.before30.sample.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by before30 on 25/07/2017.
 */
@Configuration
public class BazDBConfig {
    @Bean
    @ConfigurationProperties(prefix = "baz.datasource")
    public DataSource bazDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "entityManagerFactoryBaz")
    public LocalContainerEntityManagerFactoryBean bazEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(bazDataSource())
                .packages("cc.before30.sample.domain.baz")
                .build();
    }

    @Bean(name = "transactionManagerBaz")
    public PlatformTransactionManager bazTransactionManager(
            @Qualifier("entityManagerFactoryBaz")EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Configuration
    @EnableJpaRepositories(
            basePackages = "cc.before30.sample.domain.baz",
            entityManagerFactoryRef = "entityManagerFactoryBaz",
            transactionManagerRef = "transactionManagerBaz"
    )
    static class bazDbJpaRepositoryConfig {
    }
}
