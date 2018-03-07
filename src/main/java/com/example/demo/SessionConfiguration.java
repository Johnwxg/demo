package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.demo.interceptor.SessionInterceptor;

/**
 * 将SessionInterceptor拦截器添加到SpringBoot的配置中，让SpringBoot项目有这么一个拦截器存在
 * @author Admin
 *
 */
@Configuration
public class SessionConfiguration extends WebMvcConfigurerAdapter {
	
	//拦截器的配置以及拦截路径配置
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
	}
}
