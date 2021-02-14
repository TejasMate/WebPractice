/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.webpractice.controllers;

import com.qt.webpractice.beans.StudentBeans;
import com.qt.webpractice.services.StudentService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "StudentController", urlPatterns = {"/StudentController"})
public class StudentController extends HttpServlet {

    StudentService service = new StudentService();
    StudentBeans student = new StudentBeans();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action.equals("insert")) {
            //System.out.println(request.getParameter("name"));
            //System.out.println(request.getParameter("roll_no"));
            //System.out.println(request.getParameter("phone_no"));
            //System.out.println(request.getParameter("address"));
            //System.out.println(request.getParameter("clg_name"));

            student.setName(request.getParameter("name"));
            student.setRoll_no(Integer.parseInt(request.getParameter("roll_no")));
            student.setPhone_no(request.getParameter("phone_no"));
            student.setAddress(request.getParameter("address"));
            student.setBrach(request.getParameter("brach"));
            student.setClg_name(request.getParameter("clg_name"));

            String msg = service.save(student);

            response.sendRedirect("index.jsp?msg=" + msg);

        } else if (action.equals("update")) {
            student.setName(request.getParameter("name"));
            student.setRoll_no(Integer.parseInt(request.getParameter("roll_no")));
            student.setPhone_no(request.getParameter("phone_no"));
            student.setAddress(request.getParameter("address"));
            student.setClg_name(request.getParameter("clg_name"));
            student.setId(Integer.parseInt(request.getParameter("id")));

            String msg = service.update(student);
            response.sendRedirect("index.jsp?msg=" + msg);
        } else if (action.equals("delete")) {
            student.setId(Integer.parseInt(request.getParameter("id")));
            String msg = service.delete(student);
            response.sendRedirect("index.jsp?msg=" + msg);
        } else if (action.equals("login")) {
            student.setPhone_no(request.getParameter("phone"));
            student.setRoll_no(Integer.parseInt(request.getParameter("rollno")));
            String msg = service.login(student, request);
            response.sendRedirect("student-login.jsp?msg=" + msg);
        }

        //System.out.println("hey it is working fine");
        // processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public ArrayList<StudentBeans> findAll() {
        return service.findAll();
    }

}
