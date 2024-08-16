package com.example.gym.bo.custom;

import com.example.gym.bo.SuperBO;
import com.example.gym.dto.EquipmentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EquipmentBO extends SuperBO {
    ArrayList<EquipmentDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
    boolean saveEquipment(EquipmentDTO dto) throws SQLException, ClassNotFoundException;
    boolean updateEquipment(EquipmentDTO dto) throws SQLException, ClassNotFoundException;
    boolean deleteEquipment(String id) throws SQLException, ClassNotFoundException;
    EquipmentDTO search(String EquipmentId) throws SQLException, ClassNotFoundException;

}

