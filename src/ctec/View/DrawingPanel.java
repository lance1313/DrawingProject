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
	private GraphPanel graphPanel;
	private ArrayList<Rectangle> rectangleList;
	private SpringLayout baseLayout;
	private JButton drawGraphButton;
	
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
		drawGraphButton = new JButton("Make the gaph.");
		
		rectangleList = new ArrayList<Rectangle>();
		shapePanel = new ShapePanel();
		graphPanel = new GraphPanel();
		
		
		
		
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
		this.add(drawGraphButton);
		this.add(drawTriangleButton);
		this.add(drawCirlceButton);
		this.add(drawEllipseButton);
		this.add(drawPolygonButton);
		this.add(drawRectangleButton);
		this.add(graphPanel);
		
		
	}
	
	public void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, drawGraphButton, 0, SpringLayout.WEST, drawEllipseButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, drawGraphButton, -6, SpringLayout.NORTH, drawEllipseButton);
		baseLayout.putConstraint(SpringLayout.NORTH, graphPanel, 47, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, graphPanel, 50, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, graphPanel, 194, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, graphPanel, 261, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 294, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -6, SpringLayout.NORTH, drawPolygonButton);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, 0, SpringLayout.EAST, drawTriangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawRectangleButton, 0, SpringLayout.WEST, drawTriangleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, drawRectangleButton, -6, SpringLayout.NORTH, drawTriangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, drawTriangleButton, 0, SpringLayout.NORTH, drawCirlceButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawCirlceButton, 0, SpringLayout.WEST, clearButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, drawCirlceButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, drawPolygonButton, 0, SpringLayout.WEST, clearButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, drawPolygonButton, -6, SpringLayout.NORTH, drawCirlceButton);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 6, SpringLayout.SOUTH, clearButton);
		baseLayout.putConstraint(SpringLayout.NORTH, drawEllipseButton, 0, SpringLayout.NORTH, drawCirlceButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawEllipseButton, 28, SpringLayout.EAST, drawCirlceButton);
		baseLayout.putConstraint(SpringLayout.EAST, drawTriangleButton, -10, SpringLayout.EAST, this);
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
		
		drawPolygonButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
			shapePanel.addPolygon();
			repaint();
			}
		});
		
		drawEllipseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
			shapePanel.addEllipse();
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
		
		drawGraphButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
			graphPanel.graph();
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
