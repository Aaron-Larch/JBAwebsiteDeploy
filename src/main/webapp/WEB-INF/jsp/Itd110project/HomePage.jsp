<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JBA Shipping Inc.</title>
 	<head>
		<title>JBA Shipping inc.</title>
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
  	
  	<p class="Menu">
  	<span class="Icon" onclick="openNav()" id="Openmenue">&#9776;</span>
	<span style="font-size:30px;">JBA Shipping Inc.</span><br>
 	<span class="c"><small>We Deliver the Best to Deliver You Success</small></span>
 	</p>
 	<h1 class="title">Welcome to JBA shipping!</h1>
   <hr style="background-color:white;"/>
</div>

<div id="Siteadd">
<iframe width="420" height="345" src="https://www.youtube.com//embed/j7atEB_RBws"></iframe><br><br>
<p>This Video is not mine in any way shape or form. This video made by the people at Meow Wolf please go to their Youttube channel to see more of there videos</p><br>
<a href="https://www.youtube.com/c/meowwolf">Meow Wolf youtube channel</a>
<p>If you would like to learn more about Meow Wolf or see one of their packs or attactions please check out their website. It's much better than this one i promice</p><br>
<a href="https://meowwolf.com/">Meow Wolf homepage</a>
</div>

    <footer>
	<hr style="background-color:black;" />
	Copyright &copy; 2020. All rights reserved
</footer>

</body>
</html>