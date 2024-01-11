package com.example.gym.bo.custom.Impl;

import com.example.gym.bo.custom.InstructoreBO;
import com.example.gym.dao.DAOFactory;
import com.example.gym.dao.custom.InstructoreDAO;
import com.example.gym.dto.InstructoreDTO;
import com.example.gym.entity.Instructore;

import java.sql.SQLException;
import java.util.ArrayList;

public class InstructorBOImpl implements InstructoreBO {
    InstructoreDAO InstructorDAO= (InstructoreDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.Instructore);

    @Override
    public ArrayList<InstructoreDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<InstructoreDTO>customerDTOS=new ArrayList<>();
        ArrayList<Instructore>customers=InstructorDAO.getAll();
        for (Instructore Instructore:customers) {
            customerDTOS.add(new InstructoreDTO(Instructore.getInstructorID(),Instructore.getFistName(),Instructore.getLastName(),Instructore.getAge(),Instructore.getGender(),Instructore.getBirth(),Instructore.getEmail(),Instructore.getContactno()));
        }
        return customerDTOS;
    }

    @Override
    public boolean saveInstructore(InstructoreDTO dto) throws SQLException, ClassNotFoundException {
        return InstructorDAO .save(new Instructore(dto.getInstructorID(),dto.getFistName(),dto.getLastName(),dto.getAge(),dto.getGender(),dto.getBirth(),dto.getEmail(),dto.getContactno()));
    }

    @Override
    public boolean updateInstructore(InstructoreDTO dto) throws SQLException, ClassNotFoundException {
        return InstructorDAO .update(new Instructore(dto.getInstructorID(),dto.getFistName(),dto.getLastName(),dto.getAge(),dto.getGender(),dto.getBirth(),dto.getEmail(),dto.getContactno()));
    }

    @Override
    public boolean deleteInstructore(String id) throws SQLException, ClassNotFoundException {
        return InstructorDAO .delete(id);
    }
}
