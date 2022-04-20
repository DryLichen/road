package com.dry.boot01;

import com.dry.boot01.bean.User;
import com.dry.boot01.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        // 1.获取IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        // // 2.查看容器中的组件
        // String[] names = run.getBeanDefinitionNames();
        // for(String name : names){
        //     System.out.println(name);
        // }

        // // 3.测试非单例Lite模式
        // MyConfig bean = run.getBean(MyConfig.class);
        //
        // User user1 = bean.user();
        // User user2 = bean.user();
        //
        // System.out.println("是否为单例：" + (user1 == user2));
    }
}
