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

		<title>My JSP 'register.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<style type="text/css">
			.errorMessage {color: red;}
		</style>
	</head>

	<body>
		<div align="center"
			style="margin-top: 80; border: solid; width: 350; margin-left: auto; margin-right: auto; border-color: black">
			<h2>
				用户注册
			</h2>

			<s:form action="userRegister.html">

				<s:textfield name="username" label="用户名" size="20"></s:textfield>

				<s:password name="password" label="密码" size="20"></s:password>

				<s:password name="repassword" label="密码确认" size="20"></s:password>

				<s:textfield name="email" label="电子邮件" size="20"></s:textfield>

				<s:submit value="注册"></s:submit>
			</s:form>
		</div>
	</body>
</html>
