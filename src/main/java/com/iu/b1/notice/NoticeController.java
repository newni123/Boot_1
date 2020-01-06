package com.iu.b1.notice;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.b1.member.MemberFilesVO;
import com.iu.b1.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	@Resource(name = "noticeService")
	private NoticeService noticeService;

	@ModelAttribute(name = "boardVO")
	public NoticeVO getNoticeVO() {
		// noticeVO 이름을 boardVO로 바꿔줌 (form 한개로 여러번 쓰기위해서)
		return new NoticeVO();
	}

	@GetMapping("noticeSelect")
	public ModelAndView noticeSelect(Model model,NoticeVO noticeVO,NoticeFilesVO noticeFilesVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		noticeVO = noticeService.boardSelect(noticeVO);
		mv.addObject("vo",noticeVO);
		mv.addObject("imgs",noticeService.boardImage(noticeVO));
		mv.setViewName("board/boardSelect");
		return mv;
	}

	@GetMapping("noticeList")
	public ModelAndView noticeList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<NoticeVO> ar = noticeService.boardList(pager);
		mv.addObject("list", ar);
		mv.addObject("Pager", pager);
		mv.setViewName("board/boardList");
		return mv;

	}

	@GetMapping("noticeWrite")
	public String noticeWrite(Model model, /* @ModelAttribute(name="boardVO") */NoticeVO noticeVO) throws Exception {
		return "board/boardWrite";
	}

	@PostMapping("noticeWrite")
	public ModelAndView noticeWrite2(@Valid NoticeVO noticeVO, BindingResult bindingResult, MultipartFile[] files,
			HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		if (bindingResult.hasErrors()) {
			mv.setViewName("board/boardWrite");
		} else {
			int result = noticeService.noticeWrite(noticeVO, files);
			String msg = "작성 실패";
			if (result > 0) {
				msg = "작성 완료";
			}
			mv.addObject("msg", msg);
			mv.addObject("path", "../");
			mv.setViewName("common/result");
		}

		return mv;
	}

}
