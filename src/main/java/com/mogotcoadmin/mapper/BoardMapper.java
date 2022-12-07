package com.mogotcoadmin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotcoadmin.dto.BoardDTO;
import com.mogotcoadmin.frame.MyMapper;


@Repository
@Mapper
public interface BoardMapper extends MyMapper<Integer, BoardDTO>{
	public List<BoardDTO> selectboardtype(int boardtype) throws Exception;
}

