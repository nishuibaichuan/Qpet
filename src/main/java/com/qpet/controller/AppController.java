package com.qpet.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qpet.entity.Appinfo;
import com.qpet.service.AppinfoService;

/**
 * @Desc: (网站站点信息)
 * @author: 张瑞
 * @date: 2017年1月12日 下午6:37:13  
 * @email:2411685663@qq.com
 */
@Controller
@RequestMapping("/admin")
public class AppController {
	@Autowired
	private AppinfoService appinfoService;
	
	/**
	 * 更新站点信息
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/app",method=RequestMethod.GET)
	public String app(Model model){
		Appinfo appinfo = appinfoService.findById(1);
		model.addAttribute("appinfo", appinfo);
		return "jsp/app/info";
	}
	
	@RequestMapping(value="/app",method=RequestMethod.POST)
	public String app(Appinfo appinfo){
		Appinfo app = new Appinfo();
		app.setAid(1);
		app.setAddress(appinfo.getAddress());
		app.setAppcopyright(appinfo.getAppcopyright());
		app.setAppdescription(appinfo.getAppdescription());
		app.setAppkeywords(appinfo.getAppkeywords());
		app.setApptitle(appinfo.getApptitle());
		app.setAppurl(appinfo.getAppurl());
		app.setCreatetime(new Date());
		app.setEmail(appinfo.getEmail());
		app.setName(appinfo.getName());
		app.setPhone(appinfo.getPhone());
		this.appinfoService.update(app);
		return "redirect:/admin/app";
	}
}