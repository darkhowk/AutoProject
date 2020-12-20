/**
 * 
 */

const dataSource = {
	withCredentials : false,
	initialRequest : true,
	api : {
		readData : {
			url : '/setting/getProgramList.do',
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
			url : '/setting/modifyProgram.do',
			method : 'GET'
		}
	}
}

const Grid = new tui.Grid({
	data : dataSource,
	el : document.getElementById('grid'), // Container element
	scrollX : false,
	scrollY : false,
	columns : [ 
	{
		header : '프로그램명',
		name : 'PROGRAM_NAME',
		editor : 'text',
	 	sortingType: 'asc',
        sortable: true
	}, {
		header : '요일',
		name : 'WEEK',
		editor : {
			type : 'select',
			options : {
				listItems : [ {
					text : '일요일',
					value : '일요일'
				}, {
					text : '월요일',
					value : '월요일'
				}, {
					text : '화요일',
					value : '화요일'
				}, {
					text : '수요일',
					value : '수요일'
				}, {
					text : '목요일',
					value : '목요일'
				}, {
					text : '금요일',
					value : '금요일'
				}, {
					text : '토요일',
					value : '토요일'
				} ]
			}
		},
	 	sortingType: 'asc',
        sortable: true
	}, {
		header : '타입',
		name : 'TYPE',
		editor : {
			type : 'select',
			options : {
				listItems : [ {
					text : '예능',
					value : '예능'
				}, {
					text : '영화',
					value : '영화'
				}, {
					text : '한드',
					value : '한드'
				}, {
					text : '일드',
					value : '일드'
				}, {
					text : '애니',
					value : '애니'
				} ]
			}
		}
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
		},
	 	sortingType: 'asc',
        sortable: true
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
	getProgramList();
});

function saveData() {
	Grid.request('modifyData');
	Grid.on('successResponse', function(ev) {
		getProgramList();
	});
	Grid.on('failResponse', function(ev) {
	});
	Grid.on('errorResponse', function(ev) {
	});
}

function getProgramList() {
	var frm = makeForm("", "frm");
	frm.appendChild(addData("ProcName", "setting"));
	frm.appendChild(addData("subProcName", "getProgramList"));
	frm.appendChild(addData("data", ""));
	document.body.appendChild(frm);
	ajax($(frm).serializeObject(), "", "getSucc", "", "");
	$(frm).remove();
}
