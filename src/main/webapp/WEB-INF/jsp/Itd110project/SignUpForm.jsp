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
 	<head>
		<title>Come and join our little family</title>
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
 	<h1 class="title">Join our Crew</h1><br>
   <hr style="background-color:white;"/>
</div>
<form action="${contextPath}/Partners" method="POST">
	<p> Welcome potential applicent and thank you for choosing to work with us at JBC incorperated. 
	We are eger to start working with you but first we need to know a little bit more About you.
	Please fill in this form and we will get back to you as soon as possibule.</p>

<h2>Tell us about you</h2>
<fieldset>
	<legend>Your Information</legend>
	<ul>
		<li><lable for="survey">Name:</lable> <input type="text" name="fullname" id="form-name"></li>
		<li><lable for="survey">Compony Name:</lable> <input type="text" name="componyname" id="form-name"></li>
		<li><lable for="survey">Address:</lable> <input type="text" name="address" id="form-name"></li>
		<li><lable for="survey">Office Number:</lable> <input type="text" name="officenumber" id="form-name"></li>
		<li><lable for="survey">Personal Number:</lable> <input type="text" name="pesonalnumber" id="form-name"></li>
	</ul>
</fieldset>

<h2>Tell us about your compony</h2>
<p>Please select the items your compony deals with from the list of options. you may select more than 1</p>
<fieldset>
	<legend>Compony Information</legend>
    	<input type="checkbox" name="operation" id="bev" value="beverages"/><label for="survey">Beverages</label><br />
    	<input type="checkbox" name="operation" id="cond" value="condiments"/><label for="survey">Condiments</label><br />
    	<input type="checkbox" name="operation" id="Conf" value="confections"/><label for="survey">Confections</label><br />
    	<input type="checkbox" name="operation" id="dairy" value="dairyproducts"/><label for="survey">Dairy Products</label><br />
    	<input type="checkbox" name="operation" id="grain" value="grain-cereal"/><label for="survey">Grain & Cereal</label><br />
    	<input type="checkbox" name="operation" id="meat" value="meat-pultry"/><label for="survey">Meat & Pultry</label><br />
    	<input type="checkbox" name="operation" id="por" value="produce"/><label for="survey">Produce</label><br />
    	<input type="checkbox" name="operation" id="seaf" value="seafood"/><label for="survey">Sea Food</label><br />
    	<input type="checkbox" onclick="checkAll(this)" onchange="document.getElementById('CheckTest').disabled = !this.checked;"/>
    	<label for="all">Select All</label><br />
		<br>
</fieldset>

<h2>How many Vehicles does you compony own?</h2>
	<select name="trucks" size="1">
		<option>1</option>
		<option>2</option>
		<option>3</option>
		<option>4</option>
		<option>5</option>
		<option>6</option>
		<option>7</option>
		<option>8</option>
		<option>9</option>
		<option>10</option>
		<option>11</option>
		<option>12</option>
		<option>13</option>
		<option>14</option>
		<option>15</option>
		<option>16</option>
		<option>17</option>
		<option>18</option>
		<option>19</option>
		<option>20</option>
		<option>21</option>
		<option>22</option>
		<option>23</option>
		<option>24</option>
		<option>25</option>
	</select>
	
<fieldset>
	<p><input type="submit" value="Submit!"><input type="reset">
</fieldset>
</form>
</body>
</html>