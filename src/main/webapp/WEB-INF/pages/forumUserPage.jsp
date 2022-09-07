<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.epicer.controller.*,tw.epicer.dao.*,tw.epicer.model.*,tw.epicer.service.*,tw.epicer.util.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員畫面</title>
</head>
<body>
<%@include file="epicerNavbar.jsp"%>
<form action="QueryAll" method="Get">
	<input type="submit" value="回首頁">
</form>
<h1>會員畫面</h1>
${userId}歡迎登入
        <form  action="QueryUserArticle" method="Get">
		<button type="submit">搜文章記錄</button>
		</form>
		        <form  action="QueryUserReply" method="Get">
		<button type="submit">搜留言紀錄</button>

  

</body>
</html>