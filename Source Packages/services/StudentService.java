/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.webpractice.services;

import com.qt.webpractice.beans.StudentBeans;
import com.qt.webpractice.models.Students;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class StudentService {

    String msg = null;
    Students studentModel = new Students();

    public String save(StudentBeans student) {

        msg = studentModel.save(student);
// System.out.println(student.getName());
        // return "Its Working";
        return msg;
    }

    public ArrayList<StudentBeans> findAll() {
        return studentModel.fetchAll();
    }

    public String delete(StudentBeans student) {
        return studentModel.delete(student.getId());
    }

    public String update(StudentBeans student) {
        return studentModel.update(student);
    }


    public String login(StudentBeans student, HttpServletRequest request) {
 StudentBeans existingStudent = studentModel.findByPhoneNo(student.getPhone_no());
        if (existingStudent.getId() <= 0) {
            msg = "It seems like you are not register yet, or you are provinding wrong phone number";
        } else {
            if (existingStudent.getRoll_no() == student.getRoll_no()) {
               HttpSession session = request.getSession();
               session.setAttribute("phone_no", existingStudent.getPhone_no());
               session.setAttribute("name", existingStudent.getName());
               
                msg = "Login Successfully";
            } else {
                msg = "You entered wrong roll no";
            }
        }
        return msg;
    }

    

}
