package lk.ijse.orm.ormh.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.orm.ormh.exception.LoginException;
import lk.ijse.orm.ormh.service.ServiceFactory;
import lk.ijse.orm.ormh.service.custom.AdminService;
import lk.ijse.orm.ormh.utils.WindowUtils;

import java.io.IOException;

public class AdminAuthController {

    AdminService adminService = (AdminService) ServiceFactory.getServiceFactory().getService(ServiceFactory.serviceType.ADMIN);

    @FXML
    private AnchorPane adminLoginAuthPane;

    @FXML
    private TextField emailTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    void backLanding(ActionEvent event) throws Exception {
        new WindowUtils().navigateTo("RoleView", adminLoginAuthPane);
    }

    @FXML
    void gotoChoicesView(ActionEvent event) throws Exception {
        try {
            String email = emailTxt.getText();
            String password = passwordTxt.getText();

            boolean resp = adminService.authAdmin(email, password);

            if (resp) {
                new WindowUtils().navigateTo("AdminChoicesView", adminLoginAuthPane);
            } else {
                new Alert(Alert.AlertType.ERROR, "Something Went Wrong!").show();
            }
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gotoRegister(MouseEvent event) throws Exception {
        new WindowUtils().navigateTo("AdminView", adminLoginAuthPane);
    }
}
