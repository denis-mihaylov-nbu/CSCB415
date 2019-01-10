package com.nbu.ap.view.pane;

import com.nbu.ap.DBManager;
import com.nbu.ap.entity.AttractionType;
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

public class AttractionTypePane extends GridPane {

	private UserView userView;	
	private AttractionType attractionType;
	
	private Label typeLabel = new Label("Type : ");
	private Label nameLabel = new Label("Name : ");
	private Label minAgeLabel = new Label("Min age of user : ");
			
	private TextField nameField = new TextField();
	private TextField minAgeField = new TextField();
	
	private Button save = new Button("Save");
	private Button cancel = new Button("Cancel");
	
	public AttractionTypePane() {
		super();
		init();
	}

	public AttractionTypePane(UserView userView) {
		this();
		this.userView = userView;
	}

	private void init() {
				
		ObservableList<AttractionType> attractionTypes = 
		    FXCollections.observableArrayList(DBManager.read(AttractionType.class));
		ComboBox<AttractionType> typeComboBox = new ComboBox<AttractionType>(attractionTypes);


		save.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					saveAttractionType(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});	
		
		add(typeLabel, 0, 0);
		add(typeComboBox, 1, 0);
		add(nameLabel, 0, 1);
		add(nameField, 1, 1);
		add(minAgeLabel, 0, 2);
		add(minAgeField, 1, 2);
		add(save, 0, 3);
		add(cancel, 1, 3);
	}


	private void saveAttractionType(ActionEvent e) throws Exception {
		if (attractionType != null && attractionType.getId() > 0) {
			DBManager.update(attractionType);
		} else {
			attractionType = new AttractionType(nameField.getText(), Integer.valueOf(minAgeField.getText()));
			DBManager.create(attractionType);
		}
		userView.restart();
	}
}
