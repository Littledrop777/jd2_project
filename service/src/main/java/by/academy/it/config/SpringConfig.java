package by.academy.it.config;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration("controllerConfig")
@ComponentScan(basePackages = "by.academy.it")
public class SpringConfig {

    @Bean
    public BCrypt.Hasher hasher() {
        return BCrypt.withDefaults();
    }

    @Bean
    public BCrypt.Verifyer verifyer() {
        return BCrypt.verifyer();
    }

}
