<%@ page import="JDBCbigTASK.Tasks.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
    <%@include file="boots.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<%
     Task task = (Task) request.getAttribute("task");
%>
<div class="container">
    <div class="row mt-3">
        <div class="col-12">
            <div class="col-6 mx-auto">
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>Наименование : </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="text" class="form-control" name="task_name" readonly
                                    value="<%=task.getName()%>">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>Описание : </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <textarea type="text" class="form-control" name="task_description"
                                      readonly><%=task.getDescription()%>
                            </textarea>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>Крайний срок : </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="date" class="form-control" name="task_deadline" readonly
                                    value="<%=task.getDeadlineDate()%>">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>Выполнено : </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <select class="form-control" name="task_done" readonly  value="<%=task.getDone()%>">
                                <option>Done</option>
                                <option>Not yet</option>
                            </select>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-3">
                            <button class="btn btn-success w-100"  data-bs-toggle="modal" data-bs-target="#EDIT">Edit Task</button>
                            <button class="btn btn-danger mt-2 w-100" data-bs-toggle="modal" data-bs-target="#deleteItem">DELETE ITEM</button>
                        </div>
                    </div>

                <!-- Modal -->

                <div class="modal fade" id="EDIT" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <form action="/saveItem" method="post">
                                <input type="hidden" name="id" value="<%=task.getId()%>">
                                <div class="modal-body">
                                    <div class="row mt-3">
                                        <div class="col-12">
                                            <label>Наименование : </label>
                                        </div>
                                    </div>
                                    <div class="row mt-2">
                                        <div class="col-12">
                                            <input type="text" class="form-control" name="task_name" required
                                                   value="<%=task.getName()%>">
                                        </div>
                                    </div>
                                    <div class="row mt-3">
                                        <div class="col-12">
                                            <label>Описание : </label>
                                        </div>
                                    </div>
                                    <div class="row mt-2">
                                        <div class="col-12">
                                <textarea type="text" class="form-control" name="task_description"
                                          required><%=task.getDescription()%>
                                </textarea>
                                        </div>
                                    </div>
                                    <div class="row mt-3">
                                        <div class="col-12">
                                            <label>Крайний срок : </label>
                                        </div>
                                    </div>
                                    <div class="row mt-2">
                                        <div class="col-12">
                                            <input type="date" class="form-control" name="task_deadline" required
                                                   value="<%=task.getDeadlineDate()%>">
                                        </div>
                                    </div>
                                    <div class="row mt-3">
                                        <div class="col-12">
                                            <label>Выполнено : </label>
                                        </div>
                                    </div>
                                    <div class="row mt-2">
                                        <div class="col-12">
                                            <select class="form-control" name="task_done"  required value="<%=task.getDone()%>">
                                                <option>Done</option>
                                                <option>Not yet</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                    <button class="btn btn-primary">SAVE</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="modal fade" id="deleteItem" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Delete Item</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <form action="/deleteItem" method="post">
                                <input type="hidden" name="id" value="<%=task.getId()%>">
                                <div class="modal-body">
                                    <h5 class="text-center">
                                        Are you sure?
                                    </h5>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                                    <button class="btn btn-danger">DELETE</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                    <!-- Delete without database
                </form>
                <form action="/delete" method="post">
                <div class="col-2">
                    <button  name="task_id" class="btn btn-danger">Удалить</button>
                </div>-->
            </div>
        </div>
    </div>
</div>
</body>
</html>
