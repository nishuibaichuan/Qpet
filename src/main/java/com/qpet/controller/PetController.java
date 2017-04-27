package com.qpet.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qpet.entity.PetCategoryProductInfo;
import com.qpet.entity.Picture;
import com.qpet.entity.SearchField;
import com.qpet.entity.User;
import com.qpet.service.ChannelService;
import com.qpet.service.PetCategoryProductInfoService;
import com.qpet.service.PictureService;
import com.qpet.service.SearchService;
import com.qpet.vo.Page;
import com.qpet.vo.PetVo;

/** 
 * @Desc: (宠物管理：列表，知识，查询(lucene)，分类)
 * @author: 张瑞
 * @date: 2017年1月14日 下午4:35:28  
 * @email:2411685663@qq.com 
 */

@Controller
@RequestMapping("/admin")
public class PetController {
	@Autowired
	private PetCategoryProductInfoService petCategoryProductInfoService;
	@Autowired
	private PictureService pictureService;
	@Autowired
	private ChannelService channelService;
	@Autowired
	private SearchService searchService;
	
	/**
	 * 宠物列表列出所有宠物的信息(不分类,分类根据父亲id分)
	 * @return
	 */
	/**
	 * 分页
	 */
	@RequestMapping(value="/manager/{pageNum}",method=RequestMethod.GET)
	public String manager(@PathVariable int pageNum,Model model){
		Page<User> pages = new Page<User>();
		List<PetCategoryProductInfo> petCategoryProductInfos = this.petCategoryProductInfoService.findByPage(pageNum*pages.getPageSize(), pages.getPageSize());
		List<PetVo> petVos = new ArrayList<PetVo>();
		PetVo petVo = null;
		for (PetCategoryProductInfo petCategoryProductInfo : petCategoryProductInfos) {
			if (petCategoryProductInfo != null) {
				petVo = new PetVo(petCategoryProductInfo.getPid(), petCategoryProductInfo.getPname(), petCategoryProductInfo.getSubtitle(),
						petCategoryProductInfo.getMarketPrice(),petCategoryProductInfo.getShopPrice(), petCategoryProductInfo.getImage(),
						petCategoryProductInfo.getPdesc(), petCategoryProductInfo.getPdate(), this.channelService.findById(petCategoryProductInfo.getCsid()).getName());
				petVos.add(petVo);
			}
		}
		Long count = this.petCategoryProductInfoService.totalSize();
		pages.setTotalRecords(count);//总数
		pages.setCurrentPage(pageNum);//当前页
		pages.setPageSize(pages.getPageSize());
		model.addAttribute("pages", pages);
		model.addAttribute("petVos", petVos);
		return "jsp/manager/petList";
	}
	
	/**
	 *  添加图片的时候，图片路径保存到pictrue表中，一张图片一行
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/manager/petSave",method=RequestMethod.GET)
	public String savePet(Model model){
		model.addAttribute("petInfo", new PetCategoryProductInfo());
		return "jsp/manager/petSave";
	}
	
	@RequestMapping(value="/manager/petSave",method=RequestMethod.POST)
	public String savePet(PetCategoryProductInfo petCategoryProductInfo){
		PetCategoryProductInfo petCategoryProductInfoModify = new PetCategoryProductInfo();
		String[] imageUrls = petCategoryProductInfo.getImage().split(",");
		petCategoryProductInfoModify.setCsid(petCategoryProductInfo.getCsid());
		petCategoryProductInfoModify.setIsHot(1);
		petCategoryProductInfoModify.setImage(imageUrls[0]);
		petCategoryProductInfoModify.setMarketPrice(petCategoryProductInfo.getMarketPrice());
		petCategoryProductInfoModify.setPdate(new Date());
		petCategoryProductInfoModify.setPdesc(petCategoryProductInfo.getPdesc());
		petCategoryProductInfoModify.setPname(petCategoryProductInfo.getPname());
		petCategoryProductInfoModify.setShopPrice(petCategoryProductInfo.getShopPrice());
		petCategoryProductInfoModify.setSubtitle(petCategoryProductInfo.getSubtitle());
		this.petCategoryProductInfoService.save(petCategoryProductInfoModify);
		//根据petCategoryProductInfo表中pname得到此条记录的编号pid.注意添加信息时候，名称不能一样！
		PetCategoryProductInfo petCategoryProductInfos = this.petCategoryProductInfoService.findByName(petCategoryProductInfoModify.getPname());
		petCategoryProductInfoModify.setPid(petCategoryProductInfos.getPid());
		
		//添加索引
		searchService.fieldToArticle(petCategoryProductInfoModify);
		if (imageUrls.length > 0) {
			for (String imageUrl : imageUrls) {
				Picture picture = this.pictureService.findByImageUrl(imageUrl);
				if (petCategoryProductInfos != null ) {
					picture.setPid(petCategoryProductInfos.getPid());
					picture.setPicturename(petCategoryProductInfo.getPname());
					picture.setPicturedescription(petCategoryProductInfo.getSubtitle());
					picture.setState(1);
					this.pictureService.update(picture);
				}
			}
		}else{
			return "";
		}
		return "redirect:/admin/manager/0";
	}
	
	/**
	 * 更新
	 * @return
	 */
	@RequestMapping(value="/manager/petUpdate/{pid}",method=RequestMethod.GET)
	public String petUpdate(@PathVariable Integer pid,Model model){
		model.addAttribute("petInfo", this.petCategoryProductInfoService.findByPid(pid));
		return "jsp/manager/petUpdate";
	}
	
	/**
	 * 更新
	 * @return
	 */
	@RequestMapping(value="/manager/petUpdate/{pid}",method=RequestMethod.POST)
	public String petUpdate(@PathVariable Integer pid,PetCategoryProductInfo petCategoryProductInfo){
		PetCategoryProductInfo petCategoryProductInfoModify = this.petCategoryProductInfoService.findByPid(pid);
		petCategoryProductInfoModify.setIsHot(1);
		petCategoryProductInfoModify.setMarketPrice(petCategoryProductInfo.getMarketPrice());
		petCategoryProductInfoModify.setPdesc(petCategoryProductInfo.getPdesc());
		petCategoryProductInfoModify.setPname(petCategoryProductInfo.getPname());
		petCategoryProductInfoModify.setShopPrice(petCategoryProductInfo.getShopPrice());
		petCategoryProductInfoModify.setSubtitle(petCategoryProductInfo.getSubtitle());
		this.petCategoryProductInfoService.update(petCategoryProductInfoModify);
		
		SearchField searchField = new SearchField(); 
		searchField.setId(String.valueOf(petCategoryProductInfoModify.getPid()));
		searchField.setContent(petCategoryProductInfoModify.getPdesc());
		searchField.setObjId(String.valueOf(petCategoryProductInfoModify.getPid()));
		searchField.setTitle(petCategoryProductInfoModify.getPname());
		searchField.setCreateDate(new Date());
		//更新索引
		System.out.println("update-pid: " + petCategoryProductInfoModify.getPid());
		searchService.updateIndex(searchField);
		return "redirect:/admin/manager/0";
	}
	
	/**
	 * 删除
	 * @param pid
	 * @return
	 */
	@RequestMapping("/manager/delete/{pid}")
	public String delete(@PathVariable Integer pid){
		this.petCategoryProductInfoService.delete(pid);
		this.pictureService.deleteByPid(pid);
		//删除索引
		System.out.println("del-pid: " + pid);
		searchService.deleteIndex(""+pid);
		return "redirect:/admin/manager/0";
	}
	
}
