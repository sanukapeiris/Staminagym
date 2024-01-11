package com.example.gym.controller;

import com.example.gym.dto.MembersDTO;
import com.example.gym.model.MembersModel;
import com.example.gym.model.HealthReportModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class HealthReport  {

    private MembersModel membersModel = new MembersModel();


    //public JFXComboBox txtmemberid;
    @FXML
    private AnchorPane root;
    private HealthReportModel HelthModel = new HealthReportModel();


    @FXML
    private TextField txtBodyFatpercentage;

    @FXML
    private TextField txthealthreportid;

    @FXML
    private TextField txtheight;

    @FXML
    private TextField txtmedical;



    @FXML
    private TextField txtweight;

    @FXML
    private ComboBox<String> cmdmemberid;


    //@FXML
    //private JFXComboBox<?> cmdmemberid;

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


    public void btnviewonaction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/ViewHealthReport.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("ViewHealthReport");
        stage.centerOnScreen();


    }


    @FXML
    void btnsaveonaction(ActionEvent event) {
        String healthreportid = txthealthreportid.getText();
        String id = cmdmemberid.getValue();
        String Weight = txtweight.getText();
        String Height = txtheight.getText();
        String MedicalCondition = txtmedical.getText();
        String BodyFat = txtBodyFatpercentage.getText();


        var dto = new HealthReportDTO(healthreportid,id,Weight,Height,MedicalCondition,BodyFat);

        try {
            boolean isSaved = HealthReportModel.saveHealthReport(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void clearFields() {
        cmdmemberid.setValue("");
        txthealthreportid.setText("");
        txtweight.setText("");
        txtheight.setText("");
        txtmedical.setText("");
        txtBodyFatpercentage.setText("");
    }


    public void btndeleteonaction(ActionEvent actionEvent) {
        String HealthreportID = txthealthreportid.getText();

        try {
            boolean isDeleted = HealthReportModel.deletehealthreport(HealthreportID);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Health Report deleted!").show();
            } else {


                new Alert(Alert.AlertType.CONFIRMATION, "Member not deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void cmbmemberidonaction(ActionEvent actionEvent) {
        String Memberid = (String) cmdmemberid.getValue();

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
            cmdmemberid.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void btnupdateonaction(ActionEvent event) {
        String Memberid = txthealthreportid.getText();
        String HRid = txthealthreportid.getText();
        String weigh = txtweight.getText();
        String height = txtheight.getText();
        String medical = txtmedical.getText();
        String fat = txtBodyFatpercentage.getText();


        var dto = new HealthReportDTO (Memberid,HRid, weigh, height, medical,fat);

        try {
            boolean isUpdated = HelthModel.updateHealth(dto);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Equipment updated!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
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
    void txtHealthReportIDSearchOnAction(ActionEvent event) {
        String memberid = txthealthreportid.getText();

        try {
            HealthReportDTO healthReportDTO= HealthReportModel.search(memberid);

            if (healthReportDTO != null) {
                cmdmemberid.setValue(healthReportDTO.getMemberID());
                txthealthreportid.setText(healthReportDTO.getHealthReportID());
                txtweight.setText(healthReportDTO.getWeight());
                txtheight.setText(String.valueOf(healthReportDTO.getHeight()));
                txtmedical.setText(healthReportDTO.getMedicalCondition());
                txtBodyFatpercentage.setText(healthReportDTO.getBodyFatpercentage());
            }else {
                new Alert(Alert.AlertType.ERROR,"Invalid ID").show();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void initialize() {
        loadMemberId();
    }

}