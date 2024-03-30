package org.ksu.swe6673.testinpeace.resumebuilder;

import org.apache.pdfbox.pdmodel.PDDocument;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.apache.pdfbox.pdmodel.PDPage;

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
    Button resetButton;

    @FXML
    protected void onSubmitButtonClick() {
        submit();
        exportPdf();
    }

    @FXML
    protected void onResetButtonClick() {
        reset();
    }



    public void submit() {
        // TODO: save updated form values to inject into PDF
        TextField textField = new TextField();
        System.out.println(firstName.getCharacters());
        firstName.setText(firstName.getText());
        submitLabel.setText("Submitted");
    }

    public void reset() {
        // TODO: clear form values
        firstName.setText(null);
        lastName.setText(null);
        addressStreet.setText(null);
        addressUnit.setText(null);
        addressZip.setText(null);
        addressCity.setText(null);
        email.setText(null);
        linkedin.setText(null);
        github.setText(null);
        phone.setText(null);
        workHistory.setText(null);
        workYears.setText(null);
        company.setText(null);
        role.setText(null);
        description.setText(null);
        education.setText(null);
        schoolYears.setText(null);
        degree.setText(null);
        school.setText(null);
        gpa.setText(null);
        status.setText(null);
        major.setText(null);
    }

    public PDDocument exportPdf() {
        // TODO: create PDF with form values
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        doc.addPage(page);
        return doc;
    }




}
