package com.qpet.entity;

import java.util.Date;

/** 
 * @Desc: (索引对象:把搜索出来的数据存到这个对象中，传到页面，页面就根据这个对象显示出内容)
 * @author: 张瑞
 * @date: 2016年11月26日 上午11:57:46  
 * @email:2411685663@qq.com 
 */
public class Search {
	/**
	 * 文章id
	 */
	private String articleId;
	
	/**
	 * 带高亮的文章标题
	 */
	private String title;
	
	/**
	 * 文章摘要
	 */
	private String summary;
	
	/**
	 * 文章创建时间
	 */
	private Date createDate;
	
	private int count;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
