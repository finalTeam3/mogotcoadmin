package com.mogotcoadmin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotcoadmin.dto.UserDTO;
import com.mogotcoadmin.frame.MyMapper;

@Repository
@Mapper
public interface UserMapper extends MyMapper<String, UserDTO>{
	
	public UserDTO selectMypage(String userid) throws Exception;
	public void deleteuser(UserDTO user) throws Exception; 
	
}

