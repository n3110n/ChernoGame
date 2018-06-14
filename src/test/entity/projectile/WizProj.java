package test.entity.projectile;

import test.entity.spawner.ParticleSpawner;
import test.graphics.Screen;
import test.graphics.Sprite;

public class WizProj extends Projectile{

	public WizProj(int xOri, int yOri, double dir) {
		super(xOri, yOri, dir);
		range = 150 + random.nextInt(100);
		damage = 20;
		rateOfFire = 4; //time between shots
		timeBetweenShots = 60 / rateOfFire; //updates div by shots per sec
		speed = 2.5;
		sprite = Sprite.projTri;
		
		//System.out.println("X: " + Math.cos(angle) + " Y: " + Math.sin(angle));
		//System.out.println(angle * 180 / Math.PI);
		
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}
	
	public void update() {
		if(level.tileCollision(x, y, nx, ny, 7, 4, 4, -1)) { //offset and size values for TriForce Proj
			level.add(new ParticleSpawner((int)x, (int)y, 32, 15, level));
		if(level.tileCollision((int)(x + nx), (int)(y + ny), 11, 7, 4, 2)) { //for tri 
		//need to fix tile collision to work for non square forms!!!
	//	if(level.tileCollision((int)(x + nx), (int)(y + ny), 6, 6, 2, 3)) { //for ball
			level.add(new ParticleSpawner((int)x, (int)y, 32, 15, level)); //move to level pls
			remove(); 
			
		}
			
		
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
