package com.example.gym.bo.custom.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import com.example.gym.dao.DAOFactory;
import com.example.gym.db.DbConnection;
import com.example.gym.dto.SuplimentsDTO;


public class SuplimentBOImpl {
    /*OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    @Override
    public boolean placeOrder(SuplimentsDTO suplimentsDTO) throws SQLException {
        String orderId = suplimentsDTO.getProductName();
        String customerId = suplimentsDTO.getProductQTY();

        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isOrderSaved =  orderDAO.saveOrder(orderId, customerId,pickupDate);
            if (isOrderSaved) {
                boolean isUpdated = itemDAO.updateItem(suplimentsDTO.getCartTmList());
                if (isUpdated) {
                    connection.commit();
                }
            }
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }
        return true;
    }

     */
}
