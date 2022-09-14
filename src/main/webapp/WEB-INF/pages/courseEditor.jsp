<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, tw.epicer.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改課程</title>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<% 
int courseId = Integer.parseInt(request.getParameter("courseId"));
String courseName = request.getParameter("courseName");
int coursePrice = Integer.parseInt(request.getParameter("coursePrice"));
String courseDescription = request.getParameter("courseDescription");
String courseDate = request.getParameter("courseDate");
int teacherId = Integer.parseInt(request.getParameter("teacherId"));
int classroomId = Integer.parseInt(request.getParameter("classroomId"));
String cuisineStyle = request.getParameter("cuisineStyle");
String other = request.getParameter("other");

//Course oldCourse = new Course();
//request.setAttribute("oldCourse", oldCourse);
%>


<h1>修改課程</h1> 

<form name="123" action="UpdateCourse" method="post">
		 
		
		<input type="hidden" name="courseId" value="<%=courseId %>" />
        <span >courseName：</span> <span><input type="text" name="courseName" value="<%=courseName %>" required/></span><br>  
        <span >coursePrice：</span> <span><input type="text" name="coursePrice" value="<%=coursePrice %>" required/></span><br>  
        <span >courseDescription：</span> <span><input type="text" name="courseDescription" value="<%=courseDescription %>" required/></span><br>  
        <span >courseDate：</span>  <span><input type="text" name="courseDate" value="<%=courseDate%>" required/></span><br>  
        <span >teacherId：</span>  <span><input type="text" name="teacherId" value="<%=teacherId%>" required/></span><br> 
        <span >classroomId：</span>  <span><input type="text" name="classroomId" value="<%=classroomId%>" required/></span><br> 
        <span >cuisineStyle：</span>  <span><input type="text" name="cuisineStyle" value="<%=cuisineStyle%>" required/></span><br> 
        <span >other：</span>  <span><input type="text" name="other" value="<%=other%>" /></span><br> 
        <br><br>          
       

       
        <center>  
            <input class="btn" type="submit" value="提交" />  
            <input class="btn" type="reset" value="重置" />  
        </center>  

</form>

</body>
</html>