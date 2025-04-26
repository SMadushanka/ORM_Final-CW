package lk.ijse.orm.ormh.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.orm.ormh.utils.WindowUtils;

import java.io.IOException;

public class RoleController {

    @FXML
    private AnchorPane selectRolePane;

    @FXML
    void backLandingPage(ActionEvent event) throws IOException {
        new WindowUtils().navigateTo("Landing",selectRolePane);
    }

    @FXML
    void gotoAdminAuth(ActionEvent event) throws IOException {
        new WindowUtils().navigateTo("AdminAuthView", selectRolePane);
    }

    @FXML
    void gotoReceptionAuth(ActionEvent event) throws IOException {
        new WindowUtils().navigateTo("ReceptionAuthView", selectRolePane);
    }
}
