package com.example.gym.controller;

import com.example.gym.dto.MembersDTO;
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

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
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

}
