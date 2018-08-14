package com.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

public class Window extends Canvas{

	private static final long serialVersionUID = -7297358436874519420L;
	

		
	public Window(int width, int height, String title, Game game) throws IOException {
		JFrame frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
		
	}
}
