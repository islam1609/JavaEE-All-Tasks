<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
<%@ page import="java.util.ArrayList" %>
<%@ page import="JOINTS1.Objects.City" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add task</title>
  <%@include file="boots.jsp"%>
</head>
<body>
<%@include file="studentNavbar.jsp"%>
<div class="container">
  <div class="row mt-3">
    <div class="col-6 mx-auto">
      <form action="/addCity" method="post">
        <div class="row mt-3">
          <div class="col-12">
            <label>NAME : </label>
          </div>
        </div>
        <div class="row mt-2">
          <div class="col-12">
            <input type="text" class="form-control" name="city_name" required placeholder="NAME">
          </div>
        </div>
        <div class="row mt-3">
          <div class="col-12">
            <label>CODE : </label>
          </div>
        </div>
        <div class="row mt-2">
          <div class="col-12">
            <textarea type="varchar(3)" class="form-control" name="city_code" required placeholder="SURNAME: "></textarea>
          </div>
        </div>
        <div class="row mt-3">
          <div class="col-3">
            <button class="form-control" >ADD CITY</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
