<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css">
<!-- Material Design Bootstrap -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/mdb.min.css">

<!-- <link type="text/css" rel="stylesheet" -->
<%-- 	href="${pageContext.request.contextPath }/resources/css/styles.css"> --%>

<title>首頁</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="/coolsystem">首頁</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="/coolsystem">Home <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="https://getbootstrap.com/docs/4.4/components/navbar/">navbar_bootstrap</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Dropdown </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Something else here</a>
					</div></li>

			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>



	<div class="container">
		<div class="row">
			<div class="col-lg-2"></div>

			<div class="col-lg-8">
				<a
					href="${pageContext.request.contextPath }/customer/list_customers"
					class="btn btn-primary btn-lg active" role="button"
					aria-pressed="true">廠商 </a> <a
					href="${pageContext.request.contextPath }/product/list_products"
					class="btn btn-secondary btn-lg active" role="button"
					aria-pressed="true">工件 </a> <a
					href="${pageContext.request.contextPath }/receive/list_sheet"
					class="btn btn-primary btn-lg active" role="button"
					aria-pressed="true">收貨單 </a> <a
					href="${pageContext.request.contextPath }/shipment/list_shipments"
					class="btn btn-primary btn-lg active" role="button"
					aria-pressed="true">出貨單 </a>

			</div>

			<div class="col-lg-2"></div>
		</div>
	</div>
	<!-- jQuery -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/mdb.min.js"></script>
</body>


</html>