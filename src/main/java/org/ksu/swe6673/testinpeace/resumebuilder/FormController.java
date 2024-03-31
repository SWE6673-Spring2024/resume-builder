package org.ksu.swe6673.testinpeace.resumebuilder;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.Clipboard;
import javafx.scene.input.KeyCode;
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

    static String makeControlCharactersVisible(String s) {
        if (s == null) {
            return s;
        }

        int len = s.length();
        StringBuilder visible = new StringBuilder(len);

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            visible.append(c >= 32 || c == '\n' ? c : (char) (c + 0x2400));
            visible.append(c >= 32 || c == '\r' ? c : (char) (c + 0x000D));
            visible.append(c >= 32 || c == '\t' ? c : (char) (c + 0x0009));
            System.out.println(c);
        }

        return visible.toString();
    }

    public void submit() {
        // TODO: save updated form values to inject into PDF
        firstName = new TextField() {
            @Override
            public void paste() {
                String text = Clipboard.getSystemClipboard().getString();
                replaceSelection(makeControlCharactersVisible(text));
            }
        };
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
