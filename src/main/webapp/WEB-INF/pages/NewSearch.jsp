<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="tw.epicer.model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html style="font-size: 16px;" lang="en"><head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>找食譜</title>
    <link rel="stylesheet" href="css/nicepage.css" media="screen">
    <link rel="stylesheet" href="css/找食譜.css" media="screen">
    <script class="u-script" type="text/javascript" src="js/jquery.js" "="" defer=""></script>
    <script class="u-script" type="text/javascript" src="js/nicepage.js" "="" defer=""></script>
    <meta name="generator" content="Nicepage 4.15.11, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
    
    
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "Site1",
		"logo": "images/logobgwhite.jpg"
}</script>
    <meta name="theme-color" content="#478ac9">
    <meta property="og:title" content="找食譜">
    <meta property="og:description" content="">
    <meta property="og:type" content="website">
  </head>
  <body class="u-body u-xl-mode" data-lang="en"><header class="u-clearfix u-header u-header" id="sec-c640"><div class="u-clearfix u-sheet u-sheet-1">
    
        <a href="https://nicepage.com" class="u-image u-logo u-image-1" data-image-width="1536" data-image-height="610">
          <img src="images/logobgwhite.jpg" class="u-logo-image u-logo-image-1">
        </a>
        <%@include file="epicerNavbar.jsp"%>
      </div></header>
    <section class="u-align-center u-clearfix u-section-1" id="sec-b463">
      <div class="u-align-left u-clearfix u-sheet u-sheet-1">
        <div class="u-clearfix u-custom-html u-custom-html-1">
          <form accept-charset="UTF-8" id="global-search" action="queryforlist.controller" method="post">
            <input type="hidden" name="todo" value="queryforlist">
            <div class="to-search">
              <div class="search-by-keyword">
                <div class="focus-input search-container search-recipe select-input"> 搜尋：<input type="search" class="light-table-filter" data-table="order-table" placeholder="請輸入食譜名" name="searchByRecipe">
                  <input type="submit">
                </div>
              </div>
              <h3>
                <a class="header-action-link" href="add" rel="nofollow"><i class="icon-plus-regular"></i>&nbsp;寫食譜 
                </a>
              </h3>
            </div>
          </form>
        </div>
      </div>
    </section>
    <section class="u-align-center u-clearfix u-section-2" id="carousel_a20b">
      <div class="u-clearfix u-sheet u-sheet-1">
        <div class="u-expanded-width u-table u-table-responsive u-table-1">
          <table class="u-table-entity u-table-entity-1 order-table">
            <colgroup>
              <col width="17.5%">
              <col width="49.9%">
              <col width="11%">
              <col width="10.5%">
              <col width="11.1%">
            </colgroup>
            <thead class="u-custom-font u-font-courier-new u-palette-4-base u-table-header u-table-header-1">
              <tr style="height: 84px;">
                <th class="u-table-cell">食譜名稱 </th>
                <th class="u-table-cell">食譜簡介</th>
                <th class="u-table-cell">烹調時間</th>
                <th class="u-table-cell">幾人份</th>
                <th class="u-table-cell">修改</th>
                <th class="u-table-cell">刪除</th>
              </tr>
            </thead>
          <c:forEach items="${requestScope.searchAll}" var="item">
            <tbody class="u-table-body">
              <tr style="height: 79px;">
               <form name ="Form" action="delete.controller" method="POST"> 
         <input type="hidden" name="id" value="${item.recipeId}" >
                <td class="u-border-1 u-border-grey-30 u-border-no-left u-border-no-right u-table-cell"><a href="http://localhost:8080/Epicer/queryforid.controller?todo=queryForId&id=${item.recipeId}">${item.recipeName}</a></td>
                <td class="u-border-1 u-border-grey-30 u-border-no-left u-border-no-right u-table-cell">${item.recipeDescription}</td>
                <td class="u-border-1 u-border-grey-30 u-border-no-left u-border-no-right u-table-cell">${item.cookTime}</td>
                <td class="u-border-1 u-border-grey-30 u-border-no-left u-border-no-right u-table-cell">${item.howManyPeople}</td>
                <td class="u-border-1 u-border-grey-30 u-border-no-left u-border-no-right u-table-cell"><a href="http://localhost:8080/Epicer/beforeupdate.controller?todo=beforeupdate&id=${item.recipeId}" >修改</a></td>
 				<td class="u-border-1 u-border-grey-30 u-border-no-left u-border-no-right u-table-cell"><input type="submit" value="刪除"></td>                
              </form>
         </tr>
         </tbody>
              </c:forEach>
          </table>
        </div>
      </div>
    </section>
    
    
    <footer class="u-align-center u-clearfix u-footer u-grey-80 u-footer" id="sec-2725"><div class="u-clearfix u-sheet u-sheet-1">
        <p class="u-small-text u-text u-text-variant u-text-1"> Copyright © 2022 EEIT 49 Eciper. All Rights Reserved</p>
      </div></footer>
    <section class="u-backlink u-clearfix u-grey-80">
      <a class="u-link" href="https://nicepage.com/website-design" target="_blank">
        <span>Website Design Ideas</span>
      </a>
      <p class="u-text">
        <span>created with</span>
      </p>
      <a class="u-link" href="https://nicepage.com/html-website-builder" target="_blank">
        <span>HTML Creator</span>
      </a>. 
    </section>
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
  
</body></html>