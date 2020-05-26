package com.tetra.eos.mysql.mapper.bbs;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.tetra.eos.bbs.model.BoardVO;
import com.tetra.eos.bbs.model.Criteria;

@Repository
@Mapper
public interface BbsMapper {
	
	
	
	public int selectBoardListCnt(BoardVO boardVO) throws Exception;
	
    // 게시물 리스트 조회
    public List<BoardVO> selectBoardList(Criteria criteria) throws Exception;
    
    // 게시물 등록
    public void insertBoard(BoardVO boardVO) throws Exception;
    
    // 게시물 수정
    public void updateBoard(BoardVO boardVO) throws Exception;
    
    // 게시물 삭제
    public void deleteBoard(BoardVO boardVO) throws Exception;
 
    // 게시물 조회
    public BoardVO selectBoardByCode(BoardVO boardVO) throws Exception;	

}
