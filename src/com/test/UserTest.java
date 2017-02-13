package com.test;

import com.service.IUserService;
import com.entity.UsersEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@Component
@ContextConfiguration(locations={"classpath:spring-config.xml"})
public class UserTest {

	@Autowired
    IUserService service;
	@Test
	public void testLogin() {
		System.out.println("service:"+service);
		UsersEntity user = new UsersEntity();
		user.setPassword("123456");
		user.setName("hzg");

//		System.out.println(service.login(user));
	}
	@Test
	public void testAdd() {
		UsersEntity user=new UsersEntity();
		user.setAccount("1226620085");
		user.setPassword("123456");
		user.setName("黄宗贵");
		service.add(user);
	}

	@Test
	public void testFindById() {
		service.find(0);
	}


}
