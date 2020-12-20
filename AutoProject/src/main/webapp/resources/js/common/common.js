
$.fn.serializeObject = function() {
  "use strict"
  var result = {}
  var extend = function(i, element) {
    var node = result[element.name]
    if ("undefined" !== typeof node && node !== null) {
      if ($.isArray(node)) {
        node.push(element.value)
      } else {
        result[element.name] = [node, element.value]
      }
    } else {
      result[element.name] = element.value
    }
  }

  $.each(this.serializeArray(), extend)
  return result
}

function existFunction(func) {
	var f = "";
	if (func.indexOf("(") > -1) {
		f = func.substring(0, func.indexOf("("));
	} else {
		f = func;
	}
	return typeof window[f] === "function";
}

function ajax(params, bfF, suF, errF, afF) {

	// 실행 이전 function 실행
	if (existFunction(bfF)) {
		eval(efF + "()");
	}

	// ajax 실행

	$.ajax({
		type : "POST",
		url : "/ajax.do",
		data : JSON.stringify(params),
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		async : false
	})
	// HTTP 요청이 성공하면 요청한 데이터가 done() 메소드로 전달됨.
	.done(function(msg) {
		if (existFunction(suF)) {
			var p = suF.indexOf("(");
			if (p > -1) {
				eval(suF);
			} else {
				eval(suF + "(msg)");
			}
		}
	})
	// HTTP 요청이 실패하면 오류와 상태에 관한 정보가 fail() 메소드로 전달됨.
	.fail(function(xhr, status, errorThrown) {
		if (existFunction(errF)) {
			eval(errF + "()");
		}
	})
	// HTTP 요청이 성공하거나 실패하는 것에 상관없이 언제나 always() 메소드가 실행됨.
	.always(function(xhr, status) {
		if (existFunction(afF)) {
			eval(afF + "()");
		}

	});
}

// 폼생성
function makeForm(actionURL, fName){
	var f = document.createElement("form");
	f.name = fName;
	f.id = fName;
	f.action = actionURL;
	f.method = "post";
	f.target = "";
	return f;
}

//폼- 데이터 추가
function addData(name, value){
	var elem = document.createElement("input");
	elem.setAttribute("type", "hidden");
	elem.setAttribute("name", name);
	elem.setAttribute("value", value);
	
	return elem;
}