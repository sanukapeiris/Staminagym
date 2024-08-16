package com.example.gym.controller;

import com.example.gym.dto.InstructoreDTO;
import com.example.gym.dto.InventoryDTO;
import com.example.gym.dto.MembersDTO;
import com.example.gym.dto.PaymentDTO;
import com.example.gym.model.InstructionModel;
import com.example.gym.model.InventoryModel;
import com.example.gym.model.MembersModel;
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
import java.time.LocalDate;

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
        String memberID = txtProductName.getText();

        try {
            boolean isDeleted = InventoryModel.deleteInventory(memberID);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Member deleted!").show();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Member not deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void btnbackonaction(ActionEvent actionEvent) throws IOException {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Supliments.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Equipment Page");
            stage.centerOnScreen();
    }
    @FXML
    void btnupdateonaction(ActionEvent event) {
        String name = txtProductName.getText();
        String qyt = txtproductqty.getText();
        String price = txtproductprice.getText();

        boolean isUpdated = false;
        try {
            isUpdated = InventoryModel.updateInventory(new InventoryDTO(name, qyt, price));
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated successfully").show();
                txtProductName.setText("");
                txtproductqty.setText("");
                txtproductprice.setText("");


            } else {
                new Alert(Alert.AlertType.ERROR, "Update failed").show();
            }
        } catch (SQLException e) {
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
    void txtProductNameSearchOnAction(ActionEvent event) {
        String memberid = txtProductName.getText();

        try {
            InventoryDTO inventoryDTO= InventoryModel.search(memberid);

            if (inventoryDTO != null) {
                txtProductName.setText(inventoryDTO.getProductName());
                txtproductqty.setText(inventoryDTO.getProductQty());
                txtproductprice.setText(inventoryDTO.getProductPrice());

            }else {
                new Alert(Alert.AlertType.ERROR,"Invalid ID").show();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}