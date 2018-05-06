<%-- 
    Document   : courseAvailable
    Created on : Apr 12, 2018, 8:25:45 AM
    Author     : HP
--%>

<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="clg.project.Course"%>
<%@page import="clg.project.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Courses</title>
        <link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="Bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="jquery-3.3.1.min.js" type="text/javascript"></script>
        <link href="Bootstrap/coursePage.css" rel="stylesheet" type="text/css"/>
        <%
    ArrayList<Course> list=(ArrayList)request.getAttribute("list");
    User u=(User)session.getAttribute("user");
%>  
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Online Examination</a>
                </div>
            <% if(u==null){%>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="login.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul><%}else{%>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span><%=u.getF_name()%></a>
                    <ul class="dropdown-menu">
                        <li><a href="userPage.jsp">Dashboard</a></li>
                        <li><a href="">Help</a></li>
                    </ul>
                </li>
                <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
            </ul><%}%>
            </div>
            
        </nav>
 <div class="container">
    <div class="well well-sm">
        <strong>Category Title</strong>
        <div class="btn-group">
            <a href="#" id="list" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-th-list">
            </span>List</a> <a href="#" id="grid" class="btn btn-default btn-sm"><span
                class="glyphicon glyphicon-th"></span>Grid</a>
        </div>
    </div>
     <%
         Set<String> set = new HashSet<String>();
                for (int i = 0; i < list.size(); i++) {
                    set.add(list.get(i).getC_name());
                }
     %>
    <div id="products" class="row list-group">
        <%for(String s:set){
                %>
        <div class="item  col-xs-4 col-lg-4">
            <div class="thumbnail">
                <img class="group list-group-image" src="images/thumbnail_course.jpg" alt="exam" />
                
                <div class="caption">
                    <h4 class="group inner list-group-item-heading">
                        <%=s%></h4>
                        
                        <ul>
                        <%for(Course c:list){
                        if(c.getC_name().equals(s)){%>
                        <p class="group inner list-group-item-text"><a href="takeExam?topic=<%=c.getT_id()%>"><%=c.getT_name()%></a></p>
                        <%}}%>
                        </ul>
                        
                 <!--   <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead">
                                $21.000</p>
                        </div>
                        <div class="col-xs-12 col-md-6">
                            <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                        </div> -->
                    </div>
                </div>
            </div>
        <%}%>
        </div>
    </div>
    <script>
$(document).ready(function() {
    $('#list').click(function(event){event.preventDefault();$('#products .item').addClass('list-group-item');});
    $('#grid').click(function(event){event.preventDefault();$('#products .item').removeClass('list-group-item');$('#products .item').addClass('grid-group-item');});
});
</script>
    </body>
</html>