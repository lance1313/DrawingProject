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
	private JButton clearButton;
	private JButton drawCirlceButton;
	private JButton drawSquareButton;
	private JButton drawPolygonButton;
	private JButton drawTriangleButton;
	private JButton drawEllipseButton;
	private JScrollPane DrawingPane;
	private ShapePanel shapePanel;
	private ArrayList<Rectangle> rectangleList;
	private SpringLayout baseLayout;
	
	public DrawingPanel(DrawingController baseController)
	{
		baseLayout = new SpringLayout();
		drawTriangleButton = new JButton("Make triangles");
		
		drawRectangleButton = new JButton("Make rectangles");
		clearButton = new JButton("clear the lists");
		drawCirlceButton = new JButton("Make circles");
		
		drawSquareButton= new JButton("Make squares");
		drawPolygonButton= new JButton("Make polygons");
		
		drawEllipseButton = new JButton("Make ellipses");
		
		rectangleList = new ArrayList<Rectangle>();
		shapePanel = new ShapePanel();
		
		this.baseController = baseController;
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	
	
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(shapePanel);
		this.add(clearButton);
		this.add(drawTriangleButton);
		this.add(drawCirlceButton);
		this.add(drawEllipseButton);
		this.add(drawPolygonButton);
		this.add(drawRectangleButton);
		
		
	}
	
	public void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 100, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 100, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, 190, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, 364, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, drawEllipseButton, 250, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, drawEllipseButton, 150, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, drawPolygonButton, 200, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, drawCirlceButton, 250, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, drawRectangleButton, 200, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, drawRectangleButton, 150, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, drawTriangleButton, 200, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, drawTriangleButton, 300, SpringLayout.WEST, this);
	}
	
	public void setupListeners()
	{
		drawTriangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
			shapePanel.addTriangle();
			repaint();
			}
		});
		
		drawCirlceButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
			shapePanel.addCircle();
			repaint();
			}
		});
		drawRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
			shapePanel.addRectangle();
			repaint();
			}
		});
		drawSquareButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
			shapePanel.addSquare();
			repaint();
			}
		});
		
		clearButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.clear();
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
		
		
		for(Rectangle current : rectangleList)
		{
			int randomStroke = (int)(Math.random() * 7);
			int red  = (int)(Math.random() * 256);
			int blue  = (int)(Math.random() * 256);
			int green  = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));
			//mainGraphics.draw(current);
			mainGraphics.fill(current);
			
		}
	}

}
