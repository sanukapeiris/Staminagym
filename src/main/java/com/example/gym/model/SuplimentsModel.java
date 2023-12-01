package com.example.gym.model;

import com.example.gym.db.DbConnection;
import com.example.gym.dto.ReportDTO;
import com.example.gym.dto.SuplimentsDTO;
import com.example.gym.dto.tm.ReportTM;
import com.example.gym.dto.tm.SuplimentsTM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SuplimentsModel {
    //private SuplimentsModel suplimentsModel =new SuplimentsModel();
   // private InventoryModel inventoryModel = new InventoryModel();
    public static boolean saveSupliments(SuplimentsDTO dto)  throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO supplements VALUES(?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getProductName());
        pstm.setString(2, dto.getProductQTY());



        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }
    public static List<SuplimentsTM> getAll() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM supplements";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        List<SuplimentsTM> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new SuplimentsTM(
                            resultSet.getString(1),
                            resultSet.getString(2)
                    )
            );
        }
        return dtoList;

    }


    public boolean saveSupliments(String productName, String productprice) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO supplements VALUES(?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, productName);
        pstm.setString(2, productprice);


        return pstm.executeUpdate()>0;

    }
}
