package com.iu.b1.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface MemberMapper {
	public int memberJoin(MemberVO memberVO) throws Exception;
	public MemberVO memberLogin(MemberVO memberVO) throws Exception;
	public MemberFilesVO memberImage(MemberVO memberVO) throws Exception;
	public MemberVO memberCheck(MemberVO memberVO) throws Exception;
}
