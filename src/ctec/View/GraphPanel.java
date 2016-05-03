package ctec.View;

import java.awt.*;

import javax.swing.*;

public class GraphPanel extends JPanel
{
	
	private int [] graphSource;
	
	public GraphPanel()
	{
		//initialize graphSource here
		/*
		 * x= 0
		 * width const 20
		 * height based off array
		 */
		int [] graphSource = {5,13,10,16,20};
		 int x = 0;
		 int height = getHeight() / graphSource.length;
		 int y = height * index
	}
	
	public void graph()
	{
		
	}
	
	protected void paintComonent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D)currentGraphics;
		for(int index = 0; index < graphSource.length; index++)
		{
			//draw a rectangle for each vaue in the array.
			int [] xPoints = new int [4];
			int [] yPoints = new int [4];
			
			
			int red  = (int)(Math.random() * 256);
			int blue  = (int)(Math.random() * 256);
			int green  = (int)(Math.random() * 256);
			//xPoints[0]= (int)(Math.random() * 250);
			xPoints = new int []{ 15, 25,25,25};
			yPoints = new int []{graphSource[1],graphSource[2],graphSource[3],graphSource[4]};
		
			int pencilSize = (int ) (Math.random() * 15);
			Polygon rectangle = new Polygon(xPoints,yPoints,4);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(pencilSize));
			mainGraphics.draw(rectangle);
		}
	}

}
