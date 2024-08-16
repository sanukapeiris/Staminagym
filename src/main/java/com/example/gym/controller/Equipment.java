package com.example.gym.controller;

import com.example.gym.bo.BOFactory;
import com.example.gym.bo.custom.EquipmentBO;
import com.example.gym.dto.EquipmentDTO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
import java.util.regex.Pattern;

public class Equipment {
    @FXML
    private TableColumn<?, ?> colEquipmentID;

    @FXML
    private TableColumn<?, ?> colEquipmentName;

    @FXML
    private TableColumn<?, ?> colEquipmentQTY;

    @FXML
    private TableColumn<?, ?> colPurchaseDatr;
    @FXML
    private TableView<?> tblEquipment;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtEquipmentid;

    @FXML
    private TextField txtEquipmentname;

    @FXML
    private TextField txtEquipmenttype;

    @FXML
    private DatePicker txtpurchasedate;
    EquipmentBO equipmentBO = (EquipmentBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.EQUIPMENT);


    ObservableList<EquipmentDTO> observableList = FXCollections.observableArrayList();



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

    /*public void btnsaveonaction(ActionEvent actionEvent) {
        String id = txtEquipmentid.getText();
        String name = txtEquipmentname.getText();
        String type = txtEquipmenttype.getText();
        String date = String.valueOf(txtpurchasedate.getValue());

        if (!name.matches("[E][0-9]{3,}")) {
            new Alert(Alert.AlertType.ERROR, "Invalid ID").show();
            txtEquipmentid.requestFocus();
            return;
        } else if (!type.matches("[0-50]")) {
            new Alert(Alert.AlertType.ERROR, "Name is too long").show();
            txtEquipmenttype.requestFocus();
            return;
        }

        if (btnSave.getText().equalsIgnoreCase("save")) {
            /*Save Customer*/
           /* try {
                if (existEquipment(id)) {
                    new Alert(Alert.AlertType.ERROR, id + " already exists").show();
                }
                EquipmentDTO equipmentDTO = new EquipmentDTO(id, name, type,date);
                boolean isSaved = Equipment.saveCustomer(equipmentDTO);
                if (isSaved) {
                    tblEquipment.getItems().add(new EquipmentTM(id, name, type,date));
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to save the customer " + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        } else {
            /*Update customer*/
           /* try {
                if (!existEquipment(id)) {
                    new Alert(Alert.AlertType.ERROR, "There is no such customer associated with the id " + id).show();
                }
                customerBO.updateCustomer(new EquipmentDTO(id, name, type,date));
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to update the customer " + id + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            EquipmentTM selectedEquipment = tblEquipment.getSelectionModel().getSelectedItem();
            selectedEquipment.setEquipmentid(id);
            selectedEquipment.setEquipmentname(name);
            selectedEquipment.setEquipmenttype(type);
            selectedEquipment.setEquipment
            tblEquipment.refresh();
        }
    }
    */


     @FXML
     void btnsaveonaction(ActionEvent event) {
         boolean isValidated = validateItem();
         if (isValidated) {

             String id = txtEquipmentid.getText();
             String name = txtEquipmentname.getText();
             String type = txtEquipmenttype.getText();
             String date = String.valueOf(txtpurchasedate.getValue());

             var dto = new EquipmentDTO(id, name, type, date);

             try {
                 boolean isSaved = equipmentBO.saveEquipment(new EquipmentDTO(id,name,type,date));

                 if (isSaved) {
                 } else {
                     new Alert(Alert.AlertType.ERROR, "Not saved  !!!").show();
                 }
             } catch (SQLException | ClassNotFoundException e) {
                 new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
             }
         }
     }



    private void clearFields() {
        txtEquipmentid.setText("");
        txtEquipmentname.setText("");
        txtEquipmenttype.setText("");
        txtpurchasedate.setValue(LocalDate.parse(""));
    }


    @FXML
    void btndeleteonaction(ActionEvent event) {
        String memberID = txtEquipmentid.getText();

        try {
            boolean isDeleted = equipmentBO.deleteEquipment(memberID);
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
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/ViewEquipment.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Equipment Page");
        stage.centerOnScreen();
    }

    private boolean validateItem() {
        String itemId = txtEquipmentid.getText();
        boolean matches = Pattern.matches("[E][0-9]{3,}", itemId);

        if (!matches) {
            new Alert(Alert.AlertType.ERROR, "Invalid item id.").show();
            return false;
        }
        return true;
    }

    @FXML
    void btnPrintOnAction(ActionEvent event) throws JRException {
        String id = txtEquipmentid.getText();

        try {
            EquipmentDTO dto = equipmentBO.search(id);
            if (dto != null) {
                viewCustomerReport(dto);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


   @FXML
    void btnupdateonaction(ActionEvent event) {
        String id = txtEquipmentid.getText();
        String name = txtEquipmentname.getText();
        String type = txtEquipmenttype.getText();
        String purchasedate = String.valueOf(txtpurchasedate.getValue());

        var dto = new EquipmentDTO(id, name, type, purchasedate);

        try {
            boolean isUpdated = equipmentBO.updateEquipment(dto);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Equipment updated!").show();
                clearFields();
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }




    private void viewCustomerReport(EquipmentDTO dto) throws JRException {
        HashMap hashMap = new HashMap();
        hashMap.put("id", dto.getEquipmentid());
        hashMap.put("name", dto.getEquipmentname());
        hashMap.put("type", dto.getEquipmentQTY());
        hashMap.put("date", dto.getPurchaseDate());


        InputStream resourceAsStream = getClass().getResourceAsStream("/Report/Equipment_Report_A4_2.jrxml");
        JasperDesign load = JRXmlLoader.load(resourceAsStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(load);

        JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasperReport,
                hashMap,
                new JREmptyDataSource()
        );

        JasperViewer.viewReport(jasperPrint, false);
    }



    @FXML
    void txtEquipmentidSearchOnAction(ActionEvent event) {
        String Equipmentid = txtEquipmentid.getText();

        try {
            EquipmentDTO equipmentDTO = equipmentBO.search(Equipmentid);

            if (equipmentDTO != null) {
                txtEquipmentid.setText(equipmentDTO.getEquipmentid());
                txtEquipmentname.setText(equipmentDTO.getEquipmentname());
                txtEquipmenttype.setText(equipmentDTO.getEquipmentQTY());
                txtpurchasedate.setValue(LocalDate.parse(String.valueOf(equipmentDTO.getPurchaseDate())));
            } else {
                new Alert(Alert.AlertType.ERROR, "Invalid ID").show();
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    /*public boolean existEquipment(String id) throws SQLException, ClassNotFoundException {
        return customerBO.existCustomer(id);
    }

     */
}


