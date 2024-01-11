package com.example.gym.bo.custom;

import com.example.gym.bo.SuperBO;
import com.example.gym.dto.HealthReportDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface HealthReportBO  extends SuperBO {
    ArrayList<HealthReportDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
    boolean saveHealthReport(HealthReportDTO dto) throws SQLException, ClassNotFoundException;
    boolean updateHealthReport(HealthReportDTO dto) throws SQLException, ClassNotFoundException;
    boolean deleteHealthReport(String id) throws SQLException, ClassNotFoundException;

}
