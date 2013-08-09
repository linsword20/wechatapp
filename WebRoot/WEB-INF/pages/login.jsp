<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title>系统登录</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>

		<div align="center"
			style="margin-top: 80; border: solid; width: 350; margin-left: auto; margin-right: auto; border-color: black">
			<h2>
				系统登录
			</h2>
			<s:form action="userlogin">
				<s:textfield name="user.username" label="用户名" size="20"></s:textfield>
				<s:password name="user.password" label="密码" size="20"></s:password>
				<s:submit value="登录"></s:submit>
			</s:form>

		</div>
	</body>
</html>
