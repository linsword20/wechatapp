//删除确认
del = function(id) {
	if (confirm("Are you sure?")) {
		window.location.href = "delete.html?task.id=" + id;
	}
	return false;
}


//动态增加表单
var i = 1;
function AddElement() {
	i++;
	var TemO = document.getElementById("add");
	var tr = document.createElement("tr");
	var td = document.createElement("td");
	TemO.appendChild(tr);
	tr.appendChild(td);
	
	var newInput = document.createElement("input");
	newInput.type = "text";
	newInput.name = "content";
	newInput.size = 40;
	
	td.innerHTML = i + ".";
	td.appendChild(newInput);
	
	var td2 = document.createElement("td");
	tr.appendChild(td2);
	var newSelect = document.createElement("select");
	var newOption1 = document.createElement("option");
	var newOption2 = document.createElement("option");
	var newOption3 = document.createElement("option");
	var newOption5 = document.createElement("option");
	newSelect.name = "time";
	td2.appendChild(newSelect);
	newOption1.innerHTML = 1;newSelect.appendChild(newOption1);
	newOption2.innerHTML = 2;newSelect.appendChild(newOption2);
	newOption3.innerHTML = 3;newSelect.appendChild(newOption3);
	newOption5.innerHTML = 5;newSelect.appendChild(newOption5);
	var x = document.createTextNode("天完成");
	td2.appendChild(x);
	newInput.focus();
}


