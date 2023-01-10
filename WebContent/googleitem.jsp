<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><!--(網頁設定值) --> 
<head>
<meta charset="UTF-8">
<title>Amigo Search for you</title>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<style>
	.logo{
		float:center;
		text-align:center;
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
.box{
  		margin :0px auto;
  		width: 400px;
  		height: 50px;
  		position: center;
	}
.container-4{
		position: center;
  		overflow: hidden;
  		width: 400px;
  		vertical-align:middle;
  		white-space: nowrap;
	}
	.container-4 input#search{
  		width: 400px;
  		height: 50px;
  		background: #FFFFFF;
  		border:none;
  		font-size: 10pt;
  		font-weight: bold;
  		float: left;
  		color: #004aad;
  		padding-left: 15px;
  		-webkit-border-radius: 5px;
  		-moz-border-radius: 5px;
  		border-radius: 5px;
  		-webkit-input-placeholder { color:white; }
	}
.container-4 input#search::-webkit-input-placeholder {
   color: #65737e;
}
 
.container-4 input#search:-moz-placeholder { /* Firefox 18- */
   color: #65737e;  
}
 
.container-4 input#search::-moz-placeholder {  /* Firefox 19+ */
   color: #65737e;  
}
 
.container-4 input#search:-ms-input-placeholder {  
   color: #65737e;  
}
.container-4 button.icon{
  -webkit-border-top-right-radius: 5px;
  -webkit-border-bottom-right-radius: 5px;
  -moz-border-radius-topright: 5px;
  -moz-border-radius-bottomright: 5px;
  border-top-right-radius: 5px;
  border-bottom-right-radius: 5px;
 
  border: none;
  background: #004aad;
  height: 52px;
  width: 50px;
  color: #4f5b66;
  opacity: 0;
  font-size: 10pt;
 
  -webkit-transition: all .55s ease;
  -moz-transition: all .55s ease;
  -ms-transition: all .55s ease;
  -o-transition: all .55s ease;
  transition: all .55s ease;
}
.container-4:hover button.icon, .container-4:active button.icon, .container-4:focus button.icon{
    outline: none;
    opacity: 1;
    margin-left: -60px;
  }
 
  .container-4:hover button.icon:hover{
    background: white;
  }
</style>
</head>
<body  style="background-color:#417ec9;">
<div class="logo">
<img src="image/logo2.png" alt="我們的logo" 
    style="float: center;"  width= "150"; height="150"/>
</div>
<div class="box">
<div class="container-4">
  <form action='${requestUri}' method='get'>
    <input type='text' id="search" name='keyword' placeholder = 'Amigo - Help build your best trip to Amierca!' 
    	/>
    <button type='submit' class="icon" ><i class="fa fa-search" style="color: #ffde59;"></i></button>
    </form>
  </div>
  </div>
  <p></p><p></p>
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
	<small style= "color: #417ec9;">123456</small>
	<small style= "color: #ffffff";><%= orderList[i][1] %></small></p>
<%
}
%>
</div>
</body><!--(網頁內的樣子) --> 
</html>