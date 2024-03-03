package org.ksu.swe6673.testinpeace.resumebuilder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

class FormUITests extends ApplicationTest {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("form.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();
        stage.toFront();
    }

    @BeforeEach
    public void setUp() throws Exception {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(FormApplication.class);
    }

    @AfterEach
    public void tearDown() throws TimeoutException {
        FxToolkit.hideStage();
    }

    @Test
    @DisplayName("Test if the form is displayed")
    public void testFormIsDisplayed() {
        assertNotNull(lookup("#firstName"));
        assertNotNull(lookup("#lastName"));
        assertNotNull(lookup("#addressStreet"));
        assertNotNull(lookup("#addressUnit"));
        assertNotNull(lookup("#addressCity"));
        assertNotNull(lookup("#addressZip"));
        assertNotNull(lookup("#email"));
        assertNotNull(lookup("#linkedin"));
        assertNotNull(lookup("#github"));
        assertNotNull(lookup("#phone"));
        assertNotNull(lookup("#workHistory"));
        assertNotNull(lookup("#workYears"));
        assertNotNull(lookup("#company"));
        assertNotNull(lookup("#role"));
        assertNotNull(lookup("#description"));
        assertNotNull(lookup("#education"));
        assertNotNull(lookup("#schoolYears"));
        assertNotNull(lookup("#degree"));
        assertNotNull(lookup("#school"));
        assertNotNull(lookup("#major"));
        assertNotNull(lookup("#gpa"));
        assertNotNull(lookup("#status"));
        assertNotNull(lookup("#submitLabel"));
    }

    @Test
    @DisplayName("Test if the form is submitted")
    public void testFormIsSubmitted() {
        clickOn("#firstName").write("John");
        clickOn("#lastName").write("Doe");
        clickOn("#addressStreet").write("1234 Main St");
        clickOn("#addressUnit").write("Apt 101");
        clickOn("#addressCity").write("Manhattan");
        clickOn("#addressZip").write("66502");
        clickOn("#email").write("abc@google.com");
        clickOn("#linkedin").write("linkedin.com/abc");
        clickOn("#github").write("github.com/abc");
        clickOn("#phone").write("123-456-7890");
        clickOn("#workHistory").write("Software Engineer");
        clickOn("#workYears").write("5");
        clickOn("#company").write("ABC Inc");
        clickOn("#role").write("Software Engineer");
        clickOn("#description").write("Developed software applications");
        clickOn("#education").write("MS");
        clickOn("#schoolYears").write("2");
        clickOn("#degree").write("MS");
        clickOn("#school").write("Kansas State University");
        clickOn("#major").write("Computer Science");
        clickOn("#gpa").write("3.5");
        clickOn("#status").write("Graduated");
        clickOn("#submitButton");
        assertNotNull(lookup("#submitLabel"));
    }

    @Test
    @DisplayName("Test if the form is reset")
    public void testFormIsReset() {
        clickOn("#firstName").write("John");
        clickOn("#lastName").write("Doe");
        clickOn("#addressStreet").write("1234 Main St");
        clickOn("#addressUnit").write("Apt 101");
        clickOn("#addressCity").write("Manhattan");
        clickOn("#addressZip").write("66502");
        clickOn("#email").write("abc@google.com");
        clickOn("#linkedin").write("linkedin.com/abc");
        clickOn("#github").write("github.com/abc");
        clickOn("#phone").write("123-456-7890");
        clickOn("#workHistory").write("Software Engineer");
        clickOn("#workYears").write("5");
        clickOn("#company").write("ABC Inc");
        clickOn("#role").write("Software Engineer");
        clickOn("#description").write("Developed software applications");
        clickOn("#education").write("MS");
        clickOn("#schoolYears").write("2");
        clickOn("#degree").write("MS");
        clickOn("#school").write("Kansas State University");
        clickOn("#major").write("Computer Science");
        clickOn("#gpa").write("3.5");
        clickOn("#status").write("Graduated");
        clickOn("#resetButton");
        assertNull(lookup("#firstName").queryTextInputControl().getText());
        assertNull(lookup("#lastName").queryTextInputControl().getText());
        assertNull(lookup("#addressStreet").queryTextInputControl().getText());
        assertNull(lookup("#addressUnit").queryTextInputControl().getText());
        assertNull(lookup("#addressCity").queryTextInputControl().getText());
        assertNull(lookup("#addressZip").queryTextInputControl().getText());
        assertNull(lookup("#email").queryTextInputControl().getText());
        assertNull(lookup("#linkedin").queryTextInputControl().getText());
        assertNull(lookup("#github").queryTextInputControl().getText());
        assertNull(lookup("#phone").queryTextInputControl().getText());
        assertNull(lookup("#workHistory").queryTextInputControl().getText());
        assertNull(lookup("#workYears").queryTextInputControl().getText());
        assertNull(lookup("#company").queryTextInputControl().getText());
        assertNull(lookup("#role").queryTextInputControl().getText());
        assertNull(lookup("#description").queryTextInputControl().getText());
        assertNull(lookup("#education").queryTextInputControl().getText());
        assertNull(lookup("#schoolYears").queryTextInputControl().getText());
        assertNull(lookup("#degree").queryTextInputControl().getText());
        assertNull(lookup("#school").queryTextInputControl().getText());
        assertNull(lookup("#major").queryTextInputControl().getText());
        assertNull(lookup("#gpa").queryTextInputControl().getText());
        assertNull(lookup("#status").queryTextInputControl().getText());
    }

    @Test
    @DisplayName("Test if the form is exported to PDF")
    public void testFormIsExportedToPDF() {
        clickOn("#firstName").write("John");
        clickOn("#lastName").write("Doe");
        clickOn("#addressStreet").write("1234 Main St");
        clickOn("#addressUnit").write("Apt 101");
        clickOn("#addressCity").write("Manhattan");
        clickOn("#addressZip").write("66502");
        clickOn("#email").write("abs@google.com");
        clickOn("#linkedin").write("linkedin.com/abc");
        clickOn("#github").write("github.com/abc");
        clickOn("#phone").write("123-456-7890");
        clickOn("#workHistory").write("Software Engineer");
        clickOn("#workYears").write("5");
        clickOn("#company").write("ABC Inc");
        clickOn("#role").write("Software Engineer");
        clickOn("#description").write("Developed software applications");
        clickOn("#education").write("MS");
        clickOn("#schoolYears").write("2");
        clickOn("#degree").write("MS");
        clickOn("#school").write("Kansas State University");
        clickOn("#major").write("Computer Science");
        clickOn("#gpa").write("3.5");
        clickOn("#status").write("Graduated");
        clickOn("#submitButton");
        // a download dialog should be displayed
        assertNotNull(lookup("Save As"));
    }

}
