package com.mogotcoadmin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotcoadmin.dto.AdminDTO;
import com.mogotcoadmin.frame.MyMapper;

@Repository
@Mapper
public interface AjaxMapper{
	
	public int getUserCnt();
	public int getMentorCnt();
	public int getMentoringCnt();
	public int getPurchasePrice();

}
