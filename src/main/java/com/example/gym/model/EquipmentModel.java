package com.example.gym.model;
import com.example.gym.controller.Equipment;
import com.example.gym.db.DbConnection;
import com.example.gym.dto.EquipmentDTO;
import com.example.gym.dto.MembersDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipmentModel {
    public static boolean saveEquipment(EquipmentDTO dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO equipment VALUES(?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getEquipmentid());
        pstm.setString(2, dto.getEquipmentname());
        pstm.setString(3, dto.getEquipmenttype());
        pstm.setString(4, dto.getPurchaseDate());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }


    public static List<EquipmentDTO> getAll() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM  equipment";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        List<EquipmentDTO> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new EquipmentDTO(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4)
                    )
            );
        }
        return dtoList;

    }

    public static EquipmentDTO search(String equipmentModel) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM equipment WHERE EquipmentID = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, equipmentModel);

        ResultSet resultSet = pstm.executeQuery();

        EquipmentDTO dto = null;

        if(resultSet.next()) {
            String EquipmentId = resultSet.getString(1);
            String EquipmentName = resultSet.getString(2);
            String EquipmentCity = resultSet.getString(3);
            String PurchaseDate = resultSet.getString(4);

            dto = new EquipmentDTO(EquipmentId, EquipmentName,EquipmentCity, PurchaseDate);
        }
        return dto;
    }

    public static boolean deleteEquipment(String memberID)  throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM equipment WHERE EquipmentID  = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, memberID);

        return pstm.executeUpdate() > 0;

    }

    public boolean updateCustomer(EquipmentDTO dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE equipment SET EquipmentName = ?, EquipmentQty = ?, PurchaseDate = ? WHERE EquipmentID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getEquipmentid());
        pstm.setString(2, dto.getEquipmentname());
        pstm.setString(3, dto.getEquipmenttype());
        pstm.setString(4, dto.getPurchaseDate());

        return pstm.executeUpdate() > 0;
    }

}
