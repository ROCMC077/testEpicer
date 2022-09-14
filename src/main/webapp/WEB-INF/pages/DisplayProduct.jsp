<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="tw.epicer.model.*"%>
<%@page import="tw.epicer.service.ProductService"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<%
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", -1); // Prevents caching at the proxy server
%>
<link data-turbolinks-track="true"
            href="http://static.oswd.org/assets/application-6d2a4562b1f5d344541d91ef6d0c8e9a.css" media="all"
            rel="stylesheet">
<title>商品頁面</title>
<style>
#nav {
	text-align: right;
	position: fixed;
	left: 0;
	top: 0;
	width: 100%;
	z-index: 10000;
	cursor: default;
	height: 4em;
	line-height: 3.5em;
	background-color: white;
}

#nav ul {
	margin-bottom: 0;
	list-style: none;
	padding-left: 0;
}

#nav li {
	display: inline-block;
	padding-left: 0;
}

#nav a {
	-moz-transition: background-color .2s ease-in-out;
	-webkit-transition: background-color .2s ease-in-out;
	-ms-transition: background-color .2s ease-in-out;
	transition: background-color .2s ease-in-out;
	position: relative;
	display: block;
	text-decoration: none;
	outline: 0;
	font-weight: 600;
	border-radius: 8px;
	color: black;
	height: 2.5em;
	line-height: 2.5em;
	padding: 0 1.25em;
}

#nav a:hover {
	color: #fff !important;
	background: #7f987e;
}

#nav a.active {
	background: #484848;
}

#nav a.active:before {
	content: '';
	display: block;
	position: absolute;
	bottom: -0.6em;
	left: 50%;
	margin-left: -0.75em;
	border-left: solid 0.75em transparent;
	border-right: solid 0.75em transparent;
	border-top: solid 0.6em #282828;
}

 ul li a {
            -moz-transition: background-color .2s ease-in-out;
            -webkit-transition: background-color .2s ease-in-out;
            -ms-transition: background-color .2s ease-in-out;
            transition: background-color .2s ease-in-out;
            position: relative;
            display: block;
            text-decoration: none;
            outline: 0;
            font-weight: 600;
            border-radius: 8px;
            color: black;
            height: 2em;
            line-height: 2em;
            padding: 0 1.25em;
        }


        ul li a:hover {
            color: #fff !important;
            background: #7f987e;
        }

</style>
</head>

<body>
<%@include file="epicerNavbar.jsp"%>
    <br>
	<br>
	<br>
	
	
	<h1 ALIGN=CENTER>商品頁面</H1>
	<nav >
		<ul class="container">
			
			<li><a href="ProductManager">新增</a></li>
		</ul>

	</nav>
	        <form action="DisplayProduct_searchCategory" method="get">      
              <div >
              <input type="hidden" name="category_id" value="1">
              <input type="hidden" name="action" value="QueryCategory">
              <input type="submit" name="123" value="全榖雜糧">
              </div>
            </form>
              
            <form action="DisplayProduct_searchCategory" method="get">
              <div >
              <input type="hidden" name="category_id" value="2">
              <input type="hidden" name="action" value="QueryCategory">  
              <input type="submit" name="123" value="豆魚蛋肉 ">  
              </div>
            </form>
              
            <form action="DisplayProduct_searchCategory" method="get">
              <div >
              <input type="hidden" name="category_id" value="3">
              <input type="hidden" name="action" value="QueryCategory">         
              <input type="submit" name="123" value="蔬菜">         
              </div>
            </form>
               
            <form action="DisplayProduct_searchCategory" method="get">
              <div >
              <input type="hidden" name="category_id" value="4">
              <input type="hidden" name="action" value="QueryCategory">
              <input type="submit" name="123" value="水果">
              </div>
            </form>
               
            <form action="DisplayProduct_searchCategory" method="get">
              <div >
              <input type="hidden" name="category_id" value="5">
              <input type="hidden" name="action" value="QueryCategory">
              <input type="submit" name="123" value="乳品">
              </div>
            </form>
               
            <form action="DisplayProduct_searchCategory" method="get">
              <div >
              <input type="hidden" name="category_id" value="6">
              <input type="hidden" name="action" value="QueryCategory">
              <input type="submit" name="123" value="油脂與堅果種子">
              </div>
            </form>
            
<!-- 	<ul> -->
<!-- 		<li><a href="./ProductServlet?action=QueryCategory&category_id=1">五穀根莖類</a></li> -->
<!-- 		<li><a href="./ProductServlet?action=QueryCategory&category_id=2">奶類</a></li> -->
<!-- 		<li><a href="./ProductServlet?action=QueryCategory&category_id=3">蛋豆魚肉類</a></li> -->
<!-- 		<li><a href="./ProductServlet?action=QueryCategory&category_id=4">蔬菜類</a></li> -->
<!-- 		<li><a href="./ProductServlet?action=QueryCategory&category_id=5">水果類</a></li> -->
<!-- 		<li><a href="./ProductServlet?action=QueryCategory&category_id=6">油脂與堅果種子類</a></li> -->
<!-- 		<li><a href="./ProductServlet?action=QueryCategory&category_id=7">調味品類</a></li> -->
<!-- 	</ul> -->

	<div ALIGN=CENTER>
		<label for="name">搜尋:</label> 
		<input type="search" class="light-table-filter" data-table="order-table" placeholder="請輸入關鍵字">

	</div>
	<br>

	<table class="order-table" cellspacing="2" cellpadding="1" border="4" width="100%">
	<colgroup>
              <col width="10%">
              <col width="10%">
              <col width="10%">
              <col width="10%">
              <col width="10%">
              <col width="10%">
              <col width="10%">
              <col width="10%">
            </colgroup>
		<thead>
			<tr >
				<th>名稱</th>
				<th>商品描述</th>
				<th>類別</th>
				<th>單位</th>
				<th>價格</th>
				<th>產地</th>
				<th>操作</th>
				<th>操作</th>
			</tr>
		</thead>

		<%
				List<ProductBean> product = (List<ProductBean>)request.getAttribute("queryall");
				for (ProductBean pb : product) {
		%>
		<tbody>
		<form action="/" method="post">
			<tr>
			<input type="hidden" name="id" value=<%=request.getParameter("id")%>>
<%-- 			    <td><%=pb.getId()%></td> --%>
				<td><%=pb.getName()%></td>
				<td><%=pb.getDescription()%></td>
				<td>
				<% 
				if (pb.getCategory().equals("1")) {
					out.println("五穀根莖類");
				} else if (pb.getCategory().equals("2")) {
					out.println("奶類");
				} else if (pb.getCategory().equals("3")) {
					out.println("蛋豆魚肉類");
				} else if (pb.getCategory().equals("4")) {
					out.println("蔬菜類");
				} else if (pb.getCategory().equals("5")) {
					out.println("水果類");
				} else if (pb.getCategory().equals("6")) {
					out.println("油脂與堅果種子類");
				} else if (pb.getCategory().equals("7")) {
					out.println("調味品類");
				} else {
					out.println("無法辨別");
				}
				%>
<%-- 				<%=pb.getCategory()%> --%>
				</td>
				<td><%=pb.getUnit()%></td>
				<td><%=pb.getPrice()%></td>
				<td><%=pb.getOrigin()%></td>
				
				<td>
		</form>
		 <form ALIGN=center action="updateProduct" method="post">
            <input type="hidden" name="id" value=<%=pb.getId()%> >
            <input type="hidden" name="name" value=<%=pb.getName()%> >
            <input type="hidden" name="description" value=<%=pb.getDescription()%> >
            <input type="hidden" name="category" value=<%=pb.getCategory()%>>
            <input type="hidden" name="unit" value=<%=pb.getUnit()%> >
            <input type="hidden" name="price" value=<%=pb.getPrice()%> >
            <input type="hidden" name="origin" value=<%=pb.getOrigin()%>>
<!--             <button type="submit"> update</button> -->
            <input ALIGN=center type="submit" value="修改" >
        </form>
         </td>
         <td>
     
        <form ALIGN=center action="deleteProduct" method="post">
            <input type="hidden" name="id" value="<%=pb.getId()%>" >
            <input type="hidden" name="name" value="<%=pb.getName()%>" >
            <input type="hidden" name="description" value="<%=pb.getDescription()%>" >
            <input type="hidden" name="category" value="<%=pb.getCategory()%>" >
            <input type="hidden" name="unit" value="<%=pb.getUnit()%>" >
            <input type="hidden" name="price" value="<%=pb.getPrice()%>" >
            <input type="hidden" name="origin" value="<%=pb.getOrigin()%>" >
            <input type="hidden" name="action" value="delete" >
            <input ALIGN=center type="submit" value="刪除" name="delete" >
        </form>
       
            </td>
			</tr>
			
			<%
			}
			%>
		</tbody>
	</table>
	<script>
	(function(document) {
		  'use strict';

		  // 建立 LightTableFilter
		  var LightTableFilter = (function(Arr) {

		    var _input;

		    // 資料輸入事件處理函數
		    function _onInputEvent(e) {
		      _input = e.target;
		      var tables = document.getElementsByClassName(_input.getAttribute('data-table'));
		      Arr.forEach.call(tables, function(table) {
		        Arr.forEach.call(table.tBodies, function(tbody) {
		          Arr.forEach.call(tbody.rows, _filter);
		        });
		      });
		    }

		    // 資料篩選函數，顯示包含關鍵字的列，其餘隱藏
		    function _filter(row) {
		      var text = row.textContent.toLowerCase(), val = _input.value.toLowerCase();
		      row.style.display = text.indexOf(val) === -1 ? 'none' : 'table-row';
		    }

		    return {
		      // 初始化函數
		      init: function() {
		        var inputs = document.getElementsByClassName('light-table-filter');
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