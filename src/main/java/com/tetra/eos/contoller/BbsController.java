package com.tetra.eos.contoller;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;
import org.springframework.web.servlet.view.*;

import com.tetra.eos.bbs.model.*;
import com.tetra.eos.bbs.service.*;
import com.tetra.eos.commom.util.*;

@Controller
public class BbsController {

	@Autowired
	private BbsService boardServiceImpl;

	/**
	 * 게시판 조회
	 * 
	 * @param boardVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/board/boardList")
	public String boardList(@ModelAttribute("boardVO") BoardVO boardVO,
			Criteria cri,
            HttpServletRequest request,
            Model model) throws Exception{
        
		   //ModelAndView mav = new ModelAndView("board/boardList");
	        
		        
		    List<BoardVO> list = boardServiceImpl.selectBoardList(cri);
		    
		    // 전체리스트 개수
	        int listCnt = boardServiceImpl.selectBoardListCnt(boardVO);		    

		    PageMaker pageMaker = new PageMaker();
		    pageMaker.setCri(cri);
		    pageMaker.setTotalCount(listCnt);
	        
        
      
        
        
	        
		    model.addAttribute("list", list);
		    model.addAttribute("pageMaker", pageMaker);


        
        return "main/bbs/boardList";
    }

	/**
	 * 글쓰기 폼
	 * 
	 * @return
	 * @throws Exception
	 */
	@AuthCheck
	@RequestMapping(value = "/board/writeForm")
	public String writeBoardForm() throws Exception {

		// return "board/writeForm";

		return "main/bbs/writeForm";
	}

	/**
	 * 게시글 등록
	 * 
	 * @param boardVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/board/write")
	public RedirectView write(@ModelAttribute("boardVO") BoardVO boardVO, Model model, HttpServletRequest req)
			throws Exception {

		System.out.println("aaaaaa");

		boardServiceImpl.insertBoard(boardVO);

		System.out.println("bbb");

		RedirectView redirectView = new RedirectView();

		System.out.println("cccc");

		// redirectView.setUrl("redirect:/board/boardList");
		redirectView.setUrl("/board/boardList");
		System.out.println("dddd");

		return redirectView;

	}

	/**
	 * 게시글 조회
	 * 
	 * @param boardVO
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/board/viewContent")
	public String viewForm(@ModelAttribute("boardVO") BoardVO boardVO, Criteria cri, Model model, HttpServletRequest request)
			throws Exception {

		int code = Integer.parseInt(request.getParameter("code"));
		boardVO.setCode(code);
        
       
        
        
      //  boardVO.set("aaaa");
        
        //boardVO.setCode(code);
        

		BoardVO resultVO = boardServiceImpl.selectBoardByCode(boardVO);
        
        
       PageMaker pageMaker = new PageMaker();
        pageMaker.setCri(cri);
        model.addAttribute("page",cri.getPage());
        model.addAttribute("pageMaker", pageMaker);


        

		model.addAttribute("result", resultVO);

		//return "main/bbs/viewForm";
		return "main/bbs/boardDetail";
	}
	
	
	/**
	 * 게시글 조회
	 * 
	 * @param boardVO
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/board/updateContent")
	public String updateForm(@ModelAttribute("boardVO") BoardVO boardVO, Criteria cri, Model model, HttpServletRequest request)
			throws Exception {

		int code = Integer.parseInt(request.getParameter("code"));
		boardVO.setCode(code);
        
       

		BoardVO resultVO = boardServiceImpl.selectBoardByCode(boardVO);
        
        
       PageMaker pageMaker = new PageMaker();
        pageMaker.setCri(cri);
        model.addAttribute("page",cri.getPage());
        model.addAttribute("pageMaker", pageMaker);


        

		model.addAttribute("result", resultVO);

		return "main/bbs/viewForm";
		
	}	
			

	/**
	 * 게시글 수정
	 * 
	 * @param boardVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/board/updateboard")
	public RedirectView updateBoard(@ModelAttribute("boardVO") BoardVO boardVO, Criteria cri, Model model, RedirectAttributes redAttr) throws Exception {

		try {

			boardServiceImpl.updateBoard(boardVO);

		} catch (Exception e) {
			e.printStackTrace();
		}

        
        
        
        
		RedirectView redirectView = new RedirectView();
        
         redAttr.addAttribute("page", cri.getPage());
        redAttr.addAttribute("perPagNum", cri.getPerPageNum());




		redirectView.setUrl("/board/boardList");
        

		return redirectView;

	}

}
