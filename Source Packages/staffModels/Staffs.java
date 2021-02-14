/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.webpractice.staffModels;

import com.qt.webpractice.database.ApnDb;
import com.qt.webpractice.staffBeans.StaffBeans;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Staffs {

    String msg = null;

    public static final String TABLENAME = "staff";

    public static void main(String[] args) {

    }

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
                System.out.println("Phone No : " + rs.getString("phone_no"));
                System.out.println("Address : " + rs.getString("address"));
                System.out.println("Subject : " + rs.getString("subject"));
                System.out.println("Post : " + rs.getString("post"));
                System.out.println("College Name : " + rs.getString("clg_name"));
                System.out.println("Created At : " + rs.getString("created_at"));
                System.out.println("===========================");
            }
        } catch (SQLException e) {
            System.out.println("com.qt.webpractice.models.Staff.findAll()" + e.getMessage());
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

    public String save(StaffBeans staff) {
        Connection con = ApnDb.connectDb();
        String sqlQuery = "insert into staff(name,phone_no,address,subject,post,clg_name) values(?,?,?,?,?,?)";
        CallableStatement cs = null;
        try {
            cs = con.prepareCall(sqlQuery);
            cs.setString(1, staff.getName());
            cs.setString(2, staff.getPhone_no());
            cs.setString(3, staff.getAddress());
            cs.setString(4, staff.getSubject());
            cs.setString(5, staff.getPost());
            cs.setString(6, staff.getClg_name());
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

    public String update(StaffBeans staff) {
        Connection con = ApnDb.connectDb();
        String sqlQuery = "update " + TABLENAME + " set name = ?, phone_no = ?, address = ?, subject = ?, post = ?, clg_name = ? where id = ?";
        CallableStatement cs = null;
        try {
            cs = con.prepareCall(sqlQuery);
            cs.setString(1, staff.getName());
            cs.setString(2, staff.getPhone_no());
            cs.setString(3, staff.getAddress());
            cs.setString(4, staff.getSubject());
            cs.setString(5, staff.getPost());
            cs.setString(6, staff.getClg_name());
            cs.setInt(7, staff.getId());

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

    public ArrayList<StaffBeans> fetchAll() {
        ArrayList<StaffBeans> staffs = new ArrayList<>();
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
                staffs.add(
                        new StaffBeans(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("phone_no"),
                                rs.getString("address"),
                                rs.getString("subject"),
                                rs.getString("post"),
                                rs.getString("clg_name"),
                                rs.getString("created_at"),
                                rs.getString("modified_at")
                        )
                );
            }
            if (staffs.isEmpty()) {
                System.out.println("No Data Found");
            }
        } catch (SQLException e) {
            System.out.println("com.qt.webpractice.models.Staffs.findAll()" + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
        return staffs;
    }

}
