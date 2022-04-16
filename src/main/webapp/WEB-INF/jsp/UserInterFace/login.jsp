<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
		<title>Log in with your account</title>
   		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  		<style><%@include file="../../resources/css/common.css"%></style>
  		<style><%@include file="../../resources/css/FrontPageStyle.css"%></style>
  		<script><%@include file="../../resources/js/reportfunctions.js"%></script>
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
			<span style="font-size:30px;">JBA Shipping Inc.</span><br>
 			<span class="c"><small>We Deliver the Best to Deliver You Success</small></span>
 		</div>
   		<hr style="background-color:white;"></hr>
	</div>

     <div class="container">
      <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username" autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            
            <div id="errorSpace">
            <span>${error}</span>
             <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</div>
			
            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><p>Forgot your Password? Then call 555-555-5551</p></h4>
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
        </div>
      </form>
    </div>
    <footer>
	<hr style="background-color:black;" />
	Copyright &copy; 2020. All rights reserved
</footer>
<script> navAnimate(document.getElementById("mySidenav"));</script>
  </body>
</html>