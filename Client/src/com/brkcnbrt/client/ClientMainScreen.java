package com.brkcnbrt.client;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ClientMainScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField serverIp;
	private JTextField serverPort;
	private JButton connect;
	private JLabel errorLabel;
	public ClientMainScreen() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setLayout(null);
		
		JLabel lbl1 = new JLabel("Sunucu IP :");
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl1.setBounds(10, 32, 140, 32);
		this.add(lbl1);
		
		serverIp = new JTextField();
		serverIp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		serverIp.setToolTipText("Server IP");
		serverIp.setBounds(144, 34, 233, 30);
		this.add(serverIp);
		serverIp.setColumns(10);
		
		JLabel lbl2 = new JLabel("Sunucu Port  :");
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl2.setBounds(10, 105, 140, 32);
		this.add(lbl2);
		
		serverPort = new JTextField();
		serverPort.setFont(new Font("Tahoma", Font.PLAIN, 20));
		serverPort.setToolTipText("Server Port");
		serverPort.setColumns(10);
		serverPort.setBounds(144, 105, 233, 30);
		this.add(serverPort);
		
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		errorLabel.setBounds(10, 173, 367, 23);
		this.add(errorLabel);
		
		connect = new JButton("Bağlan");
		connect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		connect.setBounds(144, 206, 233, 35);
		this.add(connect);
	}

	public JTextField getServerIp() {
		return serverIp;
	}

	public JTextField getServerPort() {
		return serverPort;
	}

	public JButton getConnect() {
		return connect;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JLabel getErrorLabel() {
		return errorLabel;
	}
	
}
