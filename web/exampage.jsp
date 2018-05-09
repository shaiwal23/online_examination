<%-- 
    Document   : exampage
    Created on : 30 Jan, 2018, 12:47:33 PM
    Author     : Shaiwal Chandra
--%>

<%@page import="clg.project.User"%>
<%@page import="clg.project.Options"%>
<%@page import="clg.project.QuizQuestion"%>
<%@page import="clg.project.Question"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exam Page</title>
        <script src="Bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
          <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
          <script src="jquery-ui.js"></script>
        <style>
            .grid-container {
                 display: grid;
                grid-template-columns: repeat(4, 1fr);
                grid-gap: 5px;
                background-color: #2196F3;
                 padding: 10px;
            }
            .grid-container > input {
                 background-color: rgba(255, 255, 255, 0.8);
                 border: 1px solid black;
                text-align: center;
                font-size: 20px;
            }
            
        </style>
        <script>
            var time;
            var min='${sessionScope.min}';
            var sec='${sessionScope.sec}';
            
            function customSubmit(){
               document.questionForm.minute.value=min;
               document.questionForm.second.value=sec;
               document.questionForm.submit();
            }
            function customSubmit2(){
               document.grid_q.minute.value=min;
               document.grid_q.second.value=sec;
               document.grid_q.submit;
            }
            function examTimer(){
                if(parseInt(sec)>0){
                    document.getElementById("showtime").innerHTML = "Time Remaining :"+min+" Minute ," + sec+" Sec";
                    sec = parseInt(sec) - 1;                
                    time = setTimeout("examTimer()", 1000);
                }
                else {
			
			    if (parseInt(min)==0 && parseInt(sec)==0){
			    	document.getElementById("showtime").innerHTML = "Time Remaining :"+min+" Minute ," + sec+" Sec";
				     alert("Time Up");
				     document.questionForm.minute.value=0;
				     document.questionForm.second.value=0;
				     document.questionForm.submit();
					 
			     }
				 
                            if (parseInt(sec) == 0) {				
				    document.getElementById("showtime").innerHTML = "Time Remaining :"+min+" Minute ," + sec+" Sec";					
                                    min = parseInt(min) - 1;
					sec=59;
                                    time = setTimeout("examTimer()", 1000);
                }
               
            }
            }
        </script>    
    </head>
    <body onload="examTimer()">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                   <span class="icon-bar"></span>                        
                </button>
            <a class="navbar-brand" href="#">Hello</a>
            </div>
        <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
        <li class="active"><a href="Homepage">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Projects</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
          <%User u=(User)session.getAttribute("user");%>
        <li><a href="#"><span class="glyphicon glyphicon-user"></span><%= u.getF_name()%></a></li>
      </ul>
    </div>
  </div>
</nav>
      <div class="container-fluid text-center">    
  <div class="row content">
    <div  style="background-image:url(images/front_page.jpg);background-size:100% 100%" class="col-sm-2 sidenav">
        <form name="grid_q" action="ExamController" method="post">
        <div class="grid-container">
            
            <%for(int i=1;i<=(Integer)request.getSession().getAttribute("total_question");i++){%>
            
            
                <input onclick="customSubmit2()" type="submit" name="q_no" value='<%=i%>'/>    
           
            
            <%}%>
            <input type="hidden" name="minute"/> 
            <input type="hidden" name="second"/>
            
        </div>
        </form>
    </div>
    <div class="col-sm-8 text-center"> 
        <div>
        <nav class="navbar navbar-default">
            <p class="navbar-text navbar-left">Current Question ${sessionScope.que.question_no} / ${sessionScope.total_question}</p>
            <p id="showtime" class="navbar-text navbar-right">
        </nav>
        </div>

    
    <div style="text-align: left" class="jumbotron">
       
        <span>${sessionScope.que.stmt}</span><br/><br/>

    <form action="ExamController" method="post" name="questionForm" >
        <%  
            QuizQuestion q=(QuizQuestion)session.getAttribute("que");
            int t_q=(Integer)session.getAttribute("total_question");
            ArrayList<Options> list=q.getOptions();
            for(Options op:list){%>
    
    <input type="radio" name="answer" <%if((q.getUserSelected()>0)&&(q.getUserSelected()==op.getAnswer_id())){%> checked <%}%> value="<%=op.getAnswer_id()%>"><%=op.getStmt()%> <br/>
    <%}%>
   
    </div>
    <div class="btn-group btn-group-justified" role="group" aria-label="...">
 
    <%int q_no=q.getQuestion_no();
        if(q_no>1){%>
    <div class="btn-group" role="group">
        <input type="submit" class="btn btn-default" name="action" value="Previous" onclick="customSubmit()" />
        <%}%>
    </div>
    <div class="btn-group" role="group">
        <input  type="submit" class="btn btn-default" name="action" value="Submit" onclick="customSubmit()">
    </div>
    <div class="btn-group" role="group">
        <%if(q_no<t_q){%>
        <input type="submit" class="btn btn-default" name="action" value="Next" onclick="customSubmit()" />
        <%}%>
    </div>
    </div>
    <input type="submit" class="btn btn-primary btn-lg" name="action" value="Finish Exam" onclick="customSubmit()" />
    
    <input type="hidden" name="minute"/> 
    <input type="hidden" name="second"/>

    </form>

    
        
    
  </div>
    <div class="col-sm-2 sidenav">
            <button onclick="calc()"style="float: right">Calculator</button>
            <div style="float: right;display: none"id="calculator"><%@include file="calculator.html"  %></div>
        
    </div>
        </div>
      </div>
        <script>
            function calc(){
                var a=document.getElementById("calculator");
                if(a.style.display=== "none")
                    a.style.display="block";
                else
                    a.style.display="none";
            }
        </script>
    </body>
</html>
