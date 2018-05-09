<%-- 
    Document   : firstpage
    Created on : 9 May, 2018, 1:18:46 PM
    Author     : Shaiwal Chandra
--%>

<%@page import="clg.project.User"%>
<%@page import="clg.project.DataAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Cookie[] cookies=null;
    String email=null,pass=null;
    cookies=request.getCookies();
    if(cookies!=null){
    for(int i=0;i<cookies.length;i++){
        if(cookies[i].getName().equals("email"))
            email=cookies[i].getValue();
        if(cookies[i].getName().equals("pass"))
            pass=cookies[i].getValue();
    }
    if(pass!=null && email!=null){
        DataAccess da=new DataAccess();
        User u=da.user_login(email,pass);
        session.setAttribute("user",u);
        request.getRequestDispatcher("userPage.jsp").forward(request, response);
    }
    }
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Examination</title>
        <link href="Bootstrap/newcss.css" rel="stylesheet" type="text/css"/>
        <script>
            function singup() {
                window.open("login.jsp","_self");
            }
            function singin() {
                window.open("login.jsp","_self");
            }
 

        
</script>
    </head>
    
    <body style="background-color:violet">
        <div>
            <p class="text">Online Examination</p>
        </div>
        <div class="center">
            <p>ONLINE TEST SERIES</p>
            
            <h6 style="color: black">GATE,ESE/IES,ISRO,CIL,BSNL,IBPS CLERK,IBPS PO,SBI CLERK,IBPS RRB,SBI PO,LIC AAO,SSC CGL,RAILWAY,IAS PRELIMS</h6>
            
        </div>
        
        <button onclick="getElementById('demo').innerHTML= singup()"
                class="button button1">SIGN UP</button>&nbsp;&nbsp;
        <button onclick="getElementById('demo').innerHTML= singin()"
                class="button button2">SIGN IN</button>
        
    </body>
</html>
