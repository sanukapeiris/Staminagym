package com.example.gym.bo.custom;

import com.example.gym.bo.SuperBO;
import com.example.gym.dto.MembersDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MemberBO  extends SuperBO {
    ArrayList<MembersDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
    boolean saveMembers(MembersDTO dto) throws SQLException, ClassNotFoundException;
    boolean updateMembers(MembersDTO dto) throws SQLException, ClassNotFoundException;
    boolean deleteMembers(String id) throws SQLException, ClassNotFoundException;

}
