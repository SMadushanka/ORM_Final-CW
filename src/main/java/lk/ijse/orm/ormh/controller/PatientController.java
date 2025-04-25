package lk.ijse.orm.ormh.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class PatientController {

    @FXML
    private TableColumn<?, ?> contactCol;

    @FXML
    private TextField contactTxt;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private TableColumn<?, ?> emailCol;

    @FXML
    private TextField emailTxt;

    @FXML
    private TextField feesTxt;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private Label idLbl;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TextField nameTxt;

    @FXML
    private AnchorPane pane;

    @FXML
    private TableView<?> patTbl;

    @FXML
    private Label proLbl;

    @FXML
    private ComboBox<?> programmeCmb;

    @FXML
    private TableColumn<?, ?> programmeCol;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private ComboBox<?> sessionCmb;

    @FXML
    private TableColumn<?, ?> sessionCol;

    @FXML
    private Label sessionLbl;

    @FXML
    private JFXButton updateBtn;

    @FXML
    void deletePatient(ActionEvent event) {

    }

    @FXML
    void gotoBack(ActionEvent event) {

    }

    @FXML
    void savePatient(ActionEvent event) {

    }

    @FXML
    void searchPatient(MouseEvent event) {

    }

    @FXML
    void selectProgramme(ActionEvent event) {

    }

    @FXML
    void selectSession(ActionEvent event) {

    }

    @FXML
    void updatePatient(ActionEvent event) {

    }

}
