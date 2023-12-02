package com.example.gym.controller;

import com.example.gym.dto.*;
import com.example.gym.dto.tm.CartTM;
import com.example.gym.dto.tm.InventoryTM;
import com.example.gym.model.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Supliment {
    @FXML
    private AnchorPane root;

    @FXML
    private ComboBox<String> cmbproductname;

    private ObservableList<CartTM> obList = FXCollections.observableArrayList();

    @FXML
    private JFXButton btnAddToCart;
    @FXML
    private TableColumn<?, ?> colqty;

    @FXML
    private TableColumn<?, ?> coltotal;

    @FXML
    private Label lblTotal;
    @FXML
    private Label lblproductprice;
    private PlaceSuplimentModel placeSuplimentModel = new PlaceSuplimentModel();
    private InventoryModel inventoryModel = new InventoryModel();




    @FXML
    private TableColumn<?, ?> colproductname;

    @FXML
    private TableColumn<?, ?> colproductprice;

    @FXML
    private Label lblNetTotal;

    @FXML
    private AnchorPane pane;

    @FXML
    private TableView<CartTM> tblOrderCart;

    @FXML
    private TextField txtQty;


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





    private void clearFields() {
        cmbproductname.setPromptText("");
        txtQty.setText("");
    }

    public void btninventoryonaction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Inventory.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Equipment Page");
        stage.centerOnScreen();
    }
    @FXML
    void cmbproductnameOnAction(ActionEvent event) {
        String productname = (String) cmbproductname.getValue();
        txtQty.requestFocus();

        try {
            InventoryDTO inventoryDTO = InventoryModel.search(productname);
            lblproductprice.setText(inventoryDTO.getProductPrice());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    private void loadMemberId() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<InventoryTM> memberTMS = inventoryModel.getAll();

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
        setCellValueFactory();
    }

    private void setCellValueFactory() {
        colproductname.setCellValueFactory(new PropertyValueFactory<>("Productname"));
        colqty.setCellValueFactory(new PropertyValueFactory<>("ProductQTY"));
        colproductprice.setCellValueFactory(new PropertyValueFactory<>("ProductPrice"));
        coltotal.setCellValueFactory(new PropertyValueFactory<>("total"));


    }

  /*  private void generateNextOrderId() {
        try {
            String orderId = InventoryModel.generateNextOrderId();
            lblOrderId.setText(orderId);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

   */

    private void loadInventoryCodes() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<InventoryTM> itemDtos = inventoryModel.getAll();

            for (InventoryTM dto : itemDtos) {
                obList.add(dto.getProductName());
            }
            cmbproductname.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadCustomerIds() {
        ObservableList<String> obList = FXCollections.observableArrayList();

        try {
            List<MembersDTO> idList = MembersModel.getAll();

            for (MembersDTO dto : idList) {
                obList.add(dto.getMemberID());
            }

            cmbproductname.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
        String productname = cmbproductname.getValue();
        int qty = Integer.parseInt(txtQty.getText());
        double productprice = Double.parseDouble(lblproductprice.getText());
        double tot = productprice * qty;

        //setRemoveBtnAction(btn);
        //btn.setCursor(Cursor.HAND);


        if (!obList.isEmpty()) {
            for (int i = 0; i < tblOrderCart.getItems().size(); i++) {
                if (colproductname.getCellData(i).equals(productname)) {
                    int col_qty = (int) colqty.getCellData(i);
                    qty += col_qty;
                    tot = productprice * qty;

                    obList.get(i).setProductQTY(qty);
                    obList.get(i).setTotal(tot);

                    calculateTotal();
                    tblOrderCart.refresh();
                    return;
                }
            }
        }
        var cartTM = new CartTM(productname, qty , productprice , tot );

        obList.add(cartTM);

        tblOrderCart.setItems(obList);
        calculateTotal();
        txtQty.clear();
    }
    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {
        String productname =cmbproductname.getValue();
        String productprice = lblproductprice.getText();

        List<CartTM> cartTmList = new ArrayList<>();
        for (int i = 0; i < tblOrderCart.getItems().size(); i++) {
            CartTM cartTm = obList.get(i);

            cartTmList.add(cartTm);
        }

        System.out.println("Place order form controller: " + cartTmList);
        var placesuplimentdto = new PlaceSuplimentsDTO(productname,productprice, cartTmList);
        try {
            boolean isSuccess = placeSuplimentModel.placeSupliment(placesuplimentdto);
            if (isSuccess) {
                new Alert(Alert.AlertType.CONFIRMATION, "Order Success!").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void calculateTotal() {
        double total = 0;
        for (int i = 0; i < tblOrderCart.getItems().size(); i++) {
            total += (double) coltotal.getCellData(i);
        }
        lblNetTotal.setText(String.valueOf(total));
    }

    public void txtQtyOnAction(ActionEvent actionEvent) {
    }

    public void btnNewCustomerOnAction(ActionEvent actionEvent) {
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
    }
}



