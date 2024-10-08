package com.example.gym.controller;

import com.example.gym.bo.BOFactory;
import com.example.gym.bo.custom.HealthReportBO;
import com.example.gym.dto.HealthReportDTO;
import com.example.gym.dto.MembersDTO;
import com.example.gym.model.MembersModel;
import com.example.gym.model.HealthReportModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class HealthReport  {

    private MembersModel membersModel = new MembersModel();


    //public JFXComboBox txtmemberid;
    @FXML
    private AnchorPane root;
    private HealthReportModel HelthModel = new HealthReportModel();


    @FXML
    private TextField txtBodyFatpercentage;

    @FXML
    private TextField txthealthreportid;

    @FXML
    private TextField txtheight;

    @FXML
    private TextField txtmedical;



    @FXML
    private TextField txtweight;

    @FXML
    private ComboBox<String> cmdmemberid;


    //@FXML
    //private JFXComboBox<?> cmdmemberid;
    HealthReportBO healthReportBO = (HealthReportBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.HEALTHREPORT);


    @FXML
    void btnMemberaction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Members.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Equipment Page");
        stage.centerOnScreen();

    }



    @FXML
    void btnReportaction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Report.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Equipment Page");
        stage.centerOnScreen();

    }


    @FXML
    void btnSupplementsonaction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Supliments.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Equipment Page");
        stage.centerOnScreen();

    }

    @FXML
    void btnadminonaction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Admin.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Equipment Page");
        stage.centerOnScreen();
    }

    @FXML
    void btnequipmentonaction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Equipment.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Equipment Page");
        stage.centerOnScreen();
    }


    @FXML
    void btnfeedbackonaction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Feedback.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Equipment Page");
        stage.centerOnScreen();
    }


    @FXML
    void btnhealthreportonaction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/HealthReport.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Equipment Page");
        stage.centerOnScreen();
    }


    @FXML
    void btninstructoronaction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Instructore.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Equipment Page");
        stage.centerOnScreen();
    }


    @FXML
    void btnpaymentonaction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Payment.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Equipment Page");
        stage.centerOnScreen();
    }


    @FXML
    void btnshedualonaction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Equipment Page");
        stage.centerOnScreen();
    }


    public void btnviewonaction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/ViewHealthReport.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("ViewHealthReport");
        stage.centerOnScreen();


    }


    @FXML
    void btnsaveonaction(ActionEvent event) {
        String healthreportid = txthealthreportid.getText();
        String id = cmdmemberid.getValue();
        String Weight = txtweight.getText();
        String Height = txtheight.getText();
        String MedicalCondition = txtmedical.getText();
        String BodyFat = txtBodyFatpercentage.getText();


        var dto = new HealthReportDTO(healthreportid,id,Weight,Height,MedicalCondition,BodyFat);

        try {
            boolean isSaved = healthReportBO.saveHealthReport(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                clearFields();
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void clearFields() {
        cmdmemberid.setValue("");
        txthealthreportid.setText("");
        txtweight.setText("");
        txtheight.setText("");
        txtmedical.setText("");
        txtBodyFatpercentage.setText("");
    }


    public void btndeleteonaction(ActionEvent actionEvent) {
        String HealthreportID = txthealthreportid.getText();

        try {
            boolean isDeleted = healthReportBO.deleteHealthReport(HealthreportID);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Health Report deleted!").show();
            } else {


                new Alert(Alert.AlertType.CONFIRMATION, "Member not deleted!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void cmbmemberidonaction(ActionEvent actionEvent) {
        String Memberid = (String) cmdmemberid.getValue();

        try {
            MembersDTO membersDTO = MembersModel.search(Memberid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadMemberId() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<MembersDTO> memberTMS = membersModel.getAll();

            for (MembersDTO dto : memberTMS) {
                obList.add(dto.getMemberID());
            }
            cmdmemberid.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void btnupdateonaction(ActionEvent event) {
        String Memberid = txthealthreportid.getText();
        String HRid = txthealthreportid.getText();
        String weigh = txtweight.getText();
        String height = txtheight.getText();
        String medical = txtmedical.getText();
        String fat = txtBodyFatpercentage.getText();


        var dto = new HealthReportDTO (Memberid,HRid, weigh, height, medical,fat);

        try {
            boolean isUpdated = healthReportBO.updateHealthReport(dto);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Equipment updated!").show();
                clearFields();
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void txtHealthReportIDSearchOnAction(ActionEvent event) {
        String memberid = txthealthreportid.getText();

        try {
            HealthReportDTO healthReportDTO= healthReportBO.search(memberid);

            if (healthReportDTO != null) {
                cmdmemberid.setValue(healthReportDTO.getMemberID());
                txthealthreportid.setText(healthReportDTO.getHealthReportID());
                txtweight.setText(healthReportDTO.getWeight());
                txtheight.setText(String.valueOf(healthReportDTO.getHeight()));
                txtmedical.setText(healthReportDTO.getMedicalCondition());
                txtBodyFatpercentage.setText(healthReportDTO.getBodyFatpercentage());
            }else {
                new Alert(Alert.AlertType.ERROR,"Invalid ID").show();
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void initialize() {
        loadMemberId();
    }

}