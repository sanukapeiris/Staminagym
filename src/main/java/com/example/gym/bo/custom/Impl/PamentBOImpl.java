package com.example.gym.bo.custom.Impl;

import com.example.gym.bo.custom.PaymentBO;
import com.example.gym.dao.DAOFactory;
import com.example.gym.dao.custom.PaymentsDAO;
import com.example.gym.dto.PaymentDTO;
import com.example.gym.entity.Payment;

import java.sql.SQLException;
import java.util.ArrayList;

public class PamentBOImpl implements PaymentBO {
    PaymentsDAO membersDAO = (PaymentsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.Payment);

    @Override
    public ArrayList<PaymentDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<PaymentDTO>customerDTOS=new ArrayList<>();
        ArrayList<Payment>customers= membersDAO.getAll();
        for (Payment payment:customers) {
            customerDTOS.add(new PaymentDTO(payment.getMemberID(),payment.getPaymenttype(),payment.getAccountno()));
        }
        return customerDTOS;
    }

    @Override
    public boolean savePayment(PaymentDTO dto) throws SQLException, ClassNotFoundException {
        return membersDAO.save(new Payment(dto.getMemberID(),dto.getPaymenttype(),dto.getAccountno()));
    }

    @Override
    public boolean updatePayment(PaymentDTO dto) throws SQLException, ClassNotFoundException {
        return membersDAO.update(new Payment(dto.getMemberID(),dto.getPaymenttype(),dto.getAccountno()));
    }

    @Override
    public boolean deletePayment(String id) throws SQLException, ClassNotFoundException {
        return membersDAO.delete(id);
    }
}
