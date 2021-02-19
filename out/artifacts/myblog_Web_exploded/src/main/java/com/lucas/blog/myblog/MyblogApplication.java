package com.lucas.blog.myblog;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.lucas.blog.myblog.mapper")
@SpringBootApplication
@EnableCaching     //开启缓存
public class MyblogApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyblogApplication.class, args);
	}
}
