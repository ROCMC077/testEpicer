<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.epicer.controller.*,tw.epicer.model.*,tw.epicer.service.*,tw.epicer.util.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


   
    <script type ="text/javascript">

	
</script>

</head>
<body>
<%@include file="epicerNavbar.jsp"%>

<form action="QueryAll" method="Get">
	<input type="submit" value="回首頁">
</form>


 <table >

            <thead>
              <tr style="height: 45px;">
                <th class="u-table-cell"> 標題</th>
                <th class="u-table-cell"> 時間</th>
                <th class="u-table-cell"> 內文</th>
                <th class="u-table-cell"> 照片</th>
              </tr>
            </thead>
            
               <%
      	   ArticleBean detail = (ArticleBean)request.getSession().getAttribute("selectDetail");  
 		%>
            <tbody >
            <tr>
            <td><%=detail.getTitle()%></td>
            <td><%=TimeTest.transToDate(detail.getDate())%></td>
            <td><%=detail.getArticleContent()%></td>
       	    </tr>
            </tbody>
            
           
			
			
			
				  <thead>
              <tr style="height: 45px;">
                <th >ReplyId</th>
                <th > 內文</th>
                <th > 時間</th>
                <th > 使用者</th>
                <th > 操作</th>
                <th> 
                <form action="replyAddPage" method="post">
				  <input type="hidden" name="articleId" value="<%= detail.getArticleId()%>">
				  <input type="submit" value="reply" >
				</form>
				</th>
              </tr>
            </thead>
			
			<%
			 List<ArticleReplyBean> articleReply = (List<ArticleReplyBean>)request.getSession().getAttribute("selectReplyAll");
	 		 int i = 1;
			for (ArticleReplyBean articleReplyList : articleReply) {
			%>
			
			   <tbody>
           
            <tr>
            <td><%=i++%></td>
            <td><%=articleReplyList.getArticleReplyContent()%></td>
            <td><%=TimeTest.transToDate(articleReplyList.getArticleReplyDate())%></td>
            <td><%=articleReplyList.getUser().getUserId()%></td>
            <td>
            
              <form action="replyUpdatePage"  method="post">  
 				  <input type="hidden" name="replyId" value="<%= articleReplyList.getArticleReplyId()%>">
                  <button type="submit">Update</button>
                </form> 
            
            
            
				<form action="replyDelete" method="post">
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