package com.qpet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qpet.entity.User;
import com.qpet.service.UserService;
import com.qpet.vo.Page;

/** 
 * @Desc: (管理员对会员只能查看和修改，普通会员只能查看自己的信息和修改,会员没有后台，模仿京东淘宝)
 * @author: 张瑞
 * @date: 2017年1月14日 下午4:37:51  
 * @email:2411685663@qq.com 
 */
@Controller
@RequestMapping("/admin")
public class MemberController {
	@Autowired
	private UserService userService;
	
	/**
	 * 会员模块搜索基于数据库，因为内容少，但是宠物列表和前台搜索基于lucene或者solr
	 * @return
	 */
	
	@RequestMapping("/member/delete/{id}")
	public String delete(@PathVariable int id){
		this.userService.delete(id);
		return "redirect:/admin/getPagerDate/0";
	}
	
	/**
	 * 分页
	 */
	@RequestMapping(value="/getPagerDate/{pageNum}",method=RequestMethod.GET)
	public String getPagerDate(@PathVariable int pageNum,Model model){
		Page<User> pages = new Page<User>();
		List<User> users = this.userService.findByPage(pageNum*pages.getPageSize(), pages.getPageSize());
		Long count = this.userService.totalSize();
		pages.setTotalRecords(count);//总数
		pages.setCurrentPage(pageNum);//当前页
		pages.setPageSize(pages.getPageSize());
		model.addAttribute("users", users);
		model.addAttribute("pages", pages);
		return "jsp/member/member";
	}
	
}
