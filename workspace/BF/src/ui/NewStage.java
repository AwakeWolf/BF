package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import runner.ClientRunner;

public class NewStage extends Stage{
	private Scene newScean;
	private GridPane newPane;
	private Label tip;
	private TextField textField;
	private Button okButton;
	private Button cancelButton;
	private Label errorLabel;
	private MainScene mainScene;
	
	public NewStage(MainScene mainScene) {
		// TODO Auto-generated constructor stub
		this.mainScene=mainScene;
		newPane=new GridPane();
		newPane.setAlignment(Pos.CENTER_RIGHT);
		newPane.setHgap(10);
		newPane.setVgap(10);
		newPane.setPadding(new Insets(25, 25, 25, 25));
		
		tip=new Label("Name project:");
		newPane.add(tip, 0, 0);
		
		textField=new TextField();
		newPane.add(textField, 1, 0,1,1);
		
		cancelButton=new Button("Cancel");
		newPane.add(cancelButton,0, 2);
		
		okButton=new Button("  Ok  ");
		HBox signBox=new HBox(10);
		signBox.setAlignment(Pos.BASELINE_RIGHT);
		signBox.getChildren().add(okButton);
		newPane.add(signBox, 1, 2);
		
		errorLabel=new Label("                    Project has existed!");
		errorLabel.setAlignment(Pos.CENTER);
		errorLabel.setTextFill(Color.RED);
		errorLabel.setVisible(false);
		newPane.add(errorLabel, 0, 3,2,1);
		
		cancelButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				NewStage.this.close();
			}
		});
		okButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (ClientRunner.controller.creatNewProject(NewStage.this.textField.getText())) {
					// TODO Auto-generated method stub
					mainScene.initOpenMenu();
					NewStage.this.close();
				}else {
					NewStage.this.errorLabel.setVisible(true);
				}
				
			}
		});
		
		newScean=new Scene(newPane, 320, 100);
		this.setScene(newScean);
		this.show();
	}

}
