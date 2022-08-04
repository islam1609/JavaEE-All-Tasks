<%@ page import="JOINTS1.Objects.Student" %>

<html>
<head>
    <title>Details</title>
    <%@include file="boots.jsp"%>
</head>
<body>
<%@include file="studentNavbar.jsp"%>
    <%
Student student = (Student)request.getAttribute("student");
%>
<div class="container">
    <div class="row mt-3">
        <div class="col-12">
            <div class="col-6 mx-auto">
                <div class="row mt-3">
                    <div class="col-12">
                        <label>NAME: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" name="task_name" readonly
                               value="<%=student.getName()%>">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>SURNAME : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                            <textarea type="text" class="form-control" name="task_description"
                                      readonly><%=student.getSurname()%>
                            </textarea>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>BIRRHDATE : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="date" class="form-control" name="task_deadline" readonly
                               value="<%=student.getBirthdate()%>">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>CITY : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" name="task_deadline" readonly
                               value="<%=student.getCity().getName()%>">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-3">
                        <button class="btn btn-success w-100"  data-bs-toggle="modal" data-bs-target="#EDIT">Edit Task</button>
                        <button class="btn btn-danger mt-2 w-100" data-bs-toggle="modal" data-bs-target="#deleteItem">DELETE ITEM</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>