package org.ksu.swe6673.testinpeace.resumebuilder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;
import javafx.scene.input.MouseButton;

import static org.junit.jupiter.api.Assertions.*;

class FormControllerTest  extends ApplicationTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void onSubmitButtonClick() {
    }

    void TwoPlusTwoEqualsFour() {
        //clickOn();
        int firstTwo = 2;
        int secondTwo = 2;

        int actual = firstTwo + secondTwo;
        int expected = 4;
        assertEquals(actual, expected);
    }

    @Test
    void FirstNameNullValue(){

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
