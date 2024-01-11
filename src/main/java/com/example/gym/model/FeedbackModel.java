package com.example.gym.model;

import com.example.gym.dao.SQLUtil;
import com.example.gym.db.DbConnection;
import com.example.gym.dto.FeedbackDTO;
import com.example.gym.view.tdm.FeedbackTM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackModel {
    public static boolean saveFeedback(FeedbackDTO feedbackDTO) throws SQLException {
        String sql = "INSERT INTO Feedback(FeedbackDate,FeedbackText) VALUES(?,?)";
        boolean isSaved = SQLUtil.execute(sql, feedbackDTO.getFeedback(),feedbackDTO.getDate());
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
