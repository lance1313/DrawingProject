package ctec.View;

import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

import javax.swing.*;

public class ShapePanel extends JPanel
{
	private ArrayList<Rectangle> rectangleList;
	//more arraylists here
	private ArrayList<Ellipse2D> ellipseList;
	private ArrayList<Polygon> triangleList;
	private ArrayList<Ellipse2D> circleList;
	private ArrayList<Polygon> squareList;
	private ArrayList<Polygon> polygonList;
	
	public ShapePanel()
	{
		triangleList = new ArrayList<Polygon>();
		circleList = new ArrayList<Ellipse2D>();
		squareList = new ArrayList<Polygon>();
		ellipseList = new ArrayList<Ellipse2D>();
		rectangleList= new ArrayList<Rectangle>();
		polygonList= new ArrayList<Polygon>();
		
	}
	
	public void addEllipse()
	{
		int xPoint = (int)(Math.random() * 200);
		int yPoint = (int)(Math.random() * 200);
		int width =  (int)(Math.random() * 100);
		int height =  (int)(Math.random() * 100);
		
		Ellipse2D ellipse = new Ellipse2D.Double(xPoint,yPoint,width,height);
		ellipseList.add(ellipse);
	}
	public void addRectangle()
	{
		int [] xPoints = new int [4];
		int [] yPoints = new int [4];
		//xPoints[0]= (int)(Math.random() * 250);
		xPoints = new int []{(int)(Math.random() * 150),(int)(Math.random() * 250),(int)(Math.random() * 250),(int)(Math.random() * 250)};
		yPoints = new int []{(int)(Math.random() * 150),(int)(Math.random() * 250),(int)(Math.random() * 250),(int)(Math.random() * 250)};
	
		Polygon square = new Polygon(xPoints,yPoints,4);
		squareList.add(square);
	}
	public void addSquare()
	{
		int [] xPoints = new int [4];
		int [] yPoints = new int [4];
		//xPoints[0]= (int)(Math.random() * 250);
		xPoints = new int []{(int)(Math.random() * 250),(int)(Math.random() * 250),(int)(Math.random() * 250),(int)(Math.random() * 250)};
		yPoints = new int []{(int)(Math.random() * 250),(int)(Math.random() * 250),(int)(Math.random() * 250),(int)(Math.random() * 250)};
	
		Polygon square = new Polygon(xPoints,yPoints,4);
		squareList.add(square);
		
	}
	
	public void addTriangle()
	{
		int [] xPoints = new int [3];
		int [] yPoints = new int [3];
		//xPoints[0]= (int)(Math.random() * 250);
		xPoints = new int []{(int)(Math.random() * 250),(int)(Math.random() * 250),(int)(Math.random() * 250)};
		yPoints = new int []{(int)(Math.random() * 250),(int)(Math.random() * 250),(int)(Math.random() * 250)};
	
		Polygon triangle = new Polygon(xPoints,yPoints,3);
		triangleList.add(triangle);

	}
	
	public void addCircle()
	{
		int xPoint = (int)(Math.random() * 200);
		int yPoint = (int)(Math.random() * 200);
		int diameter =  (int)(Math.random() * 10);
		
		Ellipse2D circle = new Ellipse2D.Double(xPoint,yPoint,diameter,diameter);
		circleList.add(circle);
		
	}
	
	public void addPolygon()
	{
		int numberOfSides = (int)(Math.random() * 10)+ 3;
		int [] xPoints = new int [numberOfSides];
		int [] yPoints = new int [numberOfSides];
		for(int sides = 0 ; sides < numberOfSides;sides++)
		{
			 xPoints[sides] = (int)(Math.random() * 200);
			 yPoints[sides] = (int)(Math.random() * 200);
		}
		Polygon myPolygon = new Polygon(xPoints,yPoints,numberOfSides);
		polygonList.add(myPolygon);
		
		
	}
	
	private void drawShapes(Graphics2D mainGraphics,ArrayList<Shape> shapeList)
	{
		for(Shape currentShape : shapeList)
		{
			int red  = (int)(Math.random() * 256);
			int blue  = (int)(Math.random() * 256);
			int green  = (int)(Math.random() * 256);
			
			int pencilSize = (int ) (Math.random() * 15);
			
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(pencilSize));
			if(currentShape instanceof Polygon)
			{
				mainGraphics.draw((Shape)currentShape);
				
			}
			else
			{
				
				mainGraphics.fill((Shape)currentShape);
			}
			
		}
	}
	
	public void clear()
	{
		polygonList.clear();
		circleList.clear();
		rectangleList.clear();
		ellipseList.clear();
		squareList.clear();
		triangleList.clear();
		
	}
	
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D)currentGraphics;

		//draw in here
		
		for(Polygon current : triangleList)
		{
			
			int red  = (int)(Math.random() * 256);
			int blue  = (int)(Math.random() * 256);
			int green  = (int)(Math.random() * 256);
			
			int pencilSize = (int ) (Math.random() * 15);
			
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(pencilSize));
			mainGraphics.draw(current);
			
		}
		for(Polygon current : polygonList)
		{
			
			int red  = (int)(Math.random() * 256);
			int blue  = (int)(Math.random() * 256);
			int green  = (int)(Math.random() * 256);
			
			
			
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.draw(current);
			
		}
		for(Ellipse2D current : circleList)
		{
			
			int red  = (int)(Math.random() * 256);
			int blue  = (int)(Math.random() * 256);
			int green  = (int)(Math.random() * 256);
			
			int pencilSize = (int ) (Math.random() * 15);
			
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(pencilSize));
			mainGraphics.fill(current);
			
		}
		for(Rectangle current : rectangleList)
		{
			
			int red  = (int)(Math.random() * 256);
			int blue  = (int)(Math.random() * 256);
			int green  = (int)(Math.random() * 256);
			
			int pencilSize = (int ) (Math.random() * 15);
			
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(pencilSize));
			mainGraphics.draw(current);
			
		}
		for(Ellipse2D current : ellipseList)
		{
			
			int red  = (int)(Math.random() * 256);
			int blue  = (int)(Math.random() * 256);
			int green  = (int)(Math.random() * 256);
			
			int pencilSize = (int ) (Math.random() * 15);
			
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(pencilSize));
			mainGraphics.fill(current);
			
		}
		for(Polygon current : squareList)
		{
			
			int red  = (int)(Math.random() * 256);
			int blue  = (int)(Math.random() * 256);
			int green  = (int)(Math.random() * 256);
			
			int pencilSize = (int ) (Math.random() * 15);
			
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(pencilSize));
			mainGraphics.fill(current);
			
		}
	}

}
