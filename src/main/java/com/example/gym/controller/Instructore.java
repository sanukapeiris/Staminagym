package com.example.gym.controller;

import com.example.gym.bo.BOFactory;
import com.example.gym.bo.custom.InstructoreBO;
import com.example.gym.dto.InstructoreDTO;
import com.example.gym.model.InstructionModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private InstructionModel InstructoreModel = new InstructionModel();
    InstructoreBO instructoreBO = (InstructoreBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.Instructore);

    ObservableList<InstructoreDTO> observableList = FXCollections.observableArrayList();

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
        Integer age = Integer.valueOf(txtage.getText());
        String gender = txtgender.getText();
        LocalDate birth = LocalDate.parse(String.valueOf(txtbirth.getValue()));
        String Email = txtEmail.getText();
        String contactno = txtcontactno.getText();



        var dto = new InstructoreDTO(Instructorid,firstname,lastname,age,gender,birth,Email,contactno);

        try {
            boolean isSaved = instructoreBO.saveInstructore(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                clearFields();
            }
        } catch (SQLException | ClassNotFoundException e) {
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
            boolean isDeleted = instructoreBO.deleteInstructore(memberID);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Member deleted!").show();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Member not deleted!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
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
            InstructoreDTO dto = instructoreBO.search(id);
            if(dto!=null){
                viewCustomerReport(dto);
            }
        } catch (SQLException | ClassNotFoundException e) {
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
    @FXML
    void btnupdateonaction(ActionEvent event) {
        String id = txtInstructorid.getText();
        String firstname = txtfirstname.getText();
        String lastname = txtlastname.getText();
        Integer age =  Integer.valueOf(txtage.getText());
        String gender = txtgender.getText();
        LocalDate birth = LocalDate.parse(String.valueOf(txtbirth.getValue()));
        String email = txtEmail.getText();
        String contact = txtcontactno.getText();

        boolean isUpdated = false;
        try {
            isUpdated = instructoreBO.updateInstructore(new InstructoreDTO(id, firstname, lastname, age,gender ,birth,email,contact));
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated successfully").show();
                txtInstructorid.setText("");
                txtfirstname.setText("");
                txtlastname.setText("");
                txtage.setText("");
                txtgender.setText("");
                txtbirth.setValue(LocalDate.parse(""));
                txtEmail.setText("");
                txtcontactno.setText("");
                observableList.clear();

            } else {
                new Alert(Alert.AlertType.ERROR, "Update failed").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /*@FXML
void btnupdateonaction(ActionEvent event) {
    String id = txtmemberid.getText();
    String firstname = txtfirstname.getText();
    String lastname = txtlastname.getText();
    Integer age = Integer.valueOf(txtage.getText());
    String gender = txtgender.getText();
    LocalDate birthdate = LocalDate.parse(String.valueOf(txtbirth.getValue()));
    String email = txtemail.getText();
    String contact = txtcontactno.getText();


    boolean isUpdated = false;
    try {
        isUpdated = MembersModel.updatemember(new MembersDTO(id, firstname, lastname, age,gender ,birthdate,email,contact));
        if (isUpdated) {
            new Alert(Alert.AlertType.CONFIRMATION, "Updated successfully").show();
            txtmemberid.setText("");
            txtfirstname.setText("");
            txtlastname.setText("");
            txtage.setText("");
            txtgender.setText("");
            txtbirth.setValue(LocalDate.parse(""));
            txtemail.setText("");
            txtcontactno.setText("");
            observableList.clear();

        } else {
            new Alert(Alert.AlertType.ERROR, "Update failed").show();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

 */
    @FXML
    public void txtInstructorIdSearchOnAction(ActionEvent actionEvent) {
        String Instructorid = txtInstructorid.getText();

        try {
            InstructoreDTO instructoreDTO= instructoreBO.search(Instructorid);

            if (instructoreDTO != null) {
                txtInstructorid.setText(instructoreDTO.getInstructorID());
                txtfirstname.setText(instructoreDTO.getFistName());
                txtlastname.setText(instructoreDTO.getLastName());
                txtage.setText(String.valueOf(instructoreDTO.getAge()));
                txtgender.setText(instructoreDTO.getGender());
                txtEmail.setText(instructoreDTO.getEmail());
                txtcontactno.setText(instructoreDTO.getContactno());
                txtbirth.setValue(instructoreDTO.getBirth());
            }else {
                new Alert(Alert.AlertType.ERROR,"Invalid ID").show();
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);

        }
    }
}
