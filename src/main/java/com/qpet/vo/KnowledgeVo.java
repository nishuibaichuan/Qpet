package com.qpet.vo;

import java.util.Date;

/** 
 * @Desc: (栏目和知识表)
 * @author: 张瑞
 * @date: 2017年1月20日 下午7:57:58  
 * @email:2411685663@qq.com 
 */
public class KnowledgeVo {
	/**
	 * 主键
	 */
    private Integer pkid;

    /**
     * 名称
     */
    private String pkname;
    
    /**
     * 所属栏目名称
     */
    private String channelName;

    /**
     * 标签或者关键字
     */
    private String label;
    
    /**
     * 版权(本文出处,隶属于XX)
     */
    private String copyright;
    
    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 作者
     */
    private String creator;

	public Integer getPkid() {
		return pkid;
	}

	public void setPkid(Integer pkid) {
		this.pkid = pkid;
	}

	public String getPkname() {
		return pkname;
	}

	public void setPkname(String pkname) {
		this.pkname = pkname;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public KnowledgeVo() {
		super();
	}

	public KnowledgeVo(Integer pkid, String pkname, String channelName,
			String label, String copyright, Date createtime, String creator) {
		super();
		this.pkid = pkid;
		this.pkname = pkname;
		this.channelName = channelName;
		this.label = label;
		this.copyright = copyright;
		this.createtime = createtime;
		this.creator = creator;
	}
    
}
