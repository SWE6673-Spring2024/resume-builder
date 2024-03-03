package org.ksu.swe6673.testinpeace.resumebuilder;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.testfx.framework.junit5.ApplicationTest;

import com.itextpdf.text.Document;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
class FormControllerTest extends ApplicationTest {

    private FormController formController;

    @BeforeEach
    void setUp() {
        this.formController = new FormController();
    }

    @AfterEach
    void tearDown() {
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
        assertNotNull(formController.contactInfo);
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
    }

    private static Stream<Arguments> phoneNumberIsProperlyFormatted() {
        // Valid inputs will return true, invalid inputs will return false
        return Stream.of(
                Arguments.of("1234567890", true),
                Arguments.of("123-456-7890", true),
                Arguments.of("123.456.7890", true),
                Arguments.of("123 456 7890", true),
                Arguments.of("(123) 456 7890", true),
                Arguments.of("(123)-456-7890", true),
                Arguments.of("+1 (800)-456-7890", true),
                Arguments.of("123-456-7890 ext 1234", false),
                Arguments.of("123-456-7890 x1234", false),
                Arguments.of("abc-def-hijk", false),
                Arguments.of("12345678", false),
                Arguments.of("12345678901", false),
                Arguments.of("1-1-1", false),
                Arguments.of("+982", false),
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
    @DisplayName("Test firstName onSubmitButtonClick with malformed inputs")
    void firstNameTestOnSubmitButtonClickWithMalformedInputs(String input) {
        formController.firstName.setText(input);
        formController.onSubmitButtonClick();
        assertEquals(input, formController.firstName.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test lastName onSubmitButtonClick with malformed inputs")
    void lastNameTestOnSubmitButtonClickWithMalformedInputs(String input) {
        formController.lastName.setText(input);
        formController.onSubmitButtonClick();
        assertEquals(input, formController.lastName.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test addressStreet onSubmitButtonClick with malformed inputs")
    void addressTestOnSubmitButtonClickWithMalformedInputs(String input) {
        formController.addressStreet.setText(input);
        formController.onSubmitButtonClick();
        assertEquals(input, formController.addressStreet.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test addressUnit onSubmitButtonClick with malformed inputs")
    void addressUnitTestOnSubmitButtonClickWithMalformedInputs(String input) {
        formController.addressUnit.setText(input);
        formController.onSubmitButtonClick();
        assertEquals(input, formController.addressUnit.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test addressCity onSubmitButtonClick with malformed inputs")
    void addressCityTestOnSubmitButtonClickWithMalformedInputs(String input) {
        formController.addressCity.setText(input);
        formController.onSubmitButtonClick();
        assertEquals(input, formController.addressCity.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test addressZip onSubmitButtonClick with malformed inputs")
    void addressZipTestOnSubmitButtonClickWithMalformedInputs(String input) {
        formController.addressZip.setText(input);
        formController.onSubmitButtonClick();
        assertEquals(input, formController.addressZip.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test email onSubmitButtonClick with malformed inputs")
    void emailTestOnSubmitButtonClickWithMalformedInputs(String input) {
        formController.email.setText(input);
        formController.onSubmitButtonClick();
        assertEquals(input, formController.email.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test linkedin onSubmitButtonClick with malformed inputs")
    void linkedinTestOnSubmitButtonClickWithMalformedInputs(String input) {
        formController.linkedin.setText(input);
        formController.onSubmitButtonClick();
        assertEquals(input, formController.linkedin.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test github onSubmitButtonClick with malformed inputs")
    void githubTestOnSubmitButtonClickWithMalformedInputs(String input) {
        formController.github.setText(input);
        formController.onSubmitButtonClick();
        assertEquals(input, formController.github.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test phone onSubmitButtonClick with malformed inputs")
    void phoneTestOnSubmitButtonClickWithMalformedInputs(String input) {
        formController.phone.setText(input);
        formController.onSubmitButtonClick();
        assertEquals(input, formController.phone.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test workHistory onSubmitButtonClick with malformed inputs")
    void workHistoryTestOnSubmitButtonClickWithMalformedInputs(String input) {
        formController.workHistory.setText(input);
        formController.onSubmitButtonClick();
        assertEquals(input, formController.workHistory.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test workYears onSubmitButtonClick with malformed inputs")
    void workYearsTestOnSubmitButtonClickWithMalformedInputs(String input) {
        formController.workYears.setText(input);
        formController.onSubmitButtonClick();
        assertEquals(input, formController.workYears.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test company onSubmitButtonClick with malformed inputs")
    void companyTestOnSubmitButtonClickWithMalformedInputs(String input) {
        formController.company.setText(input);
        formController.onSubmitButtonClick();
        assertEquals(input, formController.company.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test role onSubmitButtonClick with malformed inputs")
    void roleTestOnSubmitButtonClickWithMalformedInputs(String input) {
        formController.role.setText(input);
        formController.onSubmitButtonClick();
        assertEquals(input, formController.role.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test description onSubmitButtonClick with malformed inputs")
    void descriptionTestOnSubmitButtonClickWithMalformedInputs(String input) {
        formController.description.setText(input);
        formController.onSubmitButtonClick();
        assertEquals(input, formController.description.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test education onSubmitButtonClick with malformed inputs")
    void educationTestOnSubmitButtonClickWithMalformedInputs(String input) {
        formController.education.setText(input);
        formController.onSubmitButtonClick();
        assertEquals(input, formController.education.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test schoolYears onSubmitButtonClick with malformed inputs")
    void schoolYearsTestOnSubmitButtonClickWithMalformedInputs(String input) {
        formController.schoolYears.setText(input);
        formController.onSubmitButtonClick();
        assertEquals(input, formController.schoolYears.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test degree onSubmitButtonClick with malformed inputs")
    void degreeTestOnSubmitButtonClickWithMalformedInputs(String input) {
        formController.degree.setText(input);
        formController.onSubmitButtonClick();
        assertEquals(input, formController.degree.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test school onSubmitButtonClick with malformed inputs")
    void schoolTestOnSubmitButtonClickWithMalformedInputs(String input) {
        formController.school.setText(input);
        formController.onSubmitButtonClick();
        assertEquals(input, formController.school.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test major onSubmitButtonClick with malformed inputs")
    void majorTestOnSubmitButtonClickWithMalformedInputs(String input) {
        formController.major.setText(input);
        formController.onSubmitButtonClick();
        assertEquals(input, formController.major.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test gpa onSubmitButtonClick with malformed inputs")
    void gpaTestOnSubmitButtonClickWithMalformedInputs(String input) {
        formController.gpa.setText(input);
        formController.onSubmitButtonClick();
        assertEquals(input, formController.gpa.getText());
    }

    @ParameterizedTest
    @MethodSource("malformedStrings")
    @DisplayName("Test status onSubmitButtonClick with malformed inputs")
    void statusTestOnSubmitButtonClickWithMalformedInputs(String input) {
        formController.status.setText(input);
        formController.onSubmitButtonClick();
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
        formController.onSubmitButtonClick();

        Document pdf = formController.exportPdf();
        assertNotNull(pdf);
        assertNotNull(pdf.getAccessibleAttributes());
    }
}