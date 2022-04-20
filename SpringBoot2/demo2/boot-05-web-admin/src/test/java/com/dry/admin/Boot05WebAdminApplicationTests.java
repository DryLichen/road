package com.dry.admin;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
    }

    @Test
    void testTemplate(){
        Long count = jdbcTemplate.queryForObject("select count(*) from t_emp", Long.class);
        log.info("记录总数：{}", count);
        log.info("数据源类型为：{}", dataSource.getClass().getName());
    }
}
