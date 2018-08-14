package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BasicEnemy extends GameObject {
	
	private Handler handler;
	private Random r;

	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);

		this.handler = handler;
		r = new Random();
		speedX = r.nextInt(5)+1;
		speedY = r.nextInt(5)+1;
	}

	public void tick() {
		x+= speedX;
		y+= speedY;
		
		if (y <= 0 || y >= Game.HEIGHT-46) {
			speedY *= -1;
		}
		if (x <= 0 || x >= Game.WIDTH-16) {
			speedX *= -1;
		}
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
	}


	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}

}
