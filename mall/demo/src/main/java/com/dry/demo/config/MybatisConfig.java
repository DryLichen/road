package com.dry.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.dry.demo.mbg.mapper")
public class MybatisConfig {
}
