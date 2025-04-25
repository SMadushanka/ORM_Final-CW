package lk.ijse.orm.ormh.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class TherapistController {

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
    private JFXButton saveBtn;

    @FXML
    private TableView<?> threTbl;

    @FXML
    private JFXButton updateBtn;

    @FXML
    void deleteTherapist(ActionEvent event) {

    }

    @FXML
    void gotoBack(ActionEvent event) {

    }

    @FXML
    void saveTherapist(ActionEvent event) {

    }

    @FXML
    void searchTherapist(MouseEvent event) {

    }

    @FXML
    void updateTherapist(ActionEvent event) {

    }

}
