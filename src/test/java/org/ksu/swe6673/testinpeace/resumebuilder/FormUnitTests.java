package org.ksu.swe6673.testinpeace.resumebuilder;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
class FormUnitTests extends ApplicationTest {

    private FormController formController;
    private FXMLLoader loader;

    @Override
    public void start(Stage stage) throws IOException {
        this.loader = new FXMLLoader(getClass().getResource("form.fxml"));
        Parent root = this.loader.load();
        stage.setScene(new Scene(root));
        stage.show();
        stage.toFront();
    }

    @BeforeEach
    void setUp() {
        this.formController = this.loader.getController();
    }

    @AfterEach
    void tearDown() throws TimeoutException {
        FxToolkit.hideStage();
    }

    @Test
    @DisplayName("Initialize FormController")
    void initializeFormController() {
        assertNotNull(formController);
        assertNotNull(formController.firstName);
        assertNotNull(formController.lastName);
        assertNotNull(formController.addressStreet);
        assertNotNull(formController.addressUnit);
        assertNotNull(formController.addressCity);
        assertNotNull(formController.addressZip);
        assertNotNull(formController.email);
        assertNotNull(formController.linkedin);
        assertNotNull(formController.github);
        assertNotNull(formController.phone);
        assertNotNull(formController.workHistory);
        assertNotNull(formController.workYears);
        assertNotNull(formController.company);
        assertNotNull(formController.role);
        assertNotNull(formController.description);
        assertNotNull(formController.education);
        assertNotNull(formController.schoolYears);
        assertNotNull(formController.degree);
        assertNotNull(formController.school);
        assertNotNull(formController.major);
        assertNotNull(formController.gpa);
        assertNotNull(formController.status);
        assertNotNull(formController.submitLabel);
        assertNotNull(formController.submitButton);
        assertNotNull(formController.resetButton);
    }

    private static Stream<Arguments> phoneNumberIsProperlyFormatted() {
        // Valid inputs will return true, invalid inputs will return false
        return Stream.of(
                Arguments.of("1234567890", true),
                Arguments.of("123456789012", true),
                Arguments.of("123-456-7890", true),
                Arguments.of("123.456.7890", true),
                Arguments.of("123 456 7890", true),
                Arguments.of("(123) 456 7890", true),
                Arguments.of("(123)-456-7890", true),
                Arguments.of("+1 (123)-456-7890", false),
                Arguments.of("+123456789012", true),
                Arguments.of("123-456-7890 ext 1234", false),
                Arguments.of("123-456-7890 x1234", false),
                Arguments.of("123-DEFHIJK", false),
                Arguments.of("12345678", false),
                Arguments.of("1-1-1", false),
                Arguments.of("+123", false),
                Arguments.of("456-7890", false),
                Arguments.of("(1) 456 7890", false)
        );
    }
    @ParameterizedTest
    @MethodSource("phoneNumberIsProperlyFormatted")
    void phoneNumberIsProperlyFormatted(String number, boolean valid) {
        formController.phone.setText(number);
        String actual = formController.phone.getText();
        // refer to: https://ihateregex.io/expr/phone/
        String pattern = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$";
        if (valid) {
            assertTrue(actual.matches(pattern));
        } else {
            assertFalse(actual.matches(pattern));
        }
    }
    
    private static Stream<Arguments> emailIsProperlyFormatted() {
        // Valid inputs will return true, invalid inputs will return false
        return Stream.of(
                Arguments.of("john@google.com", true),
                Arguments.of("john@google.org", true),
                Arguments.of("john@google", false),
                Arguments.of("john@.com", false),
                Arguments.of("@google.com", false)
        );
    }
    @ParameterizedTest
    @MethodSource("emailIsProperlyFormatted")
    void emailIsProperlyFormatted(String email, boolean valid) {
        formController.email.setText(email);
        String actual = formController.email.getText();
        // refer to: https://ihateregex.io/expr/email/
        String pattern = "^[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+";
        if (valid) {
            assertTrue(actual.matches(pattern));
        } else {
            assertFalse(actual.matches(pattern));
        }
    }

    private static Stream<String> malformedStrings() {
        return Stream.of(
                null, // null string
                "", // empty string
                " ", // whitespace string
                "\t\n\r", // control characters string
                "a" + "\0" + "b", // string with null character
                "This is a very long string that exceeds the maximum length allowed for the field", // string that is too long
                "This string contains some invalid characters such as @#$%^&*()", // string with non-alphanumeric characters
                "This string has a mismatched quote'", // string with unbalanced quotes
                "This string has an escape sequence \\", // string with incomplete escape sequence
                "This string has a non-ASCII character é" // string with non-ASCII character
        );
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test firstName submit with malformed inputs")
    void firstNameTestSubmitWithMalformedInputs(String input) {
        formController.firstName.setText(input);
        Platform.runLater(() -> formController.submit());
        assertEquals(input, formController.firstName.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test lastName submit with malformed inputs")
    void lastNameTestSubmitWithMalformedInputs(String input) {
        formController.lastName.setText(input);
        Platform.runLater(() -> formController.submit());
        assertEquals(input, formController.lastName.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test addressStreet submit with malformed inputs")
    void addressStreetTestSubmitWithMalformedInputs(String input) {
        formController.addressStreet.setText(input);
        Platform.runLater(() -> formController.submit());
        assertEquals(input, formController.addressStreet.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test addressUnit submit with malformed inputs")
    void addressUnitTestSubmitWithMalformedInputs(String input) {
        formController.addressUnit.setText(input);
        Platform.runLater(() -> formController.submit());
        assertEquals(input, formController.addressUnit.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test addressCity submit with malformed inputs")
    void addressCityTestSubmitWithMalformedInputs(String input) {
        formController.addressCity.setText(input);
        Platform.runLater(() -> formController.submit());
        assertEquals(input, formController.addressCity.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test addressZip submit with malformed inputs")
    void addressZipTestSubmitWithMalformedInputs(String input) {
        formController.addressZip.setText(input);
        Platform.runLater(() -> formController.submit());
        assertEquals(input, formController.addressZip.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test email submit with malformed inputs")
    void emailTestSubmitWithMalformedInputs(String input) {
        formController.email.setText(input);
        Platform.runLater(() -> formController.submit());
        assertEquals(input, formController.email.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test linkedin submit with malformed inputs")
    void linkedinTestSubmitWithMalformedInputs(String input) {
        formController.linkedin.setText(input);
        Platform.runLater(() -> formController.submit());
        assertEquals(input, formController.linkedin.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test github submit with malformed inputs")
    void githubTestSubmitWithMalformedInputs(String input) {
        formController.github.setText(input);
        Platform.runLater(() -> formController.submit());
        assertEquals(input, formController.github.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test phone submit with malformed inputs")
    void phoneTestSubmitWithMalformedInputs(String input) {
        formController.phone.setText(input);
        Platform.runLater(() -> formController.submit());
        assertEquals(input, formController.phone.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test workHistory submit with malformed inputs")
    void workHistoryTestSubmitWithMalformedInputs(String input) {
        formController.workHistory.setText(input);
        Platform.runLater(() -> formController.submit());
        assertEquals(input, formController.workHistory.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test workYears submit with malformed inputs")
    void workYearsTestSubmitWithMalformedInputs(String input) {
        formController.workYears.setText(input);
        Platform.runLater(() -> formController.submit());
        assertEquals(input, formController.workYears.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test company submit with malformed inputs")
    void companyTestSubmitWithMalformedInputs(String input) {
        formController.company.setText(input);
        Platform.runLater(() -> formController.submit());
        assertEquals(input, formController.company.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test role submit with malformed inputs")
    void roleTestSubmitWithMalformedInputs(String input) {
        formController.role.setText(input);
        Platform.runLater(() -> formController.submit());
        assertEquals(input, formController.role.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test description submit with malformed inputs")
    void descriptionTestSubmitWithMalformedInputs(String input) {
        formController.description.setText(input);
        Platform.runLater(() -> formController.submit());
        assertEquals(input, formController.description.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test education submit with malformed inputs")
    void educationTestSubmitWithMalformedInputs(String input) {
        formController.education.setText(input);
        Platform.runLater(() -> formController.submit());
        assertEquals(input, formController.education.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test schoolYears submit with malformed inputs")
    void schoolYearsTestSubmitWithMalformedInputs(String input) {
        formController.schoolYears.setText(input);
        Platform.runLater(() -> formController.submit());
        assertEquals(input, formController.schoolYears.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test degree submit with malformed inputs")
    void degreeTestSubmitWithMalformedInputs(String input) {
        formController.degree.setText(input);
        Platform.runLater(() -> formController.submit());
        assertEquals(input, formController.degree.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test school submit with malformed inputs")
    void schoolTestSubmitWithMalformedInputs(String input) {
        formController.school.setText(input);
        Platform.runLater(() -> formController.submit());
        assertEquals(input, formController.school.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test major submit with malformed inputs")
    void majorTestSubmitWithMalformedInputs(String input) {
        formController.major.setText(input);
        Platform.runLater(() -> formController.submit());
        assertEquals(input, formController.major.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test gpa submit with malformed inputs")
    void gpaTestSubmitWithMalformedInputs(String input) {
        formController.gpa.setText(input);
        Platform.runLater(() -> formController.submit());
        assertEquals(input, formController.gpa.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test status submit with malformed inputs")
    void statusTestSubmitWithMalformedInputs(String input) {
        formController.status.setText(input);
        Platform.runLater(() -> formController.submit());
        assertEquals(input, formController.status.getText());
    }

    @Test
    @DisplayName("Test exportPdf method")
    void testExportPdf() {
        formController.firstName.setText("John");
        formController.lastName.setText("Doe");
        formController.addressStreet.setText("123 Street St.");
        formController.addressUnit.setText("Apt. 123");
        formController.addressCity.setText("City");
        formController.addressZip.setText("12345");
        formController.email.setText("abc@google.com");
        formController.linkedin.setText("linkedin.com/in/johndoe");
        formController.github.setText("github.com/johndoe");
        formController.phone.setText("123-456-7890");
        formController.workHistory.setText("Software Engineer");
        formController.workYears.setText("5");
        formController.company.setText("Google");
        formController.role.setText("Software Engineer");
        formController.description.setText("Developed software");
        formController.education.setText("B.S. Computer Science");
        formController.schoolYears.setText("4");
        formController.degree.setText("B.S.");
        formController.school.setText("University of Kansas");
        formController.major.setText("Computer Science");
        formController.gpa.setText("3.5");
        formController.status.setText("Graduated");
        Platform.runLater(() -> formController.submit());

        PDDocument pdf = formController.exportPdf();
        assertNotNull(pdf);
        assertTrue(pdf.getNumberOfPages() > 0);
    }
}