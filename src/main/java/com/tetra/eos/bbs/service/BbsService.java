package com.tetra.eos.bbs.service;

import java.util.List;

import com.tetra.eos.bbs.model.BoardVO;
import com.tetra.eos.bbs.model.Criteria;

public interface BbsService {

    /**
     * 게시물 리스트 조회
     * @param boardVO
     * @return
     * @throws Exception
     */
    int selectBoardListCnt(BoardVO boardVO) throws Exception;	
	
	
    /**
     * 게시물 리스트 조회
     * @param boardVO
     * @return
     * @throws Exception
     */
    List<BoardVO> selectBoardList(Criteria criteria) throws Exception;
 
    /**
     * 게시물 등록
     * @param boardVO
     * @throws Exception
     */
    void insertBoard(BoardVO boardVO) throws Exception;
 
    /**
     * 게시물 수정
     * @param boardVO
     * @throws Exception
     */
    void updateBoard(BoardVO boardVO) throws Exception;
 
    /**
     * 게시물 삭제
     * @param boardVO
     * @throws Exception
     */
    void deleteBoard(BoardVO boardVO) throws Exception;
 
    /**
     * 게시물 조회
     * @param boardVO
     * @return
     * @throws Exception
     */
    BoardVO selectBoardByCode(BoardVO boardVO) throws Exception;
    
    
    
	
}
