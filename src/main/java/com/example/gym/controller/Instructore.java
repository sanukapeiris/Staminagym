package com.example.gym.controller;

import com.example.gym.dto.InstructoreDTO;
import com.example.gym.dto.MembersDTO;
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

public class Instructore {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtInstructorid;

    @FXML
    private TextField txtage;

    @FXML
    private DatePicker txtbirth;

    @FXML
    private TextField txtcontactno;

    @FXML
    private TextField txtfirstname;

    @FXML
    private TextField txtgender;

    @FXML
    private TextField txtlastname;
    @FXML
    private TextField txtEmail;

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
        String Instructorid = txtInstructorid.getText();
        String firstname = txtfirstname.getText();
        String lastname = txtlastname.getText();
        String age = txtage.getText();
        String gender = txtgender.getText();
        String birth = String.valueOf(txtbirth.getValue());
        String Email = txtEmail.getText();
        String contactno = txtcontactno.getText();



        var dto = new InstructoreDTO(Instructorid,firstname,lastname,age,gender,birth,Email,contactno);

        try {
            boolean isSaved = InstructionModel.saveInstruction(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }



    private void clearFields() {
        txtInstructorid.setText("");
        txtfirstname.setText("");
        txtlastname.setText("");
        txtage.setText("");
        txtgender.setText("");
        txtbirth.setValue(LocalDate.parse(""));
        txtEmail.setText("");
        txtcontactno.setText("");
    }



    public void btndeleteonaction(ActionEvent actionEvent) {
        String memberID = txtInstructorid.getText();

        try {
            boolean isDeleted = InstructionModel.deleteInstruction(memberID);
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
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/ViewInstructor.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("ViewInstructor");
        stage.centerOnScreen();

    }
    @FXML
    void btnPrintOnAction(ActionEvent event) throws JRException {
        String id = txtInstructorid.getText();

        try {
            InstructoreDTO dto = InstructionModel.search(id);
            if(dto!=null){
                viewCustomerReport(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void viewCustomerReport(InstructoreDTO dto) throws JRException {
        HashMap hashMap = new HashMap();
        hashMap.put("id",dto.getInstructorID());
        hashMap.put("firstname",dto.getFistName());
        hashMap.put("lastname",dto.getLastName());
        hashMap.put("age",dto.getAge());
        hashMap.put("gender",dto.getGender());
        hashMap.put("Email",dto.getEmail());
        hashMap.put("contactno",dto.getContactno());
        hashMap.put("birth",dto.getBirth());


        InputStream resourceAsStream =  getClass().getResourceAsStream("/Report/Instructore _A4_2.jrxml");
        JasperDesign load = JRXmlLoader.load(resourceAsStream);
        JasperReport jasperReport= JasperCompileManager.compileReport(load);

        JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasperReport,
                hashMap,
                new JREmptyDataSource()
        );

        JasperViewer.viewReport(jasperPrint,false);
    }

}
