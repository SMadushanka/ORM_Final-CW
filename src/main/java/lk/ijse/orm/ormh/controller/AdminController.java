package lk.ijse.orm.ormh.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.orm.ormh.dto.AdminDto;
import lk.ijse.orm.ormh.exception.RegisterException;
import lk.ijse.orm.ormh.service.ServiceFactory;
import lk.ijse.orm.ormh.service.custom.AdminService;
import lk.ijse.orm.ormh.utils.WindowUtils;

import java.io.IOException;

public class AdminController {

    AdminService adminService = (AdminService) ServiceFactory.getServiceFactory().getService(ServiceFactory.serviceType.ADMIN);


    @FXML
    private TextField contactTxt;

    @FXML
    private TextField emailTxt;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField passwordTxt;

    @FXML
    private AnchorPane pane;

    @FXML
    void gotoBack(ActionEvent event) throws Exception {
        new WindowUtils().navigateTo("RoleView", pane);
    }

    @FXML
    void gotoLog(MouseEvent event) throws Exception {
        new WindowUtils().navigateTo("AdminAuthView", pane);
    }

    @FXML
    void saveAdmin(ActionEvent event) throws Exception {
        String emailReg = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        String conReg = "^[0-9]{10}$";

        if (emailTxt.getText().isEmpty() || contactTxt.getText().isEmpty() || nameTxt.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Something Went Wrong!").show();
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
            boolean resp = adminService.saveAdmin(new AdminDto(
                    nameTxt.getText(), emailTxt.getText(), passwordTxt.getText(), Integer.parseInt(contactTxt.getText())));

            if (resp) {
                new Alert(Alert.AlertType.INFORMATION, "New Admin Added Success!").show();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Something Went Wrong!").show();
            }
        } catch (RegisterException e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        nameTxt.setText("");
        emailTxt.setText("");
        passwordTxt.setText("");
        contactTxt.setText("");
    }
}
