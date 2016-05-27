package ui;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import runner.ClientRunner;
import runner.Controller;

public class LoginScene extends Scene{

	GridPane grid;
	
	public LoginScene(Parent root, double width, double height) {
		
		super(root, width, height);
		// TODO Auto-generated constructor stub
		initGridpane();
		this.setRoot(grid);
	}
	private void initGridpane() {
		// TODO Auto-generated method stub
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
        
		Label userName = new Label("User Name:");
        grid.add(userName, 0, 0);

        TextField userNameTextField = new TextField();
        grid.add(userNameTextField, 1, 0);

        Label passWord = new Label("Password:");
        grid.add(passWord, 0, 1);

        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 1);

		Button sign=new Button("Sign");
		HBox signBox=new HBox(10);
		signBox.setAlignment(Pos.BASELINE_RIGHT);
		signBox.getChildren().add(sign);
		grid.add(signBox, 0, 3);
		
		Button login=new Button("Login");
		HBox loginBox=new HBox(10);
		loginBox.setAlignment(Pos.BASELINE_RIGHT);
		loginBox.getChildren().add(login);
 		grid.add(loginBox, 1, 3);
 		
 		
 		Label errorInformation=new Label("             The information is not true!");
 		errorInformation.setTextFill(Color.RED);
 		errorInformation.setVisible(false);
 		grid.add(errorInformation,0,4,2,1);
 		
 		Label signErrorInformation=new Label("             The user has existed!");
 		signErrorInformation.setTextFill(Color.RED);
 		signErrorInformation.setVisible(false);
 		grid.add(signErrorInformation,0,4,2,1);
 	
 		login.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (!ClientRunner.controller.login(userNameTextField.getText(), passwordField.getText())) {
					// TODO Auto-generated method stub
					signErrorInformation.setVisible(false);
					errorInformation.setVisible(true);
				}else {
					ClientRunner.controller.setCurrentUser(userNameTextField.getText());
					ClientRunner.primaryStage.setScene(new MainScene(new BorderPane(), 500, 400));
				}
			}

			
		});
 		sign.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if ((!ClientRunner.controller.signin(userNameTextField.getText(), passwordField.getText()))) {
					signErrorInformation.setVisible(true);
					errorInformation.setVisible(false);
				}else{
					ClientRunner.controller.setCurrentUser(userNameTextField.getText());
					ClientRunner.primaryStage.setScene(new MainScene(new BorderPane(), 500, 400));
				}
			}
 			
		});
	}
	
}
