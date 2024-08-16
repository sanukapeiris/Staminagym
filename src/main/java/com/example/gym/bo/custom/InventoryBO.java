package com.example.gym.bo.custom;

import com.example.gym.bo.SuperBO;
import com.example.gym.dto.InventoryDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface InventoryBO extends SuperBO {
    ArrayList<InventoryDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
    boolean saveInventory(InventoryDTO dto) throws SQLException, ClassNotFoundException;
    boolean updateInventory(InventoryDTO dto) throws SQLException, ClassNotFoundException;
    boolean deleteInventory(String id) throws SQLException, ClassNotFoundException;
    InventoryDTO search(String InventoryId) throws SQLException, ClassNotFoundException;
}
