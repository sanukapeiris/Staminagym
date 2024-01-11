package com.example.gym.bo.custom;


import com.example.gym.bo.SuperBO;
import com.example.gym.dto.FeedbackDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FeedbackBO extends SuperBO {
    ArrayList<FeedbackDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
    boolean saveFeedback(FeedbackDTO dto) throws SQLException, ClassNotFoundException;

}
