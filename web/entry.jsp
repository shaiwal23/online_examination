<%-- 
    Document   : entry
    Created on : 30 Mar, 2018, 2:52:53 PM
    Author     : Shaiwal Chandra
--%>

<%@page import="clg.project.Options"%>
<%@page import="clg.project.QuizQuestion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entry</title>
        <script src="jquery.js"></script>
        <script src="jquery-ui.js"></script>
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <style>
            #input{
                border: dashed;
                width:50%;
                padding: 50px 0px 50px 30px;
                
            }
        </style>
    </head>
    
    <body>
        <div id="input">
            <form action="" method="post">
                Course :<input type="text" id="course"><br>
                <div id="test"></div><br>
                Topic: <select id="t_id"></select><br>
                Question:<input type="text" style="height:50px;widht:100px" name="que"><br>
                <input type="submit" value="Done">
            </form>
        </div>
        <script>
           $(function() {
  
                $("#course").keypress(function () {   
                 $.ajax({
                     url:"DropDownTopic",
                     type:"post",
                     data:'',
                  success:function(data){
                      jsonResult = JSON.parse(data);
                        $("test").html('<span>"'+jsonResult+'"</span>');
     
                    },error:  function(data, status, er){
                         console.log(data+"_"+status+"_"+er);
                    },
           
                });
    
                });
 
         }); 
         /*   $(function () {
            var ddlCustomers = $("#c_id");
            ddlCustomers.empty().append('<option selected="selected" value="0" disabled = "disabled">Loading.....</option>');
            $.ajax({
                type: "POST",
                url: "DropDownTopic",
                data: '{}',
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (response) {
                    ddlCustomers.empty().append('<option selected="selected" value="0">Please select</option>');
                    $.each(response, function () {
                        ddlCustomers.append($("<option></option>").val(this['Value']).html(this['Text']));
                    });
                },
                failure: function (response) {
                    alert(response.responseText);
                },
                error: function (response) {
                    alert(response.responseText);
                }
            });
        });*/
        </script>
        <p><%QuizQuestion stmt=(QuizQuestion)session.getAttribute("que");
        out.print(stmt.getStmt());%></p><br>
        <%
            for(Options op:stmt.getOptions()){
                out.print(op.getStmt());
                out.print("<br>");
            }
        %>
    </body>
</html>
