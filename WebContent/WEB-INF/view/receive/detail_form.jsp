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
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>新增貨單</title>
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
					<form:form action="updateDetailForm" modelAttribute="detail"
						method="POST">
						<form:hidden path="id"/>
						<table>
							<tr>
								<th>產品名稱</th>
								<th>數量</th>
								<th>備註</th>
							</tr>
								<tr>
									<td>
										<div class="form-group">
										<select name = "targetProduct" id = "targetProduct">
											<c:forEach varStatus="pr" var="product" items="${products }"> 
 												<option value="${product.id }">${product.name }</option> 
											</c:forEach> 
										</select>							
										</div>
									</td>
									<td>
										<div class = "form-group">
											<form:input class="form-control" path="amount"/>
										</div>
									</td>
									<td>
										<div class = "form-group">
											<form:input class="form-control" path="ps"/>
										</div>
									</td>
								</tr>
						</table>
						<button type="submit" class="btn btn-primary">送出</button>
					</form:form>
				</div>

			</div>
		</div>
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