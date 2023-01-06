<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><!--(網頁設定值) --> 
<head>
<meta charset="UTF-8">
<title>Amigo Search for you</title>
<style>
	.logo{
		float:left;
		text-align:left;
		}
	.url{
		clear:left
	}
	.snow-container {
  		position: absolute;
  		height: 1000px;
  		width: 100%;
  		max-width: 100%;
  		top: 0;
  		overflow-y: visible;
  		z-index: 2;
  		pointer-events: none;
	}

	.snow {
  		display: block;
  		position: absolute;
  		z-index: 2;
  		top: 0;
  		right: 0;
  		bottom: 0;
  		left: 0;
  		pointer-events: none;
  		-webkit-transform: translate3d(0, -100%, 0);
          		transform: translate3d(0, -100%, 0);
  		-webkit-animation: snow linear infinite;
          		animation: snow linear infinite;
	}
	.snow.foreground {
  		background-image: url("https://dl6rt3mwcjzxg.cloudfront.net/assets/snow/snow-large-075d267ecbc42e3564c8ed43516dd557.png");
  		-webkit-animation-duration: 14s;
          		animation-duration: 14s;
	}
	.snow.foreground.layered {
  		-webkit-animation-delay: 8.5s;
          		animation-delay: 8.5s;
	}

@-webkit-keyframes snow {
  0% {
    -webkit-transform: translate3d(0, -100%, 0);
            transform: translate3d(0, -100%, 0);
  }
  100% {
    -webkit-transform: translate3d(15%, 100%, 0);
            transform: translate3d(15%, 100%, 0);
  }
}

@keyframes snow {
  0% {
    -webkit-transform: translate3d(0, -100%, 0);
            transform: translate3d(0, -100%, 0);
  }
  100% {
    -webkit-transform: translate3d(15%, 100%, 0);
            transform: translate3d(15%, 100%, 0);
  }
}
</style>
</head>
<body  style="background-color:#343d46;">
<div class="logo">
<img src="image/logo2.png" alt="我們的logo" 
    style="float: center;"  width= "150";height="150"/>
</div>
<div class="snow-container">
  <div class="snow foreground"></div>
  <div class="snow foreground layered"></div>
</div>
<div class = "url">
<%
String[][] orderList = (String[][])  request.getAttribute("query");
for(int i =0 ; i < orderList.length;i++){%>
<img src="image/world.png" alt="这是一个图片" width= "40";height="40";>
<a href='<%= orderList[i][1] %>'
	style="color:white; font-size:20px; font-weight: bold;">
	<%= orderList[i][0] %></a>
<p>
	<small style= "color: #343d46;">123456</small>
	<small style= "color: #ffffff";><%= orderList[i][1] %></small></p>
<%
}
%>
</div>
</body><!--(網頁內的樣子) --> 
</html>