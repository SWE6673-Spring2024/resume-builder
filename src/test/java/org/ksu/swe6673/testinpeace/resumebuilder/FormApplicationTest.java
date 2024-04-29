package org.ksu.swe6673.testinpeace.resumebuilder;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.*;

class FormApplicationTest extends ApplicationTest {

    private Scene scene;
    private FormApplication formApplication;

    @Override
    public void start(Stage stage) throws Exception {
        formApplication = new FormApplication();
        formApplication.start(stage);
        scene = stage.getScene();
    }

    @Test
    void windowDimensionsAreCorrect() {
        assertEquals(900, scene.getWidth());
        assertEquals(750, scene.getHeight());
    }

    @Test
    void windowIsVisible() {
        assertTrue(scene.getRoot().isVisible());
        assertTrue(scene.getWindow().isShowing());
    }
}
