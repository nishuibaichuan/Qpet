package com.qpet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qpet.service.SearchService;


/**
 * @Desc: (全文检索: 初始化索引,生成索引,更新索引,删除索引,重构索引)
 * @author: 张瑞
 * @date: 2016年11月25日 上午9:52:27
 * @email:2411685663@qq.com
 */
@Controller
@RequestMapping("/admin")
public class SearchController {
	@Autowired
	private SearchService searchService;

	@RequestMapping("/search/reconstructIndex")
	public String indexManage() {
		return "jsp/search/reconstructIndex";
	}

	/**
	 * 索引重构
	 * 
	 * @return
	 */
	@RequestMapping("/search/reconstructIndexs")
	public String reconstructIndex() {
		searchService.reconstructIndex();
		return "redirect:/admin/search/reconstructIndex";
	}

	/**
	 * 检索内容
	 * @return
	 */
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String search(Model model,String keyword) {
		model.addAttribute("keywords", searchService.search(keyword));
		return "jsp/search/search";
	}

}
