package lk.ijse.orm.ormh.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.orm.ormh.dto.SessionDto;
import lk.ijse.orm.ormh.dto.TherapistDto;
import lk.ijse.orm.ormh.service.ServiceFactory;
import lk.ijse.orm.ormh.service.ServiceFactory.serviceType;
import lk.ijse.orm.ormh.service.custom.SessionService;
import lk.ijse.orm.ormh.service.custom.TherapistService;
import lk.ijse.orm.ormh.tm.SessionTM;
import lk.ijse.orm.ormh.utils.WindowUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class SessionController implements Initializable {

    SessionService sessionService = (SessionService) ServiceFactory.getServiceFactory().getService(serviceType.SESSIONS);
    TherapistService therapistService = (TherapistService) ServiceFactory.getServiceFactory().getService(serviceType.THERAPIST);

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private TextField endTxt;

    @FXML
    private TableColumn<SessionTM, Integer> endtimeCol;

    @FXML
    private TableColumn<SessionTM, Integer> idCol;

    @FXML
    private Label idLbl;

    @FXML
    private TableColumn<SessionTM, String> nameCol;

    @FXML
    private TextField nameTxt;

    @FXML
    private AnchorPane pane;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private Label sessionIdLbl;

    @FXML
    private TableView<SessionTM> sessionTbl;

    @FXML
    private TableColumn<SessionTM, Integer> startTimeCol;

    @FXML
    private TextField startTxt;

    @FXML
    private TableColumn<SessionTM, Integer> therepyIdCol;

    @FXML
    private JFXButton updateBtn;

    @FXML
    void deleteSession(ActionEvent event) throws Exception {
        boolean resp = sessionService.deleteSession(Integer.parseInt(sessionIdLbl.getText()));
        if (resp) {
            new Alert(Alert.AlertType.INFORMATION, "Deleted Session").show();
            getAllSessions();
            clearFields();
            getAllTherapistNames();
        }else {
            new Alert(Alert.AlertType.ERROR, "Something went wrong!").show();
        }
    }

    @FXML
    void saveSession(ActionEvent event) throws Exception {
        if (nameTxt.getText().isEmpty() || startTxt.getText().isEmpty() || endTxt.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong !").show();
        }

        boolean resp = sessionService.saveSession(new SessionDto(
                nameTxt.getText(),
                Integer.parseInt(startTxt.getText()),
                Integer.parseInt(endTxt.getText()),
                Integer.parseInt(idLbl.getText())
        ));

        if (resp){
            new Alert(Alert.AlertType.INFORMATION,"Saved").show();
            getAllSessions();
            clearFields();
            getAllTherapistNames();
        }else {
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong !").show();
        }
    }

    @FXML
    void searchSession(MouseEvent event) {
        SessionTM sessionTM = sessionTbl.getSelectionModel().getSelectedItem();
        if (sessionTM != null) {
            idLbl.setText(String.valueOf(sessionTM.getTherapistId()));
            nameTxt.setText(sessionTM.getName());
            startTxt.setText(String.valueOf(sessionTM.getStart()));
            endTxt.setText(String.valueOf(sessionTM.getEnd()));
            sessionIdLbl.setText(String.valueOf(sessionTM.getId()));
        }
    }

    @FXML
    void selectTherapist(ActionEvent event) {
        SessionTM selectedName = therapistCmb.getSelectionModel().getSelectedItem();
        TherapistDto selectedDto = therapistMap.get(selectedName);

        if (selectedDto != null) {
            idLbl.setText(String.valueOf(selectedDto.getId()));
        } else {
            System.out.println("Therapist not found.");
        }
    }


    @FXML
    void updateSession(ActionEvent event) {
        boolean resp = sessionService.updateService(new SessionDto(
                Integer.parseInt(sessionIdLbl.getText()),
                nameTxt.getText(),
                Integer.parseInt(startTxt.getText()),
                Integer.parseInt(endTxt.getText()),
                Integer.parseInt(idLbl.getText())
        ));

        if (resp){
            new Alert(Alert.AlertType.INFORMATION,"Updated!").show();
            getAllSessions();
            clearFields();
            getAllTherapistNames();
        }else {
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong!").show();
        }
    }
    @FXML
    private ComboBox<SessionTM> therapistCmb;

    private Map<SessionTM, TherapistDto> therapistMap = new HashMap<>();
    public void getAllTherapistNames(){
        ArrayList<TherapistDto>therapistDtos = therapistService.getAllTherapists();
        for (TherapistDto dto : therapistDtos ) {
            SessionTM sessionTM = new SessionTM(0, dto.getName(), 0, 0, dto.getId());
            therapistMap.put(sessionTM, dto);  // Save mapping
            therapistCmb.getItems().add(sessionTM);
        }
    }

    public void getAllSessions(){
        ArrayList<SessionDto>sessionDtos = sessionService.getAllSessions();
        ObservableList<SessionTM> sessionTMObservableList = FXCollections.observableArrayList();

        for (SessionDto dto : sessionDtos) {
            SessionTM sessionTM = new SessionTM(
                    dto.getId(),
                    dto.getName(),
                    dto.getStart(),
                    dto.getEnd(),
                    dto.getTherapistId()
            );
            sessionTMObservableList.add(sessionTM);
        }
        sessionTbl.setItems(sessionTMObservableList);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            startTimeCol.setCellValueFactory(new PropertyValueFactory<>("start"));
            endtimeCol.setCellValueFactory(new PropertyValueFactory<>("end"));
            therepyIdCol.setCellValueFactory(new PropertyValueFactory<>("therepistId"));

            idLbl.setText("");
            sessionIdLbl.setText("");

            clearFields();
            getAllTherapistNames();
            getAllSessions();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearFields(){
        idLbl.setText("");
        nameTxt.setText("");
        startTxt.setText("");
        endTxt.setText("");
        sessionIdLbl.setText("");
        therapistCmb.getItems().clear();
    }

    @FXML
    void gotoBack(ActionEvent event) throws IOException {
        new WindowUtils().navigateTo("ReceptionChoiceView", pane);
    }
}
