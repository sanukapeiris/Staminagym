package com.example.gym.controller;

import com.example.gym.dto.InventoryDTO;
import com.example.gym.dto.MembersDTO;
import com.example.gym.dto.PaymentDTO;
import com.example.gym.dto.SuplimentsDTO;
import com.example.gym.dto.tm.InventoryTM;
import com.example.gym.model.InventoryModel;
import com.example.gym.model.MembersModel;
import com.example.gym.model.PaymentModel;
import com.example.gym.model.SuplimentsModel;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Supliment {
    @FXML
    private AnchorPane root;

    @FXML
    private ComboBox<String> cmbproductname;



    @FXML
    private TextField txtproductqty;

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
    public void btndeleteonaction(ActionEvent actionEvent) {
    }


    @FXML
    public void btnviewonaction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/ViewSupliments.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Equipment Page");
        stage.centerOnScreen();
    }

    @FXML
    void btnsaveonaction(ActionEvent event) {
        String ProductName = (String) cmbproductname.getValue();
        String ProductQTY = txtproductqty.getText();


        var dto = new SuplimentsDTO(ProductName,ProductQTY);

        try {
            boolean isSaved = SuplimentsModel.saveSupliments(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "payment detales!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }



    private void clearFields() {
        cmbproductname.setPromptText("");
        txtproductqty.setText("");
    }

    public void btninventoryonaction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Inventory.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Equipment Page");
        stage.centerOnScreen();
    }
    public void cmbmemberidonaction(ActionEvent actionEvent) {
        String Memberid = (String) cmbproductname.getValue();

        try {
                InventoryDTO membersDTO = InventoryModel.search(Memberid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadMemberId() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<InventoryTM> memberTMS = InventoryModel.getAll();

            for (InventoryTM dto : memberTMS) {
                obList.add(dto.getProductName());
            }
            cmbproductname.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void initialize() {
        loadMemberId();
    }
}



