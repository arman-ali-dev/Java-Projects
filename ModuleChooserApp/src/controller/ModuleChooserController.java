package controller;

import javafx.scene.control.Alert;
import javafx.stage.Stage;
import model.*;
import model.Module;
import view.*;

public class ModuleChooserController {

    private ModuleChooserRootPane view;
    private StudentProfile studentProfile;

    public ModuleChooserController(ModuleChooserRootPane view) {
        this.view = view;
        attachEventHandlers();
    }

    private void attachEventHandlers() {
        // Create Profile tab
        view.getCreateProfilePane().getCreateBtn().setOnAction(e -> createProfileHandler());
        view.getCreateProfilePane().getResetBtn().setOnAction(e -> resetHandler());

        // Select Modules tab
        view.getSelectModulesPane().getAddBtn().setOnAction(e -> addModuleHandler());
        view.getSelectModulesPane().getRemoveBtn().setOnAction(e -> removeModuleHandler());
        view.getSelectModulesPane().getSubmitBtn().setOnAction(e -> submitHandler());

        // Reserve Modules tab
        view.getReserveModulesPane().getConfirmBtn().setOnAction(e -> confirmHandler());

        // Overview tab
        view.getOverviewPane().getSaveBtn().setOnAction(e -> saveOverviewHandler());
        view.getOverviewPane().getLoadBtn().setOnAction(e -> loadStudentDataHandler());
    }

    private void createProfileHandler() {
        String pName = view.getCreateProfilePane().getNameField().getText();
        String pEmail = view.getCreateProfilePane().getEmailField().getText();
        Course selectedCourse = view.getCreateProfilePane().getSelectedCourse();
        if (view.getCreateProfilePane().getDatePicker().getValue() == null) {
            showAlert("Error", "Please select a date.");
            return;
        }
        String date = view.getCreateProfilePane().getDatePicker().getValue().toString();

        Name name = new Name(pName, "", "");
        studentProfile = new StudentProfile(name);
        studentProfile.setEmail(pEmail);
        studentProfile.setDate(date);
        studentProfile.setCourse(selectedCourse);

        // Move to next tab
        view.getModuleChooserTabPane().getSelectionModel().selectNext();
    }

    private void resetHandler() {
        view.getCreateProfilePane().getNameField().clear();
        view.getCreateProfilePane().getEmailField().clear();
        view.getCreateProfilePane().getDatePicker().setValue(null);
        view.getCreateProfilePane().getCourseComboBox().getSelectionModel().clearSelection();
    }

    private void addModuleHandler() {
        Module selected = view.getSelectModulesPane().getUnselectedModulesList().getSelectionModel().getSelectedItem();
        if (selected != null) {
            view.getSelectModulesPane().getUnselectedModulesList().getItems().remove(selected);
            view.getSelectModulesPane().getSelectedModulesList().getItems().add(selected);
        }
    }

    private void removeModuleHandler() {
        Module selected = view.getSelectModulesPane().getSelectedModulesList().getSelectionModel().getSelectedItem();
        if (selected != null) {
            view.getSelectModulesPane().getSelectedModulesList().getItems().remove(selected);
            view.getSelectModulesPane().getUnselectedModulesList().getItems().add(selected);
        }
    }

    private void submitHandler() {
        studentProfile.clearSelectedModules();

        // ✅ Directly add selected Module objects
        for (Module m : view.getSelectModulesPane().getSelectedModulesList().getItems()) {
            studentProfile.addSelectedModule(m);
        }

        view.getModuleChooserTabPane().getSelectionModel().selectNext();
    }

    private void confirmHandler() {
        studentProfile.clearReservedModules();

        // ✅ Directly add reserved Module objects
        for (Module m : view.getReserveModulesPane().getReservedModulesList().getItems()) {
            studentProfile.addReservedModule(m);
        }

        // Build Overview text
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(studentProfile.getStudentName()).append("\n");
        sb.append("Email: ").append(studentProfile.getEmail()).append("\n");
        sb.append("Date: ").append(studentProfile.getDate()).append("\n");
        sb.append("Course: ").append(studentProfile.getCourse().getCourseName()).append("\n\n");

        sb.append("Mandatory Modules:\n");
        for (Module m : studentProfile.getCourse().getMandatoryModules()) {
            sb.append(" - ").append(m.getModuleName()).append("\n");
        }

        sb.append("\nSelected Optional Modules:\n");
        for (Module m : studentProfile.getSelectedModules()) {
            sb.append(" - ").append(m.getModuleName()).append("\n");
        }

        sb.append("\nReserved Modules:\n");
        for (Module m : studentProfile.getReservedModules()) {
            sb.append(" - ").append(m.getModuleName()).append("\n");
        }

        view.getOverviewPane().getOverviewArea().setText(sb.toString());
        view.getModuleChooserTabPane().getSelectionModel().selectNext();
    }

    private void saveOverviewHandler() {
        try {
            java.io.PrintWriter writer = new java.io.PrintWriter("overview.txt");
            writer.println(view.getOverviewPane().getOverviewArea().getText());
            writer.close();
            showAlert("Success", "Overview saved to overview.txt");
        } catch (Exception e) {
            showAlert("Error", "Failed to save overview.");
        }
    }

    private void saveProfileHandler() {
        try (java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(
                new java.io.FileOutputStream("profile.dat"))) {
            oos.writeObject(studentProfile);
            showAlert("Success", "Profile saved to profile.dat");
        } catch (Exception e) {
            showAlert("Error", "Failed to save profile.");
        }
    }

    private void loadStudentDataHandler() {
        try (java.io.ObjectInputStream ois = new java.io.ObjectInputStream(
                new java.io.FileInputStream("profile.dat"))) {
            studentProfile = (StudentProfile) ois.readObject();
            showAlert("Success", "Student profile loaded from profile.dat");
        } catch (Exception e) {
            showAlert("Error", "Failed to load profile.");
        }
    }

    private void aboutHandler() {
        showAlert("About", "Module Chooser Application\nVersion 1.0\nDeveloped by You");
    }

    private void exitHandler() {
        Stage stage = (Stage) view.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
