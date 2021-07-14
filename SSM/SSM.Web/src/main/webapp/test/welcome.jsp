<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
<script src="<%=request.getContextPath() %>/js/jquery-1.8.0.js"></script>
<html>
<head>

<title>welcome.jsp</title>
<style type="text/css">
tr:hover{
  background:black;
  color:yellow;
}

</style>
</head>
<script type="text/javascript">
	$(function() {
		getDepar();	
	}); 

	
	function getDepar() {
		$.ajax({
			type : "post",
			url : '<%=request.getContextPath()%>/queryDepart',
			success : function(deparList) {
				var html = "";
				$.each(deparList,function(i){
					html += "<tr  height='40px'><td align='center'>"+deparList[i].id+"</td>"+
					"<td  align='center'>"+deparList[i].name+"</td>"+
					"<td  align='center'>"+deparList[i].manager+"</td>"+
					"<td  align='center'>"+
					"<input type='button' value='添加' onclick=\"javascript:location.href='<%=request.getContextPath()%>/test/addDepart.jsp'\">"+
					"<input type='button' value='修改' onclick=\"javascript:location.href='<%=request.getContextPath()%>/"+deparList[i].id+"/getDepart'\">"+
					"<input type='button' value=\"删除\"onclick=delDepar('"+deparList[i].id+"')>"+ 
					"</td></tr>";
					
				});
				$('#deparId').html(html);
			}
		})
	}
</script>
<body bgcolor=#FFE4C4>
	<div align="center">
		<table class="imagetable" style="font-size: 15px;">
			<tr height=10>
				<th>部门编号</th>
				<th>部门名称</th>
				<th>部门经理</th>
				<th>操作</th>
			</tr>
			<tbody id="deparId"></tbody >
		</table>
	</div>
	<hr>
	 <%-- <jsp:include page="wel.jsp" flush="true"/> --%>
</body>

<script type="text/javascript">
function delDepar(id) {
	if (confirm("是否删除id为'"+id+"'的部门信息?")) {
		$.ajax({  
			url:'<%=request.getContextPath()%>/delDepart/'+id,  
            type:'POST',
            success:function(data){  
				if (data == "s") {
					alert("删除成功");
					window.location.href="<%=request.getContextPath()%>/test/welcome.jsp";
				}else{
					alert("删除失败");
				}
            }  
        })  
	}
}
</script>
</html>