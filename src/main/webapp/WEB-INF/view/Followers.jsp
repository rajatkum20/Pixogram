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
.profile
{
    display: block;
}
 </style>
<body style="background: linear-gradient(to top right, #fc2c77 0%, #6c4079 100%);  height:50vw;">
<div class="col-lg-12 col-md-12 col sm-12" > <img src="${pageContext.request.contextPath}/images/p.svg" width=150px; class="responsive"
  height=120px;>
  <button  type="button" class="btn btn-secondary" style="margin-left:25%;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;" ><a href="/uploadmedianew" style="color: white;text-decoration:none;">Upload Media</a></button>
  <button type="button" class="btn btn-secondary  "style="margin-left:0.5%;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;"><a href="/mymediapic "style="color: white;text-decoration:none;">My Media</a></button>
  <button type="button" class="btn btn-secondary  "style="margin-left:0.5%;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;"><a href="/followers"style="color: white;text-decoration:none;">Followings</a></button>
  <button type="button" class="btn btn-secondary "  style="position: absolute;right:0; top: 30px;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;"><a href="/block" style="color: white;text-decoration:none;">Account</a></button>
  <!--<a (click)="logout()">logout</a>-->
  
  <div class="profile"><img src="${pageContext.request.contextPath}/images/profile.png" width=150px; 
    height=150px;><h3 style="margin-left: 150px;margin-top: -70px; ">${username}</h3>
        </div>
        <div class="btn-group" style="float: right;"role="group" aria-label="Basic example">
           
       <a href="/Follow">  <button type="button" class="btn btn-secondary">All Users</button></a>
          </div>
     <br>
        
        <hr>
        
        <div class="row">
        <c:forEach var="d" items="${data}">
          <div class="card text-white bg-secondary mb-3" style="max-width: 14rem;margin-left: 10%;">
  <div class="card-header">

</div>
  <div class="card-body"style="width:300px;height:150px;">
    
 <p>Click on Username to<br> vist profile </p>
 <center>  <a href="<c:url value='/profile/${d.uname}'/>" style="color: white;text-decoration:none;"><h3>${d.uname}<h3></a></center>

   </div>
     
  <div class="card-footer"><div class="btn-group" role="group" aria-label="Basic example" style="margin-left: 4%;">
 
 
<a href="<c:url value='/block/${d.uname}'/>"><button type="button" class="btn btn-secondary">Block</button></a>
  <a href="<c:url value='/unfollow/${d.id}'/>"><button type="button" class="btn btn-secondary">Unfollow</button></a>
  
</div></div>
</div></c:forEach></div></div>
</body>
</html>