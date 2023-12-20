package com.example.gym.controller;

import com.example.gym.dto.InventoryDTO;
import com.example.gym.dto.PaymentDTO;
import com.example.gym.model.InventoryModel;
import com.example.gym.model.PaymentModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class Inventory {

    @FXML
    private TextField txtProductName;

    @FXML
    private TextField txtproductprice;

    @FXML
    private TextField txtproductqty;


    @FXML
    private AnchorPane root;

    public void btnsaveonaction(ActionEvent actionEvent) {
        String productname = txtProductName.getText();
        String productqty = txtproductqty.getText();
        String productprice = txtproductprice.getText();


        var dto = new InventoryDTO(productname,productqty,productprice);

        try {
            boolean isSaved = InventoryModel.saveInventory(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "payment detales!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    private void clearFields() {
        txtProductName.setText("");
        txtproductqty.setText("");
        txtproductprice.setText("");
    }


    public void btnviewonaction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/ViewInventory.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Equipment Page");
        stage.centerOnScreen();
    }

    public void btndeleteonaction(ActionEvent actionEvent) {
    }

    public void btnbackonaction(ActionEvent actionEvent) throws IOException {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Supliments.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Equipment Page");
            stage.centerOnScreen();
    }
}