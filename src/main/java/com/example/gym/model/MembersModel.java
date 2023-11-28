package com.example.gym.model;

import com.example.gym.db.DbConnection;
import com.example.gym.dto.MembersDTO;
import com.example.gym.dto.tm.MemberTM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MembersModel{
    public static boolean saveMembers(MembersDTO dto)  throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO members VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getMemberID());
        pstm.setString(2, dto.getFistName());
        pstm.setString(3, dto.getLastName());
        pstm.setString(4, dto.getAge());
        pstm.setString(5, dto.getGender());
        pstm.setString(6, dto.getBirth());
        pstm.setString(7, dto.getEmail());
        pstm.setString(8, dto.getContactNo());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }

    public static List<MembersDTO> getAll() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM members";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        List<MembersDTO> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new MembersDTO(
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

    public static MembersDTO search(String membersModel) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM members WHERE code = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, membersModel);

        ResultSet resultSet = pstm.executeQuery();

        MembersDTO dto = null;

        if(resultSet.next()) {
            dto = new MembersDTO(
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
    public static boolean deleteMembers(String memberID) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM members WHERE MemberID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, memberID);

        return pstm.executeUpdate() > 0;
    }

}
