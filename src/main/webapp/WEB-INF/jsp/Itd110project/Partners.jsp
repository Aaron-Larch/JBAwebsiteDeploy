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
  			<h1 id="topBanner" >Some of the Companies we work with</h1>
			<span style="font-size:30px;">JBA Shipping Inc.</span><br>
 			<span class="c"><small>We Deliver the Best to Deliver You Success</small></span>
 		</div>
   		<hr style="background-color:white;"></hr>
	</div>
	
	<div id="test" style="position: relative; min-height: 100vh;">
	<div id="partners">
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
    	<p>
    		<h4 style= "font-family: Verdana">If you have enjoyed what you've seen and want to join our little team then follow these steps to become a partner.</h4><br>
    		Step 1 Fill out this form <a href="SignUpForm">Here</a><br><br>
    		Step 2 Call this number 555-666-7899 and schedule an interview. be sure to bring or prepare the following:<br>
    			<span style="padding-left: 35px;">A suit and tie.<br></span>
    			<span style="padding-left: 35px;">A bagged lunch.<br></span>
    			<span style="padding-left: 35px;">Your Resume and no fewer than three references<br></span>
    			<span style="padding-left: 35px;">Proof of ID</span>
    		<br><br>
    		Step 3 Follow the zoomlink we send you or meet in person at our main office in a place that doesn't exist<br><br>
    		Step 4 Sacrifice no more than 4 gummy bears to our dark gods to ensure a successful business transaction
    	</p>
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