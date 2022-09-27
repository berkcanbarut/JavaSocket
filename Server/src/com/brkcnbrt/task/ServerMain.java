package com.brkcnbrt.task;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;


public class ServerMain extends JFrame{
	private Shape[] shapeList;
	
	public static void main(String[] args) {
		ServerMain main = new ServerMain();
		ServerMainScreen serverScreen = new ServerMainScreen();
		
		main.setTitle("Sunucu Verileri Giriş");
		main.setResizable(false);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(450,450);
		main.add(serverScreen);
		
		serverScreen.getStart().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = main.serverSocketInfo(serverScreen,main);
				if(result != -1) {
					ServerBroadcast serverShape = new ServerBroadcast(result,main.shapeList);
					Thread socketThread = new Thread(serverShape);
					socketThread.start();
					
					main.remove(serverScreen);
					main.revalidate();
					main.repaint();
					
					ShapeScreen shapeScreen = new ShapeScreen(main.shapeList);
					
					main.setSize(650,650);
					main.setTitle("Sunucu");
					main.add(shapeScreen);
					
					Thread moveThread = new Thread() {
					    public void run() {
					    	while(true) {
					    		main.moveToShape();
					    		shapeScreen.setShapeList(main.shapeList);
					    		shapeScreen.repaint();
					    		main.revalidate();
					    		main.repaint();
					    		try {
									Thread.sleep(20);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					    	}
					    }
					};
					moveThread.start();
					
				}
			}
		});
		
		main.setVisible(true);
	}

	public int serverSocketInfo(ServerMainScreen serverScreen, ServerMain main) {
		try {
			Integer[] connectionInfo = inputValue(serverScreen);
			main.shapeList = createShape(connectionInfo[1], connectionInfo[2], connectionInfo[3]);
			return connectionInfo[0];
		}
		catch(NumberFormatException exception) {
			serverScreen.getErrorLabel().setText("Giriş bilgileri hatalı veya eksik!");
			return -1;
		}
	}
	
	public Integer[] inputValue(ServerMainScreen serverScreen) {
		Integer[] connectionInfo = new Integer[4];
		connectionInfo[0] = Integer.parseInt(serverScreen.getPortNumber().getText());
		connectionInfo[1] = Integer.parseInt(serverScreen.getSquareNumber().getText());
		connectionInfo[2] = Integer.parseInt(serverScreen.getCircleNumber().getText());
		connectionInfo[3] = Integer.parseInt(serverScreen.getRectangleNumber().getText());
		return connectionInfo;
	}
	
	public Shape[] createShape(int squareNumber,int circleNumber,int rectangleNumber) {
		Random random = new Random();
		int arrayLength = squareNumber+circleNumber+rectangleNumber;
		Shape[] shapeList = new Shape[arrayLength];
		int counter = 0;
		for(int i=0;i<squareNumber;i++) {
			int width = random.nextInt(60) + 20;
			int x = random.nextInt(500);
			int y = random.nextInt(500);
			
			int R = random.nextInt(256);
			int G = random.nextInt(256);
			int B= random.nextInt(256);
			
			Shape s = new Shape(0, x, y, width,width,R,G,B);
			shapeList[counter] = s;
			counter++;
		}
		
		for(int i=0;i<circleNumber;i++) {
			int width = random.nextInt(60) + 20;
			int x = random.nextInt(500);
			int y = random.nextInt(500);
			
			int R = random.nextInt(256);
			int G = random.nextInt(256);
			int B= random.nextInt(256);
			
			Shape s = new Shape(1, x, y,width,width,R,G,B);
			shapeList[counter] = s;
			counter++;
		}
		
		for(int i=0;i<rectangleNumber;i++) {
			int width = random.nextInt(60) + 20;
			int height = width + random.nextInt(20) + 10;
			int x = random.nextInt(500);
			int y = random.nextInt(500);
			
			int R = random.nextInt(256);
			int G = random.nextInt(256);
			int B= random.nextInt(256);
			
			Shape s = new Shape(2, x, y, width,height,R,G,B);
			shapeList[counter] = s;
			counter++;
		}
		return shapeList;
	}
	
	public void moveToShape() {

		for (Shape shape : this.shapeList) {
			float choice = (float) Math.random() * 2;
			
			if(choice > 1) {
				if((shape.getX() + shape.getWidth()) == 610) {
					shape.setxDirection(-1);
				}
				if(shape.getX() == 1) {
					shape.setxDirection(1);
				}
				shape.setX(shape.getX() + shape.getxDirection());
			}
			else {
				if((shape.getY() + shape.getHeight()) == 610) {
					shape.setyDirection(-1);
				}
				if(shape.getY() == 1) {
					shape.setyDirection(1);
				}
				shape.setY(shape.getY() + shape.getyDirection());
			}
		}
		
	}

}
