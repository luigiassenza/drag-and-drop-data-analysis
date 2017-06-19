<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" 
integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Google Charts -->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<!-- Load Google Charts -->
<script type="text/javascript">
	google.charts.load('current', {'packages':['bar']});
	google.charts.setOnLoadCallback(typeChart);
	google.charts.setOnLoadCallback(descriptionChart);
	
	function typeChart() {
		var data = new google.visualization.DataTable();
			data.addColumn('string', 'Type');
			data.addColumn('number', 'Amount');
			<c:forEach items="${summaryByType}" var="item">
				data.addRow(['${item.type}', ${item.amount}]);
			</c:forEach>

		var options = {
			chart: {title: 'Revenue and Expenses'},
			width: 400,
			height: 250,
			bar: {groupWidth: "95%"},
			legend: {position:"none"},
		};
			
		var chart = new google.charts.Bar(document.getElementById('charttype_div'));
		chart.draw(data, options);
	};
	
	
	function descriptionChart() {
		var data = new google.visualization.DataTable();
			data.addColumn('string', 'Description');
			data.addColumn('number', 'Amount');
			data.addColumn('string', 'Type');
			<c:forEach items="${summaryByDescription}" var="item">
				data.addRow(['${item.description}', ${item.amount}, '${item.type}']);
			</c:forEach>

		var options = {
			chart: {title: 'Revenue and Expenses by Product'},
			width: 400,
			height: 250,
			bar: {groupWidth: "95%"},
			legend: {position:"none"},
		};
			
		var chart = new google.charts.Bar(document.getElementById('chartdescription_div'));
		chart.draw(data, options);
	};
</script>

<title>Dashboard</title>
</head>
<body>
	<form action="FinancialsHomepage" method="post">
		<button class="btn btn-default" type="submit">Homepage</button>
	</form>
<center><h1>Dashboard</h1></center>

<div class="row">
	<div class="col-md-2">
		<div align="left">	
		</div>
	</div>
	<div class="col-md-2">
		<table class="table table-striped table-nonfluid table-bordered" style="width:auto">
			<c:forEach items="${summaryByType}" var="item">
				<tr>
					<td>${item.type}</td>
					<td>${item.amount}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="col-md-2">
		<div align="right">
			<!-- Bar Chart -->			
			<div id="charttype_div" style="width: 400px; height: 250px;"></div>
		</div>
	</div>
</div>

<br><br><br><br>

<div class="row">
	<div class="col-md-2">
		<div align="left">	
		</div>
	</div>
	<div class="col-md-2">
		<table class="table table-striped table-nonfluid table-bordered" style="width:auto">
			<c:forEach items="${summaryByDescription}" var="item">
				<tr>
					<td>${item.description}</td>
					<td>${item.type}</td>
					<td>${item.amount}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="col-md-2">
		<div align="right">
			<!-- Bar Chart -->			
			<div id="chartdescription_div" style="width: 400px; height: 250px;"></div>
		</div>
	</div>
</div>


</body>
</html>