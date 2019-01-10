package com.nbu.ap.view;

import com.nbu.ap.view.pane.AmusementParkPane;
import com.nbu.ap.view.pane.AttractionPane;
import com.nbu.ap.view.pane.AttractionTypePane;
import com.nbu.ap.view.pane.ManagerPane;
import com.nbu.ap.view.pane.TicketPane;

import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.stage.Stage;

public class UserView {
	
	private Stage stage;
	
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		TabPane tabPane = new TabPane();
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		Tab ticketTab = new Tab("Tickets");
		TicketPane ticketPane = new TicketPane(this);
		ticketTab.setContent(ticketPane);
		tabPane.getTabs().add(ticketTab);
		
		Tab amusementParksTab = new Tab("Amusement parks");
		AmusementParkPane amusementParkGrid = new AmusementParkPane(this);

		amusementParksTab.setContent(amusementParkGrid);
		tabPane.getTabs().add(amusementParksTab);

		Tab attractionsTab = new Tab("Attractions");
		AttractionPane attractionPane = new AttractionPane(this);
		attractionsTab.setContent(attractionPane);
		tabPane.getTabs().add(attractionsTab);

		Tab attractionTypesTab = new Tab("Attraction types");
		AttractionTypePane attractionTypePane = new AttractionTypePane(this);
		attractionTypesTab.setContent(attractionTypePane);
		tabPane.getTabs().add(attractionTypesTab);
		
		Tab managerTab = new Tab("Managers");
		ManagerPane managerPane = new ManagerPane(this);
		managerTab.setContent(managerPane);
		tabPane.getTabs().add(managerTab);

		Scene scene = new Scene(tabPane, 800, 500);
		stage.setScene(scene);
		stage.show();
	}

	public void restart() throws Exception {
		start(stage);
	}
}