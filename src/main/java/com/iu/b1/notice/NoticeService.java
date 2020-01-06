package com.iu.b1.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b1.member.MemberFilesVO;
import com.iu.b1.util.FilePathGenerator;
import com.iu.b1.util.FileSaver;
import com.iu.b1.util.Pager;

@Service
public class NoticeService {
	@Resource(name = "noticeMapper")
	private NoticeMapper noticeMapper;
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileSaver fileSaver;
	@Autowired
	private NoticeFilesMapper noticeFilesMapper;
	
	public List<NoticeFilesVO> boardImage(NoticeVO noticeVO) throws Exception{
		return noticeFilesMapper.boardImage(noticeVO);
	}
	public List<NoticeVO> boardList(Pager pager) throws Exception{
		pager.makeRow();
		pager.makePage(noticeMapper.boardCount(pager));
		return noticeMapper.boardList(pager);
	}
	public NoticeVO boardSelect(NoticeVO noticeVO) throws Exception{
		return noticeMapper.boardSelect(noticeVO);
	}
	public int noticeWrite(NoticeVO noticeVO, MultipartFile[] files) throws Exception {
		File file = filePathGenerator.getUseClassPathResource("notice");
		int result = noticeMapper.boardWrite(noticeVO);
		List<NoticeFilesVO> noticeFilesVOs = new ArrayList<>();
		if (result > 0) {
			for (int i = 1; i < files.length; i++) {
				String fileName = fileSaver.save(file, files[i]);
				String originalName = files[i].getOriginalFilename();
				System.out.println("oname : " + files[i].getOriginalFilename());
				NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
				noticeFilesVO.setFname(fileName);
				noticeFilesVO.setNum(noticeVO.getNum());
				noticeFilesVO.setOname(originalName);
				//result = noticeFilesMapper.noticeFileWrite(noticeFilesVO);
				noticeFilesVOs.add(noticeFilesVO);
			}
			noticeFilesMapper.noticeFileWrite(noticeFilesVOs);
		}
		return result;
	}
}
