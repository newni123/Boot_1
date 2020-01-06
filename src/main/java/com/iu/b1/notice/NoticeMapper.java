package com.iu.b1.notice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.iu.b1.util.Pager;
@Repository
@Mapper
public interface NoticeMapper {
	public List<NoticeVO> boardList(Pager pager) throws Exception;
	public int boardWrite(NoticeVO noticeVO) throws Exception;
	public int noticeFilesWrite(List<NoticeFilesVO> noticeFilesVOs)throws Exception;
	public int boardCount(Pager pager) throws Exception;
	public NoticeVO boardSelect(NoticeVO noticeVO) throws Exception;
}
