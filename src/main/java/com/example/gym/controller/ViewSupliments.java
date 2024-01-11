package com.example.gym.controller;


import com.example.gym.view.tdm.SuplimentsTM;
import com.example.gym.model.SuplimentsModel;
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

public class ViewSupliments implements Initializable {

    @FXML
    private TableColumn<?, ?> colproductname;

    @FXML
    private TableColumn<?, ?> colproductqty;

    @FXML
    private AnchorPane root;


    @FXML
    private TableView<SuplimentsTM> tblSupliments;;
    public void btnbackaction(ActionEvent actionEvent)  throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Supliments.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("ViewFeedback");
        stage.centerOnScreen();
    }
    private void getAll() {
        try {
            List<SuplimentsTM> dtoList = SuplimentsModel.getAll();
            ObservableList<SuplimentsTM> obList = FXCollections.observableArrayList();

            for (SuplimentsTM dto : dtoList) {
                obList.add(new SuplimentsTM(
                        dto.getProductName(),
                        dto.getProductQTY()

                ));
            }
            tblSupliments.setItems(obList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {

        colproductname.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        colproductqty.setCellValueFactory(new PropertyValueFactory<>("ProductQTY"));

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        getAll();
    }
}
