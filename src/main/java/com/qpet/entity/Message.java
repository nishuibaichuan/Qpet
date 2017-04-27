package com.qpet.entity;

import java.util.Date;

/**
 * 评价管理
* @Description：
* @author：张瑞 
* @date：2017年4月24日 下午5:39:17
 */
public class Message {
	/**
	 * 主键
	 */
    private Integer mid;

    /**
     * 评价者id
     */
    private Integer pid;

    private Date createtime;

    private String content;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}