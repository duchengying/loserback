package com.du;

import com.du.tool.JwtAuthenticationTokenFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@MapperScan("com.du.dao")
@SpringBootApplication

/*
* 存在加载延迟或者其他问题
* 即：一开始使用@SpringBootApplication  @MapperScan("com.du.dao")是无法装配dao
* 然后使用其他3个注解就可以自动装配
* */
public class LoserbackApplication{

	public static void main(String[] args) {
		SpringApplication.run(LoserbackApplication.class, args);
	}

}
