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
		<link rel="stylesheet" href=" https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
		<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
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
  			<h1 id="topBanner" >Learn more about what we do</h1>
			<span style="font-size:30px;">JBA Shipping Inc.</span><br>
 			<span class="c"><small>We Deliver the Best to Deliver You Success</small></span>
 		</div>
   		<hr style="background-color:white;"></hr>
	</div>
	
	<div id="test" style="position: relative; min-height: 100vh;">
	<div id="Placeholder" class="services">
		<div id="slider" class="Site_Features_List">
			<c:forEach var="img" items="${imageUrlList}">  
				<div id="silde" class="myslides">
					<img id="pic" src="${contextPath}/ImageAssets/${img}" alt="MissingImg" width="800" height="400"/>
					<p class="SlideText"><span>${fn:substringBefore(img, ".")}</span></p>
				</div>
			</c:forEach>
			<canvas class="myslides" id="chartSampler"></canvas>
			
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
	<br>
	<footer>
		<hr style="background-color:black; width: 70%;" />
		<p>Copyright &copy; 2020. All rights reserved <br>
		For more information please feel free to contact us at 
		<a href="mailto:a.larch@yahoo.com">hege@example.com</a><br>
		Or call us at 555-444-5678 and we will ignore your questions</p>
	</footer>
	</div>
<script>
	navAnimate(document.getElementById("mySidenav"));
	newSetUp(1, ${Arrays.toString(Data)});
</script>
</body>
</html>