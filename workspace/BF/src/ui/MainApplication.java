package ui;


import java.io.File;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import runner.Controller;

public class MainApplication extends Application{
	TextArea codeTextArea;
	TextArea parseTextArea;
	Label resultLabel;
	TextField newNameTextField;
	File[] projects;
	File[] currentVersions;
	Controller controller;
	
	public MainApplication(File[] projects,Controller controller) {
		// TODO Auto-generated constructor stub
		this.projects=projects;
		this.controller=controller;
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		
		BorderPane borderPane=new BorderPane();
		Scene scene=new Scene(borderPane,500,400);
		MenuBar menuBar=new MenuBar();
		//创建file菜单
		Menu fileMenu=new Menu("File"); 
		MenuItem newMenuItem =new MenuItem("New");
		Menu openMenu=new Menu("Open");
		MenuItem saveMenuItem =new MenuItem("Save");
		MenuItem exitMenuItem =new MenuItem("Exit");
		fileMenu.getItems().addAll(newMenuItem,openMenu,saveMenuItem,exitMenuItem);
		
		//对openmenu的赋值，事件监听未实现
		MenuItem[] openMenuItem=new MenuItem[projects.length];
		for (int i = 0; i < projects.length; i++) {
			openMenu.getItems().add(openMenuItem[i]=new MenuItem(projects[i].getName()));
			openMenuItem[i].setOnMenuValidation(new EventHandler<Event>() {
				
				@Override
				public void handle(Event event) {
					// TODO Auto-generated method stub
					
				}
			});
			
		}
		//创建Run菜单
		Menu runMenu=new Menu("Run");
		MenuItem executeMenuItem =new MenuItem("Execute");
		runMenu.getItems().add(executeMenuItem);
		
		//创建Version菜单
		Menu versionMenu=new Menu("Version");
		
		//创建代码输入文本域
		codeTextArea =new TextArea();
		
		//参数输入框与结果显示
		GridPane gridPane=new GridPane();
		parseTextArea=new TextArea();
		parseTextArea.setMaxHeight(scene.getHeight()/3);
		gridPane.add(parseTextArea,0,0);
		
		resultLabel=new Label();
		resultLabel.setMinSize(scene.getWidth()/2, 0);
		resultLabel.setTextAlignment(TextAlignment.CENTER);
		gridPane.add(resultLabel, 1, 0);
		
		GridPane.setMargin(parseTextArea,  new Insets(8,8,8,8));
		GridPane.setMargin(resultLabel,  new Insets(8,8,8,8));
		//将菜单放到menubar中
		menuBar.getMenus().addAll(fileMenu,runMenu,versionMenu);
		//放置位置
		
		BorderPane.setMargin(codeTextArea, new Insets(8,8,8,8));
		
		borderPane.setTop(menuBar);
		borderPane.setCenter(codeTextArea);
		borderPane.setBottom(gridPane);
			
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("BF");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

}
