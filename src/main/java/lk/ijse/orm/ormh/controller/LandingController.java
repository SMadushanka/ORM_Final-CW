package lk.ijse.orm.ormh.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.orm.ormh.utils.WindowUtils;

import java.io.IOException;

public class LandingController {

    @FXML
    private AnchorPane LandingPane;

    @FXML
    void gotoSigInView(ActionEvent event) throws Exception {
        new WindowUtils().navigateTo("RoleView", LandingPane);
    }

    @FXML
    void gotoSignUpView(ActionEvent event) throws Exception {
        new WindowUtils().navigateTo("RoleView", LandingPane);
    }
}
