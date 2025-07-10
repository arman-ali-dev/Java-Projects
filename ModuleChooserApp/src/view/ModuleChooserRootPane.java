package view;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class ModuleChooserRootPane extends BorderPane {

    private CreateProfilePane createProfilePane;
    private SelectModulesPane selectModulesPane;
    private ReserveModulesPane reserveModulesPane;
    private OverviewPane overviewPane;

    private TabPane tabPane;
    private Tab t1, t2, t3, t4;

    public ModuleChooserRootPane() {
        this.createProfilePane = new CreateProfilePane();
        this.selectModulesPane = new SelectModulesPane();
        this.reserveModulesPane = new ReserveModulesPane();
        this.overviewPane = new OverviewPane();

        this.tabPane = new TabPane();
        this.t1 = new Tab("Create Profile", createProfilePane);
        this.t2 = new Tab("Select Modules", selectModulesPane);
        this.t3 = new Tab("Reserve Modules", reserveModulesPane);
        this.t4 = new Tab("Overview", overviewPane);

        // Tabs should not be closable
        t1.setClosable(false);
        t2.setClosable(false);
        t3.setClosable(false);
        t4.setClosable(false);

        // Add tabs to TabPane
        tabPane.getTabs().addAll(t1, t2, t3, t4);

        // Set TabPane as center of BorderPane
        this.setCenter(tabPane);
    }

    // Getters for all sub-panes
    public CreateProfilePane getCreateProfilePane() {
        return createProfilePane;
    }

    public SelectModulesPane getSelectModulesPane() {
        return selectModulesPane;
    }

    public ReserveModulesPane getReserveModulesPane() {
        return reserveModulesPane;
    }

    public OverviewPane getOverviewPane() {
        return overviewPane;
    }

    public TabPane getModuleChooserTabPane() {
        return tabPane;
    }
}
