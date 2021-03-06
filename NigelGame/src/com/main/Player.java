package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends GameObject{

	Handler handler;

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {
		x += speedX;
		y += speedY;
		
		x = Game.clamp(x, 0, Game.WIDTH-38);
		y = Game.clamp(y, 0, Game.HEIGHT-67);
		
		collision();
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.white, 32, 32, 0.05f, handler));
	}

	private void collision() {
		for(int i=0; i<handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH -=2;
				}
			}
			
			
			
		}
	}
	
	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);		
	}

	public Rectangle getBounds() {

		return new Rectangle(x, y, 32, 32);
	}

}
