<%@ page import="java.util.ArrayList" %>
<%@ page import="Sprint2.Objects.Languages" %>
<%@ page import="Sprint2.Objects.Publications" %>
            <div class="container">
                <div class="row">
                    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: whitesmoke;">
                        <div class="container-fluid d-flex justify-content-between">
                            <div class="collapse navbar-collapse col-3">
                                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                    <%
                                        ArrayList<Languages> languages = (ArrayList) request.getAttribute("allLang");
                                        if (languages != null) {
                                            for (Languages language : languages) {
                                    %>
                                    <li class="nav-item">
                                        <a class="nav-link fw-bold">"
                                        <%=language.getCode()%></a>
                                    </li>
                                    <%
                                            }
                                        }
                                    %>
                                </ul>
                            </div>
                            <div class="text-center col-7">
                                <a class="navbar-brand fw-bold" href="/"
                                   style="color: darkred;">WORLD NEWS PORTAL</a>
                            </div>
                            <div class="col-2 text-end">
                                <ul class="navbar-nav mb-2 mb-lg-0">
                                    <li class="nav-item">
                                        <a class="nav-link fw-bold" href="#">Current User</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="/">LOGOUT</a>

                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link btn" data-bs-toggle="modal" data-bs-target="#registerModal">SIGN UP</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link btn" data-bs-toggle="modal" data-bs-target="#loginModal">LOGIN</a>
                                    </li>
                                </ul>
                            </div>
                            <div>
                                <button class="navbar-toggler" type="button"
                                        data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                                        aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>
<div class="container">
    <div class="row">
        <nav class="navbar navbar-expand-lg navbar-dark" style="color: white; background-color: #2F4F4F;">
            <div class="container-fluid d-flex justify-content-between">
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <%
                            ArrayList<Publications> publications = (ArrayList) request.getAttribute("allPublications");
                            if (publications != null) {
                                for (Publications publication : publications) {
                        %>
                        <li class="nav-item">
                            <a class="nav-link fw-bold" href="/=<%=publication.getId()%>">
                                <%=publication.getName()%></a>
                        </li>
                        <%
                                }
                            }
                        %>
                    </ul>
                </div>
                <div>
                    <button class="navbar-toggler" type="button"
                            data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </div>
            </div>
        </nav>
    </div>
</div>
