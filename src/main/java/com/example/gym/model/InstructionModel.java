package com.example.gym.model;

import com.example.gym.db.DbConnection;
import com.example.gym.dto.EquipmentDTO;
import com.example.gym.dto.InstructoreDTO;
import com.example.gym.dto.MembersDTO;
import com.example.gym.dto.tm.InstructoreTM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructionModel {
    public static boolean saveInstruction(InstructoreDTO dto)  throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO instructor VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getInstructorID());
        pstm.setString(2, dto.getFistName());
        pstm.setString(3, dto.getLastName());
        pstm.setString(4, dto.getAge());
        pstm.setString(5, dto.getGender());
        pstm.setString(6, dto.getBirth());
        pstm.setString(7, dto.getEmail());
        pstm.setString(8, dto.getContactno());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }

    public static List<InstructoreTM> getAll()  throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM instructor";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        List<InstructoreTM> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new InstructoreTM(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8)
                    )
            );
        }
        return dtoList;


    }

    public static boolean deleteInstruction(String memberID) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM instructor WHERE InstructorID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, memberID);

        return pstm.executeUpdate() > 0;
    }

    public static InstructoreDTO search(String instructoremodel) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM instructor WHERE InstructorID = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, instructoremodel);

        ResultSet resultSet = pstm.executeQuery();

        InstructoreDTO dto = null;

        if(resultSet.next()) {
            dto = new InstructoreDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8)
            );
        }
        return dto;
    }
    public static boolean updateInstructore(InstructoreDTO dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE instructor SET EquipmentName = ?, EquipmentQty = ?, PurchaseDate = ? WHERE EquipmentID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getInstructorID());
        pstm.setString(2, dto.getFistName());
        pstm.setString(3, dto.getLastName());
        pstm.setString(4, dto.getGender());
        pstm.setString(4, dto.getEmail());
        pstm.setString(4, dto.getContactno());
        pstm.setString(4, dto.getBirth());



        return pstm.executeUpdate() > 0;
    }
}
