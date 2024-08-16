package com.example.gym.bo.custom;

import com.example.gym.dto.SuplimentsDTO;

import java.sql.SQLException;

public interface SuplimentBO {
    public boolean placeOrder(SuplimentsDTO suplimentsDTO) throws SQLException;
}
