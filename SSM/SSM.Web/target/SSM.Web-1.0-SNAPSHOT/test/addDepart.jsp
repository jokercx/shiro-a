<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="<%=request.getContextPath()%>/js/jquery-1.8.0.js"></script>
<title>添加页面</title>
</head>
<body bgcolor="pink">
	<div align="center">
		<form id="formId">
			<table border="1">
				<tr>
					<th><input type="text" name="name" id="nameId"
						placeholder="请输入部门名称" /></th>
				</tr>
				<tr>
					<th><input type="text" name="manager" id="managerId"
						placeholder="请输入部门经理" /></th>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="reset" value="重置">
						<input type="button" value="提交" id="subId" /> <input
						type="button" value="返回" onclick="back()" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
<script type="text/javascript">
	$(function() {//页面加载完成就执行以下函数
		$("#subId").click(function() {//鼠标点击事件,点击提交就执行setData函数
			setData();
		})
	});
	function setData() {
		var name = $("#nameId").val();//得到输入的部门名称
		var manager = $("#managerId").val();//得到输入的部门经理
		if ("" == name || "" == manager) {//判断是否为null
			alert("数据不能为空");
			window.close();
		} else {
			$.ajax({
				type : "post",
				url : '<%=request.getContextPath()%>/addDepart',
				data : $("#formId").serialize(),
				success : function(mark) {
					if (mark == "s") {
						alert("添加成功");
						window.location.href = "welcome.jsp";
					} else {
						alert("添加失败");
					}
				},
			});
		}
	}

	function back() {
		window.history.back();
	}
</script>
</html>