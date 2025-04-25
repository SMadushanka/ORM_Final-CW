package lk.ijse.orm.ormh.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ProgrammeController {

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private TableColumn<?, ?> durationCol;

    @FXML
    private TextField durationTxt;

    @FXML
    private TableColumn<?, ?> feesCol;

    @FXML
    private TextField feesTxt;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private Label idLbl;

    @FXML
    private TextField nameTxt;

    @FXML
    private AnchorPane pane;

    @FXML
    private TableView<?> programmeTbl;

    @FXML
    private TableColumn<?, ?> programmenameCol;

    @FXML
    private JFXButton savebtn;

    @FXML
    private JFXButton updateBtn;

    @FXML
    void deleteProgramme(ActionEvent event) {

    }

    @FXML
    void gotoBack(ActionEvent event) {

    }

    @FXML
    void saveProgramme(ActionEvent event) {

    }

    @FXML
    void updateProgramme(ActionEvent event) {

    }

}
