/*!
 * JavaScript Methods (https://github.com/Aaron-Larch/Websight-Protobuild)
 * Copyright 2020-2025 GCE, Inc.
 * Created by Aaron Larch
 */

$(document).ready(function () {
	// Get a modal
	this.loadModal = function(input){
		$("#AssineParamiters").modal().on('shown.bs.modal', function (e) {loadValues(".PopUpModal", ".CreateNewRecord", input)});
		load_page('/WEB-INF/ModelLibrary.jsp #container');
	};
	
	this.getModal = function(){
		$("#CreateNewRecord").modal().on('shown.bs.modal');
		load_page('/WEB-INF/ModelLibrary.jsp #container');
	};
	
	//function to call popup window
	this.loadPopUp =function (input){
		$("#PopUpModal").modal().on('shown.bs.modal', function (e) {loadContent(input);});
		load_page('/WEB-INF/ModelLibrary.jsp #container');
	};
	
	//Switch states button
	this.SwichLoadout= function(a){
		if(a==1){
			[].forEach.call(document.querySelectorAll(".Populate"), function (i) {i.style.display="block";});
			[].forEach.call(document.querySelectorAll(".display"), function (i) {i.style.display="none";});
		}else{
			[].forEach.call(document.querySelectorAll(".Populate"), function (i) {i.style.display="none";});
			[].forEach.call(document.querySelectorAll('.display'), function (i) {i.style.display="block";});
		}
	};

	//Check all function
	this.checkAll=function(source) {
		  checkboxes = document.getElementsByName('operation');
		  for(var i=0; i<checkboxes.length; i++) {
		    checkboxes[i].checked = source.checked;
		  }
		};
	
	this.renderChart();
})	

function load_page(url){$('modal-isi-body').load(url) ;}

//Display a combination of classes based of a given variabule
function loadValues(class1, class2, flag){
	if(flag=="page1"){
		[].forEach.call(document.querySelectorAll(class1), function (i) {i.style.display="block";});
		[].forEach.call(document.querySelectorAll(class2), function (i) {i.style.display="none";});
	}else if(flag=="page2"){
		[].forEach.call(document.querySelectorAll(class2), function (i) {i.style.display="block";});
		[].forEach.call(document.querySelectorAll(class1), function (i) {i.style.display="none";});
		}
}

//Select a string from an array of strings based on user input 
function loadContent(input) {
	document.getElementById("Display").value = "";
	//convert string into an array of strings
	var JsArray = document.getElementById('DisplayValue').innerHTML;
	var block = JsArray.substring(1, JsArray.length-1);
	var string = block.split("break");
	if(input > 0){ //Search array
		var quickfix=string[input].substring(2, string[input].length);
		document.getElementById('Display').value=quickfix;
	}else{document.getElementById('Display').value=string[input];}
}

//create a select function for multiple classes that are on one page. Do not know if this is a good Idea. but it will lower file count
function loadChannel(cl1, cl2, cl3, cl4, flag){
	if(flag=="Step1"){ //set flag values for each class
		[].forEach.call(document.querySelectorAll(cl1), function (i) {i.style.display="none";});
		[].forEach.call(document.querySelectorAll(cl2), function (i) {i.style.display="none";});
		[].forEach.call(document.querySelectorAll(cl3), function (i) {i.style.display="none";});
		[].forEach.call(document.querySelectorAll(cl4), function (i) {i.style.display="block";});
	}else if(flag=="Step2"){
		[].forEach.call(document.querySelectorAll(cl4), function (i) {i.style.display="none";});
		[].forEach.call(document.querySelectorAll(cl2), function (i) {i.style.display="none";});
		[].forEach.call(document.querySelectorAll(cl3), function (i) {i.style.display="none";});
		[].forEach.call(document.querySelectorAll(cl1), function (i) {i.style.display="block";});
	}else if(flag=="Step3"){
		[].forEach.call(document.querySelectorAll(cl4), function (i) {i.style.display="none";});
		[].forEach.call(document.querySelectorAll(cl1), function (i) {i.style.display="none";});
		[].forEach.call(document.querySelectorAll(cl2), function (i) {i.style.display="none";});
		[].forEach.call(document.querySelectorAll(cl3), function (i) {i.style.display="block";});
	}else{
		[].forEach.call(document.querySelectorAll(cl4), function (i) {i.style.display="none";});
		[].forEach.call(document.querySelectorAll(cl1), function (i) {i.style.display="none";});
		[].forEach.call(document.querySelectorAll(cl3), function (i) {i.style.display="none";});
		[].forEach.call(document.querySelectorAll(cl2), function (i) {i.style.display="block";});
	}
}

//Create a bunch of objects at ones to make a graphics page
function buildReport(
		xAxsis,
		bellData,
		highData,
		lowData,
		boxData,
		barXAxis,
		HistogramData) {
	/*Chart program layouts as found on https://www.chartjs.org/samples/latest/*/
	 new Chart("BellcurveChart", {
		  type: 'line',
		  data: {
		    labels: xAxsis,
		    datasets: [{ 
		        data: bellData,
		        //set a dynamic title card
		        label: document.getElementById("divName").innerHTML,
		        borderColor: "#3e95cd",
		        fill: false
		      }]
		  },
		  options: {
		    title: {
		      display: true,
		      text: 'Bell Curve Graph'
		    }
		  }
		});
	 
	 new Chart("HighLineGraph", {
		  type: 'line',
		  data: {
		    labels: xAxsis,
		    datasets: [{ 
		        data: highData,
		        label: document.getElementById("divName").innerHTML,
		        borderColor: "#3e95cd",
		        fill: false
		      }]
		  },
		  options: {
		    title: {
		      display: true,
		      text: 'Data Graph from high to low'
		    }
		  }
		});
	 
	 new Chart("LowLineGraph", {
		  type: 'line',
		  data: {
		    labels: xAxsis,
		    datasets: [{ 
		        data: lowData,
		        label: document.getElementById("divName").innerHTML,
		        borderColor: "#3e95cd",
		        fill: false
		      }]
		  },
		  options: {
		    title: {
		      display: true,
		      text: 'Data Graph from low to high'
		    }
		  }
		});
	 
	 new Chart("HistogramChart", {
		  type: 'bar',
		  data: {
		    labels: barXAxis,
		    datasets: [{ 
		        data: HistogramData,
		        label: document.getElementById("divName").innerHTML,
		        borderColor: "#3e95cd",
		        fill: false
		      }]
		  },
		  options: {
		    title: {
		      display: true,
		      text: 'Histogram Chart'
		    }
		  }
		});
	 
	 var chart = new CanvasJS.Chart("BoxandWhisker", {
			title:{
				text: "Box And Whisker Plot"
			},
			axisY: {
				interval: 40
			},
			data: [{
				type: "boxAndWhisker",
				upperBoxColor: "#FFC28D",
				lowerBoxColor: "#9ECCB8",
				color: "black",
				dataPoints: [
					
					{ label: document.getElementById("divName").innerHTML, y: boxData }
				]
			}]
		});
		chart.render();
}
//Take a canvas object and format it to fit in a div
function chartslide(data, ChartId){
	$(document).ready(function(){renderChart(data, ChartId);});//populate a chart object
	var canvas = document.querySelector('canvas');
	fitToContainer(canvas);

	//by setting the canvas ID to a variabule you can duplacate this image quite easaly
	function renderChart(input, picture) {
		/*Chart program layouts as found on https://www.chartjs.org/samples/latest/*/
		var chart = new Chart(picture, { 
			type: 'line',
				data: {
					labels: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
					datasets: [{ 
						data: input,
						label: 'My first dataset',
						borderColor: "#3e95cd",
						fill: false
					}]
				},
				options: {
					title: {
						display: true,
						text: 'This site can also track Large volumes of data over time and place them into graphs using CharJS software'
					}
				}
			});
		chart.render();
	}
	
	function fitToContainer(canvas){
		// Make it visually fill the positioned parent
		canvas.style.width ='100%';
		canvas.style.height='100%';
		// ...then set the internal size to match
		canvas.width  = canvas.offsetWidth;
		canvas.height = canvas.offsetHeight;
	}
}
function AnimateSlide(){
	var Index = 0;
	carousel();

	//set all but one of the slides to hidden
	function carousel() {
		var i;
		var x = document.getElementsByClassName("ProductSlides");
		for (i = 0; i < x.length; i++) {
			x[i].style.display = "none";  
		}
		Index++;
		if (Index > x.length) {Index = 1} //counter reset
		x[Index-1].style.display = "block";  
		setTimeout(carousel, 4000); // Change image every 4 seconds
	}
}

function openNav() { 
	//set nav bar to open 
	document.getElementById("mySidenav").style.width = "250px";//triggers animation effect
}

function closeNav() { 
	//set nav bar close
	document.getElementById("mySidenav").style.width = "0";//triggers animation effect
}

//Just like close nav only set to hight.
function closebox() {
	document.getElementById("myDropdown").style.height = "0";//triggers animation effect
}
	
function switchStateBtn(input){
	closeNav();//close nav bar before running class setting function
	loadChannel(".services", ".slideshow", ".partners", ".AboutSite", input);//call class selector
}
function plusDivs(n) {
	closebox();//run closing animation
	setTimeout(function(){showDivs(slideIndex += n);}, 800);//set timer before moving to next slide
}

function currentDiv(n) {
	closebox();//run closing animation
	setTimeout(function(){showDivs(slideIndex = n);}, 800);//save slide posision
}

function showDivs(n) {
	var i;
	var x = document.getElementsByClassName("mySlides");//set slide list to var
	var dots = document.getElementsByClassName("demo");//set dadge list to var
	if (n > x.length) {slideIndex = 1} //counter reset
	if (n < 1) {slideIndex = x.length} //set flag so that when hitting back on the fist slide takes you to the last slide
	
	//hide all slides
	for (i = 0; i < x.length; i++) {
		x[i].style.display = "none";  
	}

	//clear all badge backgrounds
	for (i = 0; i < dots.length; i++) {
		dots[i].className = dots[i].className.replace(" dotFill", "");
	}
	x[slideIndex-1].style.display = "block"; //show selected slide
	dots[slideIndex-1].className += " dotFill"; //fill animated badge
	openbox(slideIndex-1);//trigger box animation
 
	//open text box animation
	function openbox(place) {
		document.getElementById("myDropdown").style.height = "200px";//triggers animation effect
		document.getElementById("message").innerHTML = document.getElementById("StoreData"+place).innerHTML;//select proper text
	}
}

function PageSetUp(sidenav, slideIndex, input){
	//load Javascript functions for page
	AnimateSlide();
	showDivs(slideIndex);
	chartslide(input, "chartContainer");
	chartslide(input, "chartClone");
	
	//This is a two part method to have the sidenav close when the user clicks off the winow
	$('html').click(function( event) {
		 var a  = event.target;
		 var checkopen = sidenav.style.width //Check if sideNav is open
		 //negate clicking on the menu itself
		 if(a !== sidenav && checkopen !== "0"){
			 closeNav(); //  Hide the sidebar
		 }
	});
	
	$('#Openmenue').click(function(event){
	    event.stopPropagation(); // prevents executing the above event
	});
}
 
 function navAnimate(sidenav){
	//This is a two part method to have the sidenav close when the user clicks off the winow
	$('html').click(function( event) {
		 var a  = event.target;
		 var checkopen = sidenav.style.width //Check if sideNav is open
		 //negate clicking on the menu itself
		 if(a !== sidenav && checkopen !== "0"){
			 closeNav(); //  Hide the sidebar
		 }
	});
	
	$('#Openmenue').click(function(event){
	    event.stopPropagation(); // prevents executing the above event
	});
}

 function newSetUp(slideIndex, input){
	//load Javascript functions for page
	AnimateSlide();
	showDivs(slideIndex);
	chartslide(input, "chartSampler");
}