package com.iu.b1.member;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.iu.b1.member.MemberMapper;
import com.iu.b1.member.MemberVO;
@SpringBootTest
@Transactional
@Rollback
class MemberTest {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	void test() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("newni");
		memberVO.setPw("1234");
		memberVO.setEmail("newni123@email.com");
		memberVO.setName("newni");
		int result = memberMapper.memberJoin(memberVO);
		assertEquals(1, result);
	}

}
