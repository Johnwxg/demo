package com.example.demo;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
public class FastJsonConfiguration extends WebMvcConfigurerAdapter {
	/**
	 * 自定义消息转换器
	 */
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		//调用父类配置
		super.configureMessageConverters(converters);
		//创建fastjson消息转换器
		FastJsonHttpMessageConverter fastJsonConverter =  new FastJsonHttpMessageConverter();
		//创建配置类
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		//修改配置返回内容的过滤
		fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect, 
				SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.WriteMapNullValue);
		fastJsonConverter.setFastJsonConfig(fastJsonConfig);
		//将fastjson添加到视图消息转换器列表内
		converters.add(fastJsonConverter);
	}
	
}
