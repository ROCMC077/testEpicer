<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, tw.epicer.model.*,tw.epicer.controller.*,org.hibernate.Session,
org.hibernate.SessionFactory"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增課程</title>
</head>
<body>
<h1>新增課程</h1> 
  <form action="addCourse" method="post">    
        <span class="item">課程名稱：</span> <span><input type="text" name="courseName" required/></span><br>  
        <span class="item">課程價錢：</span> <span><input type="text" name="coursePrice" required/></span><br>  
        <span class="item">課程介紹：</span>      <span><input type="text" name="courseDescription" required/></span><br>  
        <span class="item">課程日期：</span>  <span><input type="text" name="courseDate" required/></span><br> 
        <span class="item">老師ID：</span>  <span><input type="text" name="teacherId" required/></span><br>
        <span class="item">教室ID：</span>  <span><input type="text" name="classroomId" required/></span><br>
        <span class="item">風格：</span>  <span><input type="text" name="cuisineStyle" required/></span><br>
        <span class="item">其他：</span>  <span><input type="text" name="other" required /></span><br> 
        <br><br>  
        <center>  
            <input class="btn" type="submit" value="提交" />  
            <input class="btn" type="reset" value="重置" />  
        </center>  
    </form> 
    
<%--     <form:form action="addCourse" method="post" modelAttribute="Course" commandName="Course"> --%>
<!--    <table> -->
<!--       <tr> -->
<%--          課程名稱:<form:input path="courseName"/> --%>
<!--       </tr> -->
<!--       <tr> -->
<%--          <td><form:label path="coursePrice">課程價錢：</form:label></td> --%>
<%--          <td><form:input path="coursePrice" /></td> --%>
<!--       </tr> -->
<!--       <tr> -->
<%--          <td><form:label path="courseDescription">課程介紹：</form:label></td> --%>
<%--          <td><form:input path="courseDescription"/></td> --%>
<!--       </tr> -->
<!--       <tr> -->
<%--          <td><form:label path="courseDate">課程日期：</form:label></td> --%>
<%--          <td><form:input type="text" path="courseDate"/></td> --%>
<!--       </tr> -->
<!--       <tr> -->
<%--          <td><form:label path="teacherId">老師ID：</form:label></td> --%>
<%--          <td><form:input type="text" path="teacherId"/></td> --%>
<!--       </tr> -->
<!--       <tr> -->
<%--          <td><form:label path="classroomId">教室ID：</form:label></td> --%>
<%--          <td><form:input type="text" path="classroomId"/></td> --%>
<!--       </tr> -->
<!--       <tr> -->
<%--          <td><form:label path="cuisineStyle">風格：</form:label></td> --%>
<%--          <td><form:input type="text" path="cuisineStyle"/></td> --%>
<!--       </tr> -->
<!--       <tr> -->
<%--          <td><form:label path="other">其他：</form:label></td> --%>
<%--          <td><form:input type="text" path="other"/></td> --%>
<!--       </tr> -->
      
<!--       <tr> -->
<%--          <td colspan="8"><form:button value="Send">Submit</form:button></td> --%>
<!--       </tr> -->
<!--    </table> -->
<%-- </form:form> --%>
</body>
</html>