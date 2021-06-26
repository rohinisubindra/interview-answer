
<html>
<head>
<TITLE>EzyPay subscription Details</TITLE>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
body {
	background: #f1f1f1;
}

.center {
	margin: auto;
	width: 60%;
	padding: 10px;
	font-family: 'Open Sans', sans-serif
}

.container {
	display: flex;
}

.leftbox {
	flex: 1;
	background-color: #f58029;
	font-family: 'Open Sans', sans-serif
}

.rightbox {
	flex: 1;
	background-color: white;
}

img {
	max-width: 100%;
	max-height: 100%;
	margin-left: auto;
	margin-right: auto;
	display: block;
}

.formDiv {
	margin: 50px 0px;
	width: 80%;
	padding: 50px;
}

p {
	text-align: center;
	font-size: 14px;
	color: #000;
	letter-spacing: 3px;
}

.formDiv i {
	position: absolute;
}

.icon {
	padding: 20px;
	min-width: 40px;
}

.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	transition: 0.3s;
	width: 40%;
	border-radius: 5px;
}

.card:hover {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}



</style>
</head>

<body>
	<div class="book" id="mainDiv">
		<P class="center">subscription Details
		<P>
		<div class="container center" id="pageDiv">
			<div class="leftbox" id="leftbox">
				<div class="formDiv">
					<br>
					amount : ${amount}<br>
					subscriptionType : ${subscriptiontype}<br>
					frequencyDetails : ${frequencydetails}<br>
					subscriptionStartDate : ${startdate}<br>
					subscriptionEndDate : ${enddate}
						
				</div>
			</div>
			
		</div>
	</div>


</body>

</html>