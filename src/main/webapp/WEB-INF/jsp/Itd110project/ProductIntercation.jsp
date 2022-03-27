<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import= "java.util.Arrays"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <head>
		<title>Information</title>
   		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  		<style><%@include file="../../resources/css/FrontPageStyle.css"%></style>
		<script><%@include file="../../resources/js/reportfunctions.js"%></script>
  </head>
</head>
<body>
	<!-- A stylish Header that contains all futuer user options -->
 	<div id="mySidenav" class="sidenav"><!-- Drop down menu layout -->
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<a onclick="switchStateBtn('Step4')" class='menuLinks' href="HomePage">Home</a>
		<a onclick="switchStateBtn('Step1')" class='menuLinks' href="AboutUs">About</a>
		<a onclick="switchStateBtn('Step2')" class='menuLinks' href="Products">Services</a>
		<a onclick="switchStateBtn('Step3')" class='menuLinks' href="Partners">Partners</a>
		<spring:url value="${contextPath}/login" var="StartURL" />
		<a id="LoadFile" href="${StartURL }" class='menuLinks'>Login</a>.
	</div>
   
  <div id="topBanner" class="headder">
  	<span style="font-size:50px; cursor:pointer; float:left;" onclick="openNav()" id="Openmenue">&#9776;</span>
  	<p class="Menu">
	<span style="font-size:25px;">JBA Shipping Inc.</span><br>
 	<span class="c"><small>We Deliver the Best to Deliver You Success</small></span>
 	</p>
 	<h1 class="title">Become a partner</h1><br>
   <hr style="background-color:white;"/>
</div>

<div id="Placeholder" class="services" style="display: none;">
		<div id="slider" class="Site_Features_List">
			<c:forEach var="img" items="${imageUrlList}">  
				<div id="silde" class="myslides">
					<img id="pic" src="${contextPath}/ImageAssets/${img}" alt="MissingImg" width="800" height="400"/>
					<p class="SlideText"><span>${fn:substringBefore(img, ".")}</span></p>
				</div>
			</c:forEach>
			<canvas class="myslides" id="chartClone"></canvas>
			<div class="navigation">
				<c:forEach begin="1" end="${imageUrlList.size()+1}" varStatus="count">
				<span class="badge demo badge-pill badge-outline-info" onclick="currentDiv(${count.index})">  </span> 
				</c:forEach>
			</div>
			<a class="prev" onclick="plusDivs(-1)">&#10094;</a>
			<a class="next" onclick="plusDivs(1)">&#10095;</a>
		</div>
		<c:forEach var="words" items="${discript}" varStatus="count">  
		<div id="StoreData${count.index}" style="display:none">${words}</div>
		</c:forEach>
		<div id="myDropdown" class="dropdown-content"><p id="message"></p></div>
	</div>

    <footer>
	<hr style="background-color:black;" />
	Copyright &copy; 2020. All rights reserved
</footer>
<script>
	var slideIndex = 1;	
	
	//this method is used to hide the backend funktions
	PageSetUp(document.getElementById("mySidenav"), slideIndex, ${Arrays.toString(Data)});
</script>
</body>
</html>