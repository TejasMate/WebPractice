/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.webpractice.models;

import com.qt.webpractice.beans.StudentBeans;
import com.qt.webpractice.database.ApnDb;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Students {

    String msg = null;

    public static final String TABLENAME = "tbl_student";

    public static void findAll() {
        //step 1: To make the connection between the database
        Connection con = ApnDb.connectDb();
        String sqlQuery = "select * from " + TABLENAME;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            //step 2: Creating mysql statements
            cs = con.prepareCall(sqlQuery);
            //step 3: Executing mysql query in database
            rs = cs.executeQuery();
            while (rs.next()) {
                //step 4: Viewing the resulting record
                System.out.println("Id : " + rs.getInt("id"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Roll No : " + rs.getInt("roll_no"));
                System.out.println("Phone No : " + rs.getString("phone_no"));
                System.out.println("Address : " + rs.getString("address"));
                System.out.println("College Name : " + rs.getString("clg_name"));
                System.out.println("Created At : " + rs.getString("created_at"));
                System.out.println("===========================");
            }
        } catch (SQLException e) {
            System.out.println("com.qt.webpractice.models.Students.findAll()" + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }

    }

    public ArrayList<StudentBeans> fetchAll() {
        ArrayList<StudentBeans> students = new ArrayList<>();
        //step 1: To make the connection between the database
        Connection con = ApnDb.connectDb();
        String sqlQuery = "select * from " + TABLENAME;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            //step 2: Creating mysql statements
            cs = con.prepareCall(sqlQuery);
            //step 3: Executing mysql query in database
            rs = cs.executeQuery();
            while (rs.next()) {
                students.add(
                        new StudentBeans(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("roll_no"),
                                rs.getString("phone_no"),
                                rs.getString("address"),
                                rs.getString("brach"),
                                rs.getString("clg_name"),
                                rs.getString("created_at"),
                                rs.getString("modified_at")
                        )
                );
            }
            if (students.isEmpty()) {
                System.out.println("No Data Found");
            }
        } catch (SQLException e) {
            System.out.println("com.qt.webpractice.models.Students.findAll()" + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
        return students;
    }

    public static void save() {
        Connection con = ApnDb.connectDb();
        String sqlQuery = "insert into tbl_student(name,roll_no,phone_no,address,brach) values(?,?,?,?,?)";
        CallableStatement cs = null;
        try {
            cs = con.prepareCall(sqlQuery);
            cs.setString(1, "ABCD");
            cs.setInt(2, 50);
            cs.setString(3, "+912345678987");
            cs.setString(4, "Mankapur, Nagpur");
            cs.setString(5, "cs");
            int rows = cs.executeUpdate();
            if (rows >= 1) {
                System.out.println("Data inserted sucessfully");
            }
        } catch (SQLException e) {
            System.out.println("Unable to insert because of : " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                    System.out.println("Connection closed");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public static void main(String[] args) {
        save();
        findAll();
    }

    public String save(StudentBeans student) {
        Connection con = ApnDb.connectDb();
        String sqlQuery = "insert into tbl_student(name,roll_no,phone_no,address,brach,clg_name) values(?,?,?,?,?,?)";
        CallableStatement cs = null;
        try {
            cs = con.prepareCall(sqlQuery);
            cs.setString(1, student.getName());
            cs.setInt(2, student.getRoll_no());
            cs.setString(3, student.getPhone_no());
            cs.setString(4, student.getAddress());
            cs.setString(5, student.getBrach());
            cs.setString(6, student.getClg_name());
            int rows = cs.executeUpdate();
            if (rows >= 1) {
                msg = "Data inserted sucessfully";
            }
        } catch (SQLException e) {
            msg = "Unable to insert because of : " + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                    System.out.println("Connection closed");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
        return msg;
    }

    public String delete(int id) {
        Connection con = ApnDb.connectDb();
        String sqlQuery = "delete from " + TABLENAME + " where id = ?";
        CallableStatement cs = null;
        try {
            cs = con.prepareCall(sqlQuery);
            cs.setInt(1, id);
            int rows = cs.executeUpdate();
            if (rows >= 1) {
                msg = "Value delete with ID : " + id + " successfully!";
            }
        } catch (SQLException e) {
            msg = "Unable to delete because of : " + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                    System.out.println("Connection closed");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
        return msg;
    }

    public String update(StudentBeans student) {
        Connection con = ApnDb.connectDb();
        String sqlQuery = "update " + TABLENAME + " set name = ?, roll_no = ?, phone_no = ?, address = ?, clg_name = ? where id = ?";
        CallableStatement cs = null;
        try {
            cs = con.prepareCall(sqlQuery);
            cs.setString(1, student.getName());
            cs.setInt(2, student.getRoll_no());
            cs.setString(3, student.getPhone_no());
            cs.setString(4, student.getAddress());
            cs.setString(5, student.getClg_name());
            cs.setInt(6, student.getId());

            int rows = cs.executeUpdate();
            if (rows >= 1) {
                msg = "Value updated successfully!";
            }
        } catch (SQLException e) {
            msg = "Unable to update because of : " + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                    System.out.println("Connection closed");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
        return msg;
    }

    public StudentBeans findByPhoneNo(String phone_no) {
        StudentBeans returnStudent = new StudentBeans();
        //step 1: To make the connection between the database
        Connection con = ApnDb.connectDb();
        String sqlQuery = "select * from " + TABLENAME + " where phone_no = ?";
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            //step 2: Creating mysql statements
            cs = con.prepareCall(sqlQuery);
            cs.setString(1, phone_no);

            //step 3: Executing mysql query in database
            rs = cs.executeQuery();
            while (rs.next()) {
                //step 4: Viewing the resulting record
                returnStudent = new StudentBeans(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("roll_no"),
                        rs.getString("phone_no"),
                        rs.getString("address"),
                        rs.getString("brach"),
                        rs.getString("clg_name"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                );

            }
        } catch (SQLException e) {
            System.out.println("com.qt.webpractice.models.Students.findByPhoneNo()"+e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
        return returnStudent;
    }
}
