package com.brkcnbrt.task;

public class Shape {
	private int id;
	private int x;
	private int y;
	private int xDirection;
	private int yDirection;
	private int width;
	private int height;
	private int R;
	private int G;
	private int B;
	
	public Shape(int id, int x, int y, int width, int height, int r, int g, int b) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
		this.xDirection = 1;
		this.yDirection = 1;
		this.width = width;
		this.height = height;
		R = r;
		G = g;
		B = b;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getxDirection() {
		return xDirection;
	}

	public void setxDirection(int xDirection) {
		this.xDirection = xDirection;
	}

	public int getyDirection() {
		return yDirection;
	}

	public void setyDirection(int yDirection) {
		this.yDirection = yDirection;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getR() {
		return R;
	}

	public void setR(int r) {
		R = r;
	}

	public int getG() {
		return G;
	}

	public void setG(int g) {
		G = g;
	}

	public int getB() {
		return B;
	}

	public void setB(int b) {
		B = b;
	}
	
}
