<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.epicer.controller.*,tw.epicer.model.*,tw.epicer.service.*,tw.epicer.util.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>回覆紀錄</title>

   
    <script type ="text/javascript">

	
</script>

</head>
<body>
<%@include file="epicerNavbar.jsp"%>
<h1>回覆紀錄</h1>

<form action="forumUser" method="post">
	<input type="submit" value="回會員首頁">
</form>
 		

 <table >

            <thead>
              <tr style="height: 45px;">
                <th>id</th>
                <th> 回覆內容</th>
                <th> 文章標題</th>
                <th> 時間</th>
                <th> 操作</th>
              </tr>
            </thead>
            
            
         <%
			 List<ArticleReplyBean> articleReply = (List<ArticleReplyBean>)request.getSession().getAttribute("UserReply");
	 		 int i = 1;
			for (ArticleReplyBean articleReplyList : articleReply) {
			%>
			
			   <tbody>
           
            <tr>
            <td><form action="articleDetail" method="post">
					   <input type="hidden" name="articleId" value="<%= articleReplyList.getArticleId().getArticleId()%>">
					   <input type="submit"  name="123" value="<%=i++ %>">
					   
					   
				</form>  </td>
            <td><%=articleReplyList.getArticleReplyContent()%></td>
            <td><%=articleReplyList.getArticleId().getTitle()%></td>
            <td><%=TimeTest.transToDate(articleReplyList.getArticleReplyDate())%></td>
            
            <td>
            
              <form action="UserUpdateReplyPage"  method="post">  
 				  <input type="hidden" name="replyId" value="<%= articleReplyList.getArticleReplyId()%>">
                  <button type="submit">Update</button>
                </form> 
            
            
            
				<form action="UserDeleteReply" method="post">
					   <input type="hidden" name="replyId" value="<%= articleReplyList.getArticleReplyId()%>">
					   <input type="hidden" name="articleId" value="<%= articleReplyList.getArticleId().getArticleId() %>">
					    <input type="submit" value="Delete">
				</form>
			</td>
       	    </tr> 
       	    <% } %>

				
				
            </tbody>
          </table>

</body>
</html>