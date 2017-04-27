package com.qpet.entity;

import java.util.Date;

public class Appinfo {
    private Integer aid;

    private String name;

    private String appdescription;

    private String appcopyright;

    private String appurl;

    private Date createtime;

    private String apptitle;

    private String appkeywords;

    private String phone;

    private String email;
    
    private String address;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAppdescription() {
        return appdescription;
    }

    public void setAppdescription(String appdescription) {
        this.appdescription = appdescription == null ? null : appdescription.trim();
    }

    public String getAppcopyright() {
        return appcopyright;
    }

    public void setAppcopyright(String appcopyright) {
        this.appcopyright = appcopyright == null ? null : appcopyright.trim();
    }

    public String getAppurl() {
        return appurl;
    }

    public void setAppurl(String appurl) {
        this.appurl = appurl == null ? null : appurl.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getApptitle() {
        return apptitle;
    }

    public void setApptitle(String apptitle) {
        this.apptitle = apptitle == null ? null : apptitle.trim();
    }

    public String getAppkeywords() {
        return appkeywords;
    }

    public void setAppkeywords(String appkeywords) {
        this.appkeywords = appkeywords == null ? null : appkeywords.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}