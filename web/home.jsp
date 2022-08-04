<%@ page import="java.util.ArrayList" %>
<%@ page import="JDBCbigTASK.Tasks.Task" %><%--

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
    <%@include file="boots.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
 <div class="container">
    <div>
        <a href="/addTask.jsp" class="btn btn-info mt-3">+ Добавить задание</a>
    </div>
    <div class="container">
    <div class="row mt-3">
        <div class="col-12">
            <table class="table table-hover">
                <thead>
                <tr>
                <th>ID</th>
                <th>Наименование</th>
                <th>Крайний срок</th>
                <th>Выполнено</th>
                <th>Детали</th>
                </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<Task> allTasks = (ArrayList)request.getAttribute("tasks");
                    if (allTasks != null) {
                        for (Task ts : allTasks) {
                %>
                <tr>
                    <td><%out.print(ts.getId());%></td>
                    <td><%out.print(ts.getName());%></td>
                    <td><%out.print(ts.getDeadlineDate());%></td>
                    <td><%out.print(ts.getDone());%></td>
                    <td>
                        <a href="/details?id=<% out.print(ts.getId());%>" class="btn btn-primary btn-sm">DETAILS</a>
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
</div>
</body>
</html>
