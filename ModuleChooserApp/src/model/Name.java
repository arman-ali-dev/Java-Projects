package model;

import java.io.Serializable;

public class Name implements Serializable {

    private String firstName;
    private String middleName;
    private String lastName;

    // Constructor
    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // toString
    @Override
    public String toString() {
        return firstName + " " + (middleName.isEmpty() ? "" : middleName + " ") + lastName;
    }
}
