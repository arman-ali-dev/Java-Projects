package view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.Block;
import model.Module;

public class ReserveModulesPane extends GridPane {

    private ListView<Module> unselectedModulesList, reservedModulesList;
    private Button reserveBtn, removeBtn, confirmBtn;

    public ReserveModulesPane() {
        this.setPadding(new Insets(20));
        this.setHgap(15);
        this.setVgap(15);

        Label unselectedLabel = new Label("Unselected Optional Modules:");
        Label reservedLabel = new Label("Reserved Modules:");

        unselectedModulesList = new ListView<>();
        unselectedModulesList.setPrefHeight(150);

        reservedModulesList = new ListView<>();
        reservedModulesList.setPrefHeight(150);

        reserveBtn = new Button("Reserve >>");
        removeBtn = new Button("<< Remove");
        confirmBtn = new Button("Confirm");

        VBox buttonsBox = new VBox(10, reserveBtn, removeBtn);
        buttonsBox.setPadding(new Insets(40, 0, 0, 0));

        this.add(unselectedLabel, 0, 0);
        this.add(unselectedModulesList, 0, 1);
        this.add(buttonsBox, 1, 1);
        this.add(reservedLabel, 2, 0);
        this.add(reservedModulesList, 2, 1);
        this.add(confirmBtn, 2, 2);

        // Load dummy modules as Module objects
        Module o1 = new Module("O201", "AI Basics", 15, false, Block.BLOCK_2);
        Module o2 = new Module("O202", "Cloud Computing", 15, false, Block.BLOCK_3);
        Module o3 = new Module("O203", "Web Development", 15, false, Block.BLOCK_4);
        Module o4 = new Module("O204", "Cybersecurity", 15, false, Block.BLOCK_4);

        unselectedModulesList.getItems().addAll(o1, o2, o3, o4);

        // 🔁 Reserve button action
        reserveBtn.setOnAction(e -> {
            Module selected = unselectedModulesList.getSelectionModel().getSelectedItem();
            if (selected != null) {
                unselectedModulesList.getItems().remove(selected);
                reservedModulesList.getItems().add(selected);
            }
        });

        // 🔁 Remove button action
        removeBtn.setOnAction(e -> {
            Module selected = reservedModulesList.getSelectionModel().getSelectedItem();
            if (selected != null) {
                reservedModulesList.getItems().remove(selected);
                unselectedModulesList.getItems().add(selected);
            }
        });

        // ✅ Optional confirm alert (actual logic in controller)
        confirmBtn.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Modules confirmed successfully.");
            alert.showAndWait();
        });
    }

    public ListView<Module> getUnselectedModulesList() {
        return unselectedModulesList;
    }

    public ListView<Module> getReservedModulesList() {
        return reservedModulesList;
    }

    public Button getReserveBtn() {
        return reserveBtn;
    }

    public Button getRemoveBtn() {
        return removeBtn;
    }

    public Button getConfirmBtn() {
        return confirmBtn;
    }
}
