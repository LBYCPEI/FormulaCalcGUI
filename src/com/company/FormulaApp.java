package com.company;

/*
@author cobalt-mkc
date modified: 8/5/2019
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import static javafx.stage.Modality.WINDOW_MODAL;


public class FormulaApp extends Application {

    private double screenWidth, screenHeight;
    private TextField firstInput;
    private TextField secondInput;
    private TextField thirdInput;
    private TextField lblResultValue;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Get Screen size
        Rectangle2D screen = Screen.getPrimary().getVisualBounds();
        screenWidth = screen.getWidth();
        screenHeight = screen.getHeight();

        // Create buttons
        Button btnOne = new Button("Formula 1");
        Button btnTwo = new Button("Formula 2");
        Button btnClose = new Button("Exit");


        // Set button handlers
        btnOne.setOnAction(e -> handleFormula1(primaryStage));
        btnTwo.setOnAction(e -> handleFormula2(primaryStage));
        btnClose.setOnAction(e -> Platform.exit());

        // Label
        Label menu = new Label("MAIN MENU");

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.getChildren().addAll(menu, btnOne, btnTwo, btnClose);

        Scene scene = new Scene(root, screenWidth, screenHeight);
        scene.getStylesheets().add(getClass().getResource("mystyle.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Formula App");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }


    private void handleFormula1(Stage primaryStage) {
        Stage stage = new Stage();
        stage.initOwner(primaryStage);
        stage.initModality(WINDOW_MODAL);

        // Create buttons
        Button btnVolume = new Button("Compute Volume");
        Button btnLength = new Button("Compute Length");
        Button btnWidth = new Button("Compute Width");
        Button btnHeight = new Button("Compute Height");
        Button btnClose = new Button("Go Back To Main");

        // Set button handlers
        btnVolume.setOnAction(e -> handleFormula1(stage, 0));
        btnLength.setOnAction(e -> handleFormula1(stage, 1));
        btnWidth.setOnAction(e -> handleFormula1(stage, 2));
        btnHeight.setOnAction(e -> handleFormula1(stage, 3));
        btnClose.setOnAction(e -> stage.close());

        // Label
        Label menu = new Label("VARIABLE MENU");

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.getChildren().addAll(menu, btnVolume, btnLength, btnWidth, btnHeight, btnClose);

        Scene scene = new Scene(root, screenWidth, screenHeight);
        scene.getStylesheets().add(getClass().getResource("mystyle.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Formula1 Sub-Menu");
        stage.setFullScreen(true);
        stage.show();
    }

    private void handleFormula1(Stage stage, int index) {
        final int choice = index;
        final String labels[] = {"   Length: ", "   Width: ", "   Height: ", "   Volume: "};
        Stage lastStage = new Stage();
        lastStage.initOwner(stage);
        lastStage.initModality(WINDOW_MODAL);

        // Create labels with textfields
        Label lblLength = new Label(labels[index++ % 4]);
        firstInput = new TextField("0.0");
        Label lblWidth = new Label(labels[index++ % 4]);
        secondInput = new TextField("0.0");
        Label lblHeight = new Label(labels[index++ % 4]);
        thirdInput = new TextField("0.0");
        Label lblResult = new Label(labels[index++ % 4]);
        lblResultValue = new TextField("0.0");

        // Create button nodes
        Button btnCompute = new Button("Compute");
        Button btnClose = new Button("Exit to Selection");
        btnCompute.setOnAction(e -> computeFormula1(choice));
        btnClose.setOnAction(e -> lastStage.close());

        // Create the scene
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(20);
        gridPane.add(new HBox(lblLength),0,0);
        gridPane.add(firstInput,1,0);
        gridPane.add(new HBox(lblWidth), 0,1);
        gridPane.add(secondInput,1,1);
        gridPane.add(new HBox(lblHeight), 0,2);
        gridPane.add(thirdInput,1,2);
        gridPane.add(btnCompute,1,3);
        gridPane.add(new HBox(lblResult), 0,4);
        gridPane.add(lblResultValue, 1,4);
        gridPane.add(btnClose,1,5);
        gridPane.setAlignment(Pos.CENTER);

        VBox root = new VBox(gridPane);
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, screenWidth/2, screenHeight);
        scene.getStylesheets().add(getClass().getResource("mystyle.css").toExternalForm());

        // Set the stage
        lastStage.setScene(scene);
        lastStage.setTitle("Formula1 Computation");
        lastStage.show();
    }

    private void computeFormula1(final int index) {
        double first = Double.parseDouble(firstInput.getText());
        double second = Double.parseDouble(secondInput.getText());
        double third = Double.parseDouble(thirdInput.getText());
        switch (index) {
            case 0:
                lblResultValue.setText(String.format("%.2f", Volume.computeVolume(first, second, third)));
                break;
            case 1:
                lblResultValue.setText(String.format("%.2f", Volume.computeLength(first, second, third)));
                break;
            case 2:
                lblResultValue.setText(String.format("%.2f", Volume.computeWidth(first, second, third)));
                break;
            case 3:
                lblResultValue.setText(String.format("%.2f", Volume.computeHeight(first, second, third)));
        }
    }


    private void handleFormula2(Stage primaryStage) {
        /* TODO */
    }
}
