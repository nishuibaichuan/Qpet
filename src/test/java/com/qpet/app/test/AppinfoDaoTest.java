package com.qpet.app.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qpet.entity.Appinfo;
import com.qpet.service.AppinfoService;

/** 
 * @Desc: ()
 * @author: 张瑞
 * @date: 2017年1月12日 下午9:35:10  
 * @email:2411685663@qq.com 
 */
public class AppinfoDaoTest {
	private AppinfoService appinfoService;
	
	@Before
	public void before(){
		System.out.println("before....");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
			new String[]{"spring-mybatis.xml","spring.xml"});
		appinfoService = (AppinfoService) context.getBean("appinfoService");
	}
	
	@Test
	public void appInfoTest(){
		Appinfo appinfo = new Appinfo();
		appinfo.setAid(1);
		appinfo.setPhone("12345678901");
		this.appinfoService.update(appinfo);
	}
	
	@Test
	public void findByIdTest(){
		Appinfo appinfo = this.appinfoService.findById(1);
		System.out.println(appinfo.toString());
	}
	
	@After
	public void after(){
		System.out.println("after....");
	}
}
