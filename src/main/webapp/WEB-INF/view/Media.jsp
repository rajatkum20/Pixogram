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
 

background-color:white;
  display: inline-block;
  border: 2px solid black;
  box-sizing: border-box;
  }
  p
  {
  width:50%;
  border: 2px solid black;
  padding: 7px;
  border-radius: 60px 60px 10px 60px;
  }
  h1{


padding:8px;
  display: inline-block;
  
  }
  .left
  {
  width:60%;
height:70%;
  }
  .right
  {
width:30%;
height:30%;
  float:right;
  }
   h5{
 background-color:white;

padding:8px;
  display: inline-block;
  border: 2px solid black;
  box-sizing: border-box;
  }
  
  </style>
<body style="background: linear-gradient(to top, #fbc2eb 0%, #a18cd1 100%);  background-size: cover">
<div class="col-lg-12 col-md-12 col sm-12" > <img src="${pageContext.request.contextPath}/images/p.svg" width=150px; class="responsive"
  height=120px;>
  <button  type="button" class="btn btn-secondary" style="margin-left:25%;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;" ><a href="/uploadmedianew" style="color: white;text-decoration:none;">Upload Media</a></button>
  <button type="button" class="btn btn-secondary  "style="margin-left:0.5%;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;"><a href="/mymediapic "style="color: white;text-decoration:none;">My Media</a></button>
  <button type="button" class="btn btn-secondary  "style="margin-left:0.5%;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;"><a href="/followers"style="color: white;text-decoration:none;">Followings</a></button>
  <button type="button" class="btn btn-secondary "  style="position: absolute;right:0; top: 30px;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;"><a href="/block" style="color: white;text-decoration:none;">Account</a></button>
  <!--<a (click)="logout()">logout</a>-->
<div class="profile"><img src="${pageContext.request.contextPath}/images/profile.png" width=150px; 
height=150px;><h3 style="margin-left: 150px;margin-top: -70px;">${username}</h3>

    </div>
    </div>
 <br>
    
    <hr>
 <div class="row">   <div class="left">
<img src="/images/profile.png" width=50px;
height=50px; style="margin-left: 7%;"><h1>${photo.title }</h1>
<br>

<img src="data:images/jpg;base64,${photo.encimg}" style="width:50%;height:30%;margin-left:7%;">




<br>
</div>
<div class="right"><!--<div  style="margin-left:60%;margin-top: -32%;"> -->
<br>
<br>
<h5>Descrption: ${photo.description }</h5><br><br>
<h5>Tags: ${photo.tags }</h5>
<br>
<br>
<h2>Comments</h2>

<br>
<c:forEach var="d" items="${comments}">
<b>${d.username}</b>
<p>${d.comment}</p>
<a href="<c:url value='/deletecomm/${d.comment_id}'/>"><button type="button" class="btn btn-dark" style="margin-left:300px; margin-top:-10%">delete comment</button></a>
<br>

</c:forEach>

<div class="row">
<form:form method="POST" modelAttribute="commentsDatamedia" action="/commentsmedia">
<form:input type="hidden" path="uploadmedia" value="${photo.id}"></form:input>
<form:input type="text" path="comment" style="margin-top: 2%; width:50%;" placeholder="comments are here...."></form:input>

<button class="btn btn-dark" style="margin-left:350px; margin-top:-10%">
       Comment</button>
       </form:form>
</div></div>
</div>

</body>
</html>