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
            <form action="/addStudent" method="post">
                <div class="row mt-3">
                    <div class="col-12">
                        <label>NAME : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" name="student_name" required placeholder="NAME">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>SURNAME : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <textarea type="text" class="form-control" name="student_surname" required placeholder="SURNAME: "></textarea>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>BIRTHDATE  : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="date" class="form-control" name="student_birthdate" required >
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>CITY : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <select class="form-select" name="student_city_id" required >
                            <%
                                ArrayList<City> cities = (ArrayList)request.getAttribute("cities");
                                if(cities!=null){
                                    for(City ct :cities){
                            %>
                                    <option value="<%=ct.getId()%>">
                                          <%=ct.getName()+" "+ct.getCode()%>
                                    </option>
                            <%
                                   }
                                }
                            %>
                        </select>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-3">
                        <button class="form-control" >ADD STUDENT</button>
                    </div>
                </div>
        </form>
        </div>
    </div>
</div>
</body>
</html>
