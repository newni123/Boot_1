package com.iu.b1.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@GetMapping("memberFileDown")
	public ModelAndView memberFileDown(MemberFilesVO memberFilesVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		memberFilesVO = memberService.memberFileSelect(memberFilesVO);
		if (memberFilesVO != null) {
			mv.addObject("memberfiles", memberFilesVO);
			mv.addObject("path", "upload");
			mv.setViewName("fileDown");

		} else {
			mv.addObject("msg", "No Image File");
			mv.addObject("path", "./memberMyPage");
			mv.setViewName("common/result");
		}

		return mv;
	}

	@GetMapping("memberMyPage")
	public ModelAndView memberMypage(HttpSession session) throws Exception {
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		MemberFilesVO memberFilesVO = memberService.memberImage(memberVO);
		ModelAndView mv = new ModelAndView();
		mv.addObject("member", memberVO);
		mv.addObject("image", memberFilesVO);
		return mv;
	}

	@GetMapping("memberLogout")
	public ModelAndView memberLogout(HttpSession session) throws Exception {
		String path = "../";
		String redirectURI = (String) session.getAttribute("redirectURI");
		// 로그아웃
		session.invalidate();
		ModelAndView mv = new ModelAndView();

		if (redirectURI != null) {
			path = redirectURI;
		}

		mv.addObject("msg", "로그아웃되었습니다.");
		mv.addObject("path", path);
		mv.setViewName("common/result");
		return mv;
	}

	@PostMapping("memberLogin")
	public ModelAndView memberLogin(MemberVO memberVO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		memberVO = memberService.memberLogin(memberVO);
		String msg = "로그인 실패";
		if (memberVO != null) {
			msg = "로그인 성공";
			session.setAttribute("member", memberVO);
		}
		mv.addObject("msg", msg);
		mv.addObject("path", "../");
		mv.setViewName("common/result");
		return mv;
	}

	@GetMapping("memberLogin")
	public void memberLogin() throws Exception {

	}
	public MemberVO getMemberVO() throws Exception{
		return new MemberVO(); 
	}
	@GetMapping("memberJoin")
	public String memberJoin(MemberVO memberVO) throws Exception {
		return "member/memberJoin";
	}

	@Transactional
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(@Valid MemberVO memberVO,BindingResult bindingResult/*검증하는애 바로 뒤에 써야함!!*/, MultipartFile files) throws Exception {
		ModelAndView mv = new ModelAndView();
		Boolean check = false;
		if(memberService.memberJoinValidate(memberVO,bindingResult)) {
			check = true;
		}
		if(bindingResult.hasErrors()) {
			mv.setViewName("/member/memberJoin");
		} else {
			int result = memberService.memberJoin(memberVO, files);
			String msg = "가입 실패";
			String path = "../";
			if (result > 0)
				msg = "가입 완료";
			mv.addObject("", check);
			mv.addObject("msg", msg);
			mv.addObject("path", path);
			mv.setViewName("common/result");
		}
		return mv;
	}
}
