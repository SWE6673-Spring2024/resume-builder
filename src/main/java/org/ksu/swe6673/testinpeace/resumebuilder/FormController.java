package org.ksu.swe6673.testinpeace.resumebuilder;

import org.apache.pdfbox.pdmodel.PDDocument;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FormController {
    @FXML
    TextField firstName;
    @FXML
    TextField lastName;
    @FXML
    TextField addressStreet;
    @FXML
    TextField addressUnit;
    @FXML
    TextField addressCity;
    @FXML
    TextField addressZip;
    @FXML
    TextField email;
    @FXML
    TextField linkedin;
    @FXML
    TextField github;
    @FXML
    TextField phone;
    @FXML
    TextField workHistory;
    @FXML
    TextField workYears;
    @FXML
    TextField company;
    @FXML
    TextField role;
    @FXML
    TextArea description;
    @FXML
    TextField education;
    @FXML
    TextField schoolYears;
    @FXML
    TextField degree;
    @FXML
    TextField school;
    @FXML
    TextField major;
    @FXML
    TextField gpa;
    @FXML
    TextField status;

    @FXML
    Label submitLabel;

    @FXML
    Button submitButton;

    @FXML
    protected void onSubmitButtonClick() {
        submitLabel.setText("Submitted");
    }

    public PDDocument exportPdf() {
        return new PDDocument();
    }

}
