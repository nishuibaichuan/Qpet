package com.qpet.entity;

import java.util.Date;

public class PetKnowledge {
	/**
	 * 主键
	 */
    private Integer pkid;

    /**
     * 所属栏目
     */
    private Integer csid;

    /**
     * 名称
     */
    private String pkname;

    /**
     * 描述
     */
    private String pkdescription;
    
    /**
     * 摘要
     */
    private String summary;
    
    /**
     * 标签或者关键字
     */
    private String label;

    /**
     * 版权(本文出处,隶属于XX)：常量
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

    public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public String getPkname() {
        return pkname;
    }

    public void setPkname(String pkname) {
        this.pkname = pkname == null ? null : pkname.trim();
    }

    public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
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

	public String getPkdescription() {
        return pkdescription;
    }

    public void setPkdescription(String pkdescription) {
        this.pkdescription = pkdescription == null ? null : pkdescription.trim();
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
        this.creator = creator == null ? null : creator.trim();
    }
}