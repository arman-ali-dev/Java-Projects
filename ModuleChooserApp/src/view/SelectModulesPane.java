package view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.Block;
import model.Module;

public class SelectModulesPane extends GridPane {

    private ListView<Module> unselectedModulesList, selectedModulesList;
    private ListView<Module> mandatoryModulesList;
    private Button addBtn, removeBtn, submitBtn, addToUnselectedBtn;
    private TextField moduleInputField;

    public SelectModulesPane() {
        this.setPadding(new Insets(20));
        this.setHgap(15);
        this.setVgap(15);

        Label mandatoryLabel = new Label("Mandatory Modules:");
        Label unselectedLabel = new Label("Unselected Optional Modules:");
        Label selectedLabel = new Label("Selected Optional Modules:");

        // --- ListViews with Module objects now ---
        mandatoryModulesList = new ListView<>();
        mandatoryModulesList.setPrefHeight(120);

        unselectedModulesList = new ListView<>();
        unselectedModulesList.setPrefHeight(150);

        selectedModulesList = new ListView<>();
        selectedModulesList.setPrefHeight(150);

        // Buttons
        addBtn = new Button("Add >>");
        removeBtn = new Button("<< Remove");
        submitBtn = new Button("Submit");

        VBox buttonsBox = new VBox(10, addBtn, removeBtn);
        buttonsBox.setPadding(new Insets(35, 0, 0, 0));

        moduleInputField = new TextField();
        moduleInputField.setPromptText("Enter optional module name");

        addToUnselectedBtn = new Button("Add to Unselected");

        addToUnselectedBtn.setOnAction(e -> {
            String input = moduleInputField.getText();
            if (!input.isEmpty()) {
                Module customModule = new Module("CUSTOM", input, 15, false, Block.BLOCK_4);
                unselectedModulesList.getItems().add(customModule);
                moduleInputField.clear();
            }
        });

        // Add nodes to GridPane
        this.add(mandatoryLabel, 0, 0);
        this.add(mandatoryModulesList, 0, 1, 3, 1);
        this.add(unselectedLabel, 0, 2);
        this.add(unselectedModulesList, 0, 3);
        this.add(buttonsBox, 1, 3);
        this.add(selectedLabel, 2, 2);
        this.add(selectedModulesList, 2, 3);
        this.add(submitBtn, 2, 4);
        this.add(moduleInputField, 0, 5, 2, 1);
        this.add(addToUnselectedBtn, 2, 5);

        // --- Dummy module data ---
        Module m1 = new Module("M101", "Programming Fundamentals", 15, true, Block.BLOCK_1);
        Module m2 = new Module("M102", "Data Structures", 15, true, Block.BLOCK_2);
        Module m3 = new Module("M103", "Operating Systems", 15, true, Block.BLOCK_3);

        mandatoryModulesList.getItems().addAll(m1, m2, m3);

        Module o1 = new Module("O201", "AI Basics", 15, false, Block.BLOCK_2);
        Module o2 = new Module("O202", "Cloud Computing", 15, false, Block.BLOCK_3);
        Module o3 = new Module("O203", "Web Development", 15, false, Block.BLOCK_4);
        Module o4 = new Module("O204", "Cybersecurity", 15, false, Block.BLOCK_4);

        unselectedModulesList.getItems().addAll(o1, o2, o3, o4);
    }

    public ListView<Module> getMandatoryModulesList() {
        return mandatoryModulesList;
    }

    public ListView<Module> getUnselectedModulesList() {
        return unselectedModulesList;
    }

    public ListView<Module> getSelectedModulesList() {
        return selectedModulesList;
    }

    public Button getAddBtn() {
        return addBtn;
    }

    public Button getRemoveBtn() {
        return removeBtn;
    }

    public Button getSubmitBtn() {
        return submitBtn;
    }

    public TextField getModuleInputField() {
        return moduleInputField;
    }

    public Button getAddToUnselectedBtn() {
        return addToUnselectedBtn;
    }
}
