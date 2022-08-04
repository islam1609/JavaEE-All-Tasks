<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20.05.2022
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add task</title>
  <%@include file="boots.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container">
  <div class="row mt-3">
    <div class="col-6 mx-auto">
      <form action="/addTask" method="post">
        <div class="row mt-3">
          <div class="col-12">
            <label>Наименование : </label>
          </div>
        </div>
        <div class="row mt-2">
          <div class="col-12">
            <input type="text" class="form-control" name="task_name" required placeholder="Наименование">
          </div>
        </div>
        <div class="row mt-3">
          <div class="col-12">
            <label>Описание : </label>
          </div>
        </div>
        <div class="row mt-2">
          <div class="col-12">
            <textarea type="text" class="form-control" name="task_description" required placeholder="Описание: "></textarea>
          </div>
        </div>
        <div class="row mt-3">
          <div class="col-12">
            <label>Крайний срок : </label>
          </div>
        </div>
        <div class="row mt-2">
          <div class="col-12">
            <input type="date" class="form-control" name="task_deadline" required placeholder="день/месяц/год">
          </div>
        </div>
        <div class="row mt-3">
          <div class="col-12">
            <label>Выполнено : </label>
          </div>
        </div>
        <div class="row mt-2">
          <div class="col-12">
            <select class="form-control" name="task_done" required >
                <option>Done</option>
                <option>Not yet</option>
            </select>
          </div>
        </div>
        <div class="row mt-3">
          <div class="col-12">
            <button type="submit" class="btn btn-success">ADD TASK</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
