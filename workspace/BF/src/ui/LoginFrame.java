package ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;

public class LoginFrame extends JFrame{

	private JTextField adminTextField;
	private JLabel admin;
	private JLabel passWord;
	private JPasswordField passwordField;
	private JPanel loginPanel;
	private JButton login;
	private JButton sign;
	public LoginFrame() {
		// TODO Auto-generated constructor stub
		//创建登陆窗体
		
//		loginFrame.setLayout(null);
		//创建登陆界面的组件
		loginPanel=new JPanel();
		loginPanel.setBounds(50, 25, 300, 130);
//		loginPanel.setBackground(Color.black);
		loginPanel.setLayout(new GridLayout(3, 2));
		
		admin=new JLabel("                                                    Admin:");
		passWord=new JLabel("                                             Password:");
		adminTextField=new JTextField();
		adminTextField.setBorder(null);
		adminTextField.setBackground(null);
//		adminTextField.setMargin(new Insets(40, 40, 40,40));
		
		passwordField=new JPasswordField();
		passwordField.setBackground(null);
		passwordField.setBorder(null);
//		System.out.println(loginPanel.getAlignmentX());
		
		login=new JButton("Login");
		login.setContentAreaFilled(false);
		login.setBorder(null);
//		login.setFocusPainted(false);
		sign=new JButton("Sign");
		sign.setBorder(null);
		sign.setContentAreaFilled(false);
//		sign.setFocusPainted(false);
		
		loginPanel.add(admin);
		loginPanel.add(adminTextField);
		loginPanel.add(passWord);
		loginPanel.add(passwordField);
		loginPanel.add(sign);
		loginPanel.add(login);
		
		this.add(loginPanel);

		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
