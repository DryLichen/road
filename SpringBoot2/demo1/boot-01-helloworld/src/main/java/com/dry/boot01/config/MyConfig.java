package com.dry.boot01.config;

import com.dry.boot01.bean.Car;
import com.dry.boot01.bean.Pet;
import com.dry.boot01.bean.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.filter.CharacterEncodingFilter;

@EnableConfigurationProperties(Car.class)
@Import({User.class})
@Configuration(proxyBeanMethods = false)
@ConditionalOnBean(name = "tom")
public class MyConfig {
    // @Bean
    // @ConditionalOnMissingBean
    // public CharacterEncodingFilter characterEncodingFilter(){
    //     return .....
    // }

    @Bean
    public User user(){
        User user = new User("zhangsan", 78);
        user.setPet(pet());
        return user;
    }

    // @Bean("tom")
    public Pet pet(){
        Pet pet = new Pet("tom");
        return pet;
    }

}
