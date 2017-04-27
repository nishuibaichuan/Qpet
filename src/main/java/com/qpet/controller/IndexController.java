package com.qpet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * @Desc: (后台首页)
 * @author: 张瑞
 * @date: 2017年1月5日 下午4:34:08  
 * @email:2411685663@qq.com 
 */
@Controller
@RequestMapping("/admin")
public class IndexController {
	
	/**
	 * 后台首页
	 * @return
	 */
	@RequestMapping("/index")
	public String index(){
		return "jsp/admin/index";
	}
	
}
