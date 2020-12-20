/**
 * 
 */

const dataSource = {
	withCredentials : false,
	initialRequest : true,
	api : {
		readData : {
			url : '/setting/getSiteList.do',
			method : 'GET'
		},
		createData : {
			url : '/api/create',
			method : 'POST'
		},
		updateData : {
			url : '/getProgramList.do',
			method : 'PUT'
		},
		deleteData : {
			url : '/api/delete',
			method : 'DELETE'
		},
		modifyData : {
			url : '/setting/modifySite.do',
			method : 'GET'
		}
	}
}

const Grid = new tui.Grid({
	data : dataSource,
	el : document.getElementById('grid'), // Container element
	scrollX : false,
	scrollY : false,
	columns : [ {
		header : '순번',
		name : 'SEQ'
	}, {
		header : '사이트명',
		name : 'SITE_NAME',
		editor : 'text'
	}, {
		header : '사이트주소',
		name : 'SITE_URL',
		editor : 'text'
	}, {
		header : '사용여부',
		name : 'USE_YN',
		editor : {
			type : 'select',
			options : {
				listItems : [ {
					text : '사용',
					value : '사용'
				}, {
					text : '미사용',
					value : '미사용'
				} ]
			}
		}
	} ],
	pagination : true,
	showDummyRows: true
});
function addRow() {
	Grid.appendRow();
}

function getSucc(msg) {
	Grid.resetData(msg);
}
$(document).ready(function() {
	getSiteList();
});

function saveData() {
	Grid.request('modifyData');
	Grid.on('successResponse', function(ev) {
		const result = ev.xhr.response;
		console.log(result);
	});
	Grid.on('failResponse', function(ev) {
	});
	Grid.on('errorResponse', function(ev) {
	});
}

function getSiteList() {
	var frm = makeForm("", "frm");
	frm.appendChild(addData("ProcName", "setting"));
	frm.appendChild(addData("subProcName", "getSiteList"));
	frm.appendChild(addData("data", ""));
	document.body.appendChild(frm);
	ajax($(frm).serializeObject(), "", "getSucc", "", "");
	$(frm).remove();
}
