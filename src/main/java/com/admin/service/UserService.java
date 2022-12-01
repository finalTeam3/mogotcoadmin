package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.UserDTO;
import com.admin.frame.MyService;
import com.admin.mapper.UserMapper;

@Service
public class UserService implements MyService<String, UserDTO>{
	
	@Autowired
	UserMapper mapper;

	@Override
	public void register(UserDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(UserDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public UserDTO get(String k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<UserDTO> get() throws Exception {
		return mapper.selectAll();
	}
	
	public UserDTO getMypage(String k) throws Exception {
		return mapper.selectMypage(k);
	}


}
