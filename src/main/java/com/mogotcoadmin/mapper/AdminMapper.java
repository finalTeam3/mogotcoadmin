package com.mogotcoadmin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotcoadmin.dto.AdminDTO;
import com.mogotcoadmin.frame.MyMapper;

@Repository
@Mapper
public interface AdminMapper extends MyMapper<String, AdminDTO>{

}
