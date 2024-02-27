module org.ksu.swe6673.testinpeace.resumebuilder {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens org.ksu.swe6673.testinpeace.resumebuilder to javafx.fxml;
    exports org.ksu.swe6673.testinpeace.resumebuilder;
}