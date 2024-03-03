package org.ksu.swe6673.testinpeace.resumebuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

class FormControllerTest {

    private FormController formController;

    @BeforeEach
    void setUp() {
        this.formController = new FormController();
    }

    @AfterEach
    void tearDown() {
    }

    /*
    @Test
    @DisplayName("firstName text field is not null")
    void firstNameShouldNotBeNullWhenInitialized() {
        assertNotNull(formController.firstName);
    }

    @Test
    @DisplayName("lastName text field is not null")
    void lastNameShouldNotBeNullWhenInitialized() {
        assertNotNull(formController.lastName);
    }

    @Test
    @DisplayName("address text field is not null")
    void addressShouldNotBeNullWhenInitialized() {
        assertNotNull(formController.address);
    }

    @Test
    @DisplayName("contactInfo text field is not null")
    void contactInfoShouldNotBeNullWhenInitialized() {
        assertNotNull(formController.contactInfo);
    }

    @Test
    @DisplayName("email text field is not null")
    void emailShouldNotBeNullWhenInitialized() {
        assertNotNull(formController.email);
    }

    @Test
    @DisplayName("linkedin text field is not null")
    void linkedinShouldNotBeNullWhenInitialized() {
        assertNotNull(formController.linkedin);
    }

    @Test
    @DisplayName("github text field is not null")
    void githubShouldNotBeNullWhenInitialized() {
        assertNotNull(formController.github);
    }

    @Test
    @DisplayName("phone text field is not null")
    void phoneShouldNotBeNullWhenInitialized() {
        assertNotNull(formController.phone);
    }

    @Test
    @DisplayName("workHistory text field is not null")
    void workHistoryShouldNotBeNullWhenInitialized() {
        assertNotNull(formController.workHistory);
    }

    @Test
    @DisplayName("workYears text field is not null")
    void workYearsShouldNotBeNullWhenInitialized() {
        assertNotNull(formController.workYears);
    }

    @Test
    @DisplayName("company text field is not null")
    void companyShouldNotBeNullWhenInitialized() {
        assertNotNull(formController.company);
    }

    @Test
    @DisplayName("role text field is not null")
    void roleShouldNotBeNullWhenInitialized() {
        assertNotNull(formController.role);
    }

    @Test
    @DisplayName("description text area is not null")
    void descriptionShouldNotBeNullWhenInitialized() {
        assertNotNull(formController.description);
    }

    @Test
    @DisplayName("education text field is not null")
    void educationShouldNotBeNullWhenInitialized() {
        assertNotNull(formController.education);
    }

    @Test
    @DisplayName("schoolYears text field is not null")
    void schoolYearsShouldNotBeNullWhenInitialized() {
        assertNotNull(formController.schoolYears);
    }

    @Test
    @DisplayName("degree text field is not null")
    void degreeShouldNotBeNullWhenInitialized() {
        assertNotNull(formController.degree);
    }

    @Test
    @DisplayName("school text field is not null")
    void schoolShouldNotBeNullWhenInitialized() {
        assertNotNull(formController.school);
    }

    @Test
    @DisplayName("major text field is not null")
    void majorShouldNotBeNullWhenInitialized() {
        assertNotNull(formController.major);
    }

    @Test
    @DisplayName("gpa text field is not null")
    void gpaShouldNotBeNullWhenInitialized() {
        assertNotNull(formController.gpa);
    }

    @Test
    @DisplayName("status text field is not null")
    void statusShouldNotBeNullWhenInitialized() {
        assertNotNull(formController.status);
    }

    @Test
    @DisplayName("submitLabel label is not null")
    void submitLabelShouldNotBeNullWhenInitialized() {
        assertNotNull(formController.submitLabel);
    }

    @Test
    @DisplayName("submitButton button is not null")
    void submitButtonShouldNotBeNullWhenInitialized() {
        assertNotNull(formController.submitButton);
    }
    //*/

    @Test
    @DisplayName("Test exportPdf method")
    void testExportPdf() {
        formController.firstName.setText("John");
        formController.lastName.setText("Doe");
        formController.address.setText("123 Street St.")
    }
}