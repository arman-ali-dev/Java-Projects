// Course.java
package model;

import java.io.Serializable;

public class Course implements Serializable {

    private String courseID;
    private String courseName;
    private Module[] allModules;
    private Module[] mandatoryModules;

    public Course(String courseID, String courseName, Module[] allModules, Module[] mandatoryModules) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.allModules = allModules;
        this.mandatoryModules = mandatoryModules;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public Module[] getAllModules() {
        return allModules;
    }

    public Module[] getMandatoryModules() {
        return mandatoryModules;
    }

    @Override
    public String toString() {
        return courseName + " (" + courseID + ")";
    }
}
