package com.qpet.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.Random;
/**
 * @Desc: (验证码)
 * @author: 张瑞
 * @date: 2017年4月1日 下午2:24:18  
 * @email:2411685663@qq.com
 */
public class Captcha {
	private int width;
	private int height;
	private int num;
	private String code;
	private static final Random ran = new Random();
	private static Captcha captcha;
	private Captcha(){
		code = "1234567890abcdefghijklmnopqrstuvwxyz";
		num = 4;
	}
	
	public static Captcha getInstance() {
		if(captcha==null) captcha = new Captcha();
		return captcha;
	}
	
	public void set(int width,int height,int num,String code) {
		this.width = width;
		this.height = height;
		this.setNum(num);
		this.setCode(code);
	}
	
	public void set(int width,int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String generateCheckcode() {
		StringBuffer cc = new StringBuffer();
		for(int i=0;i<num;i++) {
			cc.append(code.charAt(ran.nextInt(code.length())));
		}
		return cc.toString();
	}
	
	public BufferedImage generateCheckImg(String checkcode) {
		//创建一个图片对象
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//获取图片对象的画笔
		Graphics2D graphic = img.createGraphics();
		img = graphic.getDeviceConfiguration().createCompatibleImage(width, height,Transparency.TRANSLUCENT);
		graphic.dispose();
		graphic = img.createGraphics();
		//graphic.setColor(Color.WHITE);
		//graphic.fillRect(0, 0, width, height);
		//graphic.setColor(Color.BLACK);
		//graphic.drawRect(0, 0, width-1, height-1);
		Font font = new Font("宋体",Font.BOLD+Font.ITALIC,(int)(height*0.8));
		graphic.setFont(font);
		for(int i=0;i<num;i++) {
			graphic.setColor(new Color(ran.nextInt(255),ran.nextInt(255),ran.nextInt(255)));
			graphic.drawString(String.valueOf(checkcode.charAt(i)), i*(width/num)+4, (int)(height*0.7));
		}
		
		//加一些点
		for(int i=0;i<(width+height);i++) {
			graphic.setColor(new Color(ran.nextInt(255),ran.nextInt(255),ran.nextInt(255)));
			graphic.drawOval(ran.nextInt(width), ran.nextInt(height), 1, 1);
		}
		
		//加一些线
		for(int i=0;i<2;i++) {
			graphic.setColor(new Color(ran.nextInt(255),ran.nextInt(255),ran.nextInt(255)));
			graphic.drawLine(0, ran.nextInt(height), width, ran.nextInt(height));
		}
		return img;
	}
	
	
}
