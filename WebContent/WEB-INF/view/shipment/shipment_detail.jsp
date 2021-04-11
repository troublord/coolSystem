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
			href="${pageContext.request.contextPath }/receive/list_sheet"
			role="button">回去</a>

	</div>

	<div id="container">
		<div id="content">
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-4">
					<form:form action="saveDetail" modelAttribute="shipment"
						method="POST">
						<form:hidden path="id"/>
						<form:hidden path="date"/>
						<form:hidden path="name"/>
						<input type = "hidden" name = "customer_id" id = "customer_id" value = "${shipment.customer.id }"/>
						出貨單編號 : ${shipment.name }
						廠商 : ${customer }
						日期 : ${shipment.date }
						<table>
							<tr>
								<th>產品名稱</th>
								<th>數量</th>
								<th>備註</th>
							</tr>
							<c:forEach varStatus="damn" var="detail"
								items="${shipment.shipment_detail }">
								<form:hidden path="shipment_detail[${damn.index}].id"/>
								<tr>
									<td>
										<div class="form-group">
										<select name = "targetProducts" id = "targetProducts">
											<c:forEach varStatus="pr" var="product" items="${products }"> 
 												<option value="${product.id }">${product.name }</option> 
											</c:forEach> 
										</select>							
										</div>
									</td>
									<td>
										<div class = "form-group">
											<form:input class="form-control" path="shipment_detail[${damn.index}].amount"/>
										</div>
									</td>
									<td>
										<div class = "form-group">
											<form:input class="form-control" path="shipment_detail[${damn.index}].ps"/>
										</div>
									</td>
								</tr>
							</c:forEach>
						</table>
						<button type="submit" class="btn btn-primary">送出</button>
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

</body>




</html>