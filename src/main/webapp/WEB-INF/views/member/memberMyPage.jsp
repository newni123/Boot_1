<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
<c:import url="../template/nav.jsp"></c:import>
	<h1>Member My Page</h1>
	 <form action="./memberMypage" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="id">아이디</label>
      <input type="text" class="form-control" id="id" value="${member.id}" name="id">
    </div>
    <div class="form-group">
      <label for="pw">비밀번호</label>
      <input type="password" class="form-control" id="pw" placeholder="비밀번호 입력"  value="${member.pw}"name="pw">
    </div>
    <div class="form-group">
      <label for="name">이름</label>
      <input type="text" class="form-control" id="name" placeholder="이름 입력"  value="${member.name}"name="name">
    </div>
    <div class="form-group">
      <label for="email">이메일</label>
      <input type="email" class="form-control" id="email" placeholder="이메일 입력"  value="${member.email}"name="email">
    </div>
     <div class="form-group">
	  	<img alt="" src="../upload/${image.fname}" style="width: 15%">
  	</div>
 	 <div class="form-group">
   	 <button type="submit" class="btn btn-default">Submit</button>
	   	 <a class="btn btn-primary" href="./memberFileDown?fnum=${image.fnum}">FileDown</a>
    </div>
  </form>
</body>
</html>