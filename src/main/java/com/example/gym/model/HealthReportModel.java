package com.example.gym.model;

import com.example.gym.dao.SQLUtil;
import com.example.gym.db.DbConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HealthReportModel {
  /*  public static boolean saveHealthReport(HealthReportDTO dto)  throws SQLException {
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

   */
  public static boolean saveHealthReport(HealthReportDTO healthReportDTO) throws SQLException {
      String sql = "INSERT INTO HealthReport(HealthReportID,MemberID,Weight,Height,MedicalCondition,BodyFatPercentage) VALUES(?,?,?,?,?,?)";
      boolean isSaved = SQLUtil.execute(sql, healthReportDTO.getHealthReportID(),healthReportDTO.getMemberID(),healthReportDTO.getWeight(),healthReportDTO.getHeight(),healthReportDTO.getMedicalCondition(),healthReportDTO.getBodyFatpercentage());
      return isSaved;
  }

   /* public static boolean deleteEquipment(String healthreportID) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM healthreport WHERE HealthReportID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, healthreportID);

        return pstm.executeUpdate() > 0;
    }
    */
   public static boolean deletehealthreport(String itemId) throws SQLException {
       String sql = "DELETE FROM healthreport WHERE HealthReportID = ?";
       return SQLUtil.execute(sql,itemId);
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
    public static HealthReportDTO search(String healthreportModel) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM healthreport WHERE HealthReportID = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, healthreportModel);

        ResultSet resultSet = pstm.executeQuery();

        HealthReportDTO dto = null;

        if(resultSet.next()) {
            String Memberid = resultSet.getString(1);
            String Healthreportid = resultSet.getString(2);
            String Weight = resultSet.getString(3);
            String height = resultSet.getString(4);
            String MedicalCondition = resultSet.getString(5);
            String Bodyfatpercentage = resultSet.getString(6);


            dto = new HealthReportDTO(Memberid, Healthreportid,Weight, height,MedicalCondition,Bodyfatpercentage);
        }
        return dto;
    }
}
