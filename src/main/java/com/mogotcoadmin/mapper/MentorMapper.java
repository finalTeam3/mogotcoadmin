package com.mogotcoadmin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotcoadmin.dto.MentorDTO;
import com.mogotcoadmin.frame.MyMapper;

@Repository
@Mapper
public interface MentorMapper extends MyMapper<Integer, MentorDTO>{
	public MentorDTO mentorAll(String userid) throws Exception;
	public List<MentorDTO> mentoritem(int mentorid) throws Exception;
	public void adminupdate(MentorDTO mdto) throws Exception;
	public MentorDTO mentordetail(int mentorid) throws Exception;
}
