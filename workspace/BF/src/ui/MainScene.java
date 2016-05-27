package ui;


import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import runner.ClientRunner;
import runner.Controller;

public class MainScene extends Scene{
	
	TextArea codeTextArea;
	TextArea parseTextArea;
	Label resultLabel;
	TextField newNameTextField;
	File[] projects;
	File[] fileList;
	Controller controller;
	BorderPane borderPane;
	String currentproject;
	Menu openMenu;
	Menu versionMenu;
	
//	public MainApplication(File[] projects,Controller controller) {
//		// TODO Auto-generated constructor stub
//		this.projects=projects;
//		this.controller=controller;
//	}
	public MainScene(Parent root, double width, double height) {
		super(root, width, height);
		// TODO Auto-generated constructor stub
		initBorderPane();
		this.setRoot(borderPane);
	}

	private void initBorderPane() {
		// TODO Auto-generated method stub
		borderPane=new BorderPane();
		MenuBar menuBar=new MenuBar();
		//创建Version菜单
		versionMenu=new Menu("Version");
		//创建file菜单
		Menu fileMenu=new Menu("File"); 
		MenuItem newMenuItem =new MenuItem("New");
		openMenu=new Menu("Open");
		MenuItem saveMenuItem =new MenuItem("Save");
		MenuItem logoutMenuItem=new MenuItem("Logout");
		MenuItem exitMenuItem =new MenuItem("Exit");
		fileMenu.getItems().addAll(newMenuItem,openMenu,saveMenuItem,logoutMenuItem ,exitMenuItem);
		
		
		newMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				NewStage newStage=new NewStage(MainScene.this);
			}
		});
		//创建Run菜单
		Menu runMenu=new Menu("Run");
		MenuItem executeMenuItem =new MenuItem("Execute");
		runMenu.getItems().add(executeMenuItem);
		
		initOpenMenu();
		
		//创建代码输入文本域
		codeTextArea =new TextArea();
		
		//参数输入框与结果显示
		GridPane gridPane=new GridPane();
		parseTextArea=new TextArea();
		parseTextArea.setMaxHeight(this.getHeight()/3);
		gridPane.add(parseTextArea,0,0);
		
		resultLabel=new Label();
		resultLabel.setMinSize(this.getWidth()/2, 0);
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
	}

	public void initOpenMenu() {
		//对openMenu的赋值，选择相应项目出现历史版本，并为历史版本处理事件监听
		projects =ClientRunner.controller.getProjects();
		openMenu.getItems().remove(0, openMenu.getItems().size());
		MenuItem[] openMenuItem=new MenuItem[projects.length];
		for (int i = 0; i < projects.length; i++) {
			openMenu.getItems().add(openMenuItem[i]=new MenuItem(projects[i].getName()));
			currentproject=projects[i].getName();
			openMenuItem[i].setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					fileList=ClientRunner.controller.getFileList(((MenuItem)event.getSource()).getText());
					MenuItem[] versionMenuItem=new MenuItem[fileList.length];
					versionMenu.getItems().remove(0, versionMenu.getItems().size());
					for (int j = 0; j < fileList.length; j++) {
						versionMenu.getItems().add(versionMenuItem[j]=new MenuItem(fileList[j].getName()));
						versionMenuItem[j].setOnAction(new EventHandler<ActionEvent>() {
							
							@Override
							public void handle(ActionEvent event) {
								// TODO Auto-generated method stub
								codeTextArea.setText(ClientRunner.controller.readFile(currentproject, ((MenuItem)event.getSource()).getText()));
							}
						});
					}
				}
			});
			
		}

	}

}
