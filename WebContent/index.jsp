<%@page import="com.Supplier"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery.min.js"></script>
<script src="Components/supplier.js"></script>
<script src="Components/jquery.min.js"></script>
<link rel="stylesheet" href="Views/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

	<div class="row">
		<div class="col-lg-12">
			<div class="card m-b-32">
				<div class="card-body">

					<form id="formUser" name="formUser" method="post"
						action="index.jsp">

						<label>Supplier Name</label> <input id="name"
							name="name" type="text"
							class="form-control form-control-sm">
							<br> 
							<label>Account Number</label><input id="account_number"
							name="account_number" type="text"
							class="form-control form-control-sm">
						
							<br><label>Units</label> <input id="units" name="units"
							type="text" class="form-control form-control-sm"> 
							
							<br><label>Price Per Unit</label> <input id="unit_price" name="unit_price"
							type="number" class="form-control form-control-sm"> 
							
							<br><label>Date</label> <input id="date"
							name="date" type="date"
							class="form-control form-control-sm">
							
							 <br>
							 <input id="btnSave" name="btnSave" type="button" value="Save"
							class="btn btn-primary"> <input type="hidden"
							id="hididSave" name="hididSave" value="">
					</form>
					<br>
					<div id="alertSuccess" class="alert alert-success"></div>
					<div id="alertError" class="alert alert-danger"></div>
					<br> <br>
					
					<div id="divUserGrid">
						<%
						Supplier empObj = new Supplier();
															out.print(empObj.readSuppliers());
						%>
					</div>
				</div>
</div>
</div>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>