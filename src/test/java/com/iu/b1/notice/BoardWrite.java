package com.iu.b1.notice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class BoardWrite {
	@Autowired
	private NoticeMapper noticeMapper;
	@Test
	void test() throws Exception {
		for(int i = 30; i < 60; i++) {
			NoticeVO noticeVO = new NoticeVO();
			noticeVO.setContents("내용"+i);
			noticeVO.setTitle("제목"+i);
			noticeVO.setWriter("작성자"+i);
			noticeMapper.boardWrite(noticeVO);
		}
	}

}
