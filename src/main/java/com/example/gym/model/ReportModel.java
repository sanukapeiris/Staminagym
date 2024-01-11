package com.example.gym.model;

import com.example.gym.dao.SQLUtil;
import com.example.gym.db.DbConnection;
import com.example.gym.dto.ReportDTO;
import com.example.gym.view.tdm.ReportTM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportModel {
    /*public static boolean saveReport(ReportDTO dto)  throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO report VALUES(?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getFromDate());
        pstm.setString(2, dto.getToDate());
        pstm.setString(3, dto.getIncome());


        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }

     */

    public static boolean saveReport(ReportDTO reportDTO) throws SQLException {
        String sql = "INSERT INTO Report(FromDate,ToDate,Income) VALUES(?,?,?)";
        boolean isSaved = SQLUtil.execute(sql, reportDTO.getFromDate(),reportDTO.getToDate(),reportDTO.getIncome());
        return isSaved;
    }
    public static List<ReportTM> getAll() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM report";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        List<ReportTM> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new ReportTM(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3)
                    )
            );
        }
        return dtoList;

    }
}
