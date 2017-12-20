package com.yijiupi.loginboot;

import com.yijiupi.loginboot.interceptor.UserInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
*@Author: ZhangZhe
*@Description 启动入口
*@Date: 15:42 2017/12/15
*/


@SpringBootApplication
@EnableAutoConfiguration
@ServletComponentScan
@MapperScan("com.yijiupi.loginboot.dao")

public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
