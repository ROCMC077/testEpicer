<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.epicer.controller.*,tw.epicer.dao.*,tw.epicer.model.*,tw.epicer.service.*,tw.epicer.util.*,java.util.*"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>登入</title>
</head>
<body>
<% session.setAttribute("userId", 10); %>
<form action="QueryAll" method="GET">
	<table>
		<tr>
			<td>登入會員</td>
		</tr>	
		<tr>
			<td><input type="submit" name="Send"></td>
		</tr>
	</table>
</form>
</body>
</html> 