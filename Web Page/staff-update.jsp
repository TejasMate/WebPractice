<%-- 
    Document   : student-update
    Created on : 25 Jul, 2020, 8:15:06 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Student</title>
        <style>
            form{
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                width: 50%;
                margin-left: 24rem;
            }
            .btn-primary {
                margin-top: 2rem;
                margin-bottom: 2rem;
            }
            input{
                width: 40%;
                background-color: whitesmoke;
            }
            h1{
                display: flex;
                justify-content: center;
                align-items: center;
            }
            .update{
                margin-top: 2rem;
                margin-bottom: 2rem;
            }

        </style>
    </head>
    <body>
        <%@include file="common-header.jsp" %>
        <%@include file="navbar.jsp" %>
        <h1 class="update">Update Staff Details</h1>

        <form action="StaffController" method="get">

            <input type="hidden" name="action" value="update"/>
            <input type="hidden" name="id" value="<%= request.getParameter("id")%>"/>

            <label for="fname">Full Name : </label>
            <input class="form-control" value="<%= request.getParameter("name")%>" id="fname" type="text" name="name" required>

            <label for="PhoneNo">Phone No : </label>
            <input class="form-control" value="<%= request.getParameter("phone_no")%>" id="PhoneNo" type="number" name="phone_no" required>

            <label for="address">Address : </label>
            <input class="form-control" value="<%= request.getParameter("address")%>" id="address" type="text" name="address" required>

            <label for="subject">Subject : </label>
            <input class="form-control" value="<%= request.getParameter("subject")%>" id="subject" type="text" name="subject" required>

            <label for="post">Post : </label>
            <input class="form-control" value="<%= request.getParameter("post")%>" id="post" type="text" name="post" required>

            <label for="college">College Name : </label>
            <input class="form-control" value="<%= request.getParameter("clg_name")%>" id="college" type="text" name="clg_name" required>

            <input class="btn btn-primary" type="submit" value="Update" name="button">

        </form>
        <%@include file="common-footer.jsp" %>
    </body>
</html>
