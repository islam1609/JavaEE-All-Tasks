<%@ page import="java.util.ArrayList" %>
<%@ page import="Sprint2.Objects.Publications" %>
<%@ page import="Sprint2.Objects.Languages" %>
<%@ page import="Sprint2.Objects.News" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.07.2022
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="boots.jsp"%>
</head>
<body>
<%
     ArrayList<Publications> allPubcs= (ArrayList) request.getAttribute("allPublications");
     ArrayList<Languages> allLang= (ArrayList) request.getAttribute("allLang");
     ArrayList<News> allNews= (ArrayList) request.getAttribute("allNews");
     %>
<div class="container">
    <div class="row">
        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: whitesmoke;">
            <div class="container-fluid d-flex justify-content-between">
                <div class="collapse navbar-collapse col-3">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <%
                            if (allLang != null) {
                                for (Languages language : allLang) {
                        %>
                        <li class="nav-item">
                            <a class="nav-link fw-bold">"
                                href="">
                                <%=language.getCode()%></a>
                        </li>
                        <%
                                }
                            }
                        %>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    </div>
</body>
</html>
