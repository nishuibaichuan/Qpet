package com.qpet.entity;

import java.util.Date;

public class Picture {
    private Integer tid;
    
    private Integer pid;//PetCategoryProductInfo表中的id，一条记录对应4张以下的图片，到时候显示在前台页面的时候，从此表中拿出
    /**
     * pid  PetCategoryProductInfo
     *  1        1
     *  2        1
     *  3        1
     *  4        1 ->4张图片
     */

    private String picturename;

    private String picturedescription;

    private String pictureurl;

    private String creator;

    private Date createtime;

    private Integer state;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPicturename() {
        return picturename;
    }

    public void setPicturename(String picturename) {
        this.picturename = picturename == null ? null : picturename.trim();
    }

    public String getPicturedescription() {
        return picturedescription;
    }

    public void setPicturedescription(String picturedescription) {
        this.picturedescription = picturedescription == null ? null : picturedescription.trim();
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl == null ? null : pictureurl.trim();
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}