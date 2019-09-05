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

</head>

<style>
.glyphicon 
    {
        width:90px;
    height:90px;
    }
    

.example {border: 3% solid #f1f1f1;
width:500px;
margin-left: 280px;
}



.border
{
    border:2px;
   border-style: solid;
   border-color:black;
padding: 3em 5em 3em 3em;

    margin-top:-110px;
}
  .search2 input[type=text]
{
border: 2px solid black;
 padding:10px;
  border-radius: 10px 40px 10px 40px;
margin-left:5%;
height:70px;width:50%;
}






.account
{
  float:left;
  width:300px;
  margin-left: 100px;
  font-family: cursive;
}


form.example input[type=text] {
  padding: 10px;
  font-size: 17px;
  border: 1px solid grey;
  float: left;
  width: 80%;
  background: #f1f1f1;
}

form.example button {
  float: left;
  width: 20%;
  padding: 10px;
  background: #2196F3;
  color: white;
  font-size: 150%;
  border: 1px solid grey;
  border-left: none;
  cursor: pointer;
}

form.example button:hover {
  background: #0b7dda;
}

form.example::after {
  content: "";
  clear: both;
  display: table;
}
</style>
<body style="background-image: url(images/image3.jpg);  background-size: cover">
<div class="col-lg-12 col-md-12 col sm-12" > <img src="${pageContext.request.contextPath}/images/p.svg" width=150px; class="responsive"
  height=120px;>
  <button  type="button" class="btn btn-secondary" style="margin-left:25%;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;" ><a href="/uploadmedianew" style="color: white;text-decoration:none;">Upload Media</a></button>
  <button type="button" class="btn btn-secondary  "style="margin-left:0.5%;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;"><a href="/mymediapic"style="color: white;text-decoration:none;">My Media</a></button>
  <button type="button" class="btn btn-secondary  "style="margin-left:0.5%;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;"><a href="/Follow"style="color: white;text-decoration:none;">Followers/Followings</a></button>
  <button type="button" class="btn btn-secondary "  style="position: absolute;right:0; top: 30px;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;"><a href="/ActivityNewsFeed" style="color: white;text-decoration:none;">Account</a></button>
  <!--<a (click)="logout()">logout</a>-->
  
<div class="profile"><img src="${pageContext.request.contextPath}/images/profile.png" width=150px; 
    height=150px;><h3 style="margin-left: 150px;margin-top: -70px; ">${username}</h3>
        </div>
        <div class="btn-group" style="float: right;"role="group" aria-label="Basic example">
            <button type="button" class="btn btn-secondary">SEARCH</button>
            
            
          </div>
     <br>
        
        <hr>
        <div class="account">
            <h1>ACCOUNT</h1>
            <br>
            <button type="button" class="btn btn-secondary btn-lg btn-block"><a href="/ActivityNewsFeed" style="color: white;text-decoration:none;">Newsfeed</a></button>
<button type="button" class="btn btn-secondary btn-lg btn-block"><a href="/block" style="color: white;text-decoration:none;">Blocked Account</a></button>
<button type="button" class="btn btn-secondary btn-lg btn-block"><a href="/AccountUpdate" style="color: white;text-decoration:none;">Account Update</a></button>
<button type="button" class="btn btn-secondary btn-lg btn-block">Search</button>
<button type="button" class="btn btn-secondary btn-lg btn-block"> <a href="/" style="color: white;text-decoration:none;">Logout</a></button>

</div>
<div class="search2" >
    <input type="text" placeholder="Search..." name="search2" class="search2">

    <button type="button" class="btn btn-secondary" style="height: 70px; margin-left: 1%;">SEARCH</button>
</div> 

</body>
</html>