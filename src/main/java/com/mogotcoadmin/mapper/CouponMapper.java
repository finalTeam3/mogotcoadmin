package com.mogotcoadmin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotcoadmin.dto.CouponDTO;
import com.mogotcoadmin.frame.MyMapper;

@Repository
@Mapper
public interface CouponMapper extends MyMapper<Integer, CouponDTO> {

}
