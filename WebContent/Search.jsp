<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Amigo</title>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<style>
 body {
        font: 1em sans-serif;
        text-align: center;
    }
    .stage {
        display: flex;
        height: 380px;
        width: 100%;

    }
    .box {
        align-self: flex-start;
        animation-duration: 3s;
        animation-iteration-count:infinite;
        height: 200px;
        margin: 0 auto 0 auto;
        transform-origin: bottom;
        width: 200px;
    }
    .bounce-1 {
        animation-name: bounce-1;
        animation-timing-function: linear;
    }
    @keyframes bounce-1 {
        0%   { transform: translateY(0); }
        50%  { transform: translateY(-30px); }
        100% { transform: translateY(0); }
    }
	.box{
  		margin :50px auto;
  		width: 350px;
  		height: 50px;
	}
 	.container-4{
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
<body  style="background-image: url('image/dark2b.jpg'); 
				background-position: center center;
				background-repeat: no-repeat;
				background-filter: brightness(60%);
				background-size: cover">
<div class="stage">
    <div class="box bounce-1"><img src="image/logo2.png" alt="這是我們的logo" 
    width= "400";height="350";></div>
</div>
<div class="box">
  <div class="container-4">
  <form action='${requestUri}' method='get'>
    <input type='text' id="search" name='keyword' placeholder = 'Amigo - Help build your best trip to Amierca!' ;" />
    <button type='submit' class="icon" ><i class="fa fa-search" style="color: #ffde59;"></i></button>
    </form>
  </div>
</div>
</body>
</html>