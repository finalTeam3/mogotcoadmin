package com.mogotcoadmin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotcoadmin.dto.UserCouponDTO;
import com.mogotcoadmin.frame.MyMapper;

@Repository
@Mapper
public interface UserCouponMapper extends MyMapper<Integer, UserCouponDTO> {
	public List<UserCouponDTO> userCouponAll(String userid) throws Exception;
	public UserCouponDTO userCouponfind(String userid, int willusecoupon) throws Exception;
}
