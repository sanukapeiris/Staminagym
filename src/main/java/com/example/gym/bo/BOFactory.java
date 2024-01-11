package com.example.gym.bo;

import com.example.gym.dao.SuperDAO;
import com.example.gym.dao.custom.Impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBOFactory(){
        return (boFactory==null)?boFactory=new BOFactory():boFactory;
    }
    public enum BOTypes{
        EQUIPMENT,FEEDBACK,HEALTHREPORT,Instructore,Members,Payment,Report
    }
    public SuperDAO getBO(BOTypes boTypes){
        switch (boTypes){
            case EQUIPMENT:
                return new EquipmentDAOImpl();
            case FEEDBACK:
                return new FeedbackDAOImpl();
            case HEALTHREPORT:
                return new HealthReportDAOImpl();
            case Instructore:
                return new InstructoreDAOImpl();
            case Members:
                return new MembersDAOImpl();
            case Payment:
                return new PaymentDAOImpl();
            case Report:
                return new ReportDAOImpl();
            default:
                return null;
        }
    }
}
