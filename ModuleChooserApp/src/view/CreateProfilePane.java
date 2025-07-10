package view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.Course;
import model.Module;
import model.Block;

public class CreateProfilePane extends GridPane {

    private TextField nameField, emailField;
    private DatePicker datePicker;
    private ComboBox<Course> courseComboBox;
    private Button createBtn, resetBtn;

    public CreateProfilePane() {
        this.setPadding(new Insets(20));
        this.setHgap(10);
        this.setVgap(10);

        nameField = new TextField();
        emailField = new TextField();
        datePicker = new DatePicker();
        courseComboBox = new ComboBox<>();
        createBtn = new Button("Create Profile");
        resetBtn = new Button("Reset");

        // Sample modules
        Module[] modules = {
                new Module("CS101", "Intro to CS", 15, true, Block.BLOCK_1),
                new Module("CS102", "OOP", 15, true, Block.BLOCK_2),
                new Module("CS103", "DSA", 15, false, Block.BLOCK_3),
                new Module("CS104", "Databases", 15, false, Block.BLOCK_4)
        };

        Module[] mandatory = {
                modules[0], modules[1]
        };

        courseComboBox.getItems().addAll(
                new Course("BSCS", "Computer Science", modules, mandatory),
                new Course("BSIT", "Information Technology", modules, mandatory));

        this.add(new Label("Name:"), 0, 0);
        this.add(nameField, 1, 0);
        this.add(new Label("Email:"), 0, 1);
        this.add(emailField, 1, 1);
        this.add(new Label("Date of Birth:"), 0, 2);
        this.add(datePicker, 1, 2);
        this.add(new Label("Course:"), 0, 3);
        this.add(courseComboBox, 1, 3);
        this.add(createBtn, 0, 4);
        this.add(resetBtn, 1, 4);
    }

    public TextField getNameField() {
        return nameField;
    }

    public TextField getEmailField() {
        return emailField;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public Course getSelectedCourse() {
        return courseComboBox.getValue();
    }

    public ComboBox<Course> getCourseComboBox() {
        return courseComboBox;
    }

    public Button getCreateBtn() {
        return createBtn;
    }

    public Button getResetBtn() {
        return resetBtn;
    }
}
