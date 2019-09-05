<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="Styles/Login.css">
</head>
<style>
@charset "ISO-8859-1";
.glyphicon 
  {
      width:90px;
  height:90px;
  }
  
hr{
    
    border:3px solid black;
    border-style: inset;
 
}
form {border: 3px solid #f1f1f1;
width:500px;
margin-left: 50%;}

input[type=text], input[type=password] {
width: 100%;
padding: 12px 20px;
margin: 8px 0;
display: inline-block;
border: 2px solid black;
box-sizing: border-box;
}



.cancelbtn {
width: auto;
padding: 10px 18px;
background-color: #6d6666;
}



.container {
padding: 16px;
}

span.psw {
float: right;
padding-top: 16px;
}
.account
{
  float:left;
  width:300px;
  margin-left: 100px;
  font-family: cursive;
}
.profile
{
  display: block;
}</style>
<body style="background-image: url(images/image3.jpg);  background-size: cover">
    <div class="col-lg-12 col-md-12 col sm-12" > <img src="images/p.svg" width=150px; class="responsive"
  height=120px;>
  <button  type="button" class="btn btn-secondary" style="margin-left:25%;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;" ><a href="#" style="color: white;text-decoration:none;">Upload Media</a></button>
  <button type="button" class="btn btn-secondary" style="margin-left:0.5%;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;"><a href="#" style="color: white;text-decoration:none;">My Media</a></button>
  <button type="button" class="btn btn-secondary" style="margin-left:0.5%;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;"><a href="#" style="color: white;text-decoration:none;">Followers/Followings</a></button>
  <button type="button" class="btn btn-secondary"  style="position: absolute;right:0; top: 30px;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;"><a href="/activitynewsfeed" style="color: white;text-decoration:none;">Account</a></button>
  <!--<a (click)="logout()">logout</a>-->
 
     </div>   
 <br>
      <hr>
      <div class="account">
        <h1 style="margin-left: 20%">ACCOUNT</h1>
        <br>
        <button type="button" class="btn btn-secondary btn-lg btn-block">LOGIN</button>
        <button type="button" class="btn btn-secondary btn-lg btn-block"><a href="${contextPath}/registration" style="color: white;text-decoration:none;">REGISTRATION</a></button>
      </div>
     
        
<form method="POST" action="loginentry" class="form-signin" >
        <h3>Login</h3>
  <label for="uname"><b>Username</b></label>

  <input type="text" placeholder="Enter Username" name="uname"  class="form-control" />
   
  <label for="psw"><b>Password</b></label>
  <input type="password" placeholder="Enter Password" name="psw" formControlName="psw" class="form-control" >
   <span>${error}</span>
   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
   
  <button type="submit" [disabled]="loading" class="btn btn-secondary" ><span  class="spinner-border spinner-border-sm mr-1"></span>Login</button>
  

<div class="container" style="background-color:#f1f1f1">
  <button type="button" class="cancelbtn"><a href="Login" style="color: white;text-decoration:none;">Cancel</a></button>
  <span class="psw">Forgot <a href="#">password?</a></span>
</div>
</div>
</form>
       


</body>
</html>