package com.example.demo.jpa;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.UserEntity;

public interface UserJPA extends JpaRepository<UserEntity, Integer>,
	JpaSpecificationExecutor<UserEntity>,
	Serializable{
	/*
	 * UserJPA继承了JpaRepository接口（SpringDataJPA提供的简单数据操作接口）
	 * JpaSpecificationExecutor（SpringDataJPA提供的复杂查询接口）
	 * Serializable（序列化接口）
	 * SpringDataJPA内部使用了类代理的方式让继承了它接口的子接口都以spring管理的Bean的形式存在,我们可以直接使用@Autowired注解在spring管理bean使用
	 * */
}
