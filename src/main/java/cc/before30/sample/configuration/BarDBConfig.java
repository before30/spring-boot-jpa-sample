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
 * Created by before30 on 24/07/2017.
 */
@Configuration
public class BarDBConfig {
    @Bean
    @ConfigurationProperties(prefix = "bar.datasource")
    public DataSource barDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "entityManagerFactoryBar")
    public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(barDataSource())
                .packages("cc.before30.sample.domain.bar")
                .build();
    }

    @Bean(name = "transactionManagerBar")
    PlatformTransactionManager barTransactionManager(
            @Qualifier("entityManagerFactoryBar") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Configuration
    @EnableJpaRepositories(
            basePackages = "cc.before30.sample.repository.bar",
            entityManagerFactoryRef = "entityManagerFactoryBar",
            transactionManagerRef = "transactionManagerBar"
    )
    static class barDbJpaRespositoryConfig {
    }

}
