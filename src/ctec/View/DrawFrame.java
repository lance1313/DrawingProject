package ctec.View;

import javax.swing.*;

import ctec.controller.DrawingController;

public class DrawFrame extends JFrame
{
	private DrawingPanel basePanel;
	private ShapePanel SPanel;
	private DrawingController baseController;
	
	public DrawFrame(DrawingController baseController)
	{
		this.baseController = baseController;
		basePanel = new DrawingPanel(baseController);
		SPanel = new ShapePanel();
		setupFrame();
	}
	
	public void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500, 500);
		this.add(SPanel);
		this.setResizable(false);
		this.setTitle("Drawing shapes");
		this.setVisible(true);
	}

}
