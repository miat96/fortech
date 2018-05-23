<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<title>Aplicatie</title>
	<style>
		  body {
			    padding-top: 120px;
			    padding-bottom: 40px;
			    background-image: url('https://cdn.wallpapersafari.com/11/39/i8tDoR.jpg');
  				background-repeat: no-repeat;
  				}
		  .btn 
		  {
		   outline:0;
		   border:none;
		   border-top:none;
		   border-bottom:none;
		   border-left:none;
		   border-right:none;
		   box-shadow:inset 2px -3px rgba(0,0,0,0.15);
		  }
		  .btn:focus
		  {
		   outline:0;
		   -webkit-outline:0;
		   -moz-outline:0;
		  }
		  .fullscreen_bg {
		    position: fixed;
		    top: 0;
		    right: 0;
		    bottom: 0;
		    left: 0;
		    background-size: cover;
		    background-position: 50% 50%;
		    
		    background-repeat:repeat;
		  }
		  .form-signin {
		    max-width: 280px;
		    padding: 15px;
		    margin: 0 auto;
		      margin-top:50px;
		  }
		  .form-signin .form-signin-heading, .form-signin {
		    margin-bottom: 10px;
		  }
		  .form-signin .form-control {
		    position: relative;
		    font-size: 16px;
		    height: auto;
		    padding: 10px;
		    -webkit-box-sizing: border-box;
		    -moz-box-sizing: border-box;
		    box-sizing: border-box;
		  }
		  .form-signin .form-control:focus {
		    z-index: 2;
		  }
		  .form-signin input[type="text"] {
		    margin-bottom: -1px;
		    border-bottom-left-radius: 0;
		    border-bottom-right-radius: 0;
		    border-top-style: solid;
		    border-right-style: solid;
		    border-bottom-style: solid;
		    border-left-style: solid;
		    border-color: #000;
		  }
		  .form-signin input[type="password"] {
		    margin-bottom: 10px;
		    border-top-left-radius: 0;
		    border-top-right-radius: 0;
		    border-top-style: solid;
		    border-right-style: solid;
		    border-bottom-style: solid;
		    border-left-style: solid;
		    border-color: #000;
		  }
		  .form-signin-heading {
		    color: #fff;
		    text-align: center;
		    text-shadow: 0 2px 2px rgba(0,0,0,0.5);
		    font-family: "Comic Sans MS", cursive, sans-serif;
		  }
		  
		  h4 {
		  	color: #000033;
		  }
		  
		  .divError {
		  	color: #e60000;
		  	font-size: 20px;
		  	text-align: center;
		  }
	</style>


</head>

<body>

		<div id="fullscreen_bg" class="fullscreen_bg"/>
		
			<div class="container">
			
				<form class="form-signin" method="POST" action="/SpringMVCExample/findUser">
					<h1 class="form-signin-heading text-muted">Autentificare</h1>
					<br>
					<br>
					<h4>Nume de utilizator:</h4>
					<input type="text" class="form-control" required="" autofocus="" name="userName" path="userName">
					<h4>Parola:</h4>
					<input type="password" class="form-control"  required="" name="password" path="password">
					<button class="btn btn-lg btn-primary btn-block" type="submit" name="login" value="login">
						Logare
					</button>
				</form>
			<div class="divError">${loginError}</div>
		
		</div>

</body>

</html>