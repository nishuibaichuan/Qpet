package com.qpet.vo;

import java.util.Date;

/** 
 * @Desc: (栏目和宠物信息表)
 * @author: 张瑞
 * @date: 2017年1月20日 下午3:29:54  
 * @email:2411685663@qq.com 
 */
public class PetVo {
	private Integer pid;

    private String pname;
    
    private String subtitle;

    private Double marketPrice;

    private Double shopPrice;

    private String image;//图片路径

    private String pdesc;//宠物内容

    private Date pdate;
    
    private String channelName;//栏目名称

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public Double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Double getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(Double shopPrice) {
		this.shopPrice = shopPrice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public PetVo(Integer pid, String pname, String subtitle,
			Double marketPrice, Double shopPrice, String image, String pdesc,
			Date pdate, String channelName) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.subtitle = subtitle;
		this.marketPrice = marketPrice;
		this.shopPrice = shopPrice;
		this.image = image;
		this.pdesc = pdesc;
		this.pdate = pdate;
		this.channelName = channelName;
	}

	public PetVo() {
		super();
	}
   
}
