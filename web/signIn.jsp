<%@include file="boots.jsp"%>
<%@include file="storeNavbar.jsp"%>
<% boolean modal = Boolean.parseBoolean((String) request.getAttribute("modal"));
    if(modal)
    {
%>
<div class="container mt-3 col-6" >
<div class=" alert alert-danger alert-dismissible fade show" role = "alert" >
            Incorrect <strong> email </strong> and <strong> password ! </strong >
    <button type = "button" class="btn-close" data-bs-dismiss = "alert" aria-label = "Close" ></button >
</div >
</div >
<%
    } else {
    %>
    <div class="hidden"></div>
    <%
    }
%>
<div class="container mt-2 bg-light border-light shadow p-3 bg-white rounded col-6 ms-auto">
    <div class="text-start ms-2 ">
        <h2>Login Page</h2>
    </div>
    <form action="/signIn" method="post">
    <div class="text-start ms-2">
        <div class="mt-5">
        <label>Email   </label>
            <input class="ms-auto" type="text" required name="login_email"><br>
        </div>
        <div class="mt-3">
            <label>Password</label>
            <input class="ms-auto" type="password" required name="login_password"><br>
        </div>
        <button class="btn-success btn-sm mt-3">Login</button>
    </div>
    </form>
</div>