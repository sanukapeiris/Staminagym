package com.example.gym.dao.custom.Impl;

import com.example.gym.dao.SQLUtil;
import com.example.gym.dao.custom.MembersDAO;
import com.example.gym.entity.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MembersDAOImpl implements MembersDAO {
    @Override
    public ArrayList<Member> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Members");
        ArrayList<Member> getAllCustomer=new ArrayList<>();
        while (rst.next()){
            Member entity=new Member(rst.getString("MemberID"),
                    rst.getString("FirstName"), rst.getString("LastName"), rst.getInt("Age"), rst.getString("Gender"), rst.getString("BirthDate"), rst.getString("Email"), rst.getString("ContactNo"));
            getAllCustomer.add(entity);
        }
        return getAllCustomer;
    }
    @Override
    public boolean save(Member entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Members (MemberID,FirstName, LastName,Age ,Gender ,BirthDate , Email, ContactNo ) VALUES (?,?,?,?,?,?,?,?)",
                entity.getMemberID(), entity.getFirstName(), entity.getLastName(), entity.getAge(), entity.getGender(), entity.getBirthDate(), entity.getEmail(), entity.getContactNo());
    }
    @Override
    public boolean update(Member entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Members SET FirstName=?, LastName=?, Age=?, Gender=?, BirthDate=?, Email=?, ContactNo=? WHERE MemberID=?"
                ,entity.getMemberID(), entity.getFirstName(), entity.getLastName(), entity.getAge(), entity.getGender(), entity.getBirthDate(), entity.getEmail(), entity.getContactNo());

    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Members WHERE MemberID=?",id);
    }
    @Override
    public Member search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Members WHERE MemberID=?",id);
        rst.next();
        return new Member(id + "",rst.getString("FirstName"), rst.getString("LastName"), rst.getInt("Age"), rst.getString("Gender"), rst.getString("BirthDate"), rst.getString("Email"), rst.getString("ContactNo"));
    }

}
