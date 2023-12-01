package com.example.gym.model;

import com.example.gym.db.DbConnection;
import com.example.gym.dto.PlaceSuplimentsDTO;

import java.sql.Connection;
import java.sql.SQLException;

public class PlaceSuplimentModel {
    private SuplimentsModel suplimentsModel =new SuplimentsModel();
    private InventoryModel inventoryModel = new InventoryModel();
    public boolean placeSupliment(PlaceSuplimentsDTO placesuplimentdto) throws SQLException {
        // System.out.println(placeOrderDto);

        String productName = placesuplimentdto.getProductName();
        String productprice = placesuplimentdto.getProductQTY();

        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isSuplimentsSaved = suplimentsModel.saveSupliments(productName, productprice);
            if (isSuplimentsSaved) {
                boolean isUpdated = inventoryModel.updateItem(placesuplimentdto.getCartTmList());
                if (isUpdated) {
                   // boolean isOrderDetailSaved = orderDetailModel.saveOrderDetails(placeOrderDto.getOrderId(), placeOrderDto.getCartTmList());
                   // if (isOrderDetailSaved) {
                        connection.commit();
                    }
                //}
            }
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }
        return true;

    }
}
