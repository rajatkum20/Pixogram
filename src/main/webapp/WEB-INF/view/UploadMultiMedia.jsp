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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<style>
.glyphicon 
{
    width:90px;
height:90px;
}


.formm {border: 3px solid #f1f1f1;
width:500px;
margin-left: 50%;

}

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



.container {
padding: 30px;

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
h4{margin-left: 500px;
display: inline;
}
h6{margin-left: 550px;
border:2px;
border-style: solid;
border-color:black;


margin-top:-80px;
}
.border
{
border:2px;
border-style: solid;
border-color:black;
padding: 3em 5em 3em 3em;

margin-top:-110px;
}</style>
<body style="background-image: url(images/image3.png);  background-size: cover">
 <div class="col-lg-12 col-md-12 col sm-12" > <img src="${pageContext.request.contextPath}/images/p.svg" width=150px; class="responsive"
  height=120px;>
  <button  type="button" class="btn btn-secondary" style="margin-left:25%;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;" ><a href="/uploadmedianew" style="color: white;text-decoration:none;">Upload Media</a></button>
  <button type="button" class="btn btn-secondary  "style="margin-left:0.5%;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;"><a href="/mymediapic"style="color: white;text-decoration:none;">My Media</a></button>
  <button type="button" class="btn btn-secondary  "style="margin-left:0.5%;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;"><a href="/Follow"style="color: white;text-decoration:none;">Followers/Followings</a></button>
  <button type="button" class="btn btn-secondary "  style="position: absolute;right:0; top: 30px;width: 200px; border-radius: 10px; box-shadow: 5px 10px #888888;"><a href="/block" style="color: white;text-decoration:none;">Account</a></button>
  <!--<a (click)="logout()">logout</a>-->
 
     </div>     
<div class="profile"><img src="${pageContext.request.contextPath}/images/profile.png" width=150px;
    height=150px;><h3 style="margin-left: 150px;margin-top: -70px; ">${username}</h3>
        </div>
        <div class="btn-group" style="float: right;"role="group" aria-label="Basic example">
          <button type="button" class="btn btn-secondary">Single</button>
          <button type="button" class="btn btn-secondary">Multi</button>
          
        </div>
   <br>
      
      <hr>
      <div class="account">
          <h1>UPLOAD</h1>
          <br>
          <button type="button" class="btn btn-secondary btn-lg btn-block"><a href="/uploadmedianew" style="color: white;text-decoration:none;">Single Media</a></button>
  <button type="button" class="btn btn-secondary btn-lg btn-block">Multiple Media</button>
  </div> 
     
       <form:form method="post" modelAttribute="uploadmedia" action="multipleupload"  enctype="multipart/form-data">
        <div class="formm">
          <div class="container" >
              <h3>New Media Page</h3>
            <label for="browse"><b>Browse</b></label><br>
            <input type="file" name="file" class="btn btn-secondary" style="margin-right: 40px;margin-left: 60px; width:51%;">
            <button type="submit" class="btn btn-secondary">Upload All</button><br>
        
            <label for="title"><b>Title</b></label>
            <form:input type="text" placeholder="Title" path="title"></form:input>
            <label for="description"><b> Description</b></label>
            
            <form:input type="text" placeholder="Description" path="description"></form:input>
            <label for="tags" style="margin-top:-150px "><b>Tags</b></label>
            <input type="text"style="margin-top:-110px " placeholder="Tags" name="tags" required>
           
            <label for="effects" style="margin-top:-110px "><b>Effects</b></label>
            <div class="btn-group"  role="group" aria-label="Basic example">
                  <button type="button" class="btn btn-secondary"style="margin-left: 40px;">Sepia</button>
                  <button type="button" class="btn btn-secondary">Grey</button>
                  <button type="button" class="btn btn-secondary">Brightness</button>
                  <button type="button" class="btn btn-secondary">Contrast</button>
                </div>
                
                
                <hr>
                <label for="browse"><b>Browse</b></label>
            <input type="file" name="file" class="btn btn-secondary" style="margin-right: 40px;margin-left: 60px;"><br>
                <label for="title"><b>Title</b></label>
            <form:input type="text" placeholder="Title" path="title"></form:input>
            <label for="description"><b> Description</b></label>
            
            <form:input type="text" placeholder="Description" path="description"></form:input>
            
            <label for="tags" ><b>Tags</b></label>
            <input type="text" placeholder="Tags" name="tags" required>
           
            <label for="effects" ><b>Effects</b></label>
            <div class="btn-group"  role="group" aria-label="Basic example">
                  <button type="button" class="btn btn-secondary"style="margin-left: 40px;">Sepia</button>
                  <button type="button" class="btn btn-secondary">Grey</button>
                  <button type="button" class="btn btn-secondary">Brightness</button>
                  <button type="button" class="btn btn-secondary">Contrast</button>
          </div>
          
       
         </div>
      
        </div>
</form:form>
</body>
</html>