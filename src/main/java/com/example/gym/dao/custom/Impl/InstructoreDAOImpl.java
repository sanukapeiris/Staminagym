package com.example.gym.dao.custom.Impl;

import com.example.gym.dao.SQLUtil;
import com.example.gym.dao.custom.InstructoreDAO;
import com.example.gym.entity.Instructore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InstructoreDAOImpl implements InstructoreDAO {
    @Override
    public ArrayList<Instructore> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Instructor");
        ArrayList<Instructore> getAllCustomer=new ArrayList<>();
        while (rst.next()){
            Instructore entity=new Instructore(rst.getString("InstructorID"),
                    rst.getString("FirstName"), rst.getString("LastName"), rst.getString("Age"), rst.getString("Gender"), rst.getString("BirthDate"), rst.getString("Email"), rst.getString("ContactNo"));
            getAllCustomer.add(entity);
        }
        return getAllCustomer;
    }

    @Override
    public boolean save(Instructore entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Instructor (InstructorID,FirstName, LastName,Age,Gender ,BirthDate , Email,ContactNo ) VALUES (?,?,?,?,?,?,?,?)",
                entity.getInstructorID(), entity.getFistName(),entity.getLastName(),entity.getAge(),entity.getGender(),entity.getEmail(),entity.getContactno(),entity.getBirth());
    }
    @Override
    public boolean update(Instructore entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Instructor SET FirstName=?, LastName=?, Age=?, Gender=?, BirthDate=?, Email=?, ContactNo=? WHERE InstructorID=?",
                entity.getInstructorID(), entity.getFistName(),entity.getLastName(),entity.getAge(),entity.getGender(),entity.getEmail(),entity.getContactno(),entity.getBirth());    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Instructor WHERE InstructorID=?",id);
    }
    @Override
    public Instructore search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Instructor WHERE InstructorID=?",id);
        rst.next();
        return new Instructore(id + "", rst.getString("FirstName"), rst.getString("LastName"), rst.getString("Age"), rst.getString("Gender"), rst.getString("BirthDate"), rst.getString("Email"), rst.getString("ContactNo"));
    }
}
