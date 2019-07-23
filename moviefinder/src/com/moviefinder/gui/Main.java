package com.moviefinder.gui;

import java.io.IOException;

import com.moviefinder.DBHandler;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	private final DBHandler dbh = new DBHandler();
	private final GUIDriver gd = new GUIDriver(dbh);
	
	@Override
	public final void start(Stage stage) throws IOException {
		gd.buildSplash(stage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
