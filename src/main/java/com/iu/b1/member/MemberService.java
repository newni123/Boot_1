package com.iu.b1.member;

import java.io.File;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b1.util.FilePathGenerator;
import com.iu.b1.util.FileSaver;

@Transactional(rollbackFor = Exception.class)
@Service
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileSaver fileSaver;
	@Autowired
	private MemberFilesMapper memberFilesMapper;

	public int memberJoin(MemberVO memberVO, MultipartFile files) throws Exception {
		// 파일을 저장할 폴더
		File file = filePathGenerator.getUseClassPathResource("upload");
		String fileName = fileSaver.save(file, files);
		String originalName = files.getOriginalFilename();
		System.out.println(fileName);
		int result = memberMapper.memberJoin(memberVO);
		if (result > 0) {
			MemberFilesVO memberFilesVO = new MemberFilesVO();
			memberFilesVO.setFname(fileName);
			memberFilesVO.setId(memberVO.getId());
			memberFilesVO.setOname(originalName);
			result = memberFilesMapper.memberFilesInsert(memberFilesVO);
		}
		return result;
	}

	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		return memberMapper.memberLogin(memberVO);
	}

	public MemberFilesVO memberImage(MemberVO memberVO) throws Exception {
		return memberMapper.memberImage(memberVO);
	}

	public MemberFilesVO memberFileSelect(MemberFilesVO memberFilesVO) throws Exception {
		return memberFilesMapper.memberFileSelect(memberFilesVO);
	}

	public boolean memberJoinValidate(MemberVO memberVO, BindingResult bindingResult) throws Exception {
		boolean check = false;// true -> error, false-> ok

		// annotation 검증 결과
		if (bindingResult.hasErrors()) {
			check = true;
		}

		// pw가 일치 하는지 검증
		if (!memberVO.getPw().equals(memberVO.getPw2())) {
			check = true;
			bindingResult.rejectValue("pw2", "memberVO.pw.notEqual");
			// form의 path명, properties의 키
		}

		memberVO = memberMapper.memberCheck(memberVO);

		if (memberVO != null) {
			check = true;
			bindingResult.rejectValue("id", "memberVO.id.check");
		}

		return check;
	}
}