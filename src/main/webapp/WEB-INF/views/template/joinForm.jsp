<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <form action="./memberJoin" method="post" enctype="multipart/form-data">
	    <div class="form-group">
	      <label for="id">아이디</label>
	      <input type="text" class="form-control" id="id" placeholder="아이디 입력" name="id">
	    </div>
	    <div class="form-group">
	      <label for="pw">비밀번호</label>
	      <input type="password" class="form-control" id="pw" placeholder="비밀번호 입력" name="pw">
	    </div>
	        <div class="form-group">
	      <label for="pw2">비밀번호 확인</label>
	      <input type="password" class="form-control" id="pw2" placeholder="비밀번호 확인" name="pw2">
	    </div>
	    <div class="form-group">
	      <label for="name">이름</label>
	      <input type="text" class="form-control" id="name" placeholder="이름 입력" name="name">
	    </div>
	    <div class="form-group">
	      <label for="email">이메일</label>
	      <input type="email" class="form-control" id="email" placeholder="이메일 입력" name="email">
	    </div>
	    <div class="form-group">
	      <label for="File">파일</label>
	      <input type="file" class="form-control" id="files" name="files">
	    </div>
	    <div class="checkbox">
	      <label><input type="checkbox" name="remember"> Remember me</label>
	    </div>
	    <button type="submit" class="btn btn-default">Submit</button>
 </form>