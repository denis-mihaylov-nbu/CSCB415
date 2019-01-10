package com.nbu.ap.view;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	UserView userView = new UserView();
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		userView.start(primaryStage);
	}
}