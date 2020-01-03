<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
<c:import url="../template/nav.jsp"></c:import>
	<form:form action="./memberJoin" method="post" enctype="multipart/form-data" modelAttribute="memberVO">
	<div class="container">
	<h1>Member Join Page</h1>
		 <div class="form-group">
		    <label for="id">아이디</label>
		    <form:input path="id" class="form-control" id="id" placeholder="아이디 입력" />
		    <form:errors path="id"/>
	    </div>		
		 <div class="form-group">
		    <label for="pw">비밀번호</label>
		    <form:password path="pw" class="form-control" id="pw" placeholder="비밀번호 입력" />
		    <form:errors path="pw" cssStyle="color:red"/>
		 </div>
		 <div class="form-group">
		    <label for="pw2">비밀번호</label>
		    <form:password path="pw2" class="form-control" id="pw2" placeholder="비밀번호 확인" />
		    <form:errors path="pw2"/>
		 </div>
		 <div class="form-group">
		 	<label for="name">이름</label>
		    <form:input path="name" class="form-control" id="name" placeholder="이름 입력" />
		    <form:errors path="name"/>
	    </div>
	    <div class="form-group">
	      <label for="email">이메일</label>
	      <form:input path="email" class="form-control" id="email" placeholder="이메일 입력" />
	      <form:errors path="email"/>
	    </div>
	    <div class="form-group">
	      <label for="File">파일</label>
	      <input type="file" class="form-control" id="files" name="files">
	    </div>
	    <button type="submit" class="btn btn-default">Submit</button>
	</div>
	</form:form>
		
</body>
</html>