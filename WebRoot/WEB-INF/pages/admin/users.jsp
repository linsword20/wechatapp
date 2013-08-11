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

		<title>用户管理</title>

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
		<script type="text/javascript" src="./js/changeAjax.js">
</script>

	</head>

	<body>
		<div align="center">
		<h2>用户管理</h2>
		<a href="log.html">查看日志</a>
		<a href="adminlogout.html">注销</a>
		</div>
		<table width="80%" align="center">
			<tr bgcolor="grey">
				<th width="50">
					序号
				</th>
				<th width="80">
					用户名
				</th>
				<th width="120">
					电子邮件
				</th>
				<th width="80">
					微信ID
				</th>
				<th width="80">
					角色
				</th>
				<th width="80">
					删除
				</th>
				<th width="80">
					修改权限
				</th>
			</tr>
			<s:iterator value="#request.users" var="user">
				<tr>
					<td>
						<s:property value="#user.id" />
					</td>
					<td>
						<s:property value="#user.username" />
					</td>
					<td>
						<s:property value="#user.email" />
					</td>
					<td>
						<s:property value="#user.wid" />
					</td>
					<td id="role<s:property value="#user.id"/>">
						<s:property value="#user.role"/>
					</td>
					<td>
						<button onclick="return rem(<s:property value="#user.id"/>)"
							style="width: 50" id="rem<s:property value="#user.id"/>">
							删除
						</button>
					</td>
					<td>
						<button onclick="ajaxRole(<s:property value="#user.id"/>)"
							style="width: 50" id="change<s:property value="#user.id"/>">
							修改
						</button>
					</td>
				</tr>
			</s:iterator>

		</table>

	</body>
</html>
