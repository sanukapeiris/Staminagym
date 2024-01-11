package com.example.gym.model;

import com.example.gym.dao.SQLUtil;
import com.example.gym.db.DbConnection;
import com.example.gym.dto.MembersDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MembersModel{
    public static boolean saveMembers(MembersDTO membersDTO) throws SQLException {
        String sql = "INSERT INTO members(MemberID,FirstName,LastName,Age,Gender,BirthDate,Email,ContactNo) VALUES(?,?,?,?,?,?,?,?)";
        boolean isSaved = SQLUtil.execute(sql, membersDTO.getMemberID(),membersDTO.getFistName(),membersDTO.getLastName(),membersDTO.getAge(),membersDTO.getGender(),membersDTO.getBirth(),membersDTO.getEmail(),membersDTO.getContactNo());
        return isSaved;
    }
    public static boolean deleteMembers(String itemId) throws SQLException {
        String sql = "DELETE FROM members WHERE MemberID = ?";
        return SQLUtil.execute(sql,itemId);
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
                            resultSet.getInt(4),
                            resultSet.getString(5),
                            resultSet.getDate(6).toLocalDate(),
                            resultSet.getString(7),
                            resultSet.getString(8)
                    )
            );
        }
        return dtoList;

    }

    public static MembersDTO search(String membersModel) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM members WHERE MemberID = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, membersModel);

        ResultSet resultSet = pstm.executeQuery();

        MembersDTO dto = null;

        if(resultSet.next()) {
            dto = new MembersDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5),
                    resultSet.getDate(6).toLocalDate(),
                    resultSet.getString(7),
                    resultSet.getString(8)
            );
        }
        return dto;
    }

    public static boolean updatemember(MembersDTO membersDTO) throws SQLException {
        String sql = "UPDATE members set FirstName=?,LastName=?,Age=?,Gender=?,BirthDate=?,Email=?,ContactNo=? WHERE MemberID = ?";
        return SQLUtil.execute(sql,membersDTO.getFistName(),membersDTO.getLastName(),membersDTO.getAge(),membersDTO.getGender(),membersDTO.getBirth(),membersDTO.getEmail(),membersDTO.getContactNo(),membersDTO.getMemberID());

    }
}
