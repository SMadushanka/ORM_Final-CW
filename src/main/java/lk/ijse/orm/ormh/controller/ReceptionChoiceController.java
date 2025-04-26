package lk.ijse.orm.ormh.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.orm.ormh.utils.WindowUtils;

import java.io.IOException;

public class ReceptionChoiceController {

    @FXML
    private AnchorPane pane;

    @FXML
    void gotoBack(ActionEvent event) throws Exception {
        new WindowUtils().navigateTo("Landing", pane);
    }

    @FXML
    void gotoPayment(ActionEvent event) throws Exception {
        new WindowUtils().navigateTo("PaymentView", pane);
    }

    @FXML
    void gotoSession(ActionEvent event) throws Exception {
        new WindowUtils().navigateTo("SessionView", pane);
    }

    @FXML
    void gotopatient(ActionEvent event) throws Exception {
        new WindowUtils().navigateTo("PatientView", pane);
    }
}
