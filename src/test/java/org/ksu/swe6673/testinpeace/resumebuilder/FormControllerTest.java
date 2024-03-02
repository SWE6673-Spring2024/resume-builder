package org.ksu.swe6673.testinpeace.resumebuilder;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.api.FxAssert;

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


    //firstName
    @ParameterizedTest
    @ValueSource(strings = {
//            null, // null string
            "", // empty string
            " ", // whitespace string
            "\t\n\r", // control characters string
            "a" + "\0" + "b", // string with null character
            "This is a very long string that exceeds the maximum length allowed for the field", // string that is too long
            "This string contains some invalid characters such as @#$%^&*()", // string with non-alphanumeric characters
            "This string has a mismatched quote'", // string with unbalanced quotes
            "This string has an escape sequence \\", // string with incomplete escape sequence
            "This string has a non-ASCII character é", // string with non-ASCII character
    })
    void firstNameTestOnSubmitButtonClickWithMalformedInputs(String input) {
        FormController myFormController = new FormController();

        clickOn("#firstName");
        write(input);

        clickOn("#submitButton");
        assertEquals(input, myFormController.firstName.getText());
    }

    //lastName
    @ParameterizedTest
    @ValueSource(strings = {
            // null, // null string
            "", // empty string
            " ", // whitespace string
            "\t\n\r", // control characters string
            "a" + "\0" + "b", // string with null character
            "This is a very long string that exceeds the maximum length allowed for the field", // string that is too long
            "This string contains some invalid characters such as @#$%^&*()", // string with non-alphanumeric characters
            "This string has a mismatched quote'", // string with unbalanced quotes
            "This string has an escape sequence \\", // string with incomplete escape sequence
            "This string has a non-ASCII character é", // string with non-ASCII character
    })
    void lastNameTestOnSubmitButtonClickWithMalformedInputs(String input) {
        FormController myFormController = new FormController();

        clickOn("#lastName");
        write(input);

        clickOn("#submitButton");
        assertEquals(input, myFormController.lastName.getText());
    }


    //address
    @ParameterizedTest
    @ValueSource(strings = {
            // null, // null string
            "", // empty string
            " ", // whitespace string
            "\t\n\r", // control characters string
            "a" + "\0" + "b", // string with null character
            "This is a very long string that exceeds the maximum length allowed for the field", // string that is too long
            "This string contains some invalid characters such as @#$%^&*()", // string with non-alphanumeric characters
            "This string has a mismatched quote'", // string with unbalanced quotes
            "This string has an escape sequence \\", // string with incomplete escape sequence
            "This string has a non-ASCII character é", // string with non-ASCII character
    })
    void addressTestOnSubmitButtonClickWithMalformedInputs(String input) {
        FormController myFormController = new FormController();

        clickOn("#address");
        write(input);

        clickOn("#submitButton");
        assertEquals(input, myFormController.address.getText());
    }


    //contact info
    @ParameterizedTest
    @ValueSource(strings = {
            // null, // null string
            "", // empty string
            " ", // whitespace string
            "\t\n\r", // control characters string
            "a" + "\0" + "b", // string with null character
            "This is a very long string that exceeds the maximum length allowed for the field", // string that is too long
            "This string contains some invalid characters such as @#$%^&*()", // string with non-alphanumeric characters
            "This string has a mismatched quote'", // string with unbalanced quotes
            "This string has an escape sequence \\", // string with incomplete escape sequence
            "This string has a non-ASCII character é", // string with non-ASCII character
    })
    void contactInfoTestOnSubmitButtonClickWithMalformedInputs(String input) {
        FormController myFormController = new FormController();

        clickOn("#contactInfo");
        write(input);

        clickOn("#submitButton");
        assertEquals(input, myFormController.contactInfo.getText());
    }

    //email
    @ParameterizedTest
    @ValueSource(strings = {
            // null, // null string
            "", // empty string
            " ", // whitespace string
            "\t\n\r", // control characters string
            "a" + "\0" + "b", // string with null character
            "This is a very long string that exceeds the maximum length allowed for the field", // string that is too long
            "This string contains some invalid characters such as @#$%^&*()", // string with non-alphanumeric characters
            "This string has a mismatched quote'", // string with unbalanced quotes
            "This string has an escape sequence \\", // string with incomplete escape sequence
            "This string has a non-ASCII character é", // string with non-ASCII character
    })
    void emailTestOnSubmitButtonClickWithMalformedInputs(String input) {
        FormController myFormController = new FormController();

        clickOn("#email");
        write(input);

        clickOn("#submitButton");
        assertEquals(input, myFormController.email.getText());
    }

    //linkedIn
    @ParameterizedTest
    @ValueSource(strings = {
            // null, // null string
            "", // empty string
            " ", // whitespace string
            "\t\n\r", // control characters string
            "a" + "\0" + "b", // string with null character
            "This is a very long string that exceeds the maximum length allowed for the field", // string that is too long
            "This string contains some invalid characters such as @#$%^&*()", // string with non-alphanumeric characters
            "This string has a mismatched quote'", // string with unbalanced quotes
            "This string has an escape sequence \\", // string with incomplete escape sequence
            "This string has a non-ASCII character é", // string with non-ASCII character
    })
    void linkedInTestOnSubmitButtonClickWithMalformedInputs(String input) {
        FormController myFormController = new FormController();

        clickOn("#linkedin");
        write(input);

        clickOn("#submitButton");
        assertEquals(input, myFormController.linkedin.getText());
    }


    //github
    @ParameterizedTest
    @ValueSource(strings = {
//            null, // null string
            "", // empty string
            " ", // whitespace string
            "\t\n\r", // control characters string
            "a" + "\0" + "b", // string with null character
            "This is a very long string that exceeds the maximum length allowed for the field", // string that is too long
            "This string contains some invalid characters such as @#$%^&*()", // string with non-alphanumeric characters
            "This string has a mismatched quote'", // string with unbalanced quotes
            "This string has an escape sequence \\", // string with incomplete escape sequence
            "This string has a non-ASCII character é", // string with non-ASCII character
    })
    void githubTestOnSubmitButtonClickWithMalformedInputs(String input) {
        FormController myFormController = new FormController();

        clickOn("#github");
        write(input);

        clickOn("#submitButton");
        assertEquals(input, myFormController.github.getText());
    }


    //phone
    @ParameterizedTest
    @ValueSource(strings = {
//            null, // null string
            "", // empty string
            " ", // whitespace string
            "\t\n\r", // control characters string
            "a" + "\0" + "b", // string with null character
            "This is a very long string that exceeds the maximum length allowed for the field", // string that is too long
            "This string contains some invalid characters such as @#$%^&*()", // string with non-alphanumeric characters
            "This string has a mismatched quote'", // string with unbalanced quotes
            "This string has an escape sequence \\", // string with incomplete escape sequence
            "This string has a non-ASCII character é", // string with non-ASCII character
    })
    void phoneTestOnSubmitButtonClickWithMalformedInputs(String input) {
        FormController myFormController = new FormController();

        clickOn("#phone");
        write(input);

        clickOn("#submitButton");
        assertEquals(input, myFormController.phone.getText());
    }


    //workHistory
    @ParameterizedTest
    @ValueSource(strings = {
//            null, // null string
            "", // empty string
            " ", // whitespace string
            "\t\n\r", // control characters string
            "a" + "\0" + "b", // string with null character
            "This is a very long string that exceeds the maximum length allowed for the field", // string that is too long
            "This string contains some invalid characters such as @#$%^&*()", // string with non-alphanumeric characters
            "This string has a mismatched quote'", // string with unbalanced quotes
            "This string has an escape sequence \\", // string with incomplete escape sequence
            "This string has a non-ASCII character é", // string with non-ASCII character
    })
    void workHistoryTestOnSubmitButtonClickWithMalformedInputs(String input) {
        FormController myFormController = new FormController();

        clickOn("#workHistory");
        write(input);

        clickOn("#submitButton");
        assertEquals(input, myFormController.workHistory.getText());
    }


    //company
    @ParameterizedTest
    @ValueSource(strings = {
//            null, // null string
            "", // empty string
            " ", // whitespace string
            "\t\n\r", // control characters string
            "a" + "\0" + "b", // string with null character
            "This is a very long string that exceeds the maximum length allowed for the field", // string that is too long
            "This string contains some invalid characters such as @#$%^&*()", // string with non-alphanumeric characters
            "This string has a mismatched quote'", // string with unbalanced quotes
            "This string has an escape sequence \\", // string with incomplete escape sequence
            "This string has a non-ASCII character é", // string with non-ASCII character
    })
    void companyTestOnSubmitButtonClickWithMalformedInputs(String input) {
        FormController myFormController = new FormController();

        clickOn("#company");
        write(input);

        clickOn("#submitButton");
        assertEquals(input, myFormController.company.getText());
    }


    //role
    @ParameterizedTest
    @ValueSource(strings = {
//            null, // null string
            "", // empty string
            " ", // whitespace string
            "\t\n\r", // control characters string
            "a" + "\0" + "b", // string with null character
            "This is a very long string that exceeds the maximum length allowed for the field", // string that is too long
            "This string contains some invalid characters such as @#$%^&*()", // string with non-alphanumeric characters
            "This string has a mismatched quote'", // string with unbalanced quotes
            "This string has an escape sequence \\", // string with incomplete escape sequence
            "This string has a non-ASCII character é", // string with non-ASCII character
    })
    void roleTestOnSubmitButtonClickWithMalformedInputs(String input) {
        FormController myFormController = new FormController();

        clickOn("#role");
        write(input);

        clickOn("#submitButton");
        assertEquals(input, myFormController.role.getText());
    }

    //description
    @ParameterizedTest
    @ValueSource(strings = {
//            null, // null string
            "", // empty string
            " ", // whitespace string
            "\t\n\r", // control characters string
            "a" + "\0" + "b", // string with null character
            "This is a very long string that exceeds the maximum length allowed for the field", // string that is too long
            "This string contains some invalid characters such as @#$%^&*()", // string with non-alphanumeric characters
            "This string has a mismatched quote'", // string with unbalanced quotes
            "This string has an escape sequence \\", // string with incomplete escape sequence
            "This string has a non-ASCII character é", // string with non-ASCII character
    })
    void descriptionTestOnSubmitButtonClickWithMalformedInputs(String input) {
        FormController myFormController = new FormController();

        clickOn("#description");
        write(input);

        clickOn("#submitButton");
        assertEquals(input, myFormController.description.getText());
    }


    //education
    @ParameterizedTest
    @ValueSource(strings = {
//            null, // null string
            "", // empty string
            " ", // whitespace string
            "\t\n\r", // control characters string
            "a" + "\0" + "b", // string with null character
            "This is a very long string that exceeds the maximum length allowed for the field", // string that is too long
            "This string contains some invalid characters such as @#$%^&*()", // string with non-alphanumeric characters
            "This string has a mismatched quote'", // string with unbalanced quotes
            "This string has an escape sequence \\", // string with incomplete escape sequence
            "This string has a non-ASCII character é", // string with non-ASCII character
    })
    void educationTestOnSubmitButtonClickWithMalformedInputs(String input) {
        FormController myFormController = new FormController();

        clickOn("#education");
        write(input);

        clickOn("#submitButton");
        assertEquals(input, myFormController.education.getText());
    }


    //schoolYears
    @ParameterizedTest
    @ValueSource(strings = {
//            null, // null string
            "", // empty string
            " ", // whitespace string
            "\t\n\r", // control characters string
            "a" + "\0" + "b", // string with null character
            "This is a very long string that exceeds the maximum length allowed for the field", // string that is too long
            "This string contains some invalid characters such as @#$%^&*()", // string with non-alphanumeric characters
            "This string has a mismatched quote'", // string with unbalanced quotes
            "This string has an escape sequence \\", // string with incomplete escape sequence
            "This string has a non-ASCII character é", // string with non-ASCII character
    })
    void schoolYearsTestOnSubmitButtonClickWithMalformedInputs(String input) {
        FormController myFormController = new FormController();

        clickOn("#schoolYears");
        write(input);

        clickOn("#submitButton");
        assertEquals(input, myFormController.schoolYears.getText());
    }

    //degree
    @ParameterizedTest
    @ValueSource(strings = {
//            null, // null string
            "", // empty string
            " ", // whitespace string
            "\t\n\r", // control characters string
            "a" + "\0" + "b", // string with null character
            "This is a very long string that exceeds the maximum length allowed for the field", // string that is too long
            "This string contains some invalid characters such as @#$%^&*()", // string with non-alphanumeric characters
            "This string has a mismatched quote'", // string with unbalanced quotes
            "This string has an escape sequence \\", // string with incomplete escape sequence
            "This string has a non-ASCII character é", // string with non-ASCII character
    })
    void degreeTestOnSubmitButtonClickWithMalformedInputs(String input) {
        FormController myFormController = new FormController();

        clickOn("#degree");
        write(input);

        clickOn("#submitButton");
        assertEquals(input, myFormController.degree.getText());
    }


    //school
    @ParameterizedTest
    @ValueSource(strings = {
//            null, // null string
            "", // empty string
            " ", // whitespace string
            "\t\n\r", // control characters string
            "a" + "\0" + "b", // string with null character
            "This is a very long string that exceeds the maximum length allowed for the field", // string that is too long
            "This string contains some invalid characters such as @#$%^&*()", // string with non-alphanumeric characters
            "This string has a mismatched quote'", // string with unbalanced quotes
            "This string has an escape sequence \\", // string with incomplete escape sequence
            "This string has a non-ASCII character é", // string with non-ASCII character
    })
    void schoolTestOnSubmitButtonClickWithMalformedInputs(String input) {
        FormController myFormController = new FormController();

        clickOn("#school");
        write(input);

        clickOn("#submitButton");
        assertEquals(input, myFormController.school.getText());
    }


    //major
    @ParameterizedTest
    @ValueSource(strings = {
//            null, // null string
            "", // empty string
            " ", // whitespace string
            "\t\n\r", // control characters string
            "a" + "\0" + "b", // string with null character
            "This is a very long string that exceeds the maximum length allowed for the field", // string that is too long
            "This string contains some invalid characters such as @#$%^&*()", // string with non-alphanumeric characters
            "This string has a mismatched quote'", // string with unbalanced quotes
            "This string has an escape sequence \\", // string with incomplete escape sequence
            "This string has a non-ASCII character é", // string with non-ASCII character
    })
    void majorTestOnSubmitButtonClickWithMalformedInputs(String input) {
        FormController myFormController = new FormController();

        clickOn("#major");
        write(input);

        clickOn("#submitButton");
        assertEquals(input, myFormController.major.getText());
    }


    //gpa
    @ParameterizedTest
    @ValueSource(strings = {
//            null, // null string
            "", // empty string
            " ", // whitespace string
            "\t\n\r", // control characters string
            "a" + "\0" + "b", // string with null character
            "This is a very long string that exceeds the maximum length allowed for the field", // string that is too long
            "This string contains some invalid characters such as @#$%^&*()", // string with non-alphanumeric characters
            "This string has a mismatched quote'", // string with unbalanced quotes
            "This string has an escape sequence \\", // string with incomplete escape sequence
            "This string has a non-ASCII character é", // string with non-ASCII character
    })
    void gpaTestOnSubmitButtonClickWithMalformedInputs(String input) {
        FormController myFormController = new FormController();

        clickOn("#gpa");
        write(input);

        clickOn("#submitButton");
        assertEquals(input, myFormController.gpa.getText());
    }


    //status
    @ParameterizedTest
    @ValueSource(strings = {
//            null, // null string
            "", // empty string
            " ", // whitespace string
            "\t\n\r", // control characters string
            "a" + "\0" + "b", // string with null character
            "This is a very long string that exceeds the maximum length allowed for the field", // string that is too long
            "This string contains some invalid characters such as @#$%^&*()", // string with non-alphanumeric characters
            "This string has a mismatched quote'", // string with unbalanced quotes
            "This string has an escape sequence \\", // string with incomplete escape sequence
            "This string has a non-ASCII character é", // string with non-ASCII character
    })
    void statusTestOnSubmitButtonClickWithMalformedInputs(String input) {
        FormController myFormController = new FormController();

        clickOn("#status");
        write(input);

        clickOn("#submitButton");
        assertEquals(input, myFormController.status.getText());
    }



    /*
    @Test
    void FirstNameNullValue() {

        FormController myFormController = new FormController();

        clickOn("#firstName");
        write(null);

        // submit form
        clickOn("#submitButton");

        // expected

        // actual

        //assertEquals(null, myFormController.firstName.getText());
        assertNull(myFormController.firstName.getText());
    }



    @Test
    void IsFirstNameGreaterThanOneChar() {
        FormController myFormController = new FormController();
        clickOn("#firstName");
        write("John");

        // submit form
        clickOn("#submitButton");

        String firstNameValue = myFormController.firstName.getText();
        assertEquals("John", firstNameValue);
    }

    // null

    @Test
    void isFirstNameEmptyString()
    {
        FormController myFormController = new FormController();
        clickOn("#firstName");
        write("");

        // submit form
        clickOn("#submitButton");
        String firstNameValue = myFormController.firstName.getText();
        assertEquals("", firstNameValue);
    }
    // empty string
    // unexpected characters
    //

    @Test
    void FirstNameContainsSpecialCharactersOrNumbers()
    {
        FormController myFormController = new FormController();
        clickOn("#firstName");
        write("@#$%^*");
    }


     */
}
