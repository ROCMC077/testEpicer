<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.epicer.controller.*,tw.epicer.model.*,tw.epicer.service.*,tw.epicer.util.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文章紀錄</title>

   
    <script type ="text/javascript">

	
</script>

</head>
<body>
<%@include file="epicerNavbar.jsp"%>
<h1>文章紀錄</h1>
<form action="forumUser" method="post">
	<input type="submit" value="回會員首頁">
</form>

 		

 <table >

            <thead>
              <tr style="height: 45px;">
                <th>id</th>
                <th> 類型</th>
                <th> 標題</th>
                <th> 時間</th>
                <th> 內文</th>
                <th> 操作</th>
              </tr>
            </thead>
            
            
           <%
      	   List<ArticleBean> articleCategoryList = (List<ArticleBean>)request.getSession().getAttribute("UserArticle");
      	   
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
                
                 <form action="UserUpdateArticlePage"  method="post">  
                  <input type="hidden" name="articleId" value=<%=article.getArticleId()%>>
                  <button type="submit">Update</button>
                </form>  
                
				<form action="UserDeleteArticle" method="POST">
					   <input type="hidden" name="number" value="<%= article.getArticleId()%>">
					   <input type="submit" value="Delete" name="action">
				</form>
					</td>
				<% } %>

				
				
            </tbody>
          </table>

</body>
</html>