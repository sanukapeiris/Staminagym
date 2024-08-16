package com.example.gym.bo;

import com.example.gym.bo.custom.Impl.*;
import com.example.gym.dao.SuperDAO;
import com.example.gym.dao.custom.Impl.*;

import static com.example.gym.dao.DAOFactory.DAOTypes.Inventory;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBOFactory(){
        return (boFactory==null)?boFactory=new BOFactory():boFactory;
    }
    public enum BOTypes{
        EQUIPMENT,FEEDBACK,HEALTHREPORT,Instructore,Members,Payment,Report,Inventory
    }
    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case EQUIPMENT:
                return new EquipmentBOImpl();
            case FEEDBACK:
                return new FeedbackBOImpl();
            case HEALTHREPORT:
                return new HealthReportImpl();
            case Instructore:
                return new InstructorBOImpl();
            case Members:
                return new MemberBOImpl();
            case Payment:
                return new PamentBOImpl();
            case Report:
                return new ReportBOImpl();
            case Inventory:
                return new InventoryBOImpl();
            default:
                return null;
        }
    }
}
