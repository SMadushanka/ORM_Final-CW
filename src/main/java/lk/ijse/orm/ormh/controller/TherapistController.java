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
import lk.ijse.orm.ormh.dto.TherapistDto;
import lk.ijse.orm.ormh.service.ServiceFactory;
import lk.ijse.orm.ormh.service.ServiceFactory.serviceType;
import lk.ijse.orm.ormh.service.custom.TherapistService;
import lk.ijse.orm.ormh.tm.TherapistTM;
import lk.ijse.orm.ormh.utils.WindowUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TherapistController implements Initializable {

    TherapistService therapistService = (TherapistService) ServiceFactory.getServiceFactory().getService(serviceType.THERAPIST);

    @FXML
    private TableColumn<TherapistTM, Integer> contactCol;

    @FXML
    private TextField contactTxt;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private TableColumn<TherapistTM, String> emailCol;

    @FXML
    private TextField emailTxt;

    @FXML
    private TableColumn<TherapistTM, Integer> idCol;

    @FXML
    private Label idLbl;

    @FXML
    private TableColumn<TherapistTM, String> nameCol;

    @FXML
    private TextField nameTxt;

    @FXML
    private AnchorPane pane;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private TableView<TherapistTM> threTbl;

    @FXML
    private JFXButton updateBtn;

    @FXML
    void deleteTherapist(ActionEvent event) throws Exception {
        boolean resp = therapistService.deleteTherapist(Integer.parseInt(idLbl.getText()));
        if (resp) {
            new Alert(Alert.AlertType.INFORMATION,"Therepy Delete Success !").show();
            getAllTherapists();
        }else{
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong !").show();
        }
    }

    @FXML
    void gotoBack(ActionEvent event) throws IOException {
        new WindowUtils().navigateTo("AdminChoicesView", pane);
    }

    @FXML
    void saveTherapist(ActionEvent event) throws Exception {
        String emailReg = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        String conReg = "^[0-9]{10}$";

        if (nameTxt.getText().isEmpty() || emailTxt.getText().isEmpty() || contactTxt.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong").show();
        }

        if (!emailTxt.getText().matches(emailReg)) {
            new Alert(Alert.AlertType.ERROR, "Invalid Email Address").show();
            return;
        }

        if (!contactTxt.getText().matches(conReg)) {
            new Alert(Alert.AlertType.ERROR, "Invalid Contact Number").show();
            return;
        }

        boolean resp = therapistService.saveTherapist(new TherapistDto(nameTxt.getText(), emailTxt.getText(),Integer.parseInt(contactTxt.getText())));
        if (resp) {
            new Alert(Alert.AlertType.INFORMATION,"Therepy Added Success !").show();
            getAllTherapists();
        }else{
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong !").show();
        }
    }

    @FXML
    void searchTherapist(MouseEvent event) {
        TherapistTM therapistTM = threTbl.getSelectionModel().getSelectedItem();

        if (therapistTM != null) {
            idLbl.setText(String.valueOf(therapistTM.getId()));
            nameTxt.setText(therapistTM.getName());
            emailTxt.setText(therapistTM.getEmail());
            contactTxt.setText(String.valueOf(therapistTM.getPhone()));
        } else {
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong !").show();
        }
    }

    @FXML
    void updateTherapist(ActionEvent event) {
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

        boolean resp = therapistService.updateTherapist(new TherapistDto(Integer.parseInt(idLbl.getText()),nameTxt.getText(), emailTxt.getText(),Integer.parseInt(contactTxt.getText())));
        if (resp) {
            new Alert(Alert.AlertType.INFORMATION,"Therepy Update Success !").show();
            getAllTherapists();
        }else{
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong !").show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
            contactCol.setCellValueFactory(new PropertyValueFactory<>("phone"));

            idLbl.setText("");

            getAllTherapists();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllTherapists(){
        ArrayList<TherapistDto> therapistDtos = therapistService.getAllTherapists();
        ObservableList<TherapistTM> therapistTMs = FXCollections.observableArrayList();

        for (TherapistDto dto : therapistDtos) {
            TherapistTM therapistTM = new TherapistTM(
                    dto.getId(),
                    dto.getName(),
                    dto.getEmail(),
                    dto.getPhone()
            );
            therapistTMs.add(therapistTM);
        }
        threTbl.setItems(therapistTMs);
    }
}
