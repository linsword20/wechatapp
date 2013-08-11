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

		<title>查看日志</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<style type="text/css">
<!--
a:hover {
	color: red;
}

a:link {
	text-decoration: none;
}
-->
</style>

	</head>

	<body>
		<div align="center">
			<h2>
				查看日志
			</h2>
			<a href="manage.html">用户管理</a>
			<a href="adminlogout.html">注销</a>
		</div>
		<table width="80%" align="center">
			<tr bgcolor="grey">
				<th width="80">
					序号
				</th>
				<th width="80">
					用户名
				</th>
				<th width="500">
					事件
				</th>
				<th width="60">
					时间
				</th>
			</tr>
			<s:iterator value="#request.list" var="log">
				<tr bgcolor="">
					<td align="center">
						<s:property value="#log.id" />
					</td>
					<td align="center">
						<s:property value="#log.username" />
					</td>
					<td align="center">
						<s:property value="#log.description" />
					</td>
					<td align="center">
						<s:date name="#log.timestamp" format="yyyy-MM-dd hh:mm:ss" />
					</td>
				</tr>
			</s:iterator>
		</table>
		<div align="center">
		<a href="log.html">首页</a>
		<%
			int i = Integer.parseInt(request.getAttribute("page").toString());
			int max = Integer.parseInt(request.getAttribute("max").toString());
			int j = i - 1;	
			if(i <= 1){
				j = i;
			}
			int k = i + 1;
			if(i >= max)
			{
				k = i;
			}
		%>
		<a href="log.html?page=<%=j%>">上一页</a>
		<s:property value="#request.page" />
		<a href="log.html?page=<%=k%>">下一页</a>
		<a href="log.html?page=end">尾页</a>
		</div>
	</body>
</html>
