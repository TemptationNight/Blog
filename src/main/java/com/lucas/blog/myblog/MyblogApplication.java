package com.lucas.blog.myblog;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.heyuanhui.blog.myblog.mapper")
@SpringBootApplication
public class MyblogApplication {





	public static void main(String[] args) {

		SpringApplication.run(MyblogApplication.class, args);







	}





}
