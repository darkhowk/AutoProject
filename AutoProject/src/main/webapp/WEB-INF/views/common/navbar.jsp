<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
	<!-- Sidebar - Brand -->
	<li>
		<a class="sidebar-brand d-flex align-items-center justify-content-center" href="/home.do" >
			<label class="sidebar-brand-text mx-3">Auto Project</label>
		</a>
	</li>
	<!-- Divider -->
	<li>
		<hr class="sidebar-divider my-0">
	</li>
	<!-- Nav Item - Dashboard -->
	<li class="nav-item active">
		<a class="nav-link" href="/home.do">
			<i class="fas fa-fw fa-tachometer-alt"></i>
			<span>Dashboard</span>
		</a>
	</li>

	<!-- Divider -->
	<li>
		<hr class="sidebar-divider">
	</li>
	<!-- Heading -->
	<li>
		<div class="sidebar-heading">토렌트</div>
	</li>
	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item">
		<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
			<i class="fas fa-fw fa-cog"></i>
			<span>Transmission</span>
		</a>
		<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<!-- 						<h6 class="collapse-header">상태</h6> -->
				<a class="collapse-item" href="/torrent/status.do">상태창</a>
				<a class="collapse-item" href="/torrent/add.do">추가</a>
			</div>
		</div>
	</li>

	<!-- Nav Item - Utilities Collapse Menu -->
	<li class="nav-item">
		<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
			<i class="fas fa-fw fa-wrench"></i>
			<span>Sites</span>
		</a>
		<div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">토렌트 사이트들</h6>
				<a class="collapse-item" href="utilities-color.html">Colors</a>
				<a class="collapse-item" href="utilities-border.html">Borders</a>
				<a class="collapse-item" href="utilities-animation.html">Animations</a>
				<a class="collapse-item" href="utilities-other.html">Other</a>
			</div>
		</div>
	</li>

	<!-- Divider -->
	<li>
		<hr class="sidebar-divider">
	</li>
	<!-- Heading -->
	<li>
		<div class="sidebar-heading">설정</div>
	</li>

	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item">
		<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
			<i class="fas fa-fw fa-folder"></i>
			<span>토렌트</span>
		</a>
		<div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">토렌트:</h6>
				<a class="collapse-item" href="/setting/addSite.do">사이트추가</a>
				<a class="collapse-item" href="/setting/addProgram.do">프로그램추가</a>
			</div>
		</div>
	</li>

	<!-- Nav Item - Charts -->
	<li class="nav-item">
		<a class="nav-link" href="/setting/folder.do">
			<i class="fas fa-fw fa-chart-area"></i>
			<span>폴더 현황</span>
		</a>
	</li>
	<li class="nav-item">
		<a class="nav-link" href="/setting/alert.do">
			<i class="fas fa-fw fa-chart-area"></i>
			<span>알림 현황</span>
		</a>
	</li>
	<!-- Nav Item - Tables -->
	<!-- 			<li class="nav-item"><a class="nav-link" href="tables.html"> <i class="fas fa-fw fa-table"></i> <span>Tables</span></a></li> -->

	<!-- Divider -->
	<li>
		<hr class="sidebar-divider d-none d-md-block">
	</li>

	<!-- Sidebar Toggler (Sidebar) -->
	<li>
		<div class="text-center d-none d-md-inline">
			<button class="rounded-circle border-0" id="sidebarToggle"></button>
		</div>
	</li>

</ul>
<!-- End of Sidebar -->
