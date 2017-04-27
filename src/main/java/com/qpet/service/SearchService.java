package com.qpet.service;

import java.util.List;

import com.qpet.entity.PetCategoryProductInfo;
import com.qpet.entity.Search;
import com.qpet.entity.SearchField;

/**
 * @Desc: (获取临时数据，对其进行操作)
 * @author: 张瑞
 * @date: 2016年11月26日 上午11:47:30
 * @email:2411685663@qq.com
 */
public interface SearchService {

	/**
	 * 添加索引到内存中
	 * @param fields
	 * @param inDatabase
	 */
	public void addArticleIndex(SearchField fields);
	
	public void fieldToArticle(PetCategoryProductInfo petCategoryProductInfo);
	
	/**
	 * 删除索引
	 * @param id
	 * @param type
	 */
	public void deleteIndex(String id);

	/**
	 * 更新索引
	 * @param fields
	 */
	public void updateIndex(SearchField fields);
	
	public List<Search> search(String keyword);
	
	/**
	 * 重构索引
	 */
	public void reconstructIndex();

}
