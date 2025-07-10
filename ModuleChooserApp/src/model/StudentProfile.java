package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentProfile implements Serializable {

    private Name studentName;
    private String email;
    private String date;
    private Course course;

    private List<Module> selectedModules;
    private List<Module> reservedModules;

    public StudentProfile(Name studentName) {
        this.studentName = studentName;
        this.selectedModules = new ArrayList<>();
        this.reservedModules = new ArrayList<>();
    }

    public Name getStudentNameObj() {
        return studentName;
    }

    public void clearSelectedModules() {
        selectedModules.clear();
    }

    public void clearReservedModules() {
        reservedModules.clear();
    }

    public void setStudentName(Name studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void clearAllModules() {
        selectedModules.clear();
        reservedModules.clear();
    }

    public void addSelectedModule(Module module) {
        selectedModules.add(module);
    }

    public void addReservedModule(Module module) {
        reservedModules.add(module);
    }

    public List<Module> getSelectedModules() {
        return selectedModules;
    }

    public List<Module> getReservedModules() {
        return reservedModules;
    }

    public String getStudentName() {
        return studentName.getFirstName() + " " + studentName.getMiddleName() + " " + studentName.getLastName();
    }
}
