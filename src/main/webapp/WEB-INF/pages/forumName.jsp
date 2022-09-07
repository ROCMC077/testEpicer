<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.epicer.controller.*,tw.epicer.model.*,tw.epicer.service.*,tw.epicer.util.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首頁</title>

   
</head>
<body>
<%@include file="epicerNavbar.jsp"%>
<h1>首頁</h1>
<form action="forumUser" method="post">
		  <input type="submit" value="userPage">
        </form>

 		<form action="QueryName" method="post">
 			<input type="text" name="title">
		  <input type="submit" name="action" value="QueryName">
        </form>
        
        
        <form  action="forumAdd" method="post">
		<button type="submit">Add</button>
		</form>
        
        
        
  			<form action="QueryCategory" method="post">      
              <div >
              <input type="hidden" name="categoryId" value="1">
              <input type="submit" name="123" value="全榖雜糧">
              </div>
            </form>
              
            <form action="QueryCategory" method="post">
              <div >
              <input type="hidden" name="categoryId" value="2">
              <input type="submit" name="123" value="豆魚蛋肉 ">  
              </div>
            </form>
              
            <form action="QueryCategory" method="post">
              <div >
              <input type="hidden" name="categoryId" value="3">
              <input type="submit" name="123" value="蔬菜">         
              </div>
            </form>
               
            <form action="QueryCategory" method="post">
              <div >
              <input type="hidden" name="categoryId" value="4">
              <input type="submit" name="123" value="水果">
              </div>
            </form>
               
            <form action="QueryCategory" method="post">
              <div >
              <input type="hidden" name="categoryId" value="5">
              <input type="submit" name="123" value="乳品">
              </div>
            </form>
               
            <form action="QueryCategory" method="post">
              <div >
              <input type="hidden" name="categoryId" value="6">
              <input type="submit" name="123" value="油脂與堅果種子">
              </div>
            </form>

 <table >

            <thead>
              <tr style="height: 45px;">
                <th class="u-table-cell">id</th>
                <th class="u-table-cell"> 類型</th>
                <th class="u-table-cell"> 標題</th>
                <th class="u-table-cell"> 時間</th>
                <th class="u-table-cell"> 內文</th>
                <th class="u-table-cell"> 操作</th>
              </tr>
            </thead>
            
            
           <%
      	   List<ArticleBean> articleCategoryList = (List<ArticleBean>)request.getSession().getAttribute("selectTitle");
      	   
      	   int i = 1;
      	for (ArticleBean article : articleCategoryList) {
 		%>
            <tbody >
              <tr style="height: 80px;">
                         
             <td><form action="articleDetail" method="post">
					   <input type="hidden" name="articleId" value="<%= article.getArticleId()%>">
					   <input type="submit"  name="123" value="<%=i++ %>">
					   
					   
				</form>    
				</td> 
				
				
                <td > <input type="hidden" name="aCtegoryId" >
					<% if(article.getPlateformCategoryId()==1){out.print("全榖雜糧");} %>
					<% if(article.getPlateformCategoryId()==2){out.print("豆魚蛋肉");} %>
					<% if(article.getPlateformCategoryId()==3){out.print("蔬菜");} %>
					<% if(article.getPlateformCategoryId()==4){out.print("水果");} %>
					<% if(article.getPlateformCategoryId()==5){out.print("乳品");} %>
					<% if(article.getPlateformCategoryId()==6){out.print("油脂與堅果種子");} %>
					
					 </td>
                <td><input type="hidden" name="aTitle" >
					<%=article.getTitle()%></td>
               <td><%=TimeTest.transToDate(article.getDate())%></td>
               
                <td ><div class="box"> <input type="hidden" name="aContent">
                <p class="ellipsis"> <%=article.getArticleContent()%></p></div></td>
					
					
                <td >
                
        		<form action="forumUpdatePage"  method="post">  
                	 <input type="hidden" name="articleId" value="<%= article.getArticleId()%>">
                  <button type="submit">Update</button>
                </form>   
                
				<form action="articleDelete" method="POST">
					   <input type="hidden" name="number" value="<%= article.getArticleId()%>">
					   <input type="submit" value="Delete" name="action">
				</form>
					</td>
				<% } %>

				
				
            </tbody>
          </table>

</body>
</html>