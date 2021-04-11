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
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css">
<!-- Material Design Bootstrap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/mdb.min.css">
<!-- <link type="text/css" rel="stylesheet" -->
<%-- 	href="${pageContext.request.contextPath }/resources/css/styles.css"> --%>

<title>收貨單</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">收貨單</a>
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

	<div id="container">
		<a class="btn btn-primary"
			href="${pageContext.request.contextPath }/receive/showReceiveForm"
			role="button">新增 </a>


		<table class="table table-dark">

			<tr>
				<th scope="col">貨單編號</th>
				<th scope="col">廠商</th>
				<th scope="col">日期</th>
				<th></th>
				<th scope="col">功能</th>
			</tr>
			<c:forEach var="receive" items="${receives }">
				<c:url var="deleteLink" value="/receive/deleteReceive">
					<c:param name="receiveId" value="${receive.id }" />
				</c:url>
				<c:url var="updateLink" value="/receive/showUpdateReceive">
					<c:param name="receiveId" value="${receive.id }" />
				</c:url>
				<tr>
					<td>${receive.name }</td>
					<td>${customerMap.get(receive.id)}</td>
					<td>${receive.date}</td>

					<td>
						總送件 ${receive.total }
						<button class="btn btn-primary" type="button"
							data-toggle="collapse" data-target="#showDetail${receive.id}"
							aria-expanded="false" aria-controls="showDetail">詳細資料</button>
						<div class="collapse" id="showDetail${receive.id}">
							<table class="table table-dark ">
								<tr>
									<th scope="col">產品名</th>
									<th scope="col">數量</th>
									<th scope="col">備註</th>
									<th></th>
								</tr>
								<c:forEach var="detail" items="${receive.receive_detail}">
									<c:url var="deleteDetail" value="/receive/deleteDetail">
										<c:param name="detailId" value="${detail.id }" />
									</c:url>
									<c:url var="updateDetail" value="/receive/updateDetail">
										<c:param name="detailId" value="${detail.id }" />
									</c:url>
									<tr>
										<td>${productMap.get(detail.id)}</td>
										<td>${detail.amount }</td>
										<td>${detail.ps }</td>
										<td>
											<a class="btn btn-danger" href="${deleteDetail }" onclick="return confirm('確定刪除嗎?')">刪除</a>
											<a class="btn btn-info" href="${updateDetail }"> 編輯 </a>
										</td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</td>
					<td><a class="btn btn-danger" href="${deleteLink }"
						onclick="return confirm('確定刪除嗎?')">刪除</a> <a class="btn btn-info"
						href="${updateLink }"> 編輯 </a></td>
				</tr>
			</c:forEach>

		</table>

	</div>

	</div>

	<footer>
			<!-- jQuery -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/resources/js/jquery.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/resources/js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/resources/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/resources/js/mdb.min.js"></script>

		<script
			src="${pageContext.request.contextPath }/resources/js/bootstrap-datepicker.js"></script>


	</footer>
</body>


</html>