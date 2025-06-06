package com.internshala.tempconvert;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {
    public static void main(String[] args){
        System.out.println("main");
        launch(args);

    }

    @Override
    public void init() throws Exception {
        System.out.println("init");
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("convert.fxml"));
        VBox rootNode = loader.load();
        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0,menuBar);


        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter");
        primaryStage.show();
    }
    private MenuBar createMenu(){
        Menu filemenu = new Menu("File");
        MenuItem newmenu = new MenuItem("New");
        newmenu.setOnAction(event -> System.out.println("New Menu Item Clicked"));
        SeparatorMenuItem sep = new SeparatorMenuItem();
        MenuItem quitmenu = new MenuItem("Quit");
        quitmenu.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });
        filemenu.getItems().addAll(newmenu,sep,quitmenu);

        Menu helpmenu = new Menu("Help");
        MenuItem aboutmenu = new MenuItem("About");
        aboutmenu.setOnAction(event -> aboutmenu());
        helpmenu.getItems().addAll(aboutmenu);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(filemenu,helpmenu);
        return menuBar;
    }

    private void aboutmenu() {
	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    alert.setTitle("My First Desktop App");
	    alert.setHeaderText("Learning JavaFX");
	    alert.setContentText("I am just a beginner but soon I will be a PRO and start developing awesome JAVA games .");
	    ButtonType yess = new ButtonType("Yes");
	    ButtonType nope = new ButtonType("No");
	    alert.getButtonTypes().setAll(yess,nope);
	    Optional<ButtonType> click = alert.showAndWait();

	    if (click.isPresent() && click.get() == yess){
		    System.out.println("Yes Button Clicked");
	    }
	    else {
		    System.out.println("No Button Clicked");
	    }
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");
        super.stop();
    }
}
