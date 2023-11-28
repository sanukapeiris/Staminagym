package com.example.gym.model;

import com.example.gym.db.DbConnection;
import com.example.gym.dto.ReportDTO;
import com.example.gym.dto.SuplimentsDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SuplimentsModel {
    public static boolean saveSupliments(SuplimentsDTO dto)  throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO supplements VALUES(?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getProductName());
        pstm.setString(2, dto.getProductQTY());



        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }
}
