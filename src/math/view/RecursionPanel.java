package math.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import math.controller.RecursionController;

public class RecursionPanel extends JPanel
	{
		
		private RecursionController baseController;
		
		private JButton fibonacciButton;
		private JButton factorialButton;
		private JTextField inputField;
		private JTextArea resultsArea;
		private SpringLayout baseLayout;
		
		public RecursionPanel(RecursionController baseController)
		{
			this.baseController = baseController;
			
			fibonacciButton = new JButton("Calculate the Fibonacci number");
			factorialButton = new JButton("n!");
			baseLayout = new SpringLayout();
			
			inputField = new JTextField(5);
			resultsArea = new JTextArea(10,15);
			
			setupPanel();
			setupLayout();
			setupListeners();
		}
		
		private void setupPanel()
		{
			setLayout(baseLayout);
			add(fibonacciButton);
			add(factorialButton);
			add(inputField);
			add(resultsArea);
			resultsArea.setWrapStyleWord(true);
			resultsArea.setLineWrap(true);
			resultsArea.setEditable(false);
		}
		
		private void setupLayout()
		{
			baseLayout.putConstraint(SpringLayout.NORTH, resultsArea, 100, SpringLayout.NORTH, this);
			baseLayout.putConstraint(SpringLayout.WEST, resultsArea, 50, SpringLayout.WEST, this);
			baseLayout.putConstraint(SpringLayout.EAST, resultsArea, -50, SpringLayout.EAST, this);
			baseLayout.putConstraint(SpringLayout.NORTH, factorialButton, 1, SpringLayout.SOUTH, fibonacciButton);
			baseLayout.putConstraint(SpringLayout.EAST, factorialButton, -30, SpringLayout.EAST, this);
			baseLayout.putConstraint(SpringLayout.NORTH, fibonacciButton, 23, SpringLayout.NORTH, this);
			baseLayout.putConstraint(SpringLayout.EAST, fibonacciButton, -20, SpringLayout.EAST, this);
		}
		
		private void setupListeners()
		{
			fibonacciButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent click)
					{
						String input = inputField.getText();
						if(checkInput(input))
							{
								resultsArea.setText(baseController.doFibonacci(input));
							}
					}
				});
			
			factorialButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent click)
					{
						String input = inputField.getText();
						if(checkInput(input))
							{
								resultsArea.append(baseController.doFactorial(input));
							}
					}
				});
		}
		
		private boolean checkInput(String input)
		{
			boolean isNumber = false;
			try
			{
					Double.parseDouble(input);
					isNumber = true;
			}
			catch(Exception numberException)
				{
					resultsArea.setText("you must type ina number");
				}
			
			return isNumber;
		}
	}

