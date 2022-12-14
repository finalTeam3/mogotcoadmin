package com.mogotcoadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogotcoadmin.dto.UserCouponDTO;
import com.mogotcoadmin.frame.MyService;
import com.mogotcoadmin.mapper.UserCouponMapper;

@Service
public class UserCouponService implements MyService<Integer, UserCouponDTO> {
	
	@Autowired
	UserCouponMapper mapper;

	@Override
	public void register(UserCouponDTO v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(UserCouponDTO v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public UserCouponDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<UserCouponDTO> get() throws Exception {
		return mapper.selectAll();
	}
	
	public List<UserCouponDTO> userCouponAll(String userid) throws Exception{
		return mapper.userCouponAll(userid);
	}
	
	public UserCouponDTO userCouponfind(String userid, int willusecoupon) throws Exception{
		return mapper.userCouponfind(userid,willusecoupon);
	}

}
