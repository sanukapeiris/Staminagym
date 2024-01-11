package com.example.gym.model;

import com.example.gym.dao.SQLUtil;
import com.example.gym.db.DbConnection;
import com.example.gym.dto.InventoryDTO;
import com.example.gym.view.tdm.CartTM;
import com.example.gym.view.tdm.InventoryTM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryModel {
    /*public static boolean saveInventory(InventoryDTO dto)  throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO inventory VALUES(?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getProductName());
        pstm.setString(2, dto.getProductQty());
        pstm.setString(3, dto.getProductPrice());
        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }
     */
    public static boolean updateInventory(InventoryDTO inventoryDTO) throws SQLException {
        String sql = "UPDATE item set ProductQty=?,ProductPrice=? WHERE ProductName = ?";
        return SQLUtil.execute(sql,inventoryDTO.getProductQty(),inventoryDTO.getProductPrice(),inventoryDTO.getProductName());

    }
    public static boolean saveInventory(InventoryDTO inventoryDTO) throws SQLException {
        String sql = "INSERT INTO Inventory(ProductName,ProductQty,ProductPrice) VALUES(?,?,?)";
        boolean isSaved = SQLUtil.execute(sql, inventoryDTO.getProductName(),inventoryDTO.getProductQty(),inventoryDTO.getProductPrice());
        return isSaved;
    }
    public static List<InventoryTM> getAll() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM inventory";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        List<InventoryTM> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new InventoryTM(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3)
                    )
            );
        }
        return dtoList;

    }
    public static InventoryDTO search(String membersModel) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM inventory WHERE ProductName = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, membersModel);

        ResultSet resultSet = pstm.executeQuery();

        InventoryDTO dto = null;

        if(resultSet.next()) {
            dto = new InventoryDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)

            );
        }
        return dto;
    }
    public static List<InventoryDTO> loadAllItems() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM inventory";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<InventoryDTO> itemList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            itemList.add(new InventoryDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            ));
        }

        return itemList;
    }
    public boolean updateItem(List<CartTM> cartTmList) throws SQLException {
        for(CartTM tm : cartTmList) {
            System.out.println("Item: " + tm);
            if(!updateQty(tm.getProductname(), tm.getProductQTY())) {
                return false;
            }
        }
        return true;
    }

    public boolean updateQty(String name, int qty) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE inventory SET ProductQty = ProductQty - ? WHERE ProductName = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setInt(1, qty);
        pstm.setString(2, name);

        return pstm.executeUpdate() > 0;//false
    }
    public static boolean deleteInventory(String itemId) throws SQLException {
        String sql = "DELETE FROM inventory WHERE ProductName = ?";
        return SQLUtil.execute(sql,itemId);
    }
}
