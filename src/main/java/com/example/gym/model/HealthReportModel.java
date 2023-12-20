package com.example.gym.model;

import com.example.gym.db.DbConnection;
import com.example.gym.dto.EquipmentDTO;
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

    public static boolean deleteEquipment(String healthreportID) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM healthreport WHERE HealthReportID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, healthreportID);

        return pstm.executeUpdate() > 0;
    }
    public boolean updateHealth(HealthReportDTO dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE healthreport SET HealthReportID = ?, Weight = ?, Height = ?, MedicalCondition = ?, BodyFatPercentage = ? WHERE MemberID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getMemberID());
        pstm.setString(2, dto.getHealthReportID());
        pstm.setString(3, dto.getWeight());
        pstm.setString(4, dto.getHeight());
        pstm.setString(5, dto.getMedicalCondition());
        pstm.setString(6, dto.getBodyFatpercentage());

        return pstm.executeUpdate() > 0;
    }
}
