package lk.ijse.orm.ormh.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.orm.ormh.dto.ReceptionDto;
import lk.ijse.orm.ormh.exception.RegisterException;
import lk.ijse.orm.ormh.service.ServiceFactory;
import lk.ijse.orm.ormh.service.ServiceFactory.serviceType;
import lk.ijse.orm.ormh.service.custom.ReceptionService;
import lk.ijse.orm.ormh.utils.WindowUtils;

public class ReceptionController {

    ReceptionService receptionService = (ReceptionService) ServiceFactory.getServiceFactory()
            .getService(serviceType.RECEPTION);


    @FXML
    private TextField contactTxt;

    @FXML
    private TextField emailTxt;

    @FXML
    private TextField nameTxt;

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField passwordTxt;

    @FXML
    void gotoBack(ActionEvent event) throws Exception {
        new WindowUtils().navigateTo("RoleView", pane);
    }

    @FXML
    void gotoLog(MouseEvent event) throws Exception {
        new WindowUtils().navigateTo("ReceptionAuthView", pane);
    }

    @FXML
    void saveAdmin(ActionEvent event) throws Exception {
        String emailReg = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        String conReg = "^[0-9]{10}$";

        if (!emailTxt.getText().matches(emailReg)) {
            new Alert(Alert.AlertType.ERROR, "Invalid Email Address!").show();
            return;
        }

        if (!contactTxt.getText().matches(conReg)) {
            new Alert(Alert.AlertType.ERROR, "Invalid Contact Number!").show();
            return;
        }

        try {
            boolean resp = receptionService.saveReception(new ReceptionDto(
                    nameTxt.getText(), emailTxt.getText(), passwordTxt.getText(),
                    Integer.parseInt(contactTxt.getText())));

            if (resp) {
                new Alert(Alert.AlertType.INFORMATION, "New Ricieptoin Added Success!").show();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Something Went Wrong!").show();
            }
        } catch (RegisterException e) {
            e.printStackTrace();
        }
    }

    private void clearFields(){
        nameTxt.setText("");
        emailTxt.setText("");
        passwordTxt.setText("");
        contactTxt.setText("");
    }
}
