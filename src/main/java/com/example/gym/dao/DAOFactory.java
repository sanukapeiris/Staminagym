package com.example.gym.dao;

import com.example.gym.dao.custom.Impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){
    }
    public static DAOFactory getDaoFactory(){
        return (daoFactory==null)?daoFactory=new DAOFactory():daoFactory;
    }
    public enum DAOTypes{
        EQUIPMENT,FEEDBACK,HEALTHREPORT,Instructore,Members,Payment,Report
    }
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
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
