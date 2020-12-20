<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
<tiles:insertAttribute name="common" />
<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">
		<!-- Sidebar -->
		<tiles:insertAttribute name="nav" />

		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">
				<tiles:insertAttribute name="header" />
				<tiles:insertAttribute name="body" />
			</div>
			
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
	<tiles:insertAttribute name="bottom" />
</body>
</html>
