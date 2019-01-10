package com.nbu.ap.view.pane;

import com.nbu.ap.DBManager;
import com.nbu.ap.entity.AmusementPark;
import com.nbu.ap.entity.Ticket;
import com.nbu.ap.view.UserView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class TicketPane extends GridPane {

	private UserView userView;
	private Ticket ticket;
	
	private Label amusementParkLabel = new Label("Amusement park : ");
	private Label priceLabel = new Label("Price : ");

	private ComboBox<AmusementPark> amusementParksComboBox;
	private TextField priceField = new TextField();
	
	private Button save = new Button("Save");
	private Button cancel = new Button("Cancel");
	
	public TicketPane() {
		super();
		init();
	}

	public TicketPane(UserView userView) {
		this();
		this.userView = userView;
	}

	private void init() {
		ObservableList<AmusementPark> amusementParks =
		    FXCollections.observableArrayList(DBManager.read(AmusementPark.class));
		amusementParksComboBox = new ComboBox<AmusementPark>(amusementParks);
				
		save.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					saveAmusementPark(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		add(amusementParkLabel, 0, 0);
		add(amusementParksComboBox, 1, 0, 2, 1);
		
		add(priceLabel, 0, 1);
		add(priceField, 1, 1);
		add(save, 0, 2);
		add(cancel, 1, 2);
	}

	private void saveAmusementPark(ActionEvent event) throws Exception {
		ticket = new Ticket(amusementParksComboBox.getValue(), Double.valueOf(priceField.getText()));
		DBManager.create(ticket);
		userView.restart();
	}
	
}
