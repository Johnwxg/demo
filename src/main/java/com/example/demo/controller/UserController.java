package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserEntity;
import com.example.demo.jpa.UserJPA;

@RestController
@RequestMapping(value="/user")
public class UserController {
	private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserJPA userJPA;
	
	/**
	 * 查询
	 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<UserEntity> list(){
		LOGGER.debug("userInfo-->debug");
		LOGGER.info("userInfo-->info");
		LOGGER.error("userInfo-->error");
		return userJPA.findAll();
	}
	
	/**
	 * 添加、更新
	 */
	@RequestMapping(value="/save", method = RequestMethod.GET)
	public UserEntity save(UserEntity entity){
		return userJPA.save(entity);
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public List<UserEntity> dalete(int id){
		userJPA.deleteById(id);
		return userJPA.findAll();
	}
}
