<html>
<head>
<%@include file="./base.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready(function() {
	$("#form1").hide();
	  $("a#dateRange").click(function() {
	    $("#form1").toggle();
	  });
	});

function dateRange(){
	var dateFrom = $("#dateFrom").val();
	  var dateTo = $("#dateTo").val();
   $("#submitdate").attr("href", '${pageContext.request.contextPath }/dateRange/'+dateFrom+'/'+dateTo);
}
function searchResult(){
	 var search = $("#search").val();
	   $("#searchbtn").attr("href", '${pageContext.request.contextPath }/search/'+search);
}
</script>
</head>
<body>
	<div class="container-fluid mt-3">
		<div class="row">
			<div class="col-md-12">
				
				<h1 class="text-center">Welcome to Vehicle App</h1>
				
				<a class="btn btn-success" href="${pageContext.request.contextPath }/"> HOME </a>
					      	
					      	<div class="btn-group">
							  <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							    Filter
							  </button>
							  <div class="dropdown-menu">
							    <a class="dropdown-item dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Select Wheels</a>
							    			<div class="dropdown-menu">
										    <a class="dropdown-item" href="${pageContext.request.contextPath }/">All Vehicles</a>
										    <a class="dropdown-item" href="${pageContext.request.contextPath }/wheelers/${2}">2 Wheelers</a>
										    <a class="dropdown-item" href="${pageContext.request.contextPath }/wheelers/${3}">3 Wheelers</a>
										    <a class="dropdown-item" href="${pageContext.request.contextPath }/wheelers/${4}">4 Wheelers</a>
										    <a class="dropdown-item" href="${pageContext.request.contextPath }/wheelers/${6}">6 Wheelers</a>
										  </div>
							    <a class="dropdown-item" href="${pageContext.request.contextPath }/asce">Asce Vehicle name</a>
							    <a class="dropdown-item" href="${pageContext.request.contextPath }/asceBySpeed">Asce Vehicle name and Speed</a>
							    <a class="dropdown-item" id="dateRange">Manufacturing date range</a>
							  </div>
							  <div id="form1" align="center">
								  <b>Date From: </b> <input type="date" name="dateFrom" id="dateFrom">&nbsp;
								  <b>Date To  : </b> <input type="date" name="dateTo" id="dateTo">&nbsp;
								  <a type="button" class="btn btn-success" id="submitdate" onclick="dateRange()">Show Result</a>
								   <%-- href="dateRange/${dateFrom}/${dateTo}" --%>
							  </div>
							  <div style="align-content: center;">
								  <input type="text" id="search" name="search" placeholder="Search by company name.">
								  <a type="button" class="btn btn-success" id="searchbtn" onclick="searchResult()">Search Result</a>
																  
							  </div>
							</div>&nbsp;
							

					<br><br>
					
					<table class="table">
					  <thead class="thead-dark">
					    <tr>
					      <th scope="col">ID</th>
					      <th scope="col">Vehicle Name</th>
					      <th scope="col">Model No</th>
					      <th scope="col">Manufactured Date</th>
					      <th scope="col">Company Name</th>
					      <th scope="col">No of Wheels</th>
					      <th scope="col">Torque</th>
					      <th scope="col">Brake Horse Power</th>
					      <th scope="col">Max Speed</th>
					      <th scope="col">Max Acceleration</th>
					      <th scope="col">Run</th>
					      <th scope="col">Role</th>
					      <th scope="col">Actions</th>
					    </tr>
					  </thead>
					  <tbody>
					  
					   <c:forEach items="${vehicles }" var="v">
					    <tr>
					      <th scope="row">${v.id }</th>
					      <td>${v.name }</td>
					      <td>${v.model_no }</td>
					      <td>${v.manufactured_date }</td>
					      <td>${v.company_name }</td>
					      <td>${v.no_of_wheels }</td>
					      <td>${v.torque }</td>
					      <td>${v.brake_horse_power }</td>
					      <td>${v.max_speed }</td>
					      <td>${v.max_acceleration }</td>
					      <td>${v.run }</td> 
					      <td>${v.role }</td>
					      <td>
					      	<a href="delete/${v.id}"><i class="far fa-trash-alt text-danger" style="font-size: 25px;"></i></a>
					      	<a href="update/${v.id}"><i class="fas fa-pen-nib text-info" style="font-size: 25px;"></i></a>
					      </td>
					    </tr>
					  </c:forEach> 
					  
					  </tbody>
					</table>
										
				<div class="container text-center">
					<a href="add-vehicle" class="btn btn-outline-success">Add Vehicle</a>
				</div>
			</div>
		
		</div>
	
	</div>
</body>
</html>
