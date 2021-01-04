<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp" %>
             <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>

<div class="container mt-3">
	<div class="row">
		<div class="col-md-6 offset-md-3">
			
			<h1 class="text-center mb-3"> Change vehicle Details</h1>
			
			<form action="${pageContext.request.contextPath }/handle-vehicle" method="post">
			
			<input type="hidden" value="${vehicle.id }" name="id"/>
			<div class="form-group">
					<label for="name">Vehicle Name</label>
					<input type="text" class="form-control" id="name" aria-describedby="emailHelp"
						name="name" placeholder="Enter the vehicle Name" value="${vehicle.name }">
				</div>
				<div class="form-group">
					<label for="model_no">Vehicle Model No.</label>
					<input type="text" class="form-control" id="model_no" value="${vehicle.model_no }"
						name="model_no" placeholder="Enter the vehicle Model No" autocapitalize="characters">
				</div>
				<div class="form-group">
					<label for="manufactured_date">Vehicle Manufactured Date</label>
					<input type="date" class="form-control" id="manufactured_date" min="2000-01-01"
						name="manufactured_date"value="${vehicle.manufactured_date }" placeholder="Enter the vehicle Manufactured Date">
				</div>
					<div class="form-group">
					<label for="company_name">Company Name</label>
					<input type="text" class="form-control" id="company_name" aria-describedby="emailHelp"
						name="company_name" value="${vehicle.company_name }" placeholder="Enter the Company Name">
				</div>
				<div class="form-group">
					<label for="no_of_wheels">Vehicle Total No. of Wheels</label>
					<select  class="form-control" id="no_of_wheels" name="no_of_wheels" 
					value="${vehicle.no_of_wheels }" >
					      <option value='2'>2 Wheeler</option>
					      <option value='3'>3 Wheeler</option>
					      <option value='4'>4 Wheeler</option>
					      <option value='6'>6 Wheeler</option>
					</select>
				</div>
				<div class="form-group">
					<label for="torque">Vehicle Torque </label>
					<input type="number" class="form-control" id="torque" aria-describedby=emailHelp"
						name="torque" value="${vehicle.torque }" placeholder="Enter the vehicle Torque value">
				</div>
					<div class="form-group">
					<label for="brake_horse_power">Vehicle's Brake horse power</label>
					<input type="number" class="form-control" id="brake_horse_power" aria-describedby="emailHelp"
						name="brake_horse_power" step="any" value="${vehicle.brake_horse_power }" placeholder="Enter the Vehicle's Brake horse power">
				</div>
				<div class="form-group">
					<label for="max_speed">Vehicle's Maximum Speed(kmph)</label>
					<input type="number" class="form-control" id="max_speed" 
						name="max_speed" value="${vehicle.max_speed }" placeholder="Enter the vehicle's Maximum Speed(kmph)">
				</div>
				<div class="form-group">
					<label for="max_acceleration">Vehicle's Maximum Acceleration</label>
					<input type="number" class="form-control" id="max_acceleration" aria-describedby=emailHelp"
						name="max_acceleration" value="${vehicle.max_acceleration }" placeholder="Enter the Vehicle's Maximum Acceleration">
				</div>
				<div class="form-group">
					<label for="run">Vehicle's Running (km)</label>
					<input type="number" class="form-control" id="run" aria-describedby=emailHelp"
						name="run" value="${vehicle.run }" placeholder="Enter the Vehicle's Running (km)">
				</div>
				<div class="form-group">
					<label for="role">Vehicle's Role</label>
					<select class="form-control" id="role" name="role"
					value="${vehicle.role }">
						  <option value='Light Weight Passenger Carrier'>Light Weight Passenger Carrier</option>
					      <option value='Heavy Weight Passenger Carrier'>Heavy Weight Passenger Carrier</option>
					      <option value='Heavy weight goods carrier'>Heavy weight goods carrier</option>
					      <option value='Light weight goods carrier'>Light weight goods carrier</option>
					</select>
				</div>
						<div class="container text-center">
				<a href="${pageContext.request.contextPath }/" class="btn btn-outline-danger">Back</a>
				<button type="submit" class="btn btn-warning">Update</button>
				</div>
				
				
			
			</form>
		
		</div>
	
	</div>
	
</div>

</body>
</html>