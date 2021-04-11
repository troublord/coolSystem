<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("UTF-8");%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<title>新增廠商</title>
</head>
<body>
	<div class="card">
		<a class="btn btn-secondary" href="${pageContext.request.contextPath }/customer/list_customers" role="button">回去</a>

	</div>

	<div id="container">
		<div id="content">
		<div class = "row">
			<div class = "col-sm-2"></div>
			<div class = "col-sm-4">
			<form:form action="saveCustomer" modelAttribute="customer" method="POST">
				<form:hidden path = "id"/>
			
				<div class="form-group">
					<label for="namelabel">廠商名稱</label> 
					<form:input class = "form-control" path = "name" />
				</div>
				<div class="form-group">
					<label for="contactor">聯絡人</label> 
					<form:input class = "form-control" path = "contact" />
				</div>
				<div class="form-group">
					<label for="namelabel">傳真</label> 
					<form:input class = "form-control" path = "fax" />
				</div>
				<div class="form-group">
					<label for="namelabel">電話</label> 
					<form:input class = "form-control" path = "number" />
				</div>
				<div class="form-group">
					<label for="namelabel">地址</label> 
					<form:input class = "form-control" path = "address" />
				</div>
				<div class="form-group">
					<label for="namelabel">備註</label> 
					<form:input class = "form-control" path = "ps" />
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form:form>
			</div>
			
			<div class = "col-sm-6">
			
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