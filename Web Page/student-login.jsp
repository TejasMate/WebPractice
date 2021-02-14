<%-- 
    Document   : student-login
    Created on : 24 Jul, 2020, 3:16:35 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page!</title>
        <style>
            h1{
                display: flex;
               
                justify-content: center;
                align-items: center;
                
            }
            .s{
                 margin-top: 2rem;
                 margin-bottom: 2rem;
            }
            form{
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                width: 50%;
                margin-left: 24rem;
            }
            input{
                width: 10%;
                background-color: whitesmoke;
            } 
            .btn-primary {
                margin-top: 2rem;
               
            }
        </style>

    </head>
    <body>
        <%@include file="common-header.jsp" %>
        <%@include file="navbar.jsp" %>

        <h1 class="s">Student Login!</h1>

        <%
            if (session.getAttribute("name") == null || session.getAttribute("name") == "null") {
        %>

        <form action="StudentController" method="get">
            <input type="hidden" name="action" value="login"/>

            <div>
                <label for="exampleInputphone">Phone No :</label>
                <input class="form-control" name="phone" required="" placeholder="Enter Your Phone NO">

            </div>

            <div>
                <label for="exampleInputRollNo">Roll No :</label>
                <input class="form-control" name="rollno" required="" placeholder="Enter Your RollNo">

            </div>


            <input class="btn btn-primary" type="submit" value="Login"/>
        </form>

        <%
        } else {
        %>

        welcome , <%= session.getAttribute("name")%>
        your phone no is , <%= session.getAttribute("phone_no")%>

        <%
            }
        %>

        <br>
        <%= request.getParameter("msg")%>
        <br>
        <br>
 <%@include file="common-footer.jsp" %>
    </body>
</html>

