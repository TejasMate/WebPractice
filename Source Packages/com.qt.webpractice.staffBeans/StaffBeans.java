/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.webpractice.staffBeans;

/**
 *
 * @author user
 */
public class StaffBeans {

    private int id;
    private String name;
    private String phone_no;
    private String address;
    private String subject;
    private String post;
    private String clg_name;
    private String created_at;
    private String modified_at;

    public StaffBeans(int id, String name, String phone_no, String address, String subject, String post, String clg_name, String created_at, String modified_at) {
        this.id = id;
        this.name = name;
        this.phone_no = phone_no;
        this.address = address;
        this.subject = subject;
        this.post = post;
        this.clg_name = clg_name;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public StaffBeans() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public String getAddress() {
        return address;
    }

    public String getSubject() {
        return subject;
    }

    public String getPost() {
        return post;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setPost(String post) {
        this.post = post;
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

}
