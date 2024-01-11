package com.example.gym.dao.custom.Impl;

import com.example.gym.dao.SQLUtil;
import com.example.gym.dao.custom.EquipmentDAO;
import com.example.gym.entity.Equipment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EquipmentDAOImpl implements EquipmentDAO {
    @Override
    public ArrayList<Equipment> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Equipment");
        ArrayList<Equipment> getAllCustomer=new ArrayList<>();
        while (rst.next()){
            Equipment entity=new Equipment(rst.getString("EquipmentID"), rst.getString("EquipmentName"),rst.getString("EquipmentQty"),rst.getString("PurchaseDate"));
            getAllCustomer.add(entity);
        }
        return getAllCustomer;
    }

    @Override
    public boolean save(Equipment entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Equipment (EquipmentID,EquipmentName, EquipmentQty,PurchaseDate) VALUES (?,?,?,?)",
                entity.getId(), entity.getName(),entity.getQty(),entity.getDate());
    }
    @Override
    public boolean update(Equipment entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Equipment SET name=?, address=? WHERE EquipmentID=?",
                entity.getId(), entity.getName(),entity.getQty(),entity.getDate());

    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Equipment WHERE EquipmentID=?",id);
    }
    @Override
    public Equipment search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Equipment WHERE EquipmentID=?",id);
        rst.next();
        return new Equipment(id + "", rst.getString("EquipmentName"), rst.getString("EquipmentQty"), rst.getString("PurchaseDate"));
    }
}
