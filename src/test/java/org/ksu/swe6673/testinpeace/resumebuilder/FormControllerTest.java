package org.ksu.swe6673.testinpeace.resumebuilder;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.*;

class FormControllerTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(FormController.class.getResource("form.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void onSubmitButtonClick() {
    }

    @Test
    void TwoPlusTwoEqualsFour() {
        // clickOn();
        int firstTwo = 2;
        int secondTwo = 2;

        int actual = firstTwo + secondTwo;
        int expected = 4;
        assertEquals(actual, expected);
    }

    @Test
    void FirstNameNullValue() {

        FormController myFormController = new FormController();

        clickOn("#firstName");
        write(null);

        // submit form
        clickOn("#submitButton");

        // expected

        // actual

        assertEquals(null, myFormController.firstName.getText());
    }
}
