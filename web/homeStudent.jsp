<%@ page import="JOINTS1.Objects.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="boots.jsp"%>
    <%@include file="studentNavbar.jsp"%>
</head>
<body>
<div class="container">
    <div>
        <a href="/addStudent" class="btn btn-info mt-3">+ ADD STUDENT</a>
        <a href="/addCity" class="btn btn-info ms-2 mt-3">+ ADD CITY</a>
    </div>
</div>
<div class="container">
    <div class="row mt-3">
        <div class="col-12">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>SURNAME</th>
                    <th>BIRTHDATE</th>
                    <th>CITY</th>
                    <th>DETAILS</th>
                </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<Student> allStudents = (ArrayList)request.getAttribute("allStudents");
                    if (allStudents != null) {
                        for (Student st : allStudents) {
                %>
                <tr>
                    <td><%out.print(st.getId());%></td>
                    <td><%out.print(st.getName());%></td>
                    <td><%out.print(st.getSurname());%></td>
                    <td><%out.print(st.getBirthdate());%></td>
                    <td><%out.print(st.getCity().getName()+"/"+st.getCity().getCode());%></td>
                    <td>
                        <a href="/detailsStudent?id=<% out.print(st.getId());%>" class="btn btn-primary btn-sm">DETAILS</a>
                    </td>
                </tr>

                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
