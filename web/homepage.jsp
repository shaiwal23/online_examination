<%-- 
    Document   : homepage
    Created on : 24 Jan, 2018, 7:16:09 PM
    Author     : Shaiwal Chandra
--%>

<%@page import="clg.project.User"%>
<%@page import="clg.project.Course"%>
<%@page import="java.sql.Array"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Course> list=(ArrayList)request.getAttribute("list");
    User u=(User)session.getAttribute("user");
%>   
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Examination</title>
        <link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<link href="Bootstrap/css/homecss.css" rel="stylesheet" type="text/css"/>
		<script src="jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="Bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body background="${pageContext.request.contextPath}/images/front_page.jpg">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Online Examination</a>
                </div>
         <!--   <ul class="nav navbar-nav">
            <%  Set<String> set = new HashSet<String>();
                for (int i = 0; i < list.size(); i++) {
                    set.add(list.get(i).getC_name());
                }
                for(String s:set){
                %>
                <li><a href=""><%=s%></a></li>
            <%}%>  
            </ul>-->
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
            <div class="container" >
            
                <%int counter=0;%>
                <%if(counter%3==0){%><div class="row"><%}%>
                <%for(String s:set){
                %>
                
                <div class="col-md-4" style="height:200px;border: double ">
                <div><a><b><%=s%></b></a>
                    <ul>
                <%for(Course c:list){
                if(c.getC_name().equals(s)){%>
                <li><a href="takeExam?topic=<%=c.getT_id()%>"><%=c.getT_name()%></a></li>
                <%}}counter++;%>
                    </ul>
                </div>
                </div>
                <%}%>
                <%if((counter-1)%3==0){%></div><%}%>
                
                
                <%--        <div class="grid-container">
                <%for(ArrayList s:list){
                ArrayList<String> temp=s;
                String t=(String)temp.get(0);%>
                <div><a><b><%=t%></b></a>
                    <ul>
                <%for(int i=2;i<temp.size();i++){
                String name=(String)temp.get(i);%>
                <li><a href="ExamPage?topic=<%=name%>"><%=name%></a></li>
                <%}%>
                    </ul>
                </div>
<%}%>--%>
            </div>
            </div>
    </body>
</html>
