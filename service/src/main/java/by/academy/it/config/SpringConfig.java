package by.academy.it.config;

import at.favre.lib.crypto.bcrypt.BCrypt;
import by.academy.it.dao.AppUserDao;
import by.academy.it.dao.AppUserInfoDao;
import by.academy.it.dao.InfoDao;
import by.academy.it.dao.impl.AppUserDaoImpl;
import by.academy.it.dao.impl.AppUserInfoDaoImpl;
import by.academy.it.dao.impl.InfoDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration("controllerConfig")
@ComponentScan(basePackages = "by.academy.it")
public class SpringConfig {

    @Bean
    public BCrypt.Hasher hasher(){
        return BCrypt.withDefaults();
    }
    @Bean
    public BCrypt.Verifyer verifyer(){
        return BCrypt.verifyer();
    }

    @Bean
    public AppUserDao appUserDao(){
        return new AppUserDaoImpl();
    }

    @Bean
    public AppUserInfoDao appUserInfoDao(){
        return new AppUserInfoDaoImpl();
    }

    @Bean
    public InfoDao infoDao(){
        return new InfoDaoImpl();
    }
}
