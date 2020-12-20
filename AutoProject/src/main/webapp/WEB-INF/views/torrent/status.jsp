<%-- <%@ page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="ca.benow.transmission.model.TorrentStatus "%>
<%
	List<TorrentStatus> list = (ArrayList<TorrentStatus>) request.getAttribute("TORRENT_LIST");
%>
<script src="http://malsup.github.com/jquery.form.js"></script>
<link rel="stylesheet" href="https://uicdn.toast.com/grid/latest/tui-grid.css" />
<script src="https://uicdn.toast.com/grid/latest/tui-grid.js"></script>
<script type="text/javascript" src="https://uicdn.toast.com/tui.code-snippet/v1.5.0/tui-code-snippet.js"></script>
<script type="text/javascript" src="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.js"></script>

<div class="container-fluid">
	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">토렌트 현황</h1>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">토렌트 리스트</h6>
		</div>
		<div class="card-body">
			<table>
				<thead>
					<tr>
						<th>
							이름
						</th>
						<th>
							상태
						</th>
						<th>
							진행도
						</th>
					</tr>
				</thead>
				<tbody  id="list">
				
				</tbody>
			</table>
		</div>
	</div>
</div>
<script type="text/javascript">
var list = <%=list %>;
$( document ).ready(function() {
	var table_data = "";
	for (var i = 0 ; i < list.length ; i ++){
		table_data += '<tr>';
		table_data += '<td>'+ list[i].name+ '</td>';
		table_data += '<td>'+ list[i].status+ '</td>';
		table_data += '<td>'+ list[i].percentDone*100+ '</td>';
		table_data += '</tr>';
	}
	console.log(table_data);
	$("#list").append(table_data);
});
</script>
<script src="/resources/js/torrent/status.js"></script>