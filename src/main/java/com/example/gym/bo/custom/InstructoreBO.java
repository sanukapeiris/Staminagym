package com.example.gym.bo.custom;


import com.example.gym.bo.SuperBO;
import com.example.gym.dto.HealthReportDTO;
import com.example.gym.dto.InstructoreDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface InstructoreBO  extends SuperBO {
    ArrayList<InstructoreDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
    boolean saveInstructore(InstructoreDTO dto) throws SQLException, ClassNotFoundException;
    boolean updateInstructore(InstructoreDTO dto) throws SQLException, ClassNotFoundException;
    boolean deleteInstructore(String id) throws SQLException, ClassNotFoundException;
    InstructoreDTO search(String InstructoreId) throws SQLException, ClassNotFoundException;


}
