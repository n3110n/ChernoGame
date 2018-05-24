package test.entity.projectile;

import test.graphics.Screen;
import test.graphics.Sprite;

public class WizProj extends Projectile{

	public WizProj(int xOri, int yOri, double dir) {
		super(xOri, yOri, dir);
		range = 200;
		damage = 20;
		rateOfFire = 15;
		speed = 1;
		sprite = Sprite.WizProjTriForce;
		
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}
	
	public void update() {
		move();
	}
	
	public void render(Screen screen) {
		screen.renderSprite(x, y, sprite);
	}
	
	protected void move() {
		x += nx;
		y += ny;
	}

}
