package math.view;

import javax.swing.JFrame;

import math.controller.RecursionController;

public class RecursionFrame extends JFrame
	{
		private RecursionController baseController;
		private RecursionPanel basePanel;
		
		public RecursionFrame(RecursionController baseController)
		{
			this.baseController = baseController;
			basePanel = new RecursionPanel(baseController);
			
			buildFrame();
		}
		
		private void buildFrame()
		{
			setContentPane(basePanel);
			setSize(500,500);
			setTitle("Recursion: (Noun), see Recursion");
			setVisible(true);
		}
	}
