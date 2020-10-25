package seedu.simplykitchen.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import seedu.simplykitchen.commons.core.LogsCenter;
import seedu.simplykitchen.logic.Logic;

/**
 * The Main Window. Provides the basic application layout containing
 * a menu bar and space where other JavaFX elements can be placed.
 */
public class ExpiredFoodWindow extends UiPart<Stage> {

    private static final String FXML = "ExpiredFoodWindow.fxml";

    private final Logger logger = LogsCenter.getLogger(getClass());

    private Logic logic;

    // Independent Ui parts residing in this Ui container
    private ExpiryFoodListPanel expiryListPanel;
    private FoodListPanel foodListPanel;


    @FXML
    private StackPane expiryListPanelPlaceholder;

    @FXML
    private StackPane foodListPanelPlaceholder;

    /**
     * Creates a {@code MainWindow} with the given {@code Stage} and {@code Logic}.
     */
    public ExpiredFoodWindow(Stage stage, Logic logic) {
        super(FXML, stage);

        // Set dependencies
        this.logic = logic;

    }

    /**
     * Fills up all the placeholders of this window.
     */
    void fillInnerParts() {
        expiryListPanel = new ExpiryFoodListPanel(logic.getFilteredExpiringFoodList());
        expiryListPanelPlaceholder.getChildren().add(expiryListPanel.getRoot());
    }

    public FoodListPanel getFoodListPanel() {
        return foodListPanel;
    }

    public ExpiryFoodListPanel getExpiryListPanel() {
        return expiryListPanel;
    }

    void show() {
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        getRoot().hide();
    }
}