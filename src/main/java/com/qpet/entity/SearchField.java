package com.qpet.entity;

import java.util.Date;

/** 
 * @Desc: (要添加的索引域对象,目的是将相应的对象转换为IndexField之后传输到Service进行更新操作)
 * @author: 张瑞
 * @date: 2016年11月26日 上午11:57:46  
 * @email:2411685663@qq.com 
 */
public class SearchField {
	
	/**
	 * 这个索引的标识唯一：文章id或者附件id(可以后扩展)
	 */
	private String id;
	
	/**
	 * 文章的标题
	 */
	private String title;
	
	/**
	 * 当前存储对象id
	 */
	private String objId;
	
	/**
	 * 创建日期
	 */
	private Date createDate;
	
	/**
	 * 文章的类型
	 */
	private String type;
	
	/**
	 * 文章的内容
	 */
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getObjId() {
		return objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
