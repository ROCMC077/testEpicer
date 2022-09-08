<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <title>Student Profile Page Design Example</title>

    <meta name="author" content="Codeconvey" />
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900&display=swap" rel="stylesheet"><link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!--Only for demo purpose - no need to add.-->
    <link rel="stylesheet" href="css/demo.css" />
    
	    <link rel="stylesheet" href="css/style.css">
</head>
<body style="background-color:antiquewhite;">
<%@ include file="userindex.jsp" %>	
<header class="ScriptHeader">
    <div class="rt-container">
    	<div class="col-rt-12">
        	<div class="rt-heading">
            	<h1>Hello ${user.getName()} !</h1>
            </div>
        </div>
    </div>
</header>

<section>
    <div class="rt-container">
          <div class="col-rt-12">
              <div class="Scriptcontent">
              
<!-- Student Profile -->
<form action="domodify" method="post" enctype="multipart/form-data"> 
<div class="student-profile py-4">
  <div class="container">
    <div class="row">
      <div class="col-lg-4">
        <div class="card shadow-sm">
          <div class="card-header bg-transparent text-center">
            <img class="profile_img" src="${user.getAvatar()}" alt="UserAvatar">
            <h3>${user.getName()}</h3>
          </div>
          <div class="card-body">
            <p class="mb-0"><strong class="pr-1">User ID:</strong>${user.getId()}</p>
            <input type="hidden" name="id" value="${user.getId()}">
            <p class="mb-0"><strong class="pr-1">Name:</strong>${user.getName()}</p>
            <p class="mb-0"><strong class="pr-1">Nickname:</strong><input type="text" name="nickname" value='${user.getNickname()}' required></p>
            <span>${show.nickname.getMessage()},1</span>
          </div>
        </div>
      </div>
      <div class="col-lg-8">
        <div class="card shadow-sm">
          <div class="card-header bg-transparent border-0">
            <h3 class="mb-0"><i class="far fa-clone pr-1"></i>General Information</h3>
          </div>
          <div class="card-body pt-0">
            <table class="table table-bordered">
              <tr>
                <th width="30%">Gender</th>
                <td width="2%">:</td>
                <td>${sgender}</td>
              </tr>
              <tr>
                <th width="30%">Birth</th>
                <td width="2%">:</td>
                <td>${sbirth}</td>
              </tr>
              <tr>
                <th width="30%">Account</th>
                <td width="2%">:</td>
                <td>${user.getAccount()}</td>
              </tr>
              <tr>
                <th width="30%">Password</th>
                <td width="2%">:</td>
                <td><input type="text" id="password" name="password" value="${user.getPassword()}" required >
<span>${show.password.getMessage()}</span>
<span id="sp1"></span></td>
              </tr>
              <tr>
                <th width="30%">Phone</th>
                <td width="2%">:</td>
                <td><input type="text" id="phone" name="phone" value="${user.getPhone()}" required>
<span>${show.phone.getMessage()}</span>
<span id="sp2"></span>
              </tr>
               <tr>
                <th width="30%">City & Township</th>
                <td width="2%">:</td>
                <td>
                <div class="twzipcode"></div>
  </td>
              </tr>
               <tr>
                <th width="30%">Address</th>
                <td width="2%">:</td>
                <td><input type="text" id="road" name="road" value="${user.getRoad()}" required>
<span>${show.road.getMessage()}</span>
<span id="sp5"></span></td>
              </tr>
              <tr>
              <td colspan="3" style="
  text-align: center;"><input type="file" id="myfile" name="myfile"></td>
              </tr>
            </table>
          </div>
        </div>
 <div style="height: 15px"></div>
          <div style="height: 50px;display: flex;
  justify-content: center;
  align-content: center;">
<input type="submit"  name="submit" value="確認">
<input type="submit" name="submit"  value="返回">
</div>
            </form>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- partial -->
           
    		</div>
		</div>
    </div>
</section>
     


    <!-- Analytics -->
 <script src="js/jquery-3.6.0.js"></script>
<script src="js/Manegment.js"></script>
<script src="js/test.js"></script>
 <script>
    const twzipcode = new TWzipcode(".twzipcode");
    </script>
	</body>
</html>