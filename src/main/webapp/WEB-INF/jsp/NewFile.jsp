<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
 <div class="page">
    <header>
      <h1>LOLCAT CLOCK</h1>
    </header>

    <h4>
      I CAN HAZ TIME?? <br>
      <span id="clock">Clock goes here</span>
    </h4>

    <img id="lolcatImage" src="https://s3.amazonaws.com/media.skillcrush.com/skillcrush/wp-content/uploads/2016/08/normalTime.jpg" alt="lolcat">

    <blockquote id="timeEvent">This is where time events are reported</blockquote>


    set Wake Up Time
    <select id="wakeUpTimeSelector">
      <option value="1">1 AM - 2AM</option>
      <option value="2">2 AM - 3AM</option>
      <option value="3">3 AM - 4AM</option>
      <option value="4">4 AM - 5AM</option>
      <option value="5">5 AM - 6AM</option>
      <option value="6">6 AM - 7AM</option>
      <option value="7">7 AM - 8AM</option>
      <option value="8" selected>8 AM - 9AM</option>
      <option value="9">9 AM - 10AM</option>
      <option value="10">10 AM - 11AM</option>
      <option value="11">11 AM - 12PM</option>
      <option value="12">12 PM - 1PM</option>
      <option value="13">1 PM - 2PM</option>
      <option value="14">2 PM - 3PM</option>
      <option value="15">3 PM - 4PM</option>
      <option value="16">4 PM - 5PM</option>
      <option value="17">5 PM - 6PM</option>
      <option value="18">6 PM - 7PM</option>
      <option value="19">7 PM - 8PM</option>
      <option value="20">8 PM - 9PM</option>
      <option value="21">9 PM - 10PM</option>
      <option value="22">10 PM - 11PM</option>
      <option value="23">11 PM - 12AM</option>
      <option value="24">12 AM - 1AM</option>
    </select>
    <br>
    set Lunch Time
      <select id="lunchTimeSelector">
        <option value="1">1 AM - 2AM</option>
        <option value="2">2 AM - 3AM</option>
        <option value="3">3 AM - 4AM</option>
        <option value="4">4 AM - 5AM</option>
        <option value="5">5 AM - 6AM</option>
        <option value="6">6 AM - 7AM</option>
        <option value="7">7 AM - 8AM</option>
        <option value="8">8 AM - 9AM</option>
        <option value="9">9 AM - 10AM</option>
        <option value="10">10 AM - 11AM</option>
        <option value="11">11 AM - 12PM</option>
        <option value="12" selected>12 PM - 1PM</option>
        <option value="13">1 PM - 2PM</option>
        <option value="14">2 PM - 3PM</option>
        <option value="15">3 PM - 4PM</option>
        <option value="16">4 PM - 5PM</option>
        <option value="17">5 PM - 6PM</option>
        <option value="18">6 PM - 7PM</option>
        <option value="19">7 PM - 8PM</option>
        <option value="20">8 PM - 9PM</option>
        <option value="21">9 PM - 10PM</option>
        <option value="22">10 PM - 11PM</option>
        <option value="23">11 PM - 12AM</option>
        <option value="24">12 AM - 1AM</option>
      </select>
    <br>
    set Nap Time
    <select id="napTimeSelector">
      <option value="1">1 AM - 2AM</option>
      <option value="2">2 AM - 3AM</option>
      <option value="3">3 AM - 4AM</option>
      <option value="4">4 AM - 5AM</option>
      <option value="5">5 AM - 6AM</option>
      <option value="6">6 AM - 7AM</option>
      <option value="7">7 AM - 8AM</option>
      <option value="8">8 AM - 9AM</option>
      <option value="9">9 AM - 10AM</option>
      <option value="10">10 AM - 11AM</option>
      <option value="11">11 AM - 12PM</option>
      <option value="12">12 PM - 1PM</option>
      <option value="13">1 PM - 2PM</option>
      <option value="14">2 PM - 3PM</option>
      <option value="15" selected>3 PM - 4PM</option>
      <option value="16">4 PM - 5PM</option>
      <option value="17">5 PM - 6PM</option>
      <option value="18">6 PM - 7PM</option>
      <option value="19">7 PM - 8PM</option>
      <option value="20">8 PM - 9PM</option>
      <option value="21">9 PM - 10PM</option>
      <option value="22">10 PM - 11PM</option>
      <option value="23">11 PM - 12AM</option>
      <option value="24">12 AM - 1AM</option>
      </select>
    <br>
    <button id="partyTimeButton">Party!</button>

    <footer>
      <p>&copy; Skillcrush 2016</p>
    </footer>
  </div>

  <script> <%@include file="../resources/js/SystemClock.js"%></script>
</body>
</html>