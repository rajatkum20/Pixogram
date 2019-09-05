<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">

</head>
<style>
.profile
{
    display: block;
}
 .row input
{
border: 2px solid black;
  padding: 7px;
  border-radius: 60px 60px 10px 60px;
}
input[type=text], input[type=textarea] {
 


  display: inline-block;
  border: 2px solid black;
  box-sizing: border-box;
  }
  h1{
 

padding:8px;
  display: inline-block;
  
  }
  .right
  {
  position: absolute;
  }
   h5{
 

padding:8px;
  display: inline-block;
  border: 2px solid black;
  box-sizing: border-box;
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
height=150px;><h3 style="margin-left: 150px;margin-top: -70px;">${username}</h3>

    </div>
    </div>
 <br>
    
    <hr>
    
    <h3 style="margin-left: 7%;">Media Details</h3>
<img src="/images/profile.png" width=50px;
height=50px; style="margin-left: 7%;"><h1>${photo.title }</h1>
<br>

<div><img src="data:images/jpg;base64,${photo.encimg}" style="width:30%;height:30%;margin-left:7%;">

<div style=" margin-top: -40px; margin-left:400px;  "><i class="material-icons" >
    thumb_up_alt
    </i>
    &nbsp;&nbsp;&nbsp;
    <i class="material-icons" >
    thumb_down_alt
    </i>
</div>
<br>
</div>
<div class="right"><div  style="margin-left:60%;margin-top: -32%; position:fixed;">
<div class="btn-group" role="group" aria-label="Basic example" >
<button type="button" class="btn btn-secondary">Sepia</button>
<button type="button" class="btn btn-secondary">Grey</button>
<button type="button" class="btn btn-secondary">Brightness</button>
<button type="button" class="btn btn-secondary">Contrast</button>
</div>
<br>
<br>
<h5>Descrption: ${photo.description }</h5><br><br>
<h5>Tags: ${photo.tags }</h5>
<br>
<br>
<i class="material-icons">
thumb_up_alt
</i>
<i class="material-icons" >
mode_comment
</i> <br> <br><b>comments</b>
<br>
<br>
<form>
<div class="row">

<input type="text" style="margin-top: 2%; width:50%;" placeholder="comments are here....">
&nbsp;&nbsp;&nbsp;&nbsp;
<b>user1</b>
<br>
Like
Unlike
Reply
Delete

<br>
<br>


<input type="text" style="margin-top: 2%; width:50%;" placeholder="comments are here....">
&nbsp;&nbsp;&nbsp;&nbsp;
<b>user2</b>
<br>
Like
Unlike
Reply
Delete

<br><br>
<input type="text" style="margin-top: 2%;width:50%;" placeholder="comments are here....">
&nbsp;&nbsp;&nbsp;&nbsp;
<b>user3</b>
<br>
Like
Unlike
Reply
Delete
<br>
<br>

</div>
</form>
</div>
</div>


</body>
</html>