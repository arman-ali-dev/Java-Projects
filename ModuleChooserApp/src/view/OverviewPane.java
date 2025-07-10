// OverviewPane.java
package view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class OverviewPane extends VBox {

    private TextArea overviewArea;
    private Button saveBtn, loadBtn;

    public OverviewPane() {
        this.setPadding(new Insets(20));
        this.setSpacing(10);

        Label heading = new Label("Overview of Student Profile and Module Selections:");

        overviewArea = new TextArea();
        overviewArea.setEditable(false);
        overviewArea.setWrapText(true);
        overviewArea.setPrefHeight(300);

        saveBtn = new Button("Save Overview");
        loadBtn = new Button("Load Profile");

        HBox buttonsBox = new HBox(10, saveBtn, loadBtn);

        this.getChildren().addAll(heading, overviewArea, buttonsBox);
    }

    public TextArea getOverviewArea() {
        return overviewArea;
    }

    public Button getSaveBtn() {
        return saveBtn;
    }

    public Button getLoadBtn() {
        return loadBtn;
    }
}