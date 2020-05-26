package com.tetra.eos.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tetra.eos.bbs.model.BoardVO;
import com.tetra.eos.bbs.model.Criteria;
import com.tetra.eos.mysql.mapper.bbs.BbsMapper;

@Service("BbsService")
@Transactional
public class BbsServiceImpl implements BbsService {
	
	@Autowired
	BbsMapper bbsMapper;

	   public int selectBoardListCnt(BoardVO boardVO) throws Exception {
	        return bbsMapper.selectBoardListCnt(boardVO);
	    }	
	
	   public List<BoardVO> selectBoardList(Criteria criteria) throws Exception {
	        return bbsMapper.selectBoardList(criteria);
	    }
	 
	    public void insertBoard(BoardVO boardVO) throws Exception {
	        bbsMapper.insertBoard(boardVO);
	    }
	 
	    public void updateBoard(BoardVO boardVO) throws Exception {
	        bbsMapper.updateBoard(boardVO);
	    }
	 
	    public void deleteBoard(BoardVO boardVO) throws Exception {
	        bbsMapper.deleteBoard(boardVO);
	    }
	 
	    @Override
	    public BoardVO selectBoardByCode(BoardVO boardVO) throws Exception {
	        return bbsMapper.selectBoardByCode(boardVO);
	    }	

}
