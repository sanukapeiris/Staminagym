package com.example.gym.bo.custom.Impl;

import com.example.gym.bo.custom.InventoryBO;
import com.example.gym.dao.DAOFactory;
import com.example.gym.dao.custom.InventoryDAO;
import com.example.gym.dto.EquipmentDTO;
import com.example.gym.dto.InventoryDTO;
import com.example.gym.entity.Inventory;

import java.sql.SQLException;
import java.util.ArrayList;

public class InventoryBOImpl implements InventoryBO {
    InventoryDAO inventoryDAO = (InventoryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.Members);

    @Override
    public ArrayList<InventoryDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<InventoryDTO>customerDTOS=new ArrayList<>();
        ArrayList<Inventory>customers= inventoryDAO.getAll();
        for (Inventory Instructore:customers) {
            customerDTOS.add(new InventoryDTO(Instructore.getProductName(),Instructore.getProductQty(),Instructore.getProductPrice()));
        }
        return customerDTOS;
    }

    @Override
    public boolean saveInventory(InventoryDTO dto) throws SQLException, ClassNotFoundException {
        return inventoryDAO.save(new Inventory(dto.getProductName(),dto.getProductQty(),dto.getProductPrice()));
    }

    @Override
    public boolean updateInventory(InventoryDTO dto) throws SQLException, ClassNotFoundException {
        return inventoryDAO.update(new Inventory(dto.getProductName(),dto.getProductQty(),dto.getProductPrice()));
    }

    @Override
    public boolean deleteInventory(String id) throws SQLException, ClassNotFoundException {
        return inventoryDAO.delete(id);
    }
    @Override
    public InventoryDTO search(String MembersId) throws SQLException, ClassNotFoundException {
        Inventory Instructore =  inventoryDAO.search(MembersId);
        return new InventoryDTO(Instructore.getProductName(),Instructore.getProductQty(),Instructore.getProductPrice());
    }
}

