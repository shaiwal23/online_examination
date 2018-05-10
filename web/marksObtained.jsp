<%-- 
    Document   : marksObtained
    Created on : Apr 11, 2018, 10:13:19 PM
    Author     : HP
--%>


<%@page import="clg.project.User"%>
<%@page import="clg.project.Marks"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="Bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="jquery-3.3.1.min.js" type="text/javascript"></script>
        <%ArrayList<Marks> list=(ArrayList <Marks>)session.getAttribute("marks");
        if(list==null){%><b>No exam given yet</b><%}
        else{
        User u=(User)session.getAttribute("user");%>
    </head>
    <body>
        
        <div class="table-responsive">          
        <table class="table table-fixed table-striped">
            <thead>
                <tr><th>Exam time</th><th>Exam Duration</th><th>Total Marks</th><th>Marks Obtained</th><th>Correct</th><th>Wrong</th><th>Unattempted</th></tr>
            </thead>
            
        <%for(Marks m:list){%>
        <tbody>
    <tr>
        <td><%=m.getExam_time()%></td>
        <td><%=m.getExam_duration()%></td>
        <td><%=m.getTotal_marks()%></td>
        <td><%=m.getMarks_obtained()%></td>
        <td><%=m.getCorrect()%></td>
        <td><%=m.getWrong()%></td>
        <td><%=m.getUnanswered()%></td>
    </tr>
    </tbody>
    <%}%>
        </table>
        </div><%}%>
    </body>
</html>
