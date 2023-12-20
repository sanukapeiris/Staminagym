package com.example.gym.model;

import com.example.gym.db.DbConnection;
import com.example.gym.dto.EquipmentDTO;
import com.example.gym.dto.FeedbackDTO;
import com.example.gym.dto.tm.FeedbackTM;
import com.example.gym.dto.tm.PaymentTM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackModel {
    public static boolean saveFeedback(FeedbackDTO dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO feedback VALUES(?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setDate(1, Date.valueOf(dto.getDate()));
        pstm.setString(2, dto.getFeedback());



        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }


    public static List<FeedbackTM> getAll()  throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM feedback";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        List<FeedbackTM> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new FeedbackTM(
                            resultSet.getString(1),
                            resultSet.getString(2)
                    )
            );
        }
        return dtoList;

    }


}
