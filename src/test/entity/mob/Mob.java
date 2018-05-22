package test.entity.mob;

import test.entity.Entity;
import test.graphics.Sprite;

public abstract class Mob extends Entity{
	
	protected Sprite sprite;
	protected int direction = 0;
	protected boolean moving = false;
	
	public void move() {
		
	}
	
	public void update() {
		
	}
	
	private boolean collision() {
		return false;
	}

}
