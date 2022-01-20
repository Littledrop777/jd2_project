package by.academy.it.config;

import by.academy.it.entity.AppUser;
<<<<<<< HEAD
import by.academy.it.entity.UserInfo;
=======
import by.academy.it.entity.AppUserInfo;
import by.academy.it.entity.Info;
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614
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
@ComponentScan(basePackages = "by.academy.it")
@PropertySource(value = "classpath:db.properties")
public class RepositoryConfiguration {

    @Autowired
    Environment env;

    @Bean
    public Properties dataSourceProperties() {
        Properties properties = new Properties();
        properties.setProperty("useSSL", env.getProperty("useSSL"));
        properties.setProperty("serverTimezone", env.getProperty("serverTimezone"));
        properties.setProperty("createDatabaseIfNotExist", env.getProperty("createDatabaseIfNotExist"));
        return properties;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        properties.setProperty("show_sql", "true");
        properties.setProperty("format_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
<<<<<<< HEAD
      /*  properties.setProperty("hibernate.connection.CharSet", "utf8");
        properties.setProperty("hibernate.connection.characterEncoding", "utf8");
        properties.setProperty("hibernate.connection.useUnicode", "true");*/

=======
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614
        return properties;
    }

    @Bean
    public DataSource networkDataSource(Properties dataSourceProperties) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(env.getProperty("db.url"));
        config.setUsername(env.getProperty("db.user"));
        config.setPassword(env.getProperty("db.password"));
        config.setDriverClassName(env.getProperty("jdbc.driver"));
        config.setMaximumPoolSize(Integer.parseInt(Objects.requireNonNull(env.getProperty("db.pool_size"))));
        config.setDataSourceProperties(dataSourceProperties);
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
<<<<<<< HEAD
        sessionFactory.setAnnotatedClasses(AppUser.class, UserInfo.class);
=======
        sessionFactory.setAnnotatedClasses(AppUser.class, Info.class, AppUserInfo.class);
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614

        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(
            @Qualifier("networkSessionFactory") SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
}
