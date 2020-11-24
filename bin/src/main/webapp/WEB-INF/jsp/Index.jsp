<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import= "java.util.Arrays"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/> 
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>JBA Shipping inc.</title>
	<script><%@include file="../resources/js/reportfunctions.js"%></script>
	<style><%@include file="../resources/css/HomePage.css"%></style>
	<link rel="stylesheet" href=" https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</head>
<body>
	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<a onclick="switchStateBtn('Step1')" href="javascript:void(0)">About</a>
		<a onclick="switchStateBtn('Step2')" href="javascript:void(0)">Services</a>
		<a onclick="switchStateBtn('Step3')" href="javascript:void(0)">Partners</a>
		<a onclick="switchStateBtn('Step4')" href="javascript:void(0)">Home</a>
		<spring:url value="${contextPath}/login" var="StartURL" />
		<a id="LoadFile" href="${StartURL }" >Login</a>.
	</div>
	
	<span style="font-size:30px; cursor:pointer;" onclick="openNav()">&#9776; Welcome to the JBA Food Shipping & Tracking</span>
	
	<div id="Placeholder" class="slideshow">${test}
		<div id="slider" class="Site_Features_List">
			<c:forEach var="img" items="${imageUrlList}">  
				<div id="silde" class="ProductSlides">
					<img id="pic" src="${contextPath}/ImageAssets/${img}" alt="MissingImg" width="800" height="400"/>
					<p class="SlideText"><span>${fn:substringBefore(img, ".")}</span></p>
				</div>
			</c:forEach>
			<canvas class="ProductSlides" id="chartContainer"></canvas>
		</div>
	</div>
	
	<div id="Placeholder" class="services">
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
	
	<div Class="AboutSite">
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
		<div class="clear"></div><br><br><br>
		<div id="SubImage">
			<img id="Add" src="${contextPath}/FixedAssets/ShopingInterface.PNG" 
				style="float: right; margin-left: 15px;" alt="SamplePage" width="650" height="325"/>
			<p style="text-align:Center;"><br>
			This project started in march 2019 and went through several 
			interations and redesigns as features were added and the sight exspanded to include more content and features. Throghout the
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

<div class="partners">
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

<script>
	window.onload = function () {loadChannel(".services", ".slideshow", ".partners", ".AboutSite", "Step4");}
	chartslide(${Arrays.toString(Data)}, "chartContainer");
	chartslide(${Arrays.toString(Data)}, "chartClone");
	AnimateSlide();
	
	var slideIndex = 1;
	showDivs(slideIndex);
</script>
</body>
</html>
