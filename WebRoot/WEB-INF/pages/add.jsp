<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>记录待办事情</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">
window.onload = function()
{
	var input = document.getElementById("in");
	input.focus();
}
</script>
<script type="text/javascript" src="./js/util.js"></script>	
</head>

	<body>
		<h2 align="center">添加待办事</h2><br />
		
		<form style="align: center" method="post" action="save.html">
			<div align="center">
				<input type="button" value="增加事项" onclick="AddElement()"/>
				<input type="submit" value="保存待办" />
			</div>
			
			<table align="center">
				<tbody id="add"“>
					<tr>
						<td>
							1.<input type="text" name="content" size="40" id="in"/>
						</td>
						<td>
							<select name="time">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>5</option>
							</select>天完成
						</td>
					</tr>
				</tbody>
			</table>
			
		</form>
	</body>
</html>
