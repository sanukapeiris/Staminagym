package com.example.gym.dao;

import com.example.gym.entity.HealthReport;
import com.example.gym.entity.Instructore;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO {
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    boolean save(T dto) throws SQLException, ClassNotFoundException;

    boolean update(T dto) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    public T search(String id) throws SQLException, ClassNotFoundException;
}