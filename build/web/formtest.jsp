<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Test script</title>
        <%@include file="getlink.jsp" %>
</head>
<body>
    <h1 class="text text-center">Register</h1>
    
    <div class="col-lg-3 col-lg-offset-2"> 
        <form id="myform" action="index.jsp" method="post">
            
            <div class="form-group">
                <!-- <label>username</label> -->
                <input type="text" id="username" class="required" placeholder="Username"  name="username"/>
                <div> </div>
            </div>
           
            <div class="form-group">
                <!-- <label>Password</label> -->
                <input type="text" id="password" class="required password"  name="password" placeholder="password *"/>
            </div>

            <div class="form-group">
                <!-- <label>Password</label> -->
                <input type="text" id="passwordConf" class="required passwordConf"  name="password" placeholder="Confirm password *"/>
            </div>

            <div class="form-group">
                <!-- <label>email</label> -->
                <input type="email" id="email" class="email required "  name="email" placeholder="email *"/>
            </div>

            <div class="form-group">
                <!-- <label>address</label> -->
                    
                <div class="col-lg-3" style="padding:unset;">
                    <select name="select" >
                        <option value="">+588</option>
                        <option value="">+12</option>
                        <option value="">+01</option>
                    </select>

                </div>
                <div class="col-lg-9" style="padding:unset;">
                    <input type="text" id="number" class="number"  name="address" placeholder="Phone number"/>
                </div>
            </div>

            <div class="form-group">
                <!-- <label>Date</label> -->
                <input type="date" id="Date"  name="Date" placeholder="Date"/>
            </div>

           
            <div class="form-group">
                <!-- <label>Phone</label> -->
                <input type="text" id="phone"  name="phone" placeholder="Phone number *"/>
            </div>

            <div class="form-group">
                <!-- <label>Phone</label> -->
                <input type="text" id="phone"  name="number" />
            </div>
            
            
            <select name="se" class="se">
                <option value="1">number1</option>
                <option value="2">number2</option>
                <option value="3">number3</option>
            </select>
            
            <input type="submit" value="Save" />  
        </form>
    </div>

    <div class="col-lg-3 col-lg-offset-1"> 
        <form id="myform" action="index.jsp" method="post">
            
            <div class="form-group">
                <!-- <label>username</label> -->
                <input type="text" id="motherName" class="border-red" placeholder="Mother Name"  name="motherName"/>
                <span class="username"></span>
            </div>
           
            <div class="form-group">
                <!-- <label>Password</label> -->
                <input type="text" id="fatherName"  name="fatherName" placeholder="Father Name"/>
            </div>

            <div class="form-group">
                <!-- <label>email</label> -->
                <input type="text" id="grade"  name="grade" placeholder="grade"/>
            </div>

            <div class="form-group">
                <!-- <label>address</label> -->
                <input type="text" id="currendAdd"  name="currendAdd" placeholder="Currend Address *"/>
            </div>

            

           
        
        </form>
    </div>
	
</body>
</html>