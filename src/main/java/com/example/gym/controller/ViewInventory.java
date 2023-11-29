package com.example.gym.controller;

import com.example.gym.dto.tm.InventoryTM;
import com.example.gym.model.InventoryModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ViewInventory implements Initializable {
    @FXML
    private TableColumn<?, ?> colproductname;

    @FXML
    private TableColumn<?, ?> colproductprice;

    @FXML
    private TableColumn<?, ?> colproductqty;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<InventoryTM> tblInventory;


    public void btnbackonaction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Inventory.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Equipment Page");
        stage.centerOnScreen();


    }
    private void getAll() {
        try {
            List<InventoryTM> dtoList = InventoryModel.getAll();
            ObservableList<InventoryTM> obList = FXCollections.observableArrayList();

            for (InventoryTM dto : dtoList) {
                obList.add(new InventoryTM(
                        dto.getProductName(),
                        dto.getProductQTY(),
                        dto.getProductPrice()
                ));
            }
            tblInventory.setItems(obList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {

        colproductname.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        colproductqty.setCellValueFactory(new PropertyValueFactory<>("ProductQty"));
        colproductprice.setCellValueFactory(new PropertyValueFactory<>("ProductPrice"));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        getAll();
    }
}
