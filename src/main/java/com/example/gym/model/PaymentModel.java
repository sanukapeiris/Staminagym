package com.example.gym.model;

import com.example.gym.dao.SQLUtil;
import com.example.gym.db.DbConnection;
import com.example.gym.dto.PaymentDTO;
import com.example.gym.view.tdm.PaymentTM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentModel {
    /*public static boolean savePayment(PaymentDTO dto)  throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO payment VALUES(?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getMemberID());
        pstm.setString(2, dto.getPaymenttype());
        pstm.setString(3, dto.getAccountno());
        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }

     */
    public static boolean savePayment(PaymentDTO paymentDTO) throws SQLException {
        String sql = "INSERT INTO Payment(MemberID,PaymentType,AccountNo) VALUES(?,?,?)";
        boolean isSaved = SQLUtil.execute(sql, paymentDTO.getMemberID(),paymentDTO.getPaymenttype(),paymentDTO.getAccountno());
        return isSaved;
    }

    public static List<PaymentTM> getAll() throws SQLException {
            Connection connection = DbConnection.getInstance().getConnection();
            String sql = "SELECT * FROM payment";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet resultSet = pstm.executeQuery();

            List<PaymentTM> dtoList = new ArrayList<>();

            while(resultSet.next()) {
                dtoList.add(
                        new PaymentTM(
                                resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getString(3)
                        )
                );
            }
            return dtoList;

        }

    /*public static boolean deletepayments(String memberID)  throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM payment WHERE AccountNo = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, memberID);

        return pstm.executeUpdate() > 0;
    }
     */
    public boolean updatepayment(PaymentDTO dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE payment SET PaymentType = ?, AccountNo = ? WHERE MemberID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getMemberID());
        pstm.setString(2, dto.getPaymenttype());
        pstm.setString(3, dto.getPaymenttype());


        return pstm.executeUpdate() > 0;
    }
    public static boolean deletepayments(String itemId) throws SQLException {
        String sql = "DELETE FROM payment WHERE AccountNo = ?";
        return SQLUtil.execute(sql,itemId);
    }
}
