<%-- 
    Document   : quizDetails
    Created on : 1 Apr, 2018, 3:49:13 PM
    Author     : RANJEET
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instructions</title>
        <style>
.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 16px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
}

.button1 {
    background-color: white; 
    color: black; 
    border: 2px solid #4CAF50;
}

.button1:hover {
    background-color: #4CAF50;
    color: white;
}
</style>
    </head>
    <body background="${pageContext.request.contextPath}/images/instruction.jpg">
        <h1 style="text-align: center"><b><u>General Instructions</b></u></h1>
        
    <ol type="1">
        <li style="font-size:20px">Total duration of the examination is 20 minutes. Calculator is available on top, right-hand side of the screen.</li>
        <li style="font-size:20px">The clock will be set at the server. The countdown timer at the top, right-hand side of the screen will display the time available for you to complete the examination. When the timer reaches zero, the examination will end automatically. You will not be required to end or submit your examination.</li>
    </li>
    <li style="font-size:20px">Click on the question number in the Question Palette to go to that particular question directly.</li>
    <li style="font-size:20px">To select your answer, click on the button of the corresponding option.</li>
    <li style="font-size:20px">To change your chosen answer, click on the button of the newly identified answer.</li>
    <div  style="position:absolute;left:600px;top:350px">
        <a href="ExamController" class="button button1">Start Exam</a>
        
    </div>
    </body>
</html>
