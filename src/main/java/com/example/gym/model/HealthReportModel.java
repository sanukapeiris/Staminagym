package com.example.gym.model;

import com.example.gym.db.DbConnection;
import com.example.gym.dto.HealthReportDTO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HealthReportModel {
    public static boolean saveHealthReport(HealthReportDTO dto)  throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO healthreport VALUES(?, ?, ?, ?, ?, ?)";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getHealthReportID());
        pstm.setString(2, dto.getMemberID());
        pstm.setString(3, dto.getWeight());
        pstm.setString(4, dto.getHeight());
        pstm.setString(5, dto.getMedicalCondition());
        pstm.setString(6, dto.getBodyFatpercentage());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }
}
