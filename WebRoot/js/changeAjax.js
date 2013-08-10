///修改  role Ajax
var id;//声明一个变量，保存ID值，以备回调函数使用
var xmlHttpRequest = null; //声明一个空对象以接收XMLHttpRequest对象
function ajaxRole(i) {
	id = i;
	changeAjax();
}

function changeAjax() {

	if (window.ActiveXObject) // IE浏览器
	{
		xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	} else if (window.XMLHttpRequest) //除IE外的其他浏览器实现
	{
		xmlHttpRequest = new XMLHttpRequest();
	}

	if (null != xmlHttpRequest) {

		var url = "changerole.html";
		xmlHttpRequest.open("post", url, true);
		xmlHttpRequest.onreadystatechange = changeCallback;
		xmlHttpRequest.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		xmlHttpRequest.send();
	}

}
changeCallback = function() {
	if (xmlHttpRequest.readyState == 4) {
		if (xmlHttpRequest.status == 200) {

			var roleTd = document.getElementById("role" + id);

			roleTd.innerHTML = "";
			var select = document.createElement("select");
			var option1 = document.createElement("option");
			var option2 = document.createElement("option");
			select.id = "roleSelect" + id;
			roleTd.appendChild(select);
			option1.innerHTML = "ROLE";
			option2.innerHTML = "ADMIN";
			select.appendChild(option1);
			select.appendChild(option2);
			document.getElementById("rem" + id).disabled = "disabled";
			var button = document.getElementById("change" + id);
			button.onclick = realAjax;
			button.innerHTML = "保存";

		}
	}
}

function realAjax() {

	var role = document.getElementById("roleSelect" + id).value;

	if (null != xmlHttpRequest) {

		var url = "change.html";
		xmlHttpRequest.open("post", url, true);
		xmlHttpRequest.onreadystatechange = changeCallback2;
		xmlHttpRequest.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		xmlHttpRequest.send("id=" + id + "&role=" + role);
	}
}

function changeCallback2() {
	if (xmlHttpRequest.readyState == 4) {
		if (xmlHttpRequest.status == 200) {
			var responseText = xmlHttpRequest.responseText;
			var role = document.getElementById("roleSelect" + id).value;
			document.getElementById("role" + id).innerHTML = role;
			document.getElementById("rem" + id).disabled = "";
			var button = document.getElementById("change" + id);
			button.innerHTML = "修改";
			button.onclick = changeAjax;
		}
	}
}
