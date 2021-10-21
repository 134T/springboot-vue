package com.baizhi.places_vue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author asus
 */
@SpringBootApplication
@MapperScan(value = "com.baizhi.places_vue.mapper")
@EnableTransactionManagement
public class Vue2Application {

    public static void main(String[] args) {
        SpringApplication.run(Vue2Application.class, args);
    }

}
