package org.ksu.swe6673.testinpeace.resumebuilder;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FormController {
    @FXML
    TextField inputName;

    @FXML
    Label submitLabel;

    @FXML
    Button submitButton;

    @FXML
    protected void onSubmitButtonClick() {
        submitLabel.setText(inputName.getText());
    }
}
