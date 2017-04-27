package com.qpet.iamge.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qpet.service.PictureService;

/** 
 * @Desc: ()
 * @author: 张瑞
 * @date: 2017年1月20日 下午12:16:09  
 * @email:2411685663@qq.com 
 */
public class PictureTest {
	private PictureService pictureService;
	
	@Before
	public void before(){
		System.out.println("begin....");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[]{"spring-mybatis.xml","spring.xml"});
		pictureService = (PictureService) context.getBean("pictureService");
	}
	
	@Test
	public void PetCategoryProductInfoFindTest(){
		System.out.println("imageUrl: " + this.pictureService.findByImageUrl("/Qpet/upload/user/20170119/148484061260233046095_src.jpg"));
	}
	
	@After
	public void after(){
		System.out.println("after....");
	}
	
}
