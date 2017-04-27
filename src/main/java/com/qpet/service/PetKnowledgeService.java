package com.qpet.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qpet.entity.PetKnowledge;

public interface PetKnowledgeService {

	public void delete(Integer pkid);

    public void save(PetKnowledge record);

    public List<PetKnowledge> findById(Integer pkid);
    
    public List<PetKnowledge> findByChannelId(Integer csid);
    
    public List<PetKnowledge> find();

    public void update(PetKnowledge record);
    
    /**
   	 * <!--根据创建者id，进行分页查询角色信息  -->
   	 * @param begin
   	 * @param pageSize
   	 * @return
   	 */
   	public List<PetKnowledge> findByPage(@Param("begin")int begin, @Param("pageSize")int pageSize);
   	
   	public Long totalSize();
}