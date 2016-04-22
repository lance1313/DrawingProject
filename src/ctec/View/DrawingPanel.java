package ctec.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import ctec.controller.DrawingController;

/**
 * 
 * @author Jacob
 *
 */
public class DrawingPanel extends JPanel
{
	private DrawingController baseController;
	private JButton drawRectangleButton;
	private JButton drawCirlceButton;
	private JButton drawSquareButton;
	private JButton drawPolygonButton;
	private JButton drawTriangleButton;
	private JButton drawEllipseButton;
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
		setupListeners();
		setupLayout();
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
			int xPosition = (int)(Math.random() * 800);
			int yPosition = (int)(Math.random() * 800);
			int width  = (int)(Math.random() * 50);
			int height = (int)(Math.random() * 50);
			
			rectangleList.add(new Rectangle(xPosition, yPosition, width, height));
			repaint();
			}
		});
			
		
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D)currentGraphics;
		mainGraphics.setColor(Color.BLUE);
		mainGraphics.setStroke(new BasicStroke(5));
		mainGraphics.draw(new Rectangle(10,10,20,40));
		
		for(Rectangle current : rectangleList)
		{
			int randomStroke = (int)(Math.random() * 7);
			int red  = (int)(Math.random() * 256);
			int blue  = (int)(Math.random() * 256);
			int green  = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));
			
			mainGraphics.fill(current);
			
		}
	}

}
