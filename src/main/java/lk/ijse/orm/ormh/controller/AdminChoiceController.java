package lk.ijse.orm.ormh.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.orm.ormh.utils.WindowUtils;

import java.io.IOException;

public class AdminChoiceController {

    @FXML
    private AnchorPane pane;

    @FXML
    void gotoBack(ActionEvent event) throws Exception {
        new WindowUtils().navigateTo("Landing", pane);
    }

    @FXML
    void gotoTherapists(ActionEvent event) throws Exception {
        new WindowUtils().navigateTo("TherapistView", pane);
    }

    @FXML
    void gotoTherapyProgramme(ActionEvent event) throws Exception {
        new WindowUtils().navigateTo("ProgrammeView", pane);
    }
}
