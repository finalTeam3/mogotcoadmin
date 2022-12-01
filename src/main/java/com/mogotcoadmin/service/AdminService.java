package com.mogotcoadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogotcoadmin.dto.AdminDTO;
import com.mogotcoadmin.frame.MyService;
import com.mogotcoadmin.mapper.AdminMapper;

@Service
public class AdminService implements MyService<String, AdminDTO>{

	@Autowired
	AdminMapper mapper;
	
	@Override
	public void register(AdminDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(AdminDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public AdminDTO get(String k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<AdminDTO> get() throws Exception {
		return mapper.selectAll();
	}

}
