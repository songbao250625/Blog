package com.song;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@org.springframework.boot.autoconfigure.SpringBootApplication
@MapperScan("com.song.Dao")
@ServletComponentScan
@EnableTransactionManagement
public class blogRunApp {
    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(blogRunApp.class, args);
        System.out.println("项目启动成功！！！！！！");
    }
}
