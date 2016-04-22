package ctec.View;

import javax.swing.*;

public class DrawFrame extends JFrame
{
	private DrawingPanel basePanel;
	private ShapePanel SPanel;
	
	public DrawFrame()
	{
		basePanel = new DrawingPanel();
		SPanel = new ShapePanel();
		setupFrame();
	}
	
	public void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(800, 800);
		this.add(SPanel);
		this.setTitle("Drawing shapes");
		this.setVisible(true);
	}

}
