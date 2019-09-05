<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">

</head>
<style>
.glyphicon 
    {
        width:90px;
    height:90px;
    }
    

.formm {border: 3px solid #f1f1f1;
width:500px;
margin-left: 50%;}

input[type=text], input[type=password], input[type=rpassword], input[type=email] {
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

.btn{
  font-family: cursive;
  background-color:black;
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
}
   .glyphicon 
    {
        width:90px;
    height:90px;
    }
    

.formm {border: 3px solid #f1f1f1;
width:500px;
margin-left: 50%;}

input[type=text], input[type=password], input[type=rpassword], input[type=email] {
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

.btn{
  font-family: cursive;
  background-color:black;
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
}
   </style>
<body style="background-image: url(images/image3.jpg);  background-size: cover">
<div class="col-lg-12 col-md-12 col sm-12" > <img src="${pageContext.request.contextPath}/images/p.svg" width=150px; class="responsive"
  height=120px;>
  <button  type="button" class="btn btn-secondary" style="margin-left:25%;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;" ><a href="/uploadmedianew" style="color: white;text-decoration:none;">Upload Media</a></button>
  <button type="button" class="btn btn-secondary  "style="margin-left:0.5%;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;"><a href="/mymediapic "style="color: white;text-decoration:none;">My Media</a></button>
  <button type="button" class="btn btn-secondary  "style="margin-left:0.5%;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;"><a href="/Follow"style="color: white;text-decoration:none;">Followers/Followings</a></button>
  <button type="button" class="btn btn-secondary "  style="position: absolute;right:0; top: 30px;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;"><a href="/ActivityNewsFeed" style="color: white;text-decoration:none;">Account</a></button>
  <!--<a (click)="logout()">logout</a>-->
  
<div class="profile"><img src="${pageContext.request.contextPath}/images/profile.png" width=150px; 
    height=150px;><h3 style="margin-left: 150px;margin-top: -70px; ">${username}</h3>
        </div>
         <div class="btn-group" style="float: right;"role="group" aria-label="Basic example">
            <button type="button" class="btn btn-secondary">ACCOUNT UPDATE</button>
            
            
          </div>
     
     <br>
        
        <hr>
        <div class="account">
            <h1>ACCOUNT</h1>
            <br>
            <button type="button" class="btn btn-secondary btn-lg btn-block"><a href="/ActivityNewsFeed"style="color: white;text-decoration:none;">Newsfeed</a></button>
<button type="button" class="btn btn-secondary btn-lg btn-block"><a href="/block" style="color: white;text-decoration:none;">Blocked Account</a></button>
<button type="button" class="btn btn-secondary btn-lg btn-block">Account Update</button>
<button type="button" class="btn btn-secondary btn-lg btn-block"><a href="/Search" style="color: white;text-decoration:none;">Search</a></button>
<button type="button" class="btn btn-secondary btn-lg btn-block"> <a href="/" style="color: white;text-decoration:none;">Logout</a></button>

</div> 
       
            <div class="formm">
          <form>
            <div class="container">
                    
              <label for="uname"><b>Username</b></label>
              <input type="text" placeholder="Enter Username" name="uname" required>
          
              <label for="psw"><b>Password</b></label>
              <input type="password" placeholder="Enter Password" name="psw" required>
              <label for="rpsw"><b> Repeat Password</b></label>
              <input type="password" placeholder="Enter Password" name="rpsw" required>
              <button type="submit" class="btn btn-secondary">check</button><br><br>
              <label for="email"><b>Email</b></label>
              <input type="email" placeholder="Email" name="email" required>
              <button type="submit" class="btn btn-secondary">Update</button>
             
              
            </div>
          </form>
          </div>

</body>
</html>