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
public class FooDBConfig {
    @Bean
    @ConfigurationProperties(prefix = "foo.datasource")
    public DataSource fooDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "entityManagerFactoryFoo")
    public LocalContainerEntityManagerFactoryBean fooEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(fooDataSource())
                .packages("cc.before30.sample.domain.foo")
                .build();
    }

    @Bean(name = "transactionManagerFoo")
    public PlatformTransactionManager fooTransactionManager(
            @Qualifier("entityManagerFactoryFoo") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Configuration
    @EnableJpaRepositories(
            basePackages = "cc.before30.sample.domain.foo",
            entityManagerFactoryRef = "entityManagerFactoryFoo",
            transactionManagerRef = "transactionManagerFoo"
    )
    static class fooDbJpaRespositoryConfig {
    }
}
