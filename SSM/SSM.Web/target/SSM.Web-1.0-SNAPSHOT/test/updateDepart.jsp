<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改页面</title>

</head>
<body bgcolor="pink">
<div align="center">
	<form action="<%=request.getContextPath()%>/updateDepart" method="post">
		<c:forEach var="department" items="${deparList}">
			<input type="hidden" name="id" value="${department.getId()}"/>
			<table border="1">
				<tr>
					<th>新部门名称:</th>
					<th><input type="text" name="name" placeholder="${department.getName()}"/></th>
				</tr>
				<tr>
					<th>新部门经理:</th>
					<th><input type="text" name="manager" placeholder="${department.getManager()}"/></th>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="reset" value="重置">
						<input type="submit" value="修改"/>
						<input type="button" value="返回" onclick="back()">
					</td>
				</tr>
			</table>
		</c:forEach>
	</form>
	<input type="hidden" value="${err}" id="errId"/>
</div>
</body>
<script type="text/javascript">
	var value = document.getElementById("errId").value;
	if(2 == value) {
		alert("不能为空");
		window.history.back();
	}
	
	function back(){
		window.history.back();
	}
</script>
</html>