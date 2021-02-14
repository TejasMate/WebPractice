<%-- 
    Document   : staff-index
    Created on : 25 Jul, 2020, 7:51:29 AM
    Author     : user
--%>


<%@page import="com.qt.webpractice.staffControllers.StaffController"%>
<%@page import="com.qt.webpractice.staffBeans.StaffBeans"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            form{
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                width: 50%;
                margin-left: 24rem;
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
            .btn-primary {
                margin-top: 2rem;
                margin-bottom: 2rem;
            }
            .fill{
                margin-top: 2rem;
            }

        </style>
    </head>
    <body>
        <%@include file="common-header.jsp" %>
        <%@include file="navbar.jsp" %>
        <h1 class="fill">Hello Fill This Form</h1>
        <hr>
        <form action="StaffController" method="get">
            <input type="hidden" name="action" value="insert"/>

            <label for="fname">Full Name : </label>
            <input class="form-control" id="fname" type="text" name="name" required>

            <label for="PhoneNo">Phone No : </label>
            <input class="form-control" id="PhoneNo" type="number" name="phone_no" required>

            <label for="address">Address : </label>
            <input class="form-control" id="address" type="text" name="address" required>

            <label for="subject">Subject : </label>
            <input class="form-control" id="subject" type="text" name="subject" required>

            <label for="post">Post : </label>
            <input class="form-control" id="post" type="text" name="post" required>

            <label for="college">College Name : </label>
            <input class="form-control" id="college" type="text" name="clg_name" required>


            <input class="btn btn-primary" type="submit" value="Add Staff" name="button">

        </form>
        <hr>

        <h1>This is your DATA</h1>
        <br>

        <!--scriplet tag!-->

        <%
            out.print(request.getParameter("msg"));
            out.print("<br>");

        %>
        <%                StaffController staffsController = new StaffController();
            ArrayList<StaffBeans> staffs = staffsController.findAll();
        %>
        <table class="table table-bordered">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Phone No</th>
                <th>Address</th>
                <th>Subject</th>
                <th>Post</th>
                <th>College Name</th>
                <th>Created At</th>
                <th>Modify At</th>
                <th colspan="2">Action</th>

            </tr>
            <%
                for (StaffBeans staff : staffs) {

            %>


            <tr>
                <td><%= staff.getId()%></td>
                <td><%= staff.getName()%></td>
                <td><%= staff.getPhone_no()%></td>
                <td><%= staff.getAddress()%></td>
                <td><%= staff.getSubject()%></td>
                <td><%= staff.getPost()%></td>
                <td><%= staff.getClg_name()%></td>
                <td><%= staff.getCreated_at()%></td>
                <td><%= staff.getModified_at()%></td>
                <td><a href="StaffController?action=delete&id=<%= staff.getId()%>">Delete</a></td>
                <td><a href="staff-update.jsp?id=<%= staff.getId()%>&name=<%= staff.getName()%>&phone_no=<%= staff.getPhone_no()%>&address=<%= staff.getAddress()%>&subject=<%= staff.getSubject()%>&post=<%= staff.getPost()%>&clg_name=<%= staff.getClg_name()%>" target="_blank">Update</a></td>
            </tr>

            <%                }
            %>



        </table>
        <%@include file="common-footer.jsp" %>
    </body>
</html>

