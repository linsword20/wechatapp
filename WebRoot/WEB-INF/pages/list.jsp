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

		<title>事项列表</title>
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
		<script type="text/javascript" src="./js/markAjax.js">
</script>

		<script type="text/javascript" src="./js/updateAjax.js">
</script>

<script type="text/javascript" src="./js/util.js">
</script>
	</head>
	<body>

		<h1 align="center">
			待办事件列表
		</h1>
		<div align="center" style="font-size: large">
			<a href="add.html">添加待办</a>&nbsp;
			<a href="list.html">显示未完成</a>&nbsp;
			<a href="list1.html">显示已完成</a>&nbsp;
			<a href="list2.html">显示全部</a>&nbsp;
			<s:property value="#session.user.username"/>
			<a href="userlogout.html">注销</a>

		</div>
		<table width="80%" align="center">
			<tr bgcolor="grey">
				<th width="50">
					序号
				</th>
				<th width="450">
					事项
				</th>
				<th width="90">
					最后日期
				</th>
				<th width="60">
					状态
				</th>
				<th width="50">
					标记
				</th>
				<th width="50">
					删除
				</th>
				<th width="50">
					修改
				</th>
			</tr>
			<s:iterator value="#request.list" var="task">
				<tr>
					<td align="center">
						<s:property value="#task.id" />
					</td>
					<td align="center" id="content<s:property value="#task.id" />">
						<s:property value="#task.content" />
					</td>
					
					<td align="center" id="time<s:property value="#task.id" />">
						<s:date name="#task.stopTime" format="yyyy-MM-dd"/>
					</td>
					
					<td align="center" id="flag<s:property value="#task.id" />">
						<s:if test="#task.flag == 0">待办</s:if>
						<s:else>已完成</s:else>
					</td>
					<td align="center">
						<s:if test="#task.flag == 0">
							<button onclick="ajaxMark(<s:property value="#task.id" />);"
								id="mark<s:property value="#task.id" />" style="width: 50">
								完成
							</button>
						</s:if>
						<s:else>
							<button onclick="ajaxMark(<s:property value="#task.id" />);"
								id="mark<s:property value="#task.id" />" style="width: 50"
								disabled="disabled">
								完成
							</button>
						</s:else>

					</td>
					<td align="center">
						<s:if test="#task.flag == 0">
							<button onclick="return del(<s:property value="#task.id" />);"
								style="width: 50" id="del<s:property value="#task.id" />">
								删除
							</button>
						</s:if>
						<s:else>
							<button onclick="return del(<s:property value="#task.id" />);"
								style="width: 50"  id="del<s:property value="#task.id" />" disabled="disabled" >
								删除
							</button>
						</s:else>
					</td>
					<td align="center">
						<button onclick="main(<s:property value="#task.id" />)"
							style="width: 50" id="alter<s:property value="#task.id" />">
							修改
						</button>
					</td>

				</tr>
			</s:iterator>
		</table>
	</body>
</html>
