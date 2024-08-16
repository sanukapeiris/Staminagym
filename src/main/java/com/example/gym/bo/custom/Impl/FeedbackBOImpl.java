package com.example.gym.bo.custom.Impl;

import com.example.gym.bo.custom.FeedbackBO;
import com.example.gym.dao.DAOFactory;
import com.example.gym.dao.custom.FeedbackDAO;
import com.example.gym.dao.custom.FeedbackDAO;
import com.example.gym.dto.FeedbackDTO;

import com.example.gym.entity.Feedback;


import java.sql.SQLException;
import java.util.ArrayList;

public class FeedbackBOImpl implements FeedbackBO {
    FeedbackDAO feedbackDAO= (FeedbackDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.FEEDBACK);

    @Override
    public ArrayList<FeedbackDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<Feedback>customers=feedbackDAO.getAll();
        ArrayList<FeedbackDTO>customerDTOS=new ArrayList<>();
        for (Feedback feedback:customers) {
            customerDTOS.add(new FeedbackDTO(feedback.getFeedbackDate(),feedback.getFeedbackText()));
        }
        return customerDTOS;
    }

    @Override
    public boolean saveFeedback(FeedbackDTO dto) throws SQLException, ClassNotFoundException {
        return feedbackDAO.save(new FeedbackDTO(dto.getFeedbackDate(),dto.getFeedback()));
    }
}
