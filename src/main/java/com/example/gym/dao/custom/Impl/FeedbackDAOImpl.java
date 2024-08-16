package com.example.gym.dao.custom.Impl;

import com.example.gym.dao.SQLUtil;
import com.example.gym.dao.custom.FeedbackDAO;
import com.example.gym.entity.Feedback;
import com.example.gym.entity.Instructore;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FeedbackDAOImpl implements FeedbackDAO {
    @Override
    public ArrayList<Feedback> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Feedback");
        ArrayList<Feedback> getAllCustomer=new ArrayList<>();
        while (rst.next()){
            Feedback entity=new Feedback(rst.getDate("FeedbackDate").toLocalDate(), rst.getString("FeedbackText"));
            getAllCustomer.add(entity);
        }
        return getAllCustomer;
    }

    @Override
    public boolean save(Feedback entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Feedback (FeedbackDate,FeedbackText) VALUES (?,?)",
                entity.getFeedbackDate(), entity.getFeedbackText());
    }
    @Override
    public boolean update(Feedback entity) throws SQLException, ClassNotFoundException {
        return false;

    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
    @Override
    public Feedback search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Feedback WHERE id=?",id);
        rst.next();
        return new Feedback(rst.getDate("FeedbackDate").toLocalDate(), rst.getString("FeedbackText"));
    }


}
