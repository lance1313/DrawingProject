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
		 graphSource = new int [] {5,13,10,16,20};
		 
		setupPanel();
	}
	
	public void setupPanel()
	{
		this.setBackground(Color.BLUE);
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D)currentGraphics;
		for(int index = 0; index < graphSource.length; index++)
		{
			//draw a rectangle for each vaue in the array.
			
			
			 int height = this.getHeight() / graphSource.length;
			 int width = graphSource[index] ;
			int  xPosition = 0;
			int  yPosition = height * index;
			
			int red  = (int)(Math.random() * 256);
			int blue  = (int)(Math.random() * 256);
			int green  = (int)(Math.random() * 256);
			
		
			mainGraphics.setColor(new Color(red, green, blue));
			
			mainGraphics.fill(new Rectangle(xPosition,yPosition,width,height));
			
		}
	}

}
