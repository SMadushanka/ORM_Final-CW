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

public class SessionController {

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private TextField endTxt;

    @FXML
    private TableColumn<?, ?> endtimeCol;

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
    private Label sessionIdLbl;

    @FXML
    private TableView<?> sessionTbl;

    @FXML
    private TableColumn<?, ?> startTimeCol;

    @FXML
    private TextField startTxt;

    @FXML
    private ComboBox<?> therapistCmb;

    @FXML
    private TableColumn<?, ?> therepyIdCol;

    @FXML
    private JFXButton updateBtn;

    @FXML
    void deleteSession(ActionEvent event) {

    }

    @FXML
    void gotoBack(ActionEvent event) {

    }

    @FXML
    void saveSession(ActionEvent event) {

    }

    @FXML
    void searchSession(MouseEvent event) {

    }

    @FXML
    void selectTherapist(ActionEvent event) {

    }

    @FXML
    void updateSession(ActionEvent event) {

    }

}
