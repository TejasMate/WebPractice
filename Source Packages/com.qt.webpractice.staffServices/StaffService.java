/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.webpractice.staffServices;

import com.qt.webpractice.staffBeans.StaffBeans;
import com.qt.webpractice.staffModels.Staffs;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class StaffService {

    String msg = null;
    Staffs staffModel = new Staffs();

    public String save(StaffBeans staff) {

        msg = staffModel.save(staff);
// System.out.println(student.getName());
        // return "Its Working";
        return msg;
    }

    public ArrayList<StaffBeans> findAll() {
        return staffModel.fetchAll();
    }

    public String delete(StaffBeans staff) {
        return staffModel.delete(staff.getId());
    }

    public String update(StaffBeans staff) {
        return staffModel.update(staff);
    }

}
