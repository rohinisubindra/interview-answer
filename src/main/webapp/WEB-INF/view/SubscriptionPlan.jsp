<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>

<head>
    <TITLE>EzyPay</TITLE>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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

img {
	border-radius: 5px 5px 0 0;
}

.container {
	padding: 2px 16px;
}

* {
	box-sizing: border-box;
}

.columns {
	float: left;
	width: 33.3%;
	padding: 8px;
}

.price {
	list-style-type: none;
	border: 1px solid #eee;
	margin: 0;
	padding: 0;
	-webkit-transition: 0.3s;
	transition: 0.3s;
}

.price:hover {
	box-shadow: 0 8px 12px 0 rgba(0, 0, 0, 0.2)
}

.price .header {
	background-color: #111;
	color: white;
	font-size: 25px;
}

.price li {
	border-bottom: 1px solid #eee;
	padding: 20px;
	text-align: center;
}

.price .grey {
	background-color: #eee;
	font-size: 20px;
}

.button {
	background-color: #04AA6D;

	color: white;
	padding: 10px 25px;
	text-align: center;
	text-decoration: none;
	font-size: 18px;
	border-radius:32px;

}
.w3-button,.w3-hover-button:hover{color:#fff!important;background-color:#262838!important}
@media only screen and (max-width: 600px) {
	.columns {
		width: 100%;
	}
}

</style>
</head>

<body>
    <div class="book" id="mainDiv">
        <P class="center">A simple subscription service
            <P>
                <div class="container center" id="pageDiv">
                    <div class="leftbox" id="leftbox">
                        <form:form id="SubscriptionPlanDetails" name="myForm" modelAttribute="wSubscriptionDetails"
                            method="post" onsubmit="return validateForm(event)">
                            <div class="formDiv">

                                <label>Amount:</label>

                                <input class="form-control" name="amount" id="amount" type="text" pattern="[0-9]*"
                                    autocomplete="off" placeholder="Kindly enter amount." onkeyup="this.value=this.value.replace(/[^\d]/,'')"></input>
                                <div class="invalid-feedback" id="amount-error" style="color:red;font-weight: 900">
                                </div>
                                <br>

                                <label>Plan Type:</label> <select onchange="calculatePlanType(this);" type="text" id="plantypeselect"
                                    name="subscriptionType" class="form-control" id="plantype" placeholder="Select your plan type"
                                    required>
                                    <option value="" disabled="" selected="selected">Select
                                        plan type</option>
                                    <option value="Daily">Daily</option>

                                    <option value="Weekly">Weekly</option>
                                    <option value="Monthly">Monthly</option>
                                </select>

                                <div class="invalid-feedback" id="amount-plantype" style="color:red;font-weight: 900"></div>
                                <div id="Weeklyss" style="display: none;">
                                    <br><label> Weekly:</label> <select name="frequencyDetails" id="Weekly" class="form-control">
                                        <option value="Sunday">Sunday</option>
                                        <option value="Monday">Monday</option>
                                        <option value="Tuesday">Tuesday</option>
                                        <option value="Wednesday">Wednesday</option>
                                        <option value="Thursday">Thursday</option>
                                        <option value="Friday">Friday</option>
                                        <option value="Saturday">Saturday</option>
                                    </select>


                                </div>

                                <div id="Monthlyss" style="display: none;">
                                    <br><label>Monthly:</label> <select id="Monthly" class="form-control">
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                        <option value="8">8</option>
                                        <option value="9">9</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                        <option value="13">13</option>
                                        <option value="14">14</option>
                                        <option value="15">15</option>
                                        <option value="16">16</option>
                                        <option value="17">17</option>
                                        <option value="18">18</option>
                                        <option value="19">19</option>
                                        <option value="20">20</option>
                                        <option value="21">21</option>
                                        <option value="22">22</option>
                                        <option value="23">23</option>
                                        <option value="24">24</option>
                                        <option value="25">25</option>
                                        <option value="26">26</option>
                                        <option value="27">27</option>
                                        <option value="28">28</option>
                                        <option value="29">29</option>
                                        <option value="30">30</option>
                                        <option value="31">31</option>
                                    </select>


                                </div>

                                <script>
                                    function calculatePlanType(that) {

                                        if (that.value == "Weekly") {
                                            document.getElementById("Weeklyss").style.display = "block";

                                        } else {
                                            document.getElementById("Weeklyss").style.display = "none";
                                        }
                                        if (that.value == "Monthly") {
                                            document.getElementById("Monthlyss").style.display = "block";

                                        } else {
                                            document.getElementById("Monthlyss").style.display = "none";
                                        }
                                    }
                                </script>
                                <br><label>Start Date:</label>
                                <input type="date" id="startdate" data-date="" data-date-format="dd/MM/yyyy" name="subscriptionStartDate"
                                    class="form-control" placeholder="DD/MM/YYYY" onkeyup="dateFormatting()"></input>


                                <br> <label>End Date:</label>
                                <input type="date" data-date="" data-date-format="dd/MM/yyyy" name="subscriptionEndDate"
                                    placeholder="DD/MM/YYYY" class="form-control" id="enddate"></input>
                                <div class="invalid-feedback" id="dateError" style="color:red;font-weight: 900">
                                </div>
                                <br>

                                <input type="submit" class="button w3-button" value="Plan subscription">
                            </div>
                        </form:form>
                    </div>
                    <div class="rightbox" id="rightbox">
                        <img src="img/test1.png">
                        <p>Back End Software Engineer Home Test. </p>
                    </div>
                </div>
    </div>


    <script>
        function validateForm(e) {
            e.preventDefault();

            alert("validateForm");
            var result = true;
            var amount = $("#amount").val();
            if (amount.length == 0) {
                $("#amount-error").html('Kindly enter amount.');
                $("#amount-error").show();
                result = false;

            }
            if (amount < 10) {
                $("#amount-error").html('Amount should be greater than 10.');
                $("#amount-error").show();
                result = false;

            }
            var plantypeselect = document.getElementById("plantypeselect");
            if (plantypeselect.value == "") {
                //If the "Please Select" option is selected display error.
                /// alert("Please select an option!");amount-plantype
                $("#amount-plantype").html('Kindly select Plan type.');
                $("#amount-plantype").show();
                result = false;

            }

            var subscriptionStartDate = document.getElementById("startdate").value;
            var subscriptionEndDate = document.getElementById("enddate").value;
            if (subscriptionStartDate.length == 0) {
                $("#dateError").html('start date cannot be empty');

                $("#dateError").show();
                result = false;
                return false;
            }

            if (subscriptionEndDate.length == 0) {

                $("#dateError").html('end date cannot be empty');
                $("#dateError").show();
                result = false;
                return false;
            }
            var startdate = new Date(subscriptionStartDate)
            var enddate = new Date(subscriptionEndDate)
            if (enddate < startdate) {
                alert('End date cannot before start date')
                $("#dateError").html('End date cannot before start date');
                $("#dateError").show();


                result = false;
                return false;
            }

            var months;
            months = (enddate.getFullYear() - startdate.getFullYear()) * 12;
            months -= startdate.getMonth();
            months += enddate.getMonth();
            if (months <= 0) {
                months = 0;
            }
            if (months > 3) {
                alert("Subscription cannot be more than 3 mth")
                $("#dateError").html('Subscription cannot be more than 3 mth');
                $("#dateError").show();
                result = false;
                return false;
            }

            if (result == false) {
                return false;
            }

            var amount = '"' + document.getElementById("amount").value + '"';

            var subscriptionType = '"' + document.getElementById("plantypeselect").value + '"';

            var frequencyDetails = '"' + document.getElementById("Weekly").value + '"';
            if (subscriptionType == 'Monthly') {
                frequencyDetails = '"' + document.getElementById("Monthly").value + '"';
            }

            var subscriptionStartDate = '"' + document.getElementById("startdate").value + '"';
            var subscriptionEndDate = '"' + document.getElementById("enddate").value + '"';

            var test = "{" + "\"amount\":" + amount + "," + "\"subscriptionType\":" + subscriptionType + "," + "\"frequencyDetails\":" + frequencyDetails + "," + "\"subscriptionStartDate\":" + subscriptionStartDate + "," + "\"subscriptionEndDate\":" + subscriptionEndDate + "}"

            var dataString = test;
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/uisubscribe",
                data: dataString,
                success: function (result) {
                    $("body").html(result);

                },
                error: function (xhr, status, error) {

                }
            });

        }
    </script>

    <script>



        $(document).ready(function () {

            $(amount).focus(function () {
                $("#amount-error").hide();
            });
            $(plantypeselect).focus(function () {
                $("#amount-plantype").hide();
            });
                $(startdate).focus(function () {
                            $("#dateError").hide();
                        });
                           $(enddate).focus(function () {
                                                    $("#dateError").hide();
                                                });



        });
    </script>


    <script>


        function myFunction() {
            var str = document.getElementById("startdate").value;
            var res = str.slice(0, 4);
            var res2 = str.slice(5, 7);
            var res3 = str.slice(8, 10);
            var formattedText = res3 + "-" + res2 + "-" + res;
            alert("formattedText ---- " + formattedText);
            document.getElementById("startdate").value = formattedText;
        }
    </script>



</body>

</html>