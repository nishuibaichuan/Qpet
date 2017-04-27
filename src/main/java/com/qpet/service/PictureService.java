package com.qpet.service;

import java.util.List;

import com.qpet.entity.Picture;

public interface PictureService {

	public void delete(Integer tid);
	
	/**
     * 根据pet信息表中的pid删除图片记录
     * @param pid
     */
	public void deleteByPid(Integer pid);

    public void save(Picture record);

    public List<Picture> findById(Integer tid);
    
    /**
     * 根据图片路径查询信息
     * @param imageUrl
     * @return
     */
    public Picture findByImageUrl(String imageUrl);

    public List<Picture> find();
    
    public void update(Picture record);
}