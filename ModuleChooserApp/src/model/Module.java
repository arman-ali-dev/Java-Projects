// Module.java
package model;

import java.io.Serializable;

public class Module implements Serializable {

    private String moduleCode;
    private String moduleName;
    private int credits;
    private boolean mandatory;
    private Block delivery;

    public Module(String moduleCode, String moduleName, int credits, boolean mandatory, Block delivery) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.credits = credits;
        this.mandatory = mandatory;
        this.delivery = delivery;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public String getTitle() {
        return moduleName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public int getCredits() {
        return credits;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public Block getDelivery() {
        return delivery;
    }

    @Override
    public String toString() {
        return moduleName;
    }
}
