package org.ksu.swe6673.testinpeace.resumebuilder;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FormController {
    @FXML
    TextField firstName = new TextField("Default First Name");
    @FXML
    TextField lastName = new TextField("Default Last Name");
    @FXML
    TextField address = new TextField("Default Address");
    @FXML
    TextField contactInfo = new TextField("Default Contact Info");
    @FXML
    TextField email = new TextField("Default email");
    @FXML
    TextField linkedin = new TextField("Default LinkedIn");
    @FXML
    TextField github = new TextField("Default Github");
    @FXML
    TextField phone = new TextField("Default Phone");
    @FXML
    TextField workHistory = new TextField("Default Work History");
    @FXML
    TextField workYears = new TextField("Default Years");
    @FXML
    TextField company = new TextField("Default Company");
    @FXML
    TextField role = new TextField("Default Role");
    @FXML
    TextField description = new TextField("Default Description");
    @FXML
    TextField education = new TextField("Default Education");
    @FXML
    TextField schoolYears = new TextField("Default School Years");
    @FXML
    TextField degree = new TextField("Default Degree");
    @FXML
    TextField school = new TextField("Default School");
    @FXML
    TextField major = new TextField("Default Major");
    @FXML
    TextField gpa = new TextField("Default GPA");
    @FXML
    TextField status = new TextField("Default Status");

    @FXML
    Label submitLabel;

    @FXML
    Button submitButton;

    @FXML
    protected void onSubmitButtonClick() {
        submitLabel.setText("Submitted");
    }

}
