package com.example.gym.dao.custom.Impl;

import com.example.gym.dao.SQLUtil;
import com.example.gym.dao.custom.PaymentsDAO;
import com.example.gym.entity.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentsDAO {
    @Override
    public ArrayList<Payment> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Payment");
        ArrayList<Payment> getAllCustomer=new ArrayList<>();
        while (rst.next()){
            Payment entity=new Payment(rst.getString("MemberID"),
                     rst.getString("PaymentType"),rst.getString("AccountNo")

            );
            getAllCustomer.add(entity);
        }
        return getAllCustomer;
    }

    @Override
    public boolean save(Payment entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Payment (MemberID,PaymentType, AccountNo) VALUES (?,?,?)",
                entity.getMemberID(),entity.getPaymenttype(),entity.getAccountno());
    }
    @Override
    public boolean update(Payment entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Payment SET name=?, address=? WHERE MemberID=?",
                entity.getMemberID(),entity.getPaymenttype(),entity.getAccountno());
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Payment WHERE MemberID=?",id);
    }
    @Override
    public Payment search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Payment WHERE MemberID=?",id);
        rst.next();
        return new Payment(id + "", rst.getString("PaymentType"), rst.getString("AccountNo"));
    }
}
