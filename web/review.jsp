<%-- 
    Document   : review
    Created on : 6 Apr, 2018, 11:32:08 AM
    Author     : Shaiwal Chandra <shaiwal.chandra007@gmail.com>
--%>

<%@page import="clg.project.Options"%>
<%@page import="clg.project.QuizQuestion"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Review</title>
        <%
        ArrayList<QuizQuestion> list=(ArrayList<QuizQuestion>)request.getAttribute("review_question");
        %>
    </head>
    
    <body>
        <h2 style="text-align: center"><u>Exam Review</u></h2>
        <p style="tab-size: 15px;text-align: center">Your Marks <span>${requestScope.result}</span></p>
        <%
            for(QuizQuestion que:list){
        %>
        <div id="main" style=" margin-right: auto; margin-left: auto; width: 800px;">
        <p id="q"><%=que.getQuestion_no()%>. <%=que.getStmt()%></p><br>
        <%
            for(Options op:que.getOptions()){
        %>
        <p id="a" style="left: 20px;margin: 0"><%=op.getAnswer_id()%>. <%=op.getStmt()%></p><br>
        <%}%>
        <p>Correct Answer: <%=que.getCorrect_answer()%></p><br>
        <p>Your Choice: <%if(que.getUserSelected()==-1){%>Nothing Selected<%}else{%><%=que.getUserSelected()%><%}%></p><br>
        <%if(que.getCorrect_answer()==que.getUserSelected()){%>
             <img height="30" width="30" src="images/correct.png" alt="Correct"/>
        <%}else if(que.getUserSelected()>0){%>
            <img height="30" width="30" src="images/wrong.png" alt="Incorrect"/>
            <%}%><hr>
        <%}%>
        
        <p>Thanks for visiting</p>
        <a href="userPage.jsp">Home</a>
        </div>
    </body>
</html>
