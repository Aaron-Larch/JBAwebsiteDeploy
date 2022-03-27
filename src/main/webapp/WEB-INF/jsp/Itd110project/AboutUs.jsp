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
		<title>The People Who made this</title>
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
 	<h1 class="title">Learn more about the team</h1><br>
   <hr style="background-color:white;"/>
</div>

    <div id="test">
    <img id="CenterLine" src="${contextPath}/FixedAssets/ComponyLogo.png" alt="Logo" width="300" height="200"/>
		<br><br>
		<img id="CenterLine" src="${contextPath}/FixedAssets/AaronLarch.jpg" alt="Founder" width="800" height="900"/>
		<p style="text-align:center;">This is our Co-founder and CEO. Aaron Larch Is a GCE Trainee built this website from scratch and designed
		 All of the features, testing, and Page displays<br>
		He then added an exsternal email server, added an exsternal SQL database, made a data tracker and analyser, 
		and with the help from his co founder Built a Reports page.<br>
		Click Here to see what the sight has to offer:</p>
		<br>
		insert button to play a video here.
		<br><br>
		<div id="SubImage">
			<img id="Cofounder" src="${contextPath}/FixedAssets/BrianRodewald1.jpg" 
				style="float: left; margin-right: 15px;" alt="Co-Founder" width="350" height="450"/>
			<h2><br><br>
			This is our Sites co-founder</h2>
			<p style="text-align:center;"> Co-founder Brian built 2 web pages for this sight. He 
			Desinged part of the logic behind the Graphing software as well as cleaned up chart data generating subrutines.
			He also created the basic layouts for the table display page where the reports are displayed</p>
		</div>
		<div class="clear"></div><br>
				<div id="SubImage">
			<img id="ArtConsultant" src="${contextPath}/FixedAssets/BenGibbs.jpg" 
				style="float: left; margin-right: 15px;" alt="Co-Founder" width="350" height="320"/>
			<h2><br><br>
			This is our Sites Graphic Arts Consultant</h2>
			<p style="text-align:center;"> Ben Gibbs Is responsibule for all of the art assets for the web Site.
			He Desinged formated and cropped all of the royalty free art assets you see on this Sight. He and His
			Crack team of Digial artists Worked Hard to create the artistic layout of the Entier site.</p>
		</div>
		<div class="clear"></div><br><br><br>
		<div id="SubImage">
			<img id="Add" src="${contextPath}/FixedAssets/ShopingInterface.PNG" 
				style="float: right; margin-left: 15px;" alt="SamplePage" width="650" height="325"/>
			<p style="text-align:Center;"><br>
			This project started in march 2019 and went through several 
			iterations and redesigns as features were added and the sight exspanded to include more content and features. Throghout the
			evolution of this project many chalenges were overcome giving way to new code techniques and improving user security and interface.
			With each challenge the code improved in quility not just for the curent product but for futuer changes as well<br>
			Added Features include: <br>
			conversion from JerseyAP to spring boot<br>
			outomated Creation of a Large number data generator<br>
			Blob Data storage of java objects<br>
		</div>
		<div class="clear"></div><br><br>
		<p  style="text-align:Center;">To contact us for an interview please call us at 111-222-3333 or go to a place that dose not exist</p>
    </div>
</body>

    <footer>
	<hr style="background-color:black;" />
	Copyright &copy; 2020. All rights reserved
</footer>
</html>