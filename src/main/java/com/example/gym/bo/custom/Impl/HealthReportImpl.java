package com.example.gym.bo.custom.Impl;

import com.example.gym.bo.custom.HealthReportBO;
import com.example.gym.dao.DAOFactory;
import com.example.gym.dao.custom.HealthReportDAO;
import com.example.gym.dao.custom.HealthReportDAO ;
import com.example.gym.dto.HealthReportDTO;
import com.example.gym.entity.HealthReport;

import java.sql.SQLException;
import java.util.ArrayList;

public class HealthReportImpl implements HealthReportBO {
    HealthReportDAO healthReportDAO= (HealthReportDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.HEALTHREPORT);

    @Override
    public ArrayList<HealthReportDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<HealthReportDTO>customerDTOS=new ArrayList<>();
        ArrayList<HealthReport>customers=healthReportDAO.getAll();
        for (HealthReport HealthReport:customers) {
            customerDTOS.add(new HealthReportDTO(HealthReport.getHealthReportID(),HealthReport.getMemberID(),HealthReport.getWeight(),HealthReport.getHeight(),HealthReport.getMedicalCondition(),HealthReport.getBodyFatpercentage()));
        }
        return customerDTOS;
    }

    @Override
    public boolean saveHealthReport(HealthReportDTO dto) throws SQLException, ClassNotFoundException {
        return healthReportDAO .save(new HealthReport(dto.getHealthReportID(),dto.getMemberID(),dto.getWeight(),dto.getHeight(),dto.getMedicalCondition(),dto.getBodyFatpercentage()));
    }

    @Override
    public boolean updateHealthReport(HealthReportDTO dto) throws SQLException, ClassNotFoundException {
        return healthReportDAO .update(new HealthReport(dto.getHealthReportID(),dto.getMemberID(),dto.getWeight(),dto.getHeight(),dto.getMedicalCondition(),dto.getBodyFatpercentage()));
    }

    @Override
    public boolean deleteHealthReport(String id) throws SQLException, ClassNotFoundException {
        return healthReportDAO .delete(id);
    }


}
