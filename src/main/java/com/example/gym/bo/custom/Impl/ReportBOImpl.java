package com.example.gym.bo.custom.Impl;

import com.example.gym.bo.custom.ReportBO;
import com.example.gym.dao.DAOFactory;
import com.example.gym.dao.custom.ReportDAO;
import com.example.gym.dto.ReportDTO;
import com.example.gym.entity.Report;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReportBOImpl implements ReportBO {
    ReportDAO reportDAO = (ReportDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.Payment);

    @Override
    public ArrayList<ReportDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<ReportDTO>customerDTOS=new ArrayList<>();
        ArrayList<Report>customers= reportDAO.getAll();
        for (Report payment:customers) {
            customerDTOS.add(new ReportDTO(payment.getFromDate(),payment.getToDate(),payment.getIncome()));
        }
        return customerDTOS;
    }

    @Override
    public boolean saveReport(ReportDTO dto) throws SQLException, ClassNotFoundException {
        return reportDAO.save(new Report(dto.getFromDate(),dto.getToDate(),dto.getIncome()));
    }
}
