package com.example.gym.bo.custom.Impl;

import com.example.gym.bo.custom.MemberBO;
import com.example.gym.dao.DAOFactory;
import com.example.gym.dao.custom.MembersDAO;
import com.example.gym.dto.EquipmentDTO;
import com.example.gym.dto.MembersDTO;
import com.example.gym.entity.Member;
import com.example.gym.entity.Member;

import java.sql.SQLException;
import java.util.ArrayList;

public class MemberBOImpl implements MemberBO {
    MembersDAO membersDAO = (MembersDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.Members);

    @Override
    public ArrayList<MembersDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<MembersDTO>customerDTOS=new ArrayList<>();
        ArrayList<Member>customers= membersDAO.getAll();
        for (Member Instructore:customers) {
            customerDTOS.add(new MembersDTO(Instructore.getMemberID(),Instructore.getFirstName(),Instructore.getLastName(),Instructore.getAge(),Instructore.getGender(),Instructore.getBirthDate(),Instructore.getEmail(),Instructore.getContactNo()));
        }
        return customerDTOS;
    }

    @Override
    public boolean saveMembers(MembersDTO dto) throws SQLException, ClassNotFoundException {
        return membersDAO.save(new Member(dto.getMemberID(),dto.getFistName(),dto.getLastName(),dto.getAge(),dto.getGender(),dto.getBirth(),dto.getEmail(),dto.getContactNo()));
    }

    @Override
    public boolean updateMembers(MembersDTO dto) throws SQLException, ClassNotFoundException {
        return membersDAO.update(new Member(dto.getMemberID(),dto.getFistName(),dto.getLastName(),dto.getAge(),dto.getGender(),dto.getBirth(),dto.getEmail(),dto.getContactNo()));
    }

    @Override
    public boolean deleteMembers(String id) throws SQLException, ClassNotFoundException {
        return membersDAO.delete(id);
    }
    @Override
    public MembersDTO search(String MembersId) throws SQLException, ClassNotFoundException {
        Member member =  membersDAO.search(MembersId);
        return new MembersDTO(member.getMemberID(),member.getFirstName(),member.getLastName(),member.getAge(),member.getGender(),member.getBirthDate(),member.getEmail(),member.getContactNo());
    }
}
