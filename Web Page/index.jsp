<%-- 
    Document   : index
    Created on : 16 Jul, 2020, 3:26:33 PM
    Author     : user
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="com.qt.webpractice.beans.StudentBeans"%>
<%@page import="com.qt.webpractice.controllers.StudentController"%>
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
            .form-control{
                width: 400%;
            }
            .showdata{
                margin-top: 2rem;
            }
            .btn-primary {
                margin-top: 1rem;
                margin-bottom: 2rem;
            }


        </style>
    </head>
    <body>
        <%@include file="common-header.jsp" %>
        <%@include file="navbar.jsp" %>
        <br>
        <h1>Hello Fill This Form</h1>

        <hr>




        <form action="StudentController" method="get">
            <input type="hidden" name="action" value="insert"/>

            <label for="fname">Full Name : </label>
            <input class="form-control" id="fname" type="text" name="name" required>

            <label for="rollno">Roll No : </label>
            <input class="form-control" id="rollno" type="text" name="roll_no" required>

            <label for="PhoneNo">Phone No : </label>
            <input class="form-control" id="PhoneNo" type="number" name="phone_no" required>

            <label for="address">Address : </label>
            <input class="form-control" id="address" type="text" name="address" required>

            <label for="college">College Name : </label>
            <input class="form-control" id="college" type="text" name="clg_name" required>

            <label for="brach">Branch : </label>
            <select name="brach" required="">
                <option value=0>Select Branch</option>
                <option value="cs">Computer</option>
                <option value="ee">Electronic</option>
                <option value="cv">Civil</option>
            </select>
            <br>
            <input class="btn btn-primary" type="submit" value="Add Student" name="button">

        </form>


        <hr>
        <h1 class="showdata">This Is Your DATA</h1>

        <br>

        <!--scriplet tag!-->

        <%
            out.print(request.getParameter("msg"));
            out.print("<br>");

        %>
        <%                StudentController studentsController = new StudentController();
            ArrayList<StudentBeans> students = studentsController.findAll();
        %>
        <table class="table table-bordered">

            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Roll No</th>
                <th>Phone No</th>
                <th>Address</th>
                <th>Branch</th>
                <th>College Name</th>
                <th>Created At</th>
                <th>Modify At</th>
                <th colspan="2">Action</th>

            </tr>
            <%
                for (StudentBeans student : students) {

            %>


            <tr>
                <td><%= student.getId()%></td>
                <td><%= student.getName()%></td>
                <td><%= student.getRoll_no()%></td>
                <td><%= student.getPhone_no()%></td>
                <td><%= student.getAddress()%></td>
                <td><%= student.getBrach()%></td>
                <td><%= student.getClg_name()%></td>
                <td><%= student.getCreated_at()%></td>
                <td><%= student.getModified_at()%></td>
                <td><a href="StudentController?action=delete&id=<%= student.getId()%>">Delete</a></td>
                <td><a href="student-update.jsp?id=<%= student.getId()%>&name=<%= student.getName()%>&roll_no=<%= student.getRoll_no()%>&phone_no=<%= student.getPhone_no()%>&address=<%= student.getAddress()%>&clg_name=<%= student.getClg_name()%>" target="_blank">Update</a></td>
            </tr>

            <%                }
            %>



        </table>
        <%@include file="common-footer.jsp" %>
    </body>
</html>
