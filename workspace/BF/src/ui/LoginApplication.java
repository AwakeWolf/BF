package ui;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginApplication extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		//设置布局结构
		GridPane grid = new GridPane();
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
 	
 		login.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				errorInformation.setVisible(true);
			}

			
		});
		 
		Scene scene = new Scene(grid, 300, 150);
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("Login");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

}
