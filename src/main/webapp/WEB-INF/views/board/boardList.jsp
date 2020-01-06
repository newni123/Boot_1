<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<form id="frm" action="noticeList">
			<input type="hidden" id="curPage" value="1" name="curPage"> <select
				name="kind">
				<option id="kindTitle" value="kindTitle">title</option>
				<option id="kindContents" value="kindContents">contents</option>
				<option id="kindWriter" value="kindWriter">writer</option>
			</select> <input type="text" name="search" value="${pager.search}">
			<button>검색</button>
		</form>
	</div>
	<div><br></div>
	<div class="container">
		<table class="table table-hover">
			<tr>
				<td>글번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
			<c:forEach items="${list}" var="vo">
				<tr>
					<td>${vo.num}</td>
					<td><a href="./noticeSelect?num=${vo.num}">${vo.title}</a></td>
					<td>${vo.writer}</td>
					<td>${vo.regDate}</td>
					<td>${vo.hit}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="container">
		<ul class="pagination">
				<c:if test="${pager.curBlock > 1 }">
					<li><span id="${pager.startNum - 1}" class="list">이전</span></li>
				</c:if>
				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<li><span id="${i}" class="list"><a href="./noticeList?curPage=${i}">${i}</a></span></li>
				</c:forEach>
				<c:if test="${pager.curBlock < pager.totalBlock}">
					<li><span id="${pager.lastNum + 1}" class="list">다음</span></li>
				</c:if>
			</ul>
	</div>
		<script type="text/javascript">
			var kind = '${pager.kind}'
			if (kind == '') {
				kind = "kindTitle"
			}
			$("#" + kind).prop("selected", true);
			$(".list").click(function() {
				$("#curPage").val($(this).attr("id"));
				$("#frm").submit();
			});
		</script>
</body>
</html>