<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp" />
</head>
<body>
<c:import url="../template/nav.jsp" />

<div class="container">
		    <div class="form-group">
		      <label for="title">제목 ${vo.title}</label>
		    </div>
				<div class="form-group">
		      <label for="writer">작성자${vo.writer}</label>
		    </div>
			<div class="form-group">
		      <label for="contents">내용${vo.contents}</label>
			</div>
			<c:if test="${imgs ne null}">
			<c:forEach items="${imgs}" var="img"> 
				<img alt="이미지가 없을 때 뜨는 문구" src="${pageContext.request.contextPath}/notice/${img.fname}">
			</c:forEach>
			</c:if>
</div>


</body>
</html>