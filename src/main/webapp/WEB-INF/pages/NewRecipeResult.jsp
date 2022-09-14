<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="tw.epicer.model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html style="font-size: 16px;" lang="en"><head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>Page 1</title>
    <link rel="stylesheet" href="css/nicepage.css" media="screen">
<link rel="stylesheet" href="css/Page-1.css" media="screen">
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
    <meta property="og:title" content="Page 1">
    <meta property="og:description" content="">
    <meta property="og:type" content="website">
  </head>
  <body class="u-body u-xl-mode" data-lang="en"><header class="u-clearfix u-header u-header" id="sec-c640"><div class="u-clearfix u-sheet u-sheet-1">
        <a href="https://nicepage.com" class="u-image u-logo u-image-1" data-image-width="1536" data-image-height="610">
          <img src="images/logobgwhite.jpg" class="u-logo-image u-logo-image-1">
        </a>
 <%@include file="epicerNavbar.jsp"%>
      </div></header>
    <section class="u-clearfix u-section-1" id="sec-a395">
      <div class="u-clearfix u-sheet u-sheet-1">
        <div class="u-clearfix u-layout-wrap u-layout-wrap-1">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-size-31">
                <div class="u-layout-col">
                  <div class="u-container-style u-layout-cell u-size-60 u-layout-cell-1">
                    <div class="u-container-layout u-container-layout-1"></div>
                  </div>
                </div>
              </div>
              <div class="u-size-29">
                <div class="u-layout-col">
                  <div class="u-container-style u-layout-cell u-size-30 u-layout-cell-2">
                    <div class="u-container-layout u-container-layout-2">
                      <h3 class="u-text u-text-default u-text-1">食譜名稱<br>${recipe.recipeName}</h3>
                    </div>
                  </div>
                  <div class="u-container-style u-layout-cell u-size-30 u-layout-cell-3">
                    <div class="u-container-layout u-container-layout-3">
                      <p class="u-text u-text-default u-text-2">食譜描述<br>${recipe.recipeDescription}
                        <br>
                      </p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <img class="u-image u-image-default u-image-1" src="${recipe.imgPath}" alt="" data-image-width="1071" data-image-height="1500">
        <div class="u-clearfix u-layout-wrap u-layout-wrap-2">
          <div class="u-layout">
            <div class="u-layout-col">
              <div class="u-size-30">
                <div class="u-layout-col">
                  <div class="u-container-style u-layout-cell u-size-60 u-layout-cell-4">
                    <div class="u-container-layout u-valign-top u-container-layout-4">
                      <div class="u-clearfix u-custom-html u-custom-html-1">
                        <form accept-charset="UTF-8" id="global-search" action="ControllerServlet" method="post">
                          <input type="hidden" name="todo" value="queryforlist">
                          <div class="to-search">
                            <div class="search-by-keyword">
                              <div class="focus-input search-container search-recipe select-input"> 搜尋：<input type="search" class="light-table-filter" data-table="order-table" placeholder="請輸入食譜名" name="searchByRecipe">
                                <input type="submit">
                              </div>
                            </div>
                            <h3>
                              <a class="header-action-link" href="addpage.controller" rel="nofollow"><i class="icon-plus-regular"></i>&nbsp;寫食譜 
                              </a>
                            </h3>
                          </div>
                        </form>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="u-size-30">
                <div class="u-layout-row">
                  <div class="u-container-style u-layout-cell u-size-30 u-layout-cell-5">
                    <div class="u-container-layout u-container-layout-5">
                      <p class="u-text u-text-default u-text-3">img of 人氣搜尋<br>
                        <br>
                      </p>
                    </div>
                  </div>
                  <div class="u-container-style u-layout-cell u-size-30 u-layout-cell-6">
                    <div class="u-container-layout u-container-layout-6">
                      <p class="u-text u-text-default u-text-4">img of 人氣搜尋<br>
                        <br>
                      </p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section class="u-align-center u-clearfix u-section-2" id="sec-d976">
      <div class="u-clearfix u-sheet u-sheet-1">
        <div class="u-table u-table-responsive u-table-1">
         <table class="u-table-entity u-table-entity-1">
            <colgroup>
              <col width="49.9%">
              <col width="50.1%">
            </colgroup>
            <thead class="u-palette-1-base u-table-header u-table-header-1">
              <tr style="height: 41px;">
                <th class="u-border-1 u-border-palette-1-base u-table-cell">烹調時間</th>
                <th class="u-border-1 u-border-palette-1-base u-table-cell">幾人份</th>
              </tr>
            </thead>
            <tbody class="u-table-body">
              <tr style="height: 75px;">
                <td class="u-border-1 u-border-grey-30 u-table-cell">${recipe.cookTime}</td>
                <td class="u-border-1 u-border-grey-30 u-table-cell">${recipe.howManyPeople}</td>
              </tr>
    
            </tbody>
          </table>
          <table class="u-table-entity u-table-entity-1">
            <colgroup>
              <col width="49.9%">
              <col width="50.1%">
            </colgroup>
            <thead class="u-palette-1-base u-table-header u-table-header-1">
              <tr style="height: 41px;">
                <th class="u-border-1 u-border-palette-1-base u-table-cell">食材</th>
                <th class="u-border-1 u-border-palette-1-base u-table-cell">份量 </th>
              </tr>
            </thead>
            <tbody class="u-table-body">
 	<c:forEach items="${requestScope.ingredients}" var="item">
              <tr style="height: 75px;">
                <td class="u-border-1 u-border-grey-30 u-table-cell">${item.ingredient}</td>
                <td class="u-border-1 u-border-grey-30 u-table-cell">${item.amount}</td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
        <div class="u-list u-list-1">
          <div class="u-repeater u-repeater-1">
            <div class="u-container-style u-list-item u-repeater-item">
              <div class="u-container-layout u-similar-container u-container-layout-1">
                <div class="u-clearfix u-custom-html u-expanded-width u-custom-html-1">
                  <a href="#推薦食譜">推薦食譜</a>
                </div>
              </div>
            </div>
            <div class="u-container-style u-list-item u-repeater-item">
              <div class="u-container-layout u-similar-container u-container-layout-2">
                <div class="u-clearfix u-custom-html u-expanded-width u-custom-html-2">
                  <a href="#推薦食譜">推薦食譜</a>
                </div>
              </div>
            </div>
            <div class="u-container-style u-list-item u-repeater-item">
              <div class="u-container-layout u-similar-container u-container-layout-3">
                <div class="u-clearfix u-custom-html u-expanded-width u-custom-html-3">
                  <a href="#推薦食譜">推薦食譜</a>
                </div>
              </div>
            </div>
            <div class="u-container-style u-list-item u-repeater-item">
              <div class="u-container-layout u-similar-container u-container-layout-4">
                <div class="u-clearfix u-custom-html u-expanded-width u-custom-html-4">
                  <a href="#推薦食譜">推薦食譜</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section class="u-align-center u-clearfix u-section-3" id="sec-e031">
      <div class="u-clearfix u-sheet u-sheet-1">
        <div class="u-table u-table-responsive u-table-1">
          <table class="u-table-entity u-table-entity-1">
            <colgroup>
              <col width="100%">
            </colgroup>
            <thead class="u-palette-1-base u-table-header u-table-header-1">
              <tr style="height: 20px;">
                <th class="u-table-cell">步驟敘述</th>
              </tr>
            </thead>
            <tbody class="u-table-alt-palette-1-light-3 u-table-body">
          <c:forEach items="${requestScope.step}" var="item" varStatus="status" >
              <tr style="height: 76px;">
                <td class="u-table-cell"><h3><span>${status.index+1}.</span></h3>${item.step}</td>
              </tr>
                </c:forEach>
            </tbody>
          </table>
        </div>
        <div class="u-list u-list-1">
          <div class="u-repeater u-repeater-1">
            <div class="u-container-style u-list-item u-repeater-item">
              <div class="u-container-layout u-similar-container u-container-layout-1"></div>
            </div>
            <div class="u-container-style u-list-item u-repeater-item">
              <div class="u-container-layout u-similar-container u-container-layout-2"></div>
            </div>
            <div class="u-container-style u-list-item u-repeater-item">
              <div class="u-container-layout u-similar-container u-container-layout-3"></div>
            </div>
            <div class="u-container-style u-list-item u-repeater-item">
              <div class="u-container-layout u-similar-container u-container-layout-4"></div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section class="u-clearfix u-section-4" id="sec-4dfb">
      <div class="u-clearfix u-sheet u-sheet-1"></div>
    </section>
    
    
    <footer class="u-align-center u-clearfix u-footer u-grey-80 u-footer" id="sec-2725"><div class="u-clearfix u-sheet u-sheet-1">
        <p class="u-small-text u-text u-text-variant u-text-1"> Copyright © 2022 EEIT 49 Eciper. All Rights Reserved</p>
      </div></footer>
    <section class="u-backlink u-clearfix u-grey-80">
      <a class="u-link" href="https://nicepage.com/website-mockup" target="_blank">
        <span>Website Mockup</span>
      </a>
      <p class="u-text">
        <span>created with</span>
      </p>
      <a class="u-link" href="https://nicepage.com/website-builder" target="_blank">
        <span>Free Website Builder</span>
      </a>. 
    </section>
  
</body></html>