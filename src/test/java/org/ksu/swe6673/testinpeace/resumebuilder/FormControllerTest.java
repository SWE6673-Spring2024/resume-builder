package org.ksu.swe6673.testinpeace.resumebuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.testfx.api.FxAssert;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

class FormUnitTests extends ApplicationTest {

    private FormController formController;
    private FXMLLoader loader;
    private Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        this.loader = new FXMLLoader(getClass().getResource("form.fxml"));
        Parent root = this.loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        // stage.show();
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
    @DisplayName("FormController is initialized")
    void formControllerIsInitialized() {
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

    @Test
    @DisplayName("formController is visible")
    void formControllerIsVisible() {
        assertTrue(formController.firstName.isVisible());
        assertTrue(formController.lastName.isVisible());
        assertTrue(formController.addressStreet.isVisible());
        assertTrue(formController.addressUnit.isVisible());
        assertTrue(formController.addressCity.isVisible());
        assertTrue(formController.addressZip.isVisible());
        assertTrue(formController.email.isVisible());
        assertTrue(formController.linkedin.isVisible());
        assertTrue(formController.github.isVisible());
        assertTrue(formController.phone.isVisible());
        assertTrue(formController.workHistory.isVisible());
        assertTrue(formController.workYears.isVisible());
        assertTrue(formController.company.isVisible());
        assertTrue(formController.role.isVisible());
        assertTrue(formController.description.isVisible());
        assertTrue(formController.education.isVisible());
        assertTrue(formController.schoolYears.isVisible());
        assertTrue(formController.degree.isVisible());
        assertTrue(formController.school.isVisible());
        assertTrue(formController.major.isVisible());
        assertTrue(formController.gpa.isVisible());
        assertTrue(formController.status.isVisible());

        assertTrue(formController.submitLabel.isVisible());
        assertTrue(formController.submitButton.isVisible());
        assertTrue(formController.resetButton.isVisible());
    }

    @ParameterizedTest
    @ValueSource(strings = { "1234567890", "123456789012", "123-456-7890", "123.456.7890", "123 456 7890",
            "(123) 456 7890", "(123)-456-7890", "+123456789012" })
    void validPhoneNumberFormatIsAccepted(String number) {
        formController.phone.setText(number);
        assertTrue(formController.errorMessage.getText().isEmpty(), "No error on a valid phone number");
    }

    @ParameterizedTest
    @ValueSource(strings = { "+1 (123)-456-7890", "123-456-7890 ext 1234", "123-456-7890 x1234", "123-DEFHIJK",
            "12345678", "1-1-1", "+123", "456-7890", "(1) 456 7890" })
    void invalidPhoneNumberFormatIsRejected(String number) {
        formController.phone.setText(number);
        assertEquals("Invalid phone number format", formController.errorMessage.getText());
    }

    @ParameterizedTest
    @ValueSource(strings = { "john@google.com", "john@google.org" })
    void validEmailFormatIsAccepted(String email) {
        formController.email.setText(email);
        assertTrue(formController.errorMessage.getText().isEmpty(), "No error on a valid email");
    }

    @ParameterizedTest
    @ValueSource(strings = { "john@google", "john@.com", "@google.com" })
    void invalidEmailFormatIsRejected(String email) {
        formController.email.setText(email);
        assertEquals("Invalid email format", formController.errorMessage.getText());
    }

    @Test
    @DisplayName("When valid GPA, then no error message")
    void whenGPAIsValid_thenNoErrorMessage() {
        formController.gpa.setText("3.5");
        formController.validateGPA();
        assertTrue(formController.errorMessage.getText().isEmpty(), "No error on a valid GPA");
    }

    @ParameterizedTest
    @ValueSource(strings = { "-0.1", "4.1" })
    @DisplayName("When invalid GPA, then error message")
    void whenGPAIsInvalid_thenErrorMessage(String gpa) {
        formController.gpa.setText(gpa);
        formController.validateGPA();
        assertEquals("GPA must be between 0.0 and 4.0", formController.errorMessage.getText());
    }

    @Test
    @DisplayName("Reset button clears all fields")
    void reset_button_clears_all_fields() {
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

        formController.reset();

        assertNull(formController.firstName.getText());
        assertNull(formController.lastName.getText());
        assertNull(formController.addressStreet.getText());
        assertNull(formController.addressUnit.getText());
        assertNull(formController.addressCity.getText());
        assertNull(formController.addressZip.getText());
        assertNull(formController.email.getText());
        assertNull(formController.linkedin.getText());
        assertNull(formController.github.getText());
        assertNull(formController.phone.getText());
        assertNull(formController.workHistory.getText());
        assertNull(formController.workYears.getText());
        assertNull(formController.company.getText());
        assertNull(formController.role.getText());
        assertNull(formController.description.getText());
        assertNull(formController.education.getText());
        assertNull(formController.schoolYears.getText());
        assertNull(formController.degree.getText());
        assertNull(formController.school.getText());
        assertNull(formController.major.getText());
        assertNull(formController.gpa.getText());
        assertNull(formController.status.getText());
    }

    @Test
    @DisplayName("PDF export is populated")
    void pdf_export_is_populated() throws IOException {
        String firstName = "John";
        formController.firstName.setText(firstName);
        String lastName = "Doe";
        formController.lastName.setText(lastName);
        String addressStreet = "123 Street St.";
        formController.addressStreet.setText(addressStreet);
        String addressUnit = "Apt. 123";
        formController.addressUnit.setText(addressUnit);
        String addressCity = "City";
        formController.addressCity.setText(addressCity);
        String addressZip = "12345";
        formController.addressZip.setText(addressZip);
        String email = "abc@google.com";
        formController.email.setText(email);
        String linkedin = "linkedin.com/in/johndoe";
        formController.linkedin.setText(linkedin);
        String github = "github.com/johndoe";
        formController.github.setText(github);
        String phone = "123-456-7890";
        formController.phone.setText(phone);
        String workHistory = "Software Engineer";
        formController.workHistory.setText(workHistory);
        String workYears = "5";
        formController.workYears.setText(workYears);
        String company = "Google";
        formController.company.setText(company);
        String role = "Software Engineer";
        formController.role.setText(role);
        String description = "Developed software";
        formController.description.setText(description);
        String education = "B.S. Computer Science";
        formController.education.setText(education);
        String schoolYears = "4";
        formController.schoolYears.setText(schoolYears);
        String degree = "B.S.";
        formController.degree.setText(degree);
        String school = "University of Kansas";
        formController.school.setText(school);
        String major = "Computer Science";
        formController.major.setText(major);
        String gpa = "3.5";
        formController.gpa.setText(gpa);
        String status = "Graduated";
        formController.status.setText(status);

        Platform.runLater(() -> formController.submit());

        PDDocument pdf = formController.exportPdf();
        assertNotNull(pdf);
        assertTrue(pdf.getNumberOfPages() > 0);
        String pdfText = new PDFTextStripper().getText(pdf);
        assertTrue(pdfText.contains(firstName));
        assertTrue(pdfText.contains(lastName));
        assertTrue(pdfText.contains(addressStreet));
        assertTrue(pdfText.contains(addressUnit));
        assertTrue(pdfText.contains(addressCity));
        assertTrue(pdfText.contains(addressZip));
        assertTrue(pdfText.contains(email));
        assertTrue(pdfText.contains(linkedin));
        assertTrue(pdfText.contains(github));
        assertTrue(pdfText.contains(phone));
        assertTrue(pdfText.contains(workHistory));
        assertTrue(pdfText.contains(workYears));
        assertTrue(pdfText.contains(company));
        assertTrue(pdfText.contains(role));
        assertTrue(pdfText.contains(description));
        assertTrue(pdfText.contains(education));
        assertTrue(pdfText.contains(schoolYears));
        assertTrue(pdfText.contains(degree));
        assertTrue(pdfText.contains(school));
        assertTrue(pdfText.contains(major));
        assertTrue(pdfText.contains(gpa));
        assertTrue(pdfText.contains(status));
    }

    @Test
    @DisplayName("Error is thrown when blank form is submitted")
    void submitting_blank_form_displays_error() {
        formController.onSubmitButtonClick();
        assertTrue(formController.errorMessage.getText().contains("Required fields are missing"));
    }
}