<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Topbar -->
<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

	<!-- Sidebar Toggle (Topbar) -->
	<button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
		<i class="fa fa-bars"></i>
	</button>

	<!-- Topbar Search -->
	<form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
		<div class="input-group">
			<input type="text" class="form-control bg-light border-0 small" placeholder="받을 파일 검색..." aria-label="Search" id="param1" aria-describedby="basic-addon2">
			<div class="input-group-append">
				<button class="btn btn-primary" type="button" onclick="searchTorrent('1');">
					<i class="fas fa-search fa-sm"></i>
				</button>
			</div>
		</div>
	</form>

	<!-- Topbar Navbar -->
	<ul class="navbar-nav ml-auto">

		<!-- Nav Item - Search Dropdown (Visible Only XS) -->
		<li class="nav-item dropdown no-arrow d-sm-none">
			<a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<i class="fas fa-search fa-fw"></i>
			</a>
			<!-- Dropdown - Messages -->
			<div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
				<form class="form-inline mr-auto w-100 navbar-search">
					<div class="input-group">
						<input type="text" class="form-control bg-light border-0 small" placeholder="받을 파일 검색..." aria-label="Search" id="param2" aria-describedby="basic-addon2" onkeydown="">
						<div class="input-group-append">
							<button class="btn btn-primary" type="button" onclick="searchTorrent('2');">
								<i class="fas fa-search fa-sm"></i>
							</button>
						</div>
					</div>
				</form>
			</div>
		</li>

		<!-- Nav Item - Alerts -->
		<li class="nav-item dropdown no-arrow mx-1">
			<a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<i class="fas fa-bell fa-fw"></i>
				<!-- Counter - Alerts 현재 받지 못한 오늘의 컨텐츠? -->
				<span class="badge badge-danger badge-counter">1</span>
			</a>
			<!-- Dropdown - Alerts -->
			<div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="alertsDropdown">
				<h6 class="dropdown-header">알림</h6>
				<a class="dropdown-item d-flex align-items-center" href="#">
					<div class="mr-3">
						<div class="icon-circle bg-primary">
							<i class="fas fa-file-alt text-white"></i>
						</div>
					</div>
					<div>
						<div class="small text-gray-500">December 12, 2019, 02:43</div>
						<span class="font-weight-bold">골목식당 다운완료!</span>
					</div>
				</a>
				<a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
			</div>
		</li>

	</ul>

</nav>
<!-- End of Topbar -->
<script type="text/javascript">
	function searchTorrent(type) {
		var param = '';
		if (type == '1'){
			param = $('#param1').val();
		}
		if (type == '2'){
			param = $("#param2").val();
		}
		
		var frm = makeForm("", "frm");
		frm.appendChild(addData("ProcName", "search"));
		frm.appendChild(addData("subProcName", param));
		frm.appendChild(addData("data", ""));
		document.body.appendChild(frm);
		ajax($(frm).serializeObject(), "", "succSearch", "", "");
		$(frm).remove();
	}
	function succSearch(){
		location.href="/program/searchList.do";
	}
</script>