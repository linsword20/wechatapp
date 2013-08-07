///标记 Ajax
var xmlHttpRequest = null; //声明一个空对象以接收XMLHttpRequest对象
var id;
var content;
var stopTime;
function main(i) {
	id = i;
	ajaxAlter();
}
//修改前，提取数据ajax
function ajaxAlter() {
	if (window.ActiveXObject) // IE浏览器
	{
		xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	} else if (window.XMLHttpRequest) //除IE外的其他浏览器实现
	{
		xmlHttpRequest = new XMLHttpRequest();
	}

	if (null != xmlHttpRequest) {

		var url = "alter.html";
		xmlHttpRequest.open("post", url, true);
		xmlHttpRequest.onreadystatechange = alterCallback;
		xmlHttpRequest.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		xmlHttpRequest.send("id=" + id); //发送需要修改的task的id值
	}
}
function alterCallback() {
	if (xmlHttpRequest.readyState == 4) {
		if (xmlHttpRequest.status == 200) {
			//得到该task的content
			var responseText = xmlHttpRequest.responseText;
			//修改为input，使可以修改
			var td = document.getElementById("content" + id)
			var input = document.createElement("input");
			td.align = "center"
			input.type = "text";
			input.value = responseText
			input.size = 60

			input.id = "genInput" + id;
			td.innerHTML = "";
			td.appendChild(input);

			//date
			var dateTd = document.getElementById("time" + id);
			var text = document.createTextNode("天完成");
			dateTd.innerHTML = "";
			var select = document.createElement("select");
			var option1 = document.createElement("option");
			var option2 = document.createElement("option");
			var option3 = document.createElement("option");
			var option5 = document.createElement("option");
			select.id = "genTime" + id;
			dateTd.appendChild(select);
			dateTd.appendChild(text);
			option1.innerHTML = 1;
			option2.innerHTML = 2;
			option3.innerHTML = 3;
			option5.innerHTML = 5;
			select.appendChild(option1);
			select.appendChild(option2);
			select.appendChild(option3);
			select.appendChild(option5);

			document.getElementById("mark" + id).disabled = "disabled";
			document.getElementById("del" + id).disabled = "disabled";

			//将button改为保存
			var button = document.getElementById("alter" + id);
			button.innerHTML = "保存";
			button.onclick = ajaxUpdate;

		}
	}
}

//执行更新ajax
ajaxUpdate = function() {
	content = document.getElementById("genInput" + id).value;
	time = document.getElementById("genTime" + id).value;
	if (null != xmlHttpRequest) {

		var url = "update.html";
		xmlHttpRequest.open("post", url, true);
		xmlHttpRequest.onreadystatechange = updateCallback;
		xmlHttpRequest.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		xmlHttpRequest.send("content=" + content + "&id=" + id + "&time="
				+ time);
	}

}

function updateCallback() {
	if (xmlHttpRequest.readyState == 4) {
		if (xmlHttpRequest.status == 200) {
			var stopTime = xmlHttpRequest.responseText;
			document.getElementById("content" + id).innerHTML = content;
			document.getElementById("content" + id).align = "center";
			var dateTd = document.getElementById("time" + id);
			dateTd.innerHTML = stopTime;
			document.getElementById("flag" + id).innerHTML = "待办";
			document.getElementById("mark" + id).disabled = "";
			document.getElementById("del" + id).disabled = "";
			
			var button = document.getElementById("alter" + id);
			button.innerHTML = "修改";
			button.onclick = ajaxAlter;

		}
	}
}
