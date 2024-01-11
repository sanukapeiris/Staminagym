package com.example.gym.model;

import com.example.gym.dao.SQLUtil;
import com.example.gym.db.DbConnection;
import com.example.gym.dto.InstructoreDTO;
import com.example.gym.view.tdm.InstructoreTM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructionModel {

    public static boolean saveInstruction(InstructoreDTO instructoreDTO) throws SQLException {
        String sql = "INSERT INTO Instructor(InstructorID,FirstName,LastName,Age,Gender,BirthDate,Email,ContactNo) VALUES(?,?,?,?,?,?,?,?)";
        boolean isSaved = SQLUtil.execute(sql, instructoreDTO.getInstructorID(),instructoreDTO.getFistName(),instructoreDTO.getLastName(),instructoreDTO.getAge(),instructoreDTO.getGender(),instructoreDTO.getBirth(),instructoreDTO.getEmail(),instructoreDTO.getContactno());
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
                    resultSet.getInt(4),
                    resultSet.getString(5),
                    resultSet.getDate(6).toLocalDate(),
                    resultSet.getString(7),
                    resultSet.getString(8)
            );
        }
        return dto;
    }

    public static boolean updateInstructore(InstructoreDTO instructoreDTO) throws SQLException {
        String sql = "UPDATE Instructor set FirstName=?,LastName=?,Age=?,Gender=?,BirthDate=?,Email=?,ContactNo=? WHERE InstructorID = ?";
        return SQLUtil.execute(sql,instructoreDTO.getFistName(),instructoreDTO.getLastName(),instructoreDTO.getAge(),instructoreDTO.getGender(),instructoreDTO.getBirth(),instructoreDTO.getEmail(),instructoreDTO.getContactno(),instructoreDTO.getInstructorID());

    }
    public static boolean deleteInstruction(String itemId) throws SQLException {
        String sql = "DELETE FROM Instructor WHERE InstructorID = ?";
        return SQLUtil.execute(sql,itemId);
    }
}
