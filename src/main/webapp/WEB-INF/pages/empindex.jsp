<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>


.split {
  height: 50%;
  width: 25%;
   position:fixed;
   border: 1px soild transparents ;
   border-radius: 20px;
}


.split:hover {
 opacity: 1;
}

/* Control the left side */
.left {
top:200px;
  left:200px;
  background-color: #111;
  opacity: 0.6;
}

/* Control the right side */
.right {
top:200px;
right:200px;
  background-color: palevioletred;
  opacity: 0.6;
}


.down {
top:200px;
right:718px;
  background-color:teal;
  opacity: 0.6;
}

/* If you want the content centered horizontally and vertically */
.centered {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  text-align: center;
}

/* Style the image inside the centered container, if needed */
.centered img {
  width: 150px;
  border-radius: 50%;
}

.centered img:hover {
  width: 150px;
  border-radius: 50%;
}


h2{
color: white;
}

</style>
</head>
<body style="background-color: antiquewhite">
<%@ include file="userindex.jsp" %>
    <div class="split left">
  <div class="centered">
  <form name='form3' action='usersdata' method='post'>  
  <a href='javascript:document.form3.submit();'> <img src="images/default.jpg" alt="Avatar woman"></a>
    <h2>使用者管理</h2>
    </form>
  </div>
</div>

<div class="split right">
  <div class="centered">
  <form name='form2' action='empregister' method='post'>
    <a href="javascript:document.form2.submit();"> <img src="images/default.jpg" alt="Avatar woman"></a>
    <h2>新進人員註冊</h2>
     </form>
  </div>
</div>

<div class="split down">
  <div class="centered">
    <a href="emploginform"> <img src="images/default.jpg" alt="Avatar woman"></a>
    <h2>工作管理</h2>
  </div>
</div>
 <script>
function menuToggle(){
    const toggleMenu=document.querySelector('.menu');
    toggleMenu.classList.toggle('active')
}

 </script>   
</body>
</html>