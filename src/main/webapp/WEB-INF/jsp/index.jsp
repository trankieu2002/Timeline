<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    
    <title>Timeline</title>
    
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
     <link href="static/css/style.css" rel="stylesheet">
    
    <!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Timeline</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-treatment">Thêm Môn</a></li>
					<li><a href="all-treatments">Danh Sách Môn</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
		<c:when test="${mode == 'MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to Treatment Manager</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_TREATMENTS'}">
			<div class="container text-center" id="tasksDiv">
				<h3>DANH SÁCH MÔN</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Mã số</th>
								<th>Tên môn</th>
								<th>Sức chứa</th>
								<th>Khoa</th>
								<th>Thời gian</th>
								<th>Thời gian thêm</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="treatment" items="${treatments}">
								<tr>
									<td>${treatment.id}</td>
									<td>${treatment.name}</td>
									<td>${treatment.capacity}</td>
									<td>${treatment.specialty}</td>
									<td>${treatment.time}</td>
									<td>${treatment.timeplus}</td>
									<td><a href="update-treatment?id=${treatment.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="delete-treatment?id=${treatment.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
			<div class="container text-center">
				<h3>THÊM MÔN</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-treatment">
					<input type="hidden" name="id" value="${treatment.id}"/>
					<div class="form-group">
						<label class="control-label col-md-3">Tên môn</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="name" value="${treatment.name}"/>
						</div>				
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Sức chứa</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="capacity" value="${treatment.capacity}"/>
						</div>				
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Khoa</label>
						<div class="col-md-7">
							<input type="radio" class="col-sm-1" name="specialty" value="YHCT"/>
							<div class="col-sm-1">YHCT</div>
							<input type="radio" class="col-sm-1" name="specialty" value="Cột sống"/>
							<div class="col-sm-1">Cột sống</div>
						</div>				
					</div>	
					<div class="form-group">
						<label class="control-label col-md-3">Thời gian</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="time" value="${treatment.time}"/>
						</div>				
					</div>	
					<div class="form-group">
						<label class="control-label col-md-3">Thời gian thêm</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="timeplus" value="${treatment.timeplus}"/>
						</div>				
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save"/>
					</div>
				</form>
			</div>
		</c:when>		
	</c:choose>

	<script src="static/js/jquery-1.11.1.min.js"></script>    
    <script src="static/js/bootstrap.min.js"></script>
</body>
</html>