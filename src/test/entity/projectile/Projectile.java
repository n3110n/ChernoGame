package test.entity.projectile;

import test.entity.Entity;
import test.graphics.Sprite;

public abstract class Projectile extends Entity{

	protected final int xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double nx, ny; //will change each tick
	protected double speed, rateOfFire, range, damage;
	
	
	public Projectile(int xOri, int yOri, double dir) {
		xOrigin = xOri;
		yOrigin = yOri;
		angle = dir;
		this.x = xOri;
		this.y = yOri;
	}
	
	protected void move() {
		
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
		this.rateOfFire = rateOfFire;
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
	
	

}