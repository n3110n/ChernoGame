package test.entity.projectile;

import test.graphics.Screen;
import test.graphics.Sprite;

public class WizProj extends Projectile{

	public WizProj(int xOri, int yOri, double dir) {
		super(xOri, yOri, dir);
		range = 5;
		damage = 20;
		rateOfFire = 15;
		speed = 3;
		sprite = Sprite.projTri;
		
		//System.out.println("X: " + Math.cos(angle) + " Y: " + Math.sin(angle));
		//System.out.println(angle * 180 / Math.PI);
		
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}
	
	public void update() {
		move();
	}
	
	public void render(Screen screen) {
		screen.renderSprite((int)x - 5, (int)y, sprite);
	}
	
	protected void move() {
		x += nx;
		y += ny;
		if(calcDistance() > range) {
			remove();
		}
	}

	

}
