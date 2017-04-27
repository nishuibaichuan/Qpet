package com.qpet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qpet.entity.PetCategoryProductInfo;

public interface PetCategoryProductInfoDao {

	/**
	 * 删除
	 * @param pid
	 */
    public void delete(Integer pid);

    /**
     * 添加
     * @param record
     * @return
     */
    public void save(PetCategoryProductInfo record);

    /**
     * 根据pid查找
     * @param pid
     * @return
     */
    public List<PetCategoryProductInfo> findById(Integer pid);
    
    /**
     * 根据pid编号查找
     * @param pid
     * @return
     */
    public PetCategoryProductInfo findByPid(Integer pid);
    
    /**
     * 根据name查找
     * @param pid
     * @return
     */
    public PetCategoryProductInfo findByName(String pname);
    
    /**
     * 根据栏目查找宠物信息
     * @param pid
     * @return
     */
    public List<PetCategoryProductInfo> findByChannelId(Integer channelId);
    
    /**
     * 列表
     * @return
     */
    public List<PetCategoryProductInfo> find();

    /**
     * 更新
     * @param record
     */
    public void update(PetCategoryProductInfo record);
    
    /**
	 * <!--根据创建者id，进行分页查询角色信息  -->
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	public List<PetCategoryProductInfo> findByPage(@Param("begin")int begin, @Param("pageSize")int pageSize);
	
	public Long totalSize();
	
}