package com.brkcnbrt.task;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ServerMainScreen extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField portNumber;
	private JTextField squareNumber;
	private JTextField circleNumber;
	private JTextField rectangleNumber;
	private JLabel errorLabel;
	private JButton start;
	
	public ServerMainScreen() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		// JLabel 1
		JLabel lbl1 = new JLabel("Port :");
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl1.setBounds(10, 30, 179, 27);
		this.add(lbl1);
		// JLabel2
		JLabel lbl2 = new JLabel("Kare Sayısı :");
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl2.setBounds(10, 90, 179, 27);
		this.add(lbl2);
		//JLabel3
		JLabel lbl3 = new JLabel("Daire Sayısı :");
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl3.setBounds(10, 150, 179, 27);
		this.add(lbl3);
		// JLabel4
		JLabel lbl4 = new JLabel("Dikdörtgen Sayısı :");
		lbl4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl4.setBounds(10, 210, 179, 27);
		this.add(lbl4);
		//JLabel Error
		errorLabel = new JLabel("");
		errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(10, 257, 353, 27);
		this.add(errorLabel);
		
		portNumber = new JTextField();
		portNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		portNumber.setToolTipText("port numarası");
		portNumber.setBounds(199, 30, 164, 27);
		this.add(portNumber);
		portNumber.setColumns(10);
		
		squareNumber = new JTextField();
		squareNumber.setToolTipText("kare sayısı");
		squareNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		squareNumber.setColumns(10);
		squareNumber.setBounds(199, 90, 164, 27);
		this.add(squareNumber);
		
		circleNumber = new JTextField();
		circleNumber.setToolTipText("daire sayısı");
		circleNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		circleNumber.setColumns(10);
		circleNumber.setBounds(199, 150, 164, 27);
		this.add(circleNumber);
			
		rectangleNumber = new JTextField();
		rectangleNumber.setToolTipText("dikdörtgen sayısı");
		rectangleNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rectangleNumber.setColumns(10);
		rectangleNumber.setBounds(199, 210, 164, 27);
		this.add(rectangleNumber);
		
		start = new JButton("Başlat");
		start.setFont(new Font("Tahoma", Font.PLAIN, 20));
		start.setBounds(214, 306, 149, 35);
		this.add(start);
	}

	public JTextField getPortNumber() {
		return portNumber;
	}

	public JTextField getSquareNumber() {
		return squareNumber;
	}

	public JTextField getCircleNumber() {
		return circleNumber;
	}

	public JTextField getRectangleNumber() {
		return rectangleNumber;
	}

	public JLabel getErrorLabel() {
		return errorLabel;
	}

	public JButton getStart() {
		return start;
	}
	
}
