<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,tw.epicer.model.*,tw.epicer.controller.*,org.hibernate.Session,
org.hibernate.SessionFactory"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Management App</title>
</head>

<body>
<%@include file="epicerNavbar.jsp"%>

	<header> <nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: tomato">
	<div>
		<a href="" class="navbar-brand"> Course Management App </a>

	</div>
	</nav> </header>

	<br>
	


	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Courses</h3>
			<hr>
			<div class="container text-left">
				<form action = "tocourseInsert" method = "post" class="btn btn-success">
				<button type = "submit">新增課程</button>
				</form>
			</div>

			<br>
			<table class="order-table table table-bordered">

				
				<thead>
					<tr>
						<th>課程ID</th>
						<th>課程名稱</th>
						<th>課程價錢</th>
						<th>課程介紹</th>
						<th>課程日期</th>
						<th>老師ID</th>
						<th>教室ID</th>
						<th>風格</th>
						<th>其他</th>
						<th>編輯</th>
						<th>刪除</th>
					</tr>
				</thead>

				<tbody>

					
					<%
					List<Course> list = (List<Course>)request.getAttribute("listAll");	
					for (Course cd : list) 
					{%>
					<tr>
						<td><%=cd.getCourseId() %></td>
						<td><%=cd.getCourseName() %></td>
						<td><%=cd.getCoursePrice() %></td>
						<td><%=cd.getCourseDescription() %></td>
						<td><%=cd.getCourseDate() %></td>
						<td><%=cd.getTeacher().getTeacherId() %></td>
						<td><%=cd.getClassroomId() %></td>
						<td><%=cd.getCuisineStyle() %></td>
						<td><%=cd.getOther() %></td>
						 
						<td>
						<form action="beforeUpdateCourse" method = "post">
						<input type = "hidden" name = "courseId" value = <%=cd.getCourseId() %>>	
						<input type = "hidden" name = "courseName" value = <%=cd.getCourseName() %>>	
						<input type = "hidden" name = "coursePrice" value = <%=cd.getCoursePrice() %>>	
						<input type = "hidden" name = "courseDescription" value = <%=cd.getCourseDescription() %>>	
						<input type = "hidden" name = "courseDate" value = <%=cd.getCourseDate() %>>	
						<input type = "hidden" name = "teacherId" value = <%=cd.getTeacher().getTeacherId() %>>	
						<input type = "hidden" name = "classroomId" value = <%=cd.getClassroomId() %>>	
						<input type = "hidden" name = "cuisineStyle" value = <%=cd.getCuisineStyle() %>>	
						<input type = "hidden" name = "other" value = <%=cd.getOther() %>>	
						<button type = "submit">編輯</button>					
						</form>						
						</td>
						
												
						<td>
						<form action="deleteCourse" method = "post">
						<input type = "hidden" name = "courseId" value = <%=cd.getCourseId() %>>			
						<button type = "submit" >刪除</button>					
						</form>
						</td>
						</tr>
												
						<% 
					}						
						%>						
				</tbody>
			</table>


			<input type="search" class="light-table-filter"
				data-table="order-table" placeholder="請輸入關鍵字">
		</div>
	</div>


	<br>

	<script>
		(function(document) {
			'use strict';

			// 建立 LightTableFilter
			var LightTableFilter = (function(Arr) {

				var _input;

				// 資料輸入事件處理函數
				function _onInputEvent(e) {
					_input = e.target;
					var tables = document.getElementsByClassName(_input
							.getAttribute('data-table'));
					Arr.forEach.call(tables, function(table) {
						Arr.forEach.call(table.tBodies, function(tbody) {
							Arr.forEach.call(tbody.rows, _filter);
						});
					});
				}

				// 資料篩選函數，顯示包含關鍵字的列，其餘隱藏
				function _filter(row) {
					var text = row.textContent.toLowerCase(), val = _input.value
							.toLowerCase();
					row.style.display = text.indexOf(val) === -1 ? 'none'
							: 'table-row';
				}

				return {
					// 初始化函數
					init : function() {
						var inputs = document
								.getElementsByClassName('light-table-filter');
						Arr.forEach.call(inputs, function(input) {
							input.oninput = _onInputEvent;
						});
					}
				};
			})(Array.prototype);

			// 網頁載入完成後，啟動 LightTableFilter
			document.addEventListener('readystatechange', function() {
				if (document.readyState === 'complete') {
					LightTableFilter.init();
				}
			});

		})(document);
	</script>
</body>



</html>