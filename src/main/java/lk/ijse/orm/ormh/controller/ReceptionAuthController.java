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
import lk.ijse.orm.ormh.service.ServiceFactory.serviceType;
import lk.ijse.orm.ormh.service.custom.ReceptionService;
import lk.ijse.orm.ormh.utils.WindowUtils;

import java.io.IOException;

public class ReceptionAuthController {

    ReceptionService receptionService = (ReceptionService) ServiceFactory.getServiceFactory().getService(serviceType.RECEPTION);

    @FXML
    private TextField emailTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private AnchorPane riviewAuthPane;

    @FXML
    void authReception(ActionEvent event) throws IOException {
        try {
            String email = emailTxt.getText();
            String password = passwordTxt.getText();

            boolean resp = receptionService.authLogin(email,password);
            if (resp) {
                new WindowUtils().navigateTo("ReceptionChoiceView", riviewAuthPane);
            }else{
                new Alert(Alert.AlertType.ERROR,"Something Went Wrong!").show();
            }
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void backLanding(ActionEvent event) throws Exception {
        new WindowUtils().navigateTo("RoleView",riviewAuthPane);
    }

    @FXML
    void gotoRegister(MouseEvent event) throws Exception {
        new WindowUtils().navigateTo("ReceptionView", riviewAuthPane);
    }

}
