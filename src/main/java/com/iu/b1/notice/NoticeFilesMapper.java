package com.iu.b1.notice;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeFilesMapper {
	//public int noticeFileWrite(NoticeFilesVO noticeFilesVO) throws Exception;
	public int noticeFileWrite(List<NoticeFilesVO> noticeFilesVOs) throws Exception;
	public ArrayList<NoticeFilesVO> boardImage(NoticeVO noticeVO) throws Exception;
}
