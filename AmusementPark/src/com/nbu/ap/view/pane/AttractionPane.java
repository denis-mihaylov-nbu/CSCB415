package com.nbu.ap.view.pane;

import com.nbu.ap.DBManager;
import com.nbu.ap.entity.Attraction;
import com.nbu.ap.entity.AttractionType;
import com.nbu.ap.view.UserView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AttractionPane extends GridPane {

	private UserView userView;
	private Attraction attraction;
	
	private Label nameLabel = new Label("Name : ");
	private Label attractionsLabel = new Label("Attractions : ");
	
	private TextField nameField = new TextField();
	private ComboBox<AttractionType> attractionsComboBox = null;

	private ListView<Attraction> attractionListView = new ListView<Attraction>();
	
	private Button save = new Button("Save");
	private Button cancel = new Button("Cancel");
	
	public AttractionPane() {
		super();
		init();
	}

	public AttractionPane(UserView userView) {
		this();
		this.userView = userView;
	}

	private void init() {
		
		ObservableList<AttractionType> attractionTypes = 
		    FXCollections.observableArrayList(DBManager.read(AttractionType.class));
		attractionsComboBox = new ComboBox<AttractionType>(attractionTypes);
			
		reinitListView();
		
		save.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					saveAttraction(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});		
		
		add(nameLabel, 0, 0);
		add(nameField, 1, 0);
		add(attractionsLabel, 0, 1);
		add(attractionsComboBox, 1, 1);
		add(attractionListView, 0, 2, 2, 1);
		add(save, 0, 3);
		add(cancel, 1, 3);
	}
	
	private void reinitListView() {
		ObservableList<Attraction> items = FXCollections.observableArrayList(DBManager.read(Attraction.class));
		attractionListView.setItems(items);
	}
	
	private void saveAttraction(ActionEvent event) throws Exception {
		attraction = new Attraction(nameField.getText(), attractionsComboBox.getValue());
		DBManager.create(attraction);
		reinitListView();
		userView.restart();
	}
	
}
