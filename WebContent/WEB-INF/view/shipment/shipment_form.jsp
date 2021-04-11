<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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

<title>新增出貨單</title>
</head>
<body>
	<div class="card">
		<a class="btn btn-secondary"
			href="${pageContext.request.contextPath }/shipment/list_shipments"
			role="button">回去</a>

	</div>

	<div id="container">
		<div id="content">
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-4">
					<form:form action="saveShipment" modelAttribute="shipment"
						method="POST">

						<div class="form-group">
							<label for="name">貨單編號</label>
							<form:input class="form-control" path="name" />
						</div>

						<div class="form-group">
							<label for="customer">廠商</label> <select class="form-control"
								id="customer_id" name="customer_id">
								<c:forEach var="customer" items="${customers }">
									<option value="${customer.id }">${customer.name }</option>
								</c:forEach>
							</select>
						</div>

						<div class="form-group">
							<label for="date">日期</label>
							<form:input type="date" path="date" />
						</div>
						<div class = "form-group">
							<label for="detailCount">出貨工件數</label>
							<select class="custom-select mr-sm-2" id="detailCount" name = "detailCount">
								<option selected value = "1">一個</option>
								<option value="2">兩個</option>
								<option value="3">三個</option>
								<option value="4">四個</option>
								<option value="5">五個</option>
							</select>
						</div>

						<button type="submit" class="btn btn-primary">Submit</button>
					</form:form>
				</div>

			</div>
		</div>
	</div>







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

	<script>
		document.getElementById('date').valueAsDate = new Date();
	</script>
</body>




</html>