package com.brkcnbrt.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.google.gson.Gson;

public class ClientMain extends JFrame{
	
	public static void main(String[] args) {
		ClientMain clientMain = new ClientMain();
		ClientMainScreen cmScreen = new ClientMainScreen();
		clientMain.setTitle("Bağlantı Bilgileri Giriş");
		clientMain.setResizable(false);
		clientMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clientMain.setSize(400,300);
		cmScreen.getConnect().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int portNumber = Integer.parseInt(cmScreen.getServerPort().getText());
					String ip = cmScreen.getServerIp().getText();
					
					clientMain.remove(cmScreen);
					clientMain.revalidate();
					clientMain.repaint();
					
					clientMain.setTitle("İstemci");
					clientMain.setSize(650,650);
										
					clientMain.serverConnection(ip,portNumber);
				}
				catch(NumberFormatException exception) {
					cmScreen.getErrorLabel().setText("Giriş bilgileri hatalı veya eksik!");
				}
				
			}
		});
		clientMain.add(cmScreen);
		clientMain.setVisible(true);
	}
	
	public void serverConnection(String ip,int port) {
		Socket client;
		ClientMain clientMain = this;

		try {
			client = new Socket(ip,port);
			ShapeScreen shapeScreen = new ShapeScreen();
			clientMain.add(shapeScreen);
			Thread moveThread = new Thread() {
				 public void run() {
					 while(true) {
							InputStreamReader in;
							try {
								in = new InputStreamReader(client.getInputStream());
								BufferedReader br = new BufferedReader(in);
								Gson gson = new Gson();
								Shape[] shapeList = gson.fromJson(br.readLine(),Shape[].class);
								
								shapeScreen.setShapeList(shapeList);
								shapeScreen.repaint();
								
								clientMain.revalidate();
								clientMain.repaint();
								
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
					 }
				 }
			};
			moveThread.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JLabel errLabel = new JLabel("Bağlantı Hatası Oldu Tekrar Deneyiniz!", SwingConstants.CENTER);
			errLabel.setForeground(Color.red);
			errLabel.setFont(new Font("Serif", Font.PLAIN, 20));
			clientMain.add(errLabel);
			e.printStackTrace();
		}
	}

}
