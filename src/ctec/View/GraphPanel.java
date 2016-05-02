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
	}
	
	protected void paintComonent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		for(int index = 0; index < graphSource.length; index++)
		{
			//draw a rectangle for each vaue in the array.
		}
	}

}
