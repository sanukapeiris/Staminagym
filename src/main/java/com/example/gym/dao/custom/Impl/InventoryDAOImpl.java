package com.example.gym.dao.custom.Impl;

import com.example.gym.dao.SQLUtil;
import com.example.gym.dao.custom.InventoryDAO;
import com.example.gym.entity.Instructore;
import com.example.gym.entity.Inventory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InventoryDAOImpl implements InventoryDAO {
    @Override
    public ArrayList<Inventory> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Inventory");
        ArrayList<Inventory> getAllCustomer=new ArrayList<>();
        while (rst.next()){
            Inventory entity=new Inventory(rst.getString("ProductName"), rst.getString("ProductQty"), rst.getString("ProductPrice"));
            getAllCustomer.add(entity);
        }
        return getAllCustomer;
    }

    @Override
    public boolean save(Inventory entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Inventory (InstructorID,FirstName, LastName,Age,Gender ,BirthDate , Email,ContactNo ) VALUES (?,?,?,?,?,?,?,?)",
                entity.getProductName(), entity.getProductQty(),entity.getProductPrice());
    }
    @Override
    public boolean update(Inventory entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Inventory SET FirstName=?, LastName=?, Age=?, Gender=?, BirthDate=?, Email=?, ContactNo=? WHERE InstructorID=?",
                entity.getProductName(), entity.getProductQty(), entity.getProductPrice());
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Inventory WHERE InstructorID=?",id);
    }
    @Override
    public Inventory search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Inventory WHERE InstructorID=?",id);
        rst.next();
        return new Inventory(rst.getString("ProductName"), rst.getString("ProductQty"), rst.getString("ProductPrice"));
    }
}
