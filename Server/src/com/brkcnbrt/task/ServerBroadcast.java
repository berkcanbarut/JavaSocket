package com.brkcnbrt.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import com.google.gson.Gson;

public class ServerBroadcast extends Thread{

	private int portNumber;
	private Shape[] shapeList;
	public ServerBroadcast(int portNumber,Shape[] shapeList) {
		this.portNumber = portNumber;
		this.shapeList = shapeList;
	}
	//TCP SOCKET
	@Override
	public void run() {
		super.run();
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(this.portNumber);
			Socket client = serverSocket.accept();
			while(true) {
				
				PrintWriter print = new PrintWriter(client.getOutputStream());
				Gson gson = new Gson();
				String jsonString = gson.toJson(this.shapeList);
				print.println(jsonString);
				print.flush();
				Thread.sleep(20);
			}
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Shape[] getShapeList() {
		return shapeList;
 	}
	public void setShapeList(Shape[] shapeList) {
		this.shapeList = shapeList;
	}
	
	
}
