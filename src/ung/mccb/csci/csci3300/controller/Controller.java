package ung.mccb.csci.csci3300.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import ung.mccb.csci.csci3300.model.Alumni;


public class Controller {
    @FXML
    TextField txtFirstname, txtLastname,txtGradYear, txtMajor, txtEmail;
    public void submitRecord(ActionEvent actionEvent) {

        Alumni model= new Alumni();
        model.setFirstname(txtFirstname.getText());
        model.setLastname(txtLastname.getText());
        model.setGradYear(txtGradYear.getText());
        model.setMajor(txtMajor.getText());
        model.setEmail(txtEmail.getText());

        int result = model.saveRecord();
    }
}
