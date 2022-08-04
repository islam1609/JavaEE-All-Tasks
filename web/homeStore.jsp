<%@ page import="Sprint1.item.Item" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Sprint1.db.DBconnector" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.05.2022
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
 <%@include file="boots.jsp" %>
</head>
<body>
<%@include file="storeNavbar.jsp"%>
    <div class="container mt-5">
    <div>
        <h2 class="text-center">Welcome to BITLAB SHOP</h2>
        <p class="text-black-50 text-center">Electronic devices with high quality and service</p>
    <div class="container mx-auto">
        <div class="card-deck row mx-auto">
            <%
                ArrayList<Item> allItems = (ArrayList) request.getAttribute("items");
                if (allItems != null){
                    for (Item itm : allItems    ){
            %>
            <div class="col-4 p-2">
                <div class="card border-success shadow p-3 bg-white rounded">
                    <div class="card-header bg-transparent  fw-bold border-success" ><%out.print(itm.getName());%></div>
                    <div class="card-body text-black-50">
                        <h5 class="card-title text-success">$<%out.print(itm.getPrice());%></h5>
                        <p class="card-text"><%out.print(itm.getDescription());%></p>
                        <button class="w-100 mt-3 btn-success text-center rounded">Buy Now</button>
                    </div>
                </div>
            </div>
            <%
                    }
                }
            %>
        </div>
    </div>
    </div>
</div>
</body>
</html>
</body>
</html>
