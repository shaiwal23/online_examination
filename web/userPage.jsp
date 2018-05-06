<%-- 
    Document   : userPage
    Created on : Apr 11, 2018, 8:03:30 PM
    Author     : HP
--%>

<%@page import="clg.project.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>User Profile</title>
        <link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="Bootstrap/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="Bootstrap/css/styles.css" rel="stylesheet" type="text/css"/>
	
	<!--Custom Font-->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse"><span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span></button>
				<a class="navbar-brand" href="#"><span>Online</span>Examination</a>
				<ul class="nav navbar-top-links navbar-right">
					<li><a href=""><span class="glyphicon glyphicon-user"></span></a></li>
				</ul>
			</div>
		</div><!-- /.container-fluid -->
	</nav>
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<div class="profile-sidebar">
			
			<div class="profile-usertitle">
                            <%User u=(User)session.getAttribute("user");%>
                            <div class="profile-usertitle-name"><%=u.getF_name()%></div>
				<div class="profile-usertitle-status"><span class="indicator label-success"></span>Online</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="divider"></div>
		
		<ul class="nav menu">
			<li class="active"><a href="userPage.jsp"><em class="glyphicon glyphicon-home">&nbsp;</em>Home</a></li>
                        <li><a href="LeaderBoard" target="box"><em class="glyphicon glyphicon-sort-by-attributes-alt">&nbsp;</em>Leader Board</a></li>
                        <li><a href="#" ><em class="glyphicon glyphicon-book">&nbsp;</em>My Exam</a></li>
                        <li><a href="ProfileController" target="box"><em class="glyphicon glyphicon-list-alt">&nbsp;</em>My Result</a></li>
                        <li><a href="Homepage"><em class="glyphicon glyphicon-plus-sign">&nbsp;</em>Buy Test Series</a></li>
                        
			
			<li><a href="logout"><em class="glyphicon glyphicon-log-out">&nbsp;</em> Logout</a></li>
		</ul>
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
            <iframe src="" name="box" frameBorder="0" width="100%" height="600"></iframe>	
	</div>	<!--/.main-->
	
        <script src="jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="Bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/custom.js"></script>
	
		
</body>
</html>
