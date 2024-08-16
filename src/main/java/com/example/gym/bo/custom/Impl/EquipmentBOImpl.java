package com.example.gym.bo.custom.Impl;

import com.example.gym.bo.custom.EquipmentBO;
import com.example.gym.dao.DAOFactory;
import com.example.gym.dao.custom.EquipmentDAO;
import com.example.gym.dto.EquipmentDTO;
import com.example.gym.entity.Equipment;

import java.sql.SQLException;
import java.util.ArrayList;

public class EquipmentBOImpl implements EquipmentBO {
    EquipmentDAO equipmentDAO= (EquipmentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EQUIPMENT);
    @Override
    public ArrayList<EquipmentDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<EquipmentDTO>customerDTOS=new ArrayList<>();
        ArrayList<Equipment>customers=equipmentDAO.getAll();
        for (Equipment equipment:customers) {
            customerDTOS.add(new EquipmentDTO(equipment.getId(),equipment.getName(),equipment.getQty(),equipment.getDate()));
        }
        return customerDTOS;
    }

    @Override
    public boolean saveEquipment(EquipmentDTO dto) throws SQLException, ClassNotFoundException {
        return equipmentDAO.save(new Equipment(dto.getEquipmentid(),dto.getEquipmentname(),dto.getEquipmentQTY(),dto.getPurchaseDate()));
    }

    @Override
    public boolean updateEquipment(EquipmentDTO dto) throws SQLException, ClassNotFoundException {
        return equipmentDAO.update(new Equipment(dto.getEquipmentid(),dto.getEquipmentname(),dto.getEquipmentQTY(),dto.getPurchaseDate()));
    }

    @Override
    public boolean deleteEquipment(String id) throws SQLException, ClassNotFoundException {
        return equipmentDAO.delete(id);
    }
    @Override
    public EquipmentDTO search(String EquipmentId) throws SQLException, ClassNotFoundException {
        Equipment  equipment =  equipmentDAO.search(EquipmentId);
        return new EquipmentDTO(equipment.getId(), equipment.getName(), equipment.getQty(), equipment.getDate());
    }




}
