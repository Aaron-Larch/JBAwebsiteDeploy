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
   
	<div class="headder">
		<p><span class="Icon" onclick="openNav()" id="Openmenue">&#9776;</span><p>
  		<div id="menue">
  			<h1 id="topBanner" >Welcome to the JBA Homepage</h1>
			<span style="font-size:30px;">JBA Shipping Inc.</span><br>
 			<span class="c"><small>We Deliver the Best to Deliver You Success</small></span>
 		</div>
   		<hr style="background-color:white;"></hr>
	</div>
	
	<div id="test" style="position: relative; min-height: 120vh;">
		<h1 id="topBanner" >Welcome Here is a friendly add to tell you all about us.</h1>
		<div id="Siteadd">
			<br><br><br><br><!-- padding to place the video and adds correctly -->
			<iframe width="620" height="445" src="https://www.youtube.com//embed/j7atEB_RBws" controls='autoplay'></iframe><br><br>
			<p>This Video is not mine in any way shape or form. This video made by the people at Meow Wolf please go to their Youttube channel to see more of there videos</p>
			<a href="https://www.youtube.com/c/meowwolf">Meow Wolf youtube channel</a><br>
			<br>
			<p>If you would like to learn more about Meow Wolf or see one of their packs or attactions please check out their website. It's much better than this one i promice</p>
			<a href="https://meowwolf.com/">Meow Wolf homepage</a>
		</div>
		<br>
		<footer>
			<hr style="background-color:black; width: 70%;" />
			<p>Copyright &copy; 2020. All rights reserved <br>
			For more information please feel free to contact us at 
			<a href="mailto:a.larch@yahoo.com">hege@example.com</a><br>
			Or call us at 555-444-5678 and we will ignore your questions</p>
		</footer>
	</div>
	<script> navAnimate(document.getElementById("mySidenav"));</script>
</body>
</html>