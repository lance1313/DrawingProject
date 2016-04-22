package ctec.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import ctec.controller.DrawingController;

public class DrawingPanel extends JPanel
{
	private DrawingController baseController;
	private JButton drawRectangleButton;
	private JScrollPane DrawingPane;
	private ShapePanel shapePanel;
	private ArrayList<Rectangle> rectangleList;
	
	public DrawingPanel(DrawingController baseController)
	{
		drawRectangleButton = new JButton("Click");
		shapePanel = new ShapePanel();
		rectangleList = new ArrayList<Rectangle>();
		this.baseController = baseController;
		setupPanel();
	}
	
	
	
	public void setupPanel()
	{
		this.add(drawRectangleButton);
		
	}
	
	public void setupLayout()
	{
		
	}
	
	public void setupListeners()
	{
		drawRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
			int xPosition = (int)(Math.random() * 600);
			int yPosition = (int)(Math.random() * 600);
			int width  = (int)(Math.random() * 50);
			int height = (int)(Math.random() * 50);
			
			rectangleList.add(new Rectangle(xPosition,yPosition,width,height));
			repaint();
			}
		});
			
		
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D)currentGraphics;
		mainGraphics.setStroke(new BasicStroke(5));
		mainGraphics.draw(new Rectangle(10,10,20,40));
		
		for(Rectangle current : rectangleList)
		{
			int randomStroke = (int)(Math.random() * 7);
			int red  = (int)(Math.random() * 256);
			int blue  = (int)(Math.random() * 256);
			int green  = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red,green,blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));
			mainGraphics.fill(current);
			
		}
	}

}
