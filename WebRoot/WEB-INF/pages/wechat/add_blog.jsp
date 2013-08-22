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
window.onload = function() {
	var input = document.getElementById("in");
	input.focus();
}
</script>
		<script type="text/javascript" src="./js/util.js">
</script>
	</head>

	<body>
		<div align="center">

			<s:form action="addBlog.html" cssStyle="align: center">

				<s:textfield name="newsItem.Title" label="标题" size="50" id="in"></s:textfield>
				<s:textarea name="newsItem.Description" label="简述" rows="3"
					cssStyle="width: 333px;max-width: 333px; overflow-y: hidden "></s:textarea>
				<s:textfield name="newsItem.Url" label="文章地址" size="50"></s:textfield>
				<s:textfield name="newsItem.PicUrl" label="图片地址" size="50"></s:textfield>

				<s:submit value="保存内容" align="center"></s:submit>

			</s:form>
		</div>
	</body>
</html>
