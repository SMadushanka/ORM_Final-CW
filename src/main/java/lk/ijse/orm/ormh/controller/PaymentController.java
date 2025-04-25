package lk.ijse.orm.ormh.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class PaymentController {

    @FXML
    private TableColumn<?, ?> amountCol;

    @FXML
    private AnchorPane pane;

    @FXML
    private TableColumn<?, ?> patIdCol;

    @FXML
    private TableColumn<?, ?> payIdCol;

    @FXML
    private TableView<?> paymentTbl;

    @FXML
    void gotoBack(ActionEvent event) {

    }

}
