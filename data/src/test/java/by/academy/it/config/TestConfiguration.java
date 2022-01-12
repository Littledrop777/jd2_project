package by.academy.it.config;

import by.academy.it.entity.AppUser;
import by.academy.it.entity.AppUserInfo;
import by.academy.it.entity.Info;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:db-test.properties")
@ComponentScan(basePackages = "by.academy.it.dao")
public class TestConfiguration{

    @Autowired
    Environment environment;

    @Bean
    public Properties testDataSourceProperties() {
        Properties properties = new Properties();
        properties.setProperty("useSSL", environment.getProperty("useSSL"));
        properties.setProperty("serverTimezone", environment.getProperty("serverTimezone"));
        properties.setProperty("createDatabaseIfNotExist", environment.getProperty("createDatabaseIfNotExist"));
        return properties;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        properties.setProperty("show_sql", "true");
        properties.setProperty("format_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        return properties;
    }

    @Bean
    public DataSource networkDataSource(Properties testDataSourceProperties) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(environment.getProperty("db.url"));
        config.setUsername(environment.getProperty("db.user"));
        config.setPassword(environment.getProperty("db.password"));
        config.setDriverClassName(environment.getProperty("jdbc.driver"));
        config.setMaximumPoolSize(Integer.parseInt(Objects.requireNonNull(environment.getProperty("db.pool_size"))));
        config.setDataSourceProperties(testDataSourceProperties);
        return new HikariDataSource(config);
    }

    @Bean
    public LocalSessionFactoryBean networkSessionFactory(
            @Qualifier("networkDataSource") DataSource dataSource) {

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        Properties properties = hibernateProperties();
        sessionFactory.setHibernateProperties(properties);

        sessionFactory.setAnnotatedPackages("by.academy.it.entity");
        sessionFactory.setAnnotatedClasses(AppUser.class, Info.class, AppUserInfo.class);

        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(
            @Qualifier("networkSessionFactory") SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
}
