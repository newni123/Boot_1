<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"/>
</head>
<body>
<c:import url="../template/nav.jsp"/>
	<div class="container">
		 <form action="./memberLogin" method="post">
		    <div class="form-group">
		      <label for="id">아이디</label>
		      <input type="text" class="form-control" id="id" placeholder="아이디를 입력하세요" name="id">
		    </div>
		    <div class="form-group">
		      <label for="pw">비밀번호</label>
		      <input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw">
		    </div>
		    <div class="checkbox">
		      <label><input type="checkbox" name="remember"> Remember me</label>
		    </div>
		    <button type="submit" class="btn btn-default">Submit</button>
	  </form>
	</div>
</body>
</html>