package ctec.View;

import java.awt.*;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.*;

public class ShapePanel extends JPanel
{
	private ArrayList<Rectangle> rectangleList;
	
	public ShapePanel()
	{
		rectangleList= new ArrayList<Rectangle>() ;
		addRectangle();
	}
	
	public void addRectangle()
	{
		rectangleList.add(new Rectangle(10,20,50,10));
	}
	
	protected void paintCompoent(Graphics currentGraphics)
	{
		
	}

}
