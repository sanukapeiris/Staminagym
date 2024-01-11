package com.example.gym.dao.custom.Impl;

import com.example.gym.dao.SQLUtil;
import com.example.gym.dao.custom.ReportDAO;
import com.example.gym.entity.Report;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReportDAOImpl implements ReportDAO {
    @Override
    public ArrayList<Report> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Report");
        ArrayList<Report> getAllCustomer=new ArrayList<>();
        while (rst.next()){
            Report entity=new Report(rst.getString("FromDate"), rst.getString("ToDate"), rst.getString("Income"));
            getAllCustomer.add(entity);
        }
        return getAllCustomer;
    }

    @Override
    public boolean save(Report entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Report (FromDate,ToDate,Income) VALUES (?,?,?)",
                entity.getFromDate(), entity.getToDate(), entity.getIncome());
    }
    @Override
    public boolean update(Report entity) throws SQLException, ClassNotFoundException {
        return false;
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
    @Override
    public Report search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Feedback WHERE id=?",id);
        rst.next();
        return new Report(rst.getString("FromDate"), rst.getString("ToDate"), rst.getString("Income"));
    }
}
