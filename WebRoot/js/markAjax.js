///标记 Ajax
var xmlHttpRequest = null; //声明一个空对象以接收XMLHttpRequest对象
var numb;//声明一个变量，保存ID值，以备回调函数使用
function ajaxMark(id) {
	numb = id;
	if (window.ActiveXObject) // IE浏览器
	{
		xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	} else if (window.XMLHttpRequest) //除IE外的其他浏览器实现
	{
		xmlHttpRequest = new XMLHttpRequest();
	}

	if (null != xmlHttpRequest) {

		var url = "mark.html";
		xmlHttpRequest.open("post", url, true);
		xmlHttpRequest.onreadystatechange = markCallback;
		xmlHttpRequest.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		xmlHttpRequest.send("id=" + id);
	}
}
function markCallback() {	
	if (xmlHttpRequest.readyState == 4) {
		if (xmlHttpRequest.status == 200) {
			document.getElementById("flag"+numb).innerHTML = "已完成";
			document.getElementById("mark"+numb).disabled = "disabled";
			document.getElementById("del"+numb).disabled = "disabled";
		}
	}
}

