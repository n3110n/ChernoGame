package test.entity.projectile;

import java.util.Random;

import test.entity.Entity;
import test.graphics.Sprite;

public abstract class Projectile extends Entity{

	protected final int xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double x, y;
	protected double nx, ny; //will change each tick
	public double speed;
	public static double rateOfFire;
	public static double timeBetweenShots;
	public double range;
	public double damage;
	protected double distance;
	protected final Random random = new Random();
	
	
	public Projectile(int xOri, int yOri, double dir) {
		xOrigin = xOri;
		yOrigin = yOri;
		angle = dir;
		this.x = xOri;
		this.y = yOri;
	}
	
	protected void move() {
		
	}
	
	public double calcDistance() {
		double dist = 0;
		
		dist = Math.sqrt( Math.pow((xOrigin - x), 2) + Math.pow((yOrigin - y), 2));
		
		return dist;
	}


	public double getAngle() {
		return angle;
	}


	public void setAngle(double angle) {
		this.angle = angle;
	}


	public Sprite getSprite() {
		return sprite;
	}


	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}


	public double getSpeed() {
		return speed;
	}


	public void setSpeed(double speed) {
		this.speed = speed;
	}


	public double getRateOfFire() {
		return rateOfFire;
	}


	public void setRateOfFire(double rateOfFire) {
		Projectile.rateOfFire = rateOfFire;
	}


	public double getRange() {
		return range;
	}


	public void setRange(double range) {
		this.range = range;
	}


	public double getDamage() {
		return damage;
	}


	public void setDamage(double damage) {
		this.damage = damage;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	

}
