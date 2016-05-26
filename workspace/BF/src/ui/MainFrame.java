package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import rmi.RemoteHelper;


public class MainFrame  {
	private JTextArea textArea;
	private JLabel resultLabel;

	JTextField adminTextField;
	private JTextArea inputTestField;
	public MainFrame() {
//		//创建登陆窗体
//		JFrame loginFrame=new JFrame("login");
//		loginFrame.setSize(400, 200);
//		loginFrame.setLocationRelativeTo(null);
//		loginFrame.setVisible(true);
//		loginFrame.setResizable(false);
//		loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
////		loginFrame.setLayout(null);
//		//创建登陆界面的组件
//		JPanel loginPanel=new JPanel();
//		loginPanel.setBounds(50, 25, 300, 130);
////		loginPanel.setBackground(Color.black);
//		loginPanel.setLayout(new GridLayout(3, 2));
		
//		JLabel admin=new JLabel("Admin:");
//		JLabel passWord=new JLabel("Password:");
//		adminTextField=new JTextField();
////		JPasswordField passwordField=new JPasswordField();
////		System.out.println(loginPanel.getAlignmentX());
//		loginPanel.add(admin);
//		loginPanel.add(passWord);
////		loginPanel.add(adminTextField);
////		loginPanel.add(passwordField);
//		
//		loginFrame.add(loginPanel);
		// 创建窗体
		JFrame frame = new JFrame("BF Client");
		frame.setLayout(new BorderLayout());

		//创建菜单框
		JMenuBar menuBar = new JMenuBar();
		//创建File菜单
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		JMenuItem newMenuItem = new JMenuItem("New");
		fileMenu.add(newMenuItem);
		JMenuItem openMenuItem = new JMenuItem("Open");
		fileMenu.add(openMenuItem);
		JMenuItem saveMenuItem = new JMenuItem("Save");
		fileMenu.add(saveMenuItem);
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		fileMenu.add(exitMenuItem);
		//创建Run菜单
		JMenu runMenu=new JMenu("Run");
		menuBar.add(runMenu);
		JMenuItem executeMenuItem=new JMenuItem("Execute");
		runMenu.add(executeMenuItem);
		//创建version菜单
		JMenu versionMenu=new JMenu("Version");
		menuBar.add(versionMenu);
		
		
		frame.setJMenuBar(menuBar);

		newMenuItem.addActionListener(new MenuItemActionListener());
		openMenuItem.addActionListener(new MenuItemActionListener());
		saveMenuItem.addActionListener(new SaveActionListener());
		exitMenuItem.addActionListener(new MenuItemActionListener());

		textArea = new JTextArea();
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setBackground(Color.LIGHT_GRAY);
		frame.add(textArea, BorderLayout.CENTER);

		//输入和输出的Panel
		JPanel iOPanel=new JPanel();
//		iOPanel.setPreferredSize(new Dimension(frame.getWidth(),frame.getHeight()/4));
		iOPanel.setLayout(new GridLayout(1, 2));
		//显示输入框
		inputTestField=new JTextArea(5,10);
//		inputTestField.setBackground(null);
//		inputTestField.setBorder();
		iOPanel.add(inputTestField);
		
		// 显示结果
		resultLabel = new JLabel();
		resultLabel.setText("result");
		
//		resultLabel.setPreferredSize(new Dimension(frame.getWidth()/2,frame.getHeight()/4));
		iOPanel.add(resultLabel);
		frame.add(iOPanel, BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);
		frame.setLocation(400, 200);
//		frame.setVisible(true);
	}

	public String getCode() {
		return textArea.getText();
	}
	
	public String getParam(){
		return inputTestField.getText();
	}
	class MenuItemActionListener implements ActionListener {
		/**
		 * 子菜单响应事件
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if (cmd.equals("Open")) {
				textArea.setText("Open");
			} else if (cmd.equals("Save")) {
				textArea.setText("Save");
			} else if (cmd.equals("Exit")) {
				System.exit(0);
			}
		}
	}

	class SaveActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String code = textArea.getText();
			try {
				RemoteHelper.getInstance().getIOService().writeFile(code, "admin", "code");
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}

	}
}
