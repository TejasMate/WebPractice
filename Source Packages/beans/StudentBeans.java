/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.webpractice.beans;

/**
 *POJO -> Plain old java object
 * DTO -> Data transfer Object
 * @author user
 */
public class StudentBeans {
    private int id;
    private String name;
    private int roll_no;
    private String phone_no;
    private String address;
    private String brach;
    private String clg_name;
    private String created_at;
    private String modified_at;

    public StudentBeans(int id, String name, int roll_no, String phone_no, String address, String brach, String clg_name, String created_at, String modified_at) {
        this.id = id;
        this.name = name;
        this.roll_no = roll_no;
        this.phone_no = phone_no;
        this.address = address;
        this.brach = brach;
        this.clg_name = clg_name;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public StudentBeans() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBrach(String brach) {
        this.brach = brach;
    }

    public void setClg_name(String clg_name) {
        this.clg_name = clg_name;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setModified_at(String modified_at) {
        this.modified_at = modified_at;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public String getAddress() {
        return address;
    }

    public String getBrach() {
        return brach;
    }

    public String getClg_name() {
        return clg_name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getModified_at() {
        return modified_at;
    }

}