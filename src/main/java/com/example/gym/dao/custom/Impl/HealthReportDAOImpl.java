package com.example.gym.dao.custom.Impl;

import com.example.gym.dao.SQLUtil;
import com.example.gym.dao.custom.HealthReportDAO;
import com.example.gym.entity.HealthReport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HealthReportDAOImpl implements HealthReportDAO {
    @Override
    public ArrayList<HealthReport> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Equipment");
        ArrayList<HealthReport> getAllCustomer=new ArrayList<>();
        while (rst.next()){
            HealthReport entity=new HealthReport(rst.getString("HealthReportID"),
                    rst.getString("MemberID"), rst.getString("Weight"),rst.getString("Height"),rst.getString("MedicalCondition"),rst.getString("BodyFatPercentage"));
            getAllCustomer.add(entity);
        }
        return getAllCustomer;
    }

    @Override
    public boolean save(HealthReport entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Equipment (EquipmentID,EquipmentName, EquipmentQty,PurchaseDate) VALUES (?,?,?,?)",
                entity.getHealthReportID(), entity.getMemberID(),entity.getWeight(),entity.getHeight(),entity.getMedicalCondition(),entity.getBodyFatpercentage());
    }
    @Override
    public boolean update(HealthReport entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Equipment SET name=?, address=? WHERE EquipmentID=?",
                entity.getHealthReportID(), entity.getMemberID(),entity.getWeight(),entity.getHeight(),entity.getMedicalCondition(),entity.getBodyFatpercentage());
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Equipment WHERE EquipmentID=?",id);
    }
    @Override
    public HealthReport search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE id=?",id);
        rst.next();
        return new HealthReport(id + "", rst.getString("MemberID"), rst.getString("Weight"),rst.getString("Height"),rst.getString("MedicalCondition"),rst.getString("BodyFatPercentage"));
    }
}
