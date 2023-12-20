package com.example.gym.controller;

import com.example.gym.dto.EquipmentDTO;
import com.example.gym.dto.InstructoreDTO;
import com.example.gym.dto.MembersDTO;
import com.example.gym.model.EquipmentModel;
import com.example.gym.model.InstructionModel;
import com.example.gym.model.MembersModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.regex.Pattern;

public class Members {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtage;

    @FXML
    private DatePicker txtbirth;

    @FXML
    private TextField txtcontactno;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtfirstname;

    @FXML
    private TextField txtgender;

    @FXML
    private TextField txtlastname;

    @FXML
    private TextField txtmemberid;

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

    @FXML
    void btnsaveonaction(ActionEvent event) {
        boolean isValidated = validateItem();
        if(isValidated) {
            String memberid = txtmemberid.getText();
            String firstname = txtfirstname.getText();
            String lastname = txtlastname.getText();
            String age = txtage.getText();
            String gender = txtgender.getText();
            String birth = String.valueOf(txtbirth.getValue());
            String Email = txtemail.getText();
            String contactno = txtcontactno.getText();


            var dto = new MembersDTO(memberid, firstname, lastname, age, gender, birth, Email, contactno);
            try {
                boolean isSaved = MembersModel.saveMembers(dto);

                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                    clearFields();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }



    private void clearFields() {
        txtmemberid.setText("");
        txtfirstname.setText("");
        txtlastname.setText("");
        txtage.setText("");
        txtgender.setText("");
        txtbirth.setValue(LocalDate.parse(""));
        txtemail.setText("");
        txtcontactno.setText("");

    }
    @FXML
    void btndeleteonaction(ActionEvent event)  {
        String memberID = txtmemberid.getText();

        try {
            boolean isDeleted = MembersModel.deleteMembers(memberID);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Member deleted!").show();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Member not deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


    public void btnviewonaction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/ViewMember.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("ViewMember");
        stage.centerOnScreen();

    }
    private boolean validateItem() {
        String itemId = txtmemberid.getText();
        boolean matches = Pattern.matches("[C][0-9]{3,}",itemId);

        if(!matches){
            new Alert(Alert.AlertType.ERROR, "Invalid item id.").show();
            return false;
        }
        return true;
    }
    @FXML
    void btnPrintOnAction(ActionEvent event) throws JRException {
        String id = txtmemberid.getText();

        try {
            MembersDTO dto = MembersModel.search(id);
            if(dto!=null){
                viewCustomerReport(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void viewCustomerReport(MembersDTO dto) throws JRException {
        HashMap hashMap = new HashMap();
        hashMap.put("id",dto.getMemberID());
        hashMap.put("firstname",dto.getFistName());
        hashMap.put("lastname",dto.getLastName());
        hashMap.put("age",dto.getAge());
        hashMap.put("gender",dto.getGender());
        hashMap.put("Email",dto.getEmail());
        hashMap.put("contactno",dto.getContactNo());
        hashMap.put("birth",dto.getBirth());


        InputStream resourceAsStream =  getClass().getResourceAsStream("/Report/Member_A4_2.jrxml");
        JasperDesign load = JRXmlLoader.load(resourceAsStream);
        JasperReport jasperReport= JasperCompileManager.compileReport(load);

        JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasperReport,
                hashMap,
                new JREmptyDataSource()
        );

        JasperViewer.viewReport(jasperPrint,false);
    }
    @FXML
    void btnupdateonaction(ActionEvent event) {
        String id = txtmemberid.getText();
        String firstname = txtfirstname.getText();
        String lastname = txtlastname.getText();
        String age = txtage.getText();
        String gender = txtgender.getText();
        String email = txtemail.getText();
        String contact = txtcontactno.getText();
        String purchasedate = String.valueOf(txtbirth.getValue());

        var dto = new MembersDTO(id, firstname, lastname, age,gender,email,contact,purchasedate);

        try {
            boolean isUpdated = MembersModel.updatemember(dto);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Equipment updated!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


}
