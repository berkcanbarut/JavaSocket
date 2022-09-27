package com.brkcnbrt.task;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ShapeScreen extends JPanel{

	private Shape[] shapeList;
	
	public ShapeScreen(Shape[] shapeList) {
		this.shapeList = shapeList;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (Shape shape : this.shapeList) {
			if(shape.getId() == 0) {
				g.setColor(new Color(shape.getR(), shape.getG(), shape.getB()));
				g.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
			}
			else if(shape.getId() == 1) {
				g.setColor(new Color(shape.getR(), shape.getG(), shape.getB()));
				g.fillOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
			}
			else {
				g.setColor(new Color(shape.getR(), shape.getG(), shape.getB()));
				g.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
			}
		}
	}

	@Override
	public void repaint() {
		super.repaint();
	}

	public Shape[] getShapeList() {
		return shapeList;
	}

	public void setShapeList(Shape[] shapeList) {
		this.shapeList = shapeList;
	}
	
	
}
