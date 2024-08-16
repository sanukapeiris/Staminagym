package com.example.gym.bo.custom;

import com.example.gym.bo.SuperBO;
import com.example.gym.dto.HealthReportDTO;
import com.example.gym.dto.PaymentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentBO extends SuperBO {
    ArrayList<PaymentDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
    boolean savePayment(PaymentDTO dto) throws SQLException, ClassNotFoundException;
    boolean updatePayment(PaymentDTO dto) throws SQLException, ClassNotFoundException;
    boolean deletePayment(String id) throws SQLException, ClassNotFoundException;

}
