package com.qpet.vo;

import java.util.Date;

/** 
 * @Desc: (会员和评价信息)
 * @author: 张瑞
 * @date: 2017年1月16日 下午3:04:47  
 * @email:2411685663@qq.com 
 */
public class MessageVo {
	
	private int id;
	
	private String username;
	
	private String realname;
	
	private String email;
	
	private String phone;
	
	private String context;
	
	private Date createtime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	public MessageVo(){
		
	}

	public MessageVo(int id, String username, String realname, String email,
			String phone, String context, Date createtime) {
		super();
		this.id = id;
		this.username = username;
		this.realname = realname;
		this.email = email;
		this.phone = phone;
		this.context = context;
		this.createtime = createtime;
	}
}