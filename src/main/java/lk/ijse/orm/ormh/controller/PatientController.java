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
import lk.ijse.orm.ormh.dto.PatientDto;
import lk.ijse.orm.ormh.dto.PaymentDto;
import lk.ijse.orm.ormh.dto.ProgrammeDto;
import lk.ijse.orm.ormh.dto.SessionDto;
import lk.ijse.orm.ormh.exception.PayException;
import lk.ijse.orm.ormh.service.ServiceFactory;
import lk.ijse.orm.ormh.service.custom.PatientService;
import lk.ijse.orm.ormh.service.custom.PaymentService;
import lk.ijse.orm.ormh.service.custom.ProgrammeService;
import lk.ijse.orm.ormh.service.custom.SessionService;
import lk.ijse.orm.ormh.tm.PatientTM;
import lk.ijse.orm.ormh.utils.WindowUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class PatientController implements Initializable {

    @FXML
    private TableColumn<PatientTM, Integer> contactCol;

    @FXML
    private TextField contactTxt;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private TableColumn<PatientTM, String> emailCol;

    @FXML
    private TextField emailTxt;

    @FXML
    private TextField feesTxt;

    @FXML
    private TableColumn<PatientTM, Integer> idCol;

    @FXML
    private Label idLbl;

    @FXML
    private TableColumn<PatientTM, String> nameCol;

    @FXML
    private TextField nameTxt;

    @FXML
    private AnchorPane pane;

    @FXML
    private TableView<PatientTM> patTbl;

    @FXML
    private Label proLbl;

    @FXML
    private ComboBox<String> programmeCmb;

    @FXML
    private TableColumn<PatientTM, Integer> programmeCol;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private ComboBox<String> sessionCmb;

    @FXML
    private TableColumn<PatientTM, Integer> sessionCol;

    @FXML
    private Label sessionLbl;

    @FXML
    private JFXButton updateBtn;

    ProgrammeService programmeService = (ProgrammeService) ServiceFactory.getServiceFactory()
            .getService(ServiceFactory.serviceType.PROGRAMME);
    SessionService sessionService = (SessionService) ServiceFactory.getServiceFactory()
            .getService(ServiceFactory.serviceType.SESSIONS);
    PatientService patientService = (PatientService) ServiceFactory.getServiceFactory()
            .getService(ServiceFactory.serviceType.PATIENT);
    PaymentService paymentService = (PaymentService) ServiceFactory.getServiceFactory()
            .getService(ServiceFactory.serviceType.PAYMENT);

    @FXML
    void deletePatient(ActionEvent event) throws Exception {
        boolean resp = patientService.deletePatient(Integer.parseInt(idLbl.getText()));
        if (resp) {
            new Alert(Alert.AlertType.INFORMATION, "Patient deleted!").show();
            getAllPatients();
        } else {
            new Alert(Alert.AlertType.ERROR, "Something went wrong!").show();
        }
    }

    @FXML
    void updatePatient(ActionEvent event) {
        String emailReg = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        String conReg = "^[0-9]{10}$";

        if (!emailTxt.getText().matches(emailReg)) {
            new Alert(Alert.AlertType.ERROR, "Invalid Email Address").show();
            return;
        }

        if (!contactTxt.getText().matches(conReg)) {
            new Alert(Alert.AlertType.ERROR, "Invalid Contact Number").show();
            return;
        }

        boolean resp = patientService.updatePatient(new PatientDto(
                Integer.parseInt(idLbl.getText()),
                nameTxt.getText(),
                emailTxt.getText(),
                Integer.parseInt(contactTxt.getText()),
                Integer.parseInt(proLbl.getText()),
                Integer.parseInt(sessionLbl.getText())));

        if (resp) {
            new Alert(Alert.AlertType.INFORMATION, "Patcient Updated").show();
            getAllPatients();
        } else {
            new Alert(Alert.AlertType.ERROR, "Something went wrong").show();
        }
    }

    private Map<String, ProgrammeDto> programmeDtoMap = new HashMap<>();
    private Map<String, SessionDto> sessionDtoMap = new HashMap<>();

    @FXML
    void savePatient(ActionEvent event) {
        String emailReg = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        String conReg = "^[0-9]{10}$";

        if (emailTxt.getText().isEmpty() || contactTxt.getText().isEmpty() || nameTxt.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"SomeThing Went Wrong!").show();
        } else {

        }

        if (!emailTxt.getText().matches(emailReg)) {
            new Alert(Alert.AlertType.ERROR, "Invalid Email Address!").show();
            return;
        }

        if (!contactTxt.getText().matches(conReg)) {
            new Alert(Alert.AlertType.ERROR, "Invalid Contact Number!").show();
            return;
        }

        try {
            int newPatientId = patientService.savePatient(new PatientDto(
                    nameTxt.getText(),
                    emailTxt.getText(),
                    Integer.parseInt(contactTxt.getText()),
                    Integer.parseInt(proLbl.getText()),
                    Integer.parseInt(sessionLbl.getText())));

            try {
                boolean resp = paymentService.savePayment(new PaymentDto(
                        Double.parseDouble(feesTxt.getText()),
                        newPatientId));

                if (resp) {
                    new Alert(Alert.AlertType.INFORMATION, "Patient saved!").show();
                    getAllPatients();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Something went wrong!").show();
                }
            } catch (PayException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something went wrong!").show();
        }
    }

    @FXML
    void searchPatient(MouseEvent event) {
        PatientTM patientTM = patTbl.getSelectionModel().getSelectedItem();
        if (patientTM != null) {
            idLbl.setText(String.valueOf(patientTM.getId()));
            nameTxt.setText(patientTM.getName());
            emailTxt.setText(patientTM.getEmail());
            contactTxt.setText(String.valueOf(patientTM.getPhone()));
            proLbl.setText(String.valueOf(patientTM.getProgrammeId()));
            sessionLbl.setText(String.valueOf(patientTM.getSessionId()));
        }
    }

    @FXML
    void selectProgramme(ActionEvent event) {
        String selectName = programmeCmb.getSelectionModel().getSelectedItem();
        ProgrammeDto programmeDto = programmeDtoMap.get(selectName);
        if (programmeDto != null) {
            proLbl.setText(String.valueOf(programmeDto.getId()));
        } else {
            System.out.println("Programme not found!");
        }
    }

    @FXML
    void selectSession(ActionEvent event) {
        String selectName = sessionCmb.getSelectionModel().getSelectedItem();
        SessionDto sessionDto = sessionDtoMap.get(selectName);
        if (sessionDto != null) {
            sessionLbl.setText(String.valueOf(sessionDto.getId()));
        } else {
            System.out.println("Session Not Found");
        }
    }

    private void getAllPatients() {
        ArrayList<PatientDto> patientDtos = patientService.getAllPatients();
        ObservableList<PatientTM> patientTMS = FXCollections.observableArrayList();

        for (PatientDto dto : patientDtos) {
            PatientTM patientTM = new PatientTM(
                    dto.getId(),
                    dto.getName(),
                    dto.getEmail(),
                    dto.getPhone(),
                    dto.getProgrammeId(),
                    dto.getSessionId());
            patientTMS.add(patientTM);
        }
        patTbl.setItems(patientTMS);
    }

    public void getAllSessions() {
        ArrayList<SessionDto> sessionDtos = sessionService.getAllSessions();
        for (SessionDto sessionDto : sessionDtos) {
            sessionDtoMap.put(sessionDto.getName(), sessionDto);
            sessionCmb.getItems().add(sessionDto.getName());
        }
    }

    public void getAllProgrammes() {
        ArrayList<ProgrammeDto> programmeDtos = programmeService.getAllProgrammes();
        for (ProgrammeDto programmeDto : programmeDtos) {
            programmeDtoMap.put(programmeDto.getName(), programmeDto);
            programmeCmb.getItems().add(programmeDto.getName());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
            contactCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
            programmeCol.setCellValueFactory(new PropertyValueFactory<>("programmeId"));
            sessionCol.setCellValueFactory(new PropertyValueFactory<>("sessionId"));

            sessionLbl.setText("");
            proLbl.setText("");
            idLbl.setText("");

            getAllProgrammes();
            getAllSessions();
            getAllPatients();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gotoBack(ActionEvent event) throws Exception {
        new WindowUtils().navigateTo("ReceptionChoiceView", pane);
    }
}
