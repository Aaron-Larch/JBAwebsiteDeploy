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
<title>Insert title here</title>
  <head>
		<title>The people we work with</title>
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

    <div id="test">
       <table class="table table-striped" id="partners-Table">
   <caption style="caption-side: top;">Here are Some of the shipping companies we work with</caption>
   <thead>
    <th scope="row">Company Name </th>
    <th scope="row">Phone Number</th>
   </thead>
   <tbody>
    <c:forEach items="${partners}" var="article" >
     <tr>
      <td>${article.companyName}</td>
      <td>${article.address}</td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
    </div>
    <div id="banner">
    <p>This banner needs to be placed on the side of the page and tell you the three step process to become a partner. <br>
    Step 1 fill out this form <a href="SignUpForm">Here</a><br>
    Step 2 Call this number 555-666-7899 and scedual an interview. be sure to bring or prepare the folflowing: List to be desided<br>
    Step 3 follow the zoomlink we send you of meet in person at a place that doesn't exist<br>
    Step 4 Scarafice no more than 4 gummy bears to our dark gods to ensure a sucessfull buiness transaction</p>
    </div>
</body>
    <footer>
	<hr style="background-color:black;" />
	Copyright &copy; 2020. All rights reserved
	</footer>
</html>