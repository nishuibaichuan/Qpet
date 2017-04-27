package com.qpet.entity;

import java.util.Date;

public class Channel {
    private Integer id;

    private String name;

    private String description;

    private String creator;

    private Date createtime;

    private Integer channelorder;

    private Integer parentid;

    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getChannelorder() {
        return channelorder;
    }

    public void setChannelorder(Integer channelorder) {
        this.channelorder = channelorder;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

	public Channel(Integer id, String name, String description, String creator,
			Date createtime, Integer channelorder, Integer parentid,
			Boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.creator = creator;
		this.createtime = createtime;
		this.channelorder = channelorder;
		this.parentid = parentid;
		this.status = status;
	}
	
	public Channel(Integer id, String name, String description, String creator,
			Date createtime, Integer channelorder,
			Boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.creator = creator;
		this.createtime = createtime;
		this.channelorder = channelorder;
		this.status = status;
	}

	public Channel() {
		super();
	}
    
}