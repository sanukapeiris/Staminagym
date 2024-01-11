package com.example.gym.controller;
import com.example.gym.dto.EquipmentDTO;
import com.example.gym.dto.MembersDTO;
import com.example.gym.model.MembersModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import com.example.gym.dto.PaymentDTO;
import com.example.gym.model.PaymentModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Payment {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtaccountno;


    @FXML
    private ComboBox<String> cmbmemberid;

    @FXML
    private TextField txtpaymenttype;

    private PaymentModel paymentModel = new PaymentModel();

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

        String memberid = cmbmemberid.getValue();
        String paymenttype = txtpaymenttype.getText();
        String accountno = txtaccountno.getText();


        var dto = new PaymentDTO(memberid,paymenttype,accountno);

        try {
            boolean isSaved = PaymentModel.savePayment(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "payment detales!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }



    private void clearFields() {
        cmbmemberid.setPromptText("");
        txtpaymenttype.setText("");
        txtaccountno.setText("");
    }


    public void btndeleteonaction(ActionEvent actionEvent) {
        String memberID = txtaccountno.getText();

        try {
            boolean isDeleted = PaymentModel.deletepayments(memberID);
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
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/ViewPayment.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("ViewPayment");
            stage.centerOnScreen();

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

    public void cmbmemberidonaction(ActionEvent actionEvent) {
        String Memberid = cmbmemberid.getValue();

        try {
            MembersDTO membersDTO = MembersModel.search(Memberid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadMemberId() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<MembersDTO> memberTMS = MembersModel.getAll();

            for (MembersDTO dto : memberTMS) {
                obList.add(dto.getMemberID());
            }
            cmbmemberid.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void btnupdateonaction(ActionEvent event) {
        String id = cmbmemberid.getValue();
        String name = txtpaymenttype.getText();
        String account = txtaccountno.getText();

        var dto = new PaymentDTO(id, name, account);

        try {
            boolean isUpdated = paymentModel.updatepayment(dto);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Equipment updated!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void initialize() {
        loadMemberId();
    }
}