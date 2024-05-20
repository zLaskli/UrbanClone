package com.codedotorg;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UrbanExplorer {

    /** The main window to display the app */
    private Stage window;

    /** The width of the scene in the app */
    private int width;

    /** The height of the scene in the app */
    private int height;

    /** The list of cities */
    private ArrayList<City> cities;

    /** The ListView containing the names of cities */
    private ListView<String> listView;

    /** The text field for the user to enter a city */
    private TextField inputField;

    /**
     * Constructs an UrbanExplorer object with the specified window, width, and height.
     * Initializes an empty ArrayList of cities, a ListView of strings, and a TextField for user input.
     *
     * @param window the Stage object representing the application window
     * @param width the width of the application window
     * @param height the height of the application window
     */
    public UrbanExplorer(Stage window, int width, int height) {
        this.window = window;
        this.width = width;
        this.height = height;

        cities = new ArrayList<City>();
        listView = new ListView<String>();
        inputField = new TextField();
    }
    
    /**
     * This method sets the title of the window to "Urban Explorer",
     * creates the main scene and adds the stylesheets to it. Then
     * it sets the main scene to the window and shows it.
     */
    public void startApp() {
        window.setTitle("Urban Explorer");

        Scene mainScene = createMainScene();
        mainScene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        
        window.setScene(mainScene);
        window.show();
    }

    /**
     * Creates the main scene of the UrbanExplorer application.
     * This scene contains an input field, an "Add" button, and a list view.
     * 
     * @return the main scene of the UrbanExplorer application
     */
    public Scene createMainScene() {
        Label titleLabel = new Label("Urban Explorer");
        Button addButton = createAddButton();

        VBox mainLayout = new VBox(10);
        mainLayout.getChildren().addAll(titleLabel, inputField, addButton, listView);

        Scene mainScene = new Scene(mainLayout, width, height);

        return mainScene;
    }

    /**
     * Adds a new city to the list of cities.
     * It first retrieves the city name from the provided TextField input.
     * If the input is not empty, it creates a new City object with the
     * input as the city name, adds it to the cities list, sorts the list,
     * refreshes the list view, and clears the input field.
     */
    public void addCity() {
        String newCity = inputField.getText();

        if (!newCity.isEmpty()) {
            cities.add(new City(newCity));
            refreshList();
            inputField.clear();
        }
    }

    /**
     * Sorts the cities in the 'cities' list based on their names.
     */
    public void sortCities() {
        

    }

    /**
     * Refreshes the list of cities displayed in the listView.
     * It first clears the current items in the listView, then iterates over
     * the 'cities' list, adding the name of each city to the listView.
     */
    public void refreshList() {
        listView.getItems().clear();

        for (City city : cities) {
            listView.getItems().add(city.getName());
        }
    }

    /**
     * Creates a button with the label "Add City" and sets its
     * action to call the addCity() method.
     * 
     * @return the created button
     */
    public Button createAddButton() {
        Button tempButton = new Button("Add City");

        tempButton.setOnAction(event -> {
            addCity();
        });

        return tempButton;
    }

}
