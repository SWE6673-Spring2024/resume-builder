module org.ksu.swe6673.testinpeace.resumebuilderui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens org.ksu.swe6673.testinpeace.resumebuilderui to javafx.fxml;
    exports org.ksu.swe6673.testinpeace.resumebuilderui;
}