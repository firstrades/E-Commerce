<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#chkPassport").click(function () {
            if ($(this).is(":checked")) {
                $("#dvPassport").show();
            } else {
                $("#dvPassport").hide();
            }
        });
    });
</script>

<script type="text/javascript" src="js_Buyer/Registration.js"></script>


    

<style type="text/css">
.formbox {
   width: 100%;
   margin: 10px 0px;
   padding: 0px;
}
.formbox label {
   font-size: 14px;
   color: #5A5A5A;
   float: left;
   /* margin: 6px 0px 0px; */
   width: 45%;
   margin-left: 22px;
}
.formbox input {
   width: 250px;
   padding: 5px;
height:25px;
   background: none repeat scroll 0% 0% #FFF;
   border: 1px solid #CECECE;
   margin: 0px 8px 0px 10px;
   color: #666;
   outline: medium none;
   background-image: none !important;
}
.formbox select {
   width: 261px;
   padding: 5px;
height:33px;
   background: none repeat scroll 0% 0% #FFF;
   border: 1px solid #CECECE;
   margin: 0px 0px 0px 10px;
   color: #666;
   outline: medium none;
}
#submit_button{
   margin-left: 48%;
   background-color: #0278B1;
   color: #ffffff;
   border: 1px solid #006786;
}
.form-box-content {
   padding: 0 20px;
}
.formcontainer {
   width: 100%;
   margin: 0px 0px 0px 10px;
}


</style>
</head>
<body>



<h1>Registration</h1>

<form action="<%=request.getContextPath() %>/Registration" method="post">



<div class="formcontainer">

<div class="formbox">
             <label>User_Id :</label>
            <input name="user_id" id="user_id"  required placeholder="Enter User_id" type="text" onchange="getUser_Id(this.value);"/><span id="getUser_Id"></span>
           
           </div>

           <div class="formbox">
             <label>Password :</label>
           <input name="password"  required placeholder="Enter Password" type="text"/>
           </div>

 <div class="formbox">
             <label>First name  :</label>
           <input name="first_name"  required placeholder="Enter First Name" type="text"/>
           </div>
           
           
           <div class="formbox">
             <label>Last name  :</label>
           <input name="last_name"  required placeholder="Enter Last Name" type="text"/>
           </div>
           
           
            <div class="formbox">
             <label>Gender   :</label>
           
<select id="sex" name="sex" class="operator_select" required="required">
<option value="">Select Gender</option>

<option value="Male">Male</option>

<option value="Female">Female</option>




</select>
           </div>
           
 <div class="formbox">
             <label>Email  :</label>
           <input name="email1"  required placeholder="Enter Email" type="text"/>
           </div>


 <div class="formbox">
             <label>Contact Number  :</label>
           <input name="mobile1"  required placeholder="Enter Contact Number" type="text"/>
           </div>
           
           
           <div class="formbox">
             <label>Address  :</label>
           <input name="address"  required placeholder="Enter Address" type="text"/>
           </div>
           
             <div class="formbox">
             <label>Pin   :</label>
           <input name="pin"  required placeholder="Enter Pin" type="text"/>
           </div>
           
                  <div class="formbox">
             <label>City   :</label>
           <input name="city"  required placeholder="Enter City" type="text"/>
           </div>
           
           <div class="formbox">
             <label>State   :</label>
           
<select id="state" name="state" class="operator_select" required="required">
<option value="">Select State</option>

<option value="Andaman and Nicobar">Andaman and Nicobar</option>

<option value="Andhra Pradesh">Andhra Pradesh</option>

<option value="Arunachal Pradesh">Arunachal Pradesh</option>

<option value="Assam">Assam</option>

<option value="Bihar">Bihar</option>

<option value="Chandigarh">Chandigarh</option>

<option value="Chhattisgarh">Chhattisgarh</option>

<option value="Dadra and Nagar Haveli">Dadra and Nagar Haveli</option>

<option value="Daman and Diu">Daman and Diu</option>

<option value="Delhi">Delhi</option>

<option value="Goa">Goa</option>

<option value="Gujarat">Gujarat</option>

<option value="Haryana">Haryana</option>

<option value="Himachal Pradesh">Himachal Pradesh</option>

<option value="Jammu And Kashmir">Jammu And Kashmir</option>

<option value="Jharkhand">Jharkhand</option>

<option value="Karnataka">Karnataka</option>

<option value="Kerala">Kerala</option>

<option value="Lakshadweep">Lakshadweep</option>

<option value="Madhya Pradesh">Madhya Pradesh</option>

<option value="Maharashtra">Maharashtra</option>

<option value="Manipur">Manipur</option>

<option value="Meghalaya">Meghalaya</option>

<option value="Mizoram">Mizoram</option>

<option value="Nagaland">Nagaland</option>

<option value="Orissa">Orissa</option>

<option value="Pondicherry">Pondicherry</option>

<option value="Punjab">Punjab</option>

<option value="Rajasthan">Rajasthan</option>

<option value="Sikkim">Sikkim</option>

<option value="Tamilnadu">Tamilnadu</option>

<option value="Tripura">Tripura</option>

<option value="Uttarakhand (Uttaranchal)">Uttarakhand (Uttaranchal)</option>

<option value="Uttar Pradesh">Uttar Pradesh</option>

<option value="West Bengal">West Bengal</option>


</select>
           </div>


</div>


<div>
	<input type="checkbox" name="checkbox" id="chkPassport" value="1"/> &nbsp; &nbsp; Tick this Box, if Product Delivery Address is different
 </div>


<div class="formcontainer" style="display:none;" id="dvPassport">
           <div class="formbox">
             <label>First Name :</label>
           <input name="first_name2"   placeholder="Enter First Name" type="text"/>
           </div>

 <div class="formbox">
             <label>Last Name  :</label>
           <input name="last_name2"   placeholder="Enter Last Name" type="text"/>
           </div>
           
           
 <div class="formbox">
             <label>Email  :</label>
           <input name="email2"   placeholder="Enter Email" type="text"/>
           </div>


 <div class="formbox">
             <label>Contact Number  :</label>
           <input name="mobile2"   placeholder="Enter Contact Number" type="text"/>
           </div>
           
           
           <div class="formbox">
             <label>Address  :</label>
           <input name="address2"   placeholder="Enter Address" type="text"/>
           </div>
           
             <div class="formbox">
             <label>Pin   :</label>
           <input name="pin2"   placeholder="Enter Pin" type="text"/>
           </div>
           
                  <div class="formbox">
             <label>City   :</label>
           <input name="city2"   placeholder="Enter City" type="text"/>
           </div>
           
           <div class="formbox">
             <label>State   :</label>
           
<select id="state" name="state2" class="operator_select" >
<option value="">Select State</option>

<option value="Andaman and Nicobar">Andaman and Nicobar</option>

<option value="Andhra Pradesh">Andhra Pradesh</option>

<option value="Arunachal Pradesh">Arunachal Pradesh</option>

<option value="Assam">Assam</option>

<option value="Bihar">Bihar</option>

<option value="Chandigarh">Chandigarh</option>

<option value="Chhattisgarh">Chhattisgarh</option>

<option value="Dadra and Nagar Haveli">Dadra and Nagar Haveli</option>

<option value="Daman and Diu">Daman and Diu</option>

<option value="Delhi">Delhi</option>

<option value="Goa">Goa</option>

<option value="Gujarat">Gujarat</option>

<option value="Haryana">Haryana</option>

<option value="Himachal Pradesh">Himachal Pradesh</option>

<option value="Jammu And Kashmir">Jammu And Kashmir</option>

<option value="Jharkhand">Jharkhand</option>

<option value="Karnataka">Karnataka</option>

<option value="Kerala">Kerala</option>

<option value="Lakshadweep">Lakshadweep</option>

<option value="Madhya Pradesh">Madhya Pradesh</option>

<option value="Maharashtra">Maharashtra</option>

<option value="Manipur">Manipur</option>

<option value="Meghalaya">Meghalaya</option>

<option value="Mizoram">Mizoram</option>

<option value="Nagaland">Nagaland</option>

<option value="Orissa">Orissa</option>

<option value="Pondicherry">Pondicherry</option>

<option value="Punjab">Punjab</option>

<option value="Rajasthan">Rajasthan</option>

<option value="Sikkim">Sikkim</option>

<option value="Tamilnadu">Tamilnadu</option>

<option value="Tripura">Tripura</option>

<option value="Uttarakhand (Uttaranchal)">Uttarakhand (Uttaranchal)</option>

<option value="Uttar Pradesh">Uttar Pradesh</option>

<option value="West Bengal">West Bengal</option>


</select>
           </div>


</div>


<input type="submit" id="submit_button" value="Registration">

</form>

</body>
</html>