<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://uicdn.toast.com/grid/latest/tui-grid.css" />
<script src="https://uicdn.toast.com/grid/latest/tui-grid.js"></script>
<script type="text/javascript" src="https://uicdn.toast.com/tui.code-snippet/v1.5.0/tui-code-snippet.js"></script>
<script type="text/javascript" src="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.js"></script>
<%@ page import="java.util.*"%>
<%@ page import="java.io.File"%>
<%
	HashMap<Integer, List<String>> list = (HashMap<Integer, List<String>>) request.getAttribute("list");
%>



<div class="container-fluid">
	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">폴더 현황</h1>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">폴더 리스트</h6>
		</div>
		<div class="card-body">
			<table>
				<tr>
					<th>Level</th>
					<th>이름</th>
				</tr>
				<c:forEach var="item" items="<%=list%>" varStatus="status">
					<tr>
						<td>${item.key }</td>
						<td>${item.value}</td>
					</tr>
				</c:forEach>

			</table>

			<input type="button" id="addBtn" value="추가" onclick="addRow();">
			<input type="button" id="saveBtn" value="저장" onclick="saveData();">
			<div id="grid"></div>
		</div>
	</div>

</div>

<script src="/resources/js/setting/folder.js"></script>