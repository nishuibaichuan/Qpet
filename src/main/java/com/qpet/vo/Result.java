package com.qpet.vo;
/** 
 * @Desc: ()
 * @author: 张瑞
 * @date: 2016年12月8日 下午5:57:48  
 * @email:2411685663@qq.com 
 */
public class Result {
	private String url;
	private String msg;
	private String uuid;

	public String getUuid() {
		return uuid;
	}

	public String getUrl() {
		return url;
	}
	
	public String getMsg() {
		return msg;
	}

	public Result(String url, String msg, String uuid) {
		super();
		this.url = url;
		this.msg = msg;
		this.uuid = uuid;
	}
}
