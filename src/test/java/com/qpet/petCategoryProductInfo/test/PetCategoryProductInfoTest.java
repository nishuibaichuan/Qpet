package com.qpet.petCategoryProductInfo.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qpet.entity.PetCategoryProductInfo;
import com.qpet.service.PetCategoryProductInfoService;

/** 
 * @Desc: ()
 * @author: 张瑞
 * @date: 2017年1月18日 下午8:46:35  
 * @email:2411685663@qq.com 
 */
public class PetCategoryProductInfoTest{
	private PetCategoryProductInfoService petCategoryProductInfoService;
	
	@Before
	public void before(){
		System.out.println("begin....");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[]{"spring-mybatis.xml","spring.xml"});
		petCategoryProductInfoService = (PetCategoryProductInfoService) context.getBean("petCategoryProductInfoService");
	}
	
	@Test
	public void PetCategoryProductInfoFindTest(){
		List<PetCategoryProductInfo> petCategoryProductInfos = this.petCategoryProductInfoService.find();
		for (PetCategoryProductInfo petCategoryProductInfo : petCategoryProductInfos) {
			System.out.println("pet: " + petCategoryProductInfo);
		}
	}
	
	@After
	public void after(){
		System.out.println("after....");
	}
}
