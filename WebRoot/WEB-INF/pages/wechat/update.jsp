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

		<title>修改待办事项</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

	</head>

	<body>
		<h2 align="center">
			修改事项
		</h2>
		<div align="center">
			<form action="update">
				<s:textfield name="task.content" size="40" value="%{task.content}"></s:textfield>

				<select name="time">
					<option>
						1
					</option>
					<option>
						2
					</option>
					<option>
						3
					</option>
					<option>
						5
					</option>
				</select>
				天完成
				<s:hidden name="task.id" value="%{task.id}"></s:hidden>
				<br />
				<input type="submit" value="保存更改" />
			</form>
		</div>

	</body>
</html>
