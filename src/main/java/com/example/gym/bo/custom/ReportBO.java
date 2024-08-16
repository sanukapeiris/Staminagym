package com.example.gym.bo.custom;

import com.example.gym.bo.SuperBO;
import com.example.gym.dto.ReportDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReportBO extends SuperBO {
    ArrayList<ReportDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
    boolean saveReport(ReportDTO dto) throws SQLException, ClassNotFoundException;

}
