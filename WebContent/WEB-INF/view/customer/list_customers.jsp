<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

   <link type = "text/css" rel = "stylesheet" 
	href = "${pageContext.request.contextPath }/resources/css/styles.css">
	
<title>廠商名單</title>
</head>
<body>

	<div class="card">
		<div class="card-header">名單頁</div>
		
	</div>

	<div id="container">
	<a class="btn btn-primary" href="${pageContext.request.contextPath }/customer/showCustomerForm" role="button">新增</a>	
		<table>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>contact</th>
				<th>fax</th>
				<th>number</th>
				<th>address</th>
				<th>ps</th>
				<th></th>
			</tr>
			<c:forEach var="customerdochi" items="${customers }">
				<c:url var = "deleteLink" value = "/customer/deleteCustomer">
					<c:param name = "customerId" value = "${customerdochi.id }"/>
				</c:url>
				<c:url var = "updateLink" value = "/customer/showUpdateCustomer">
					<c:param name="customerId" value = "${customerdochi.id }"></c:param>
				</c:url>
			
	
				<tr>
					<td>${customerdochi.id }</td>
					<td>${customerdochi.name }</td>
					<td>${customerdochi.contact }</td>
					<td>${customerdochi.fax }</td>
					<td>${customerdochi.number }</td>
					<td>${customerdochi.address }</td>
					<td>${customerdochi.ps }</td>
					<td>
						<a  href = "${deleteLink }">刪除</a>
						|
						<a href = "${updateLink }"> 編輯 </a>
						
					</td>
				</tr>

			</c:forEach>
			

		</table>

	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>


</html>