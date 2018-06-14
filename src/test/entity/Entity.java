package test.entity;

import java.util.Random;

import test.graphics.Screen;
import test.graphics.Sprite;
import test.level.Level;

public abstract class Entity {
	 
	public int x, y;
	private Sprite sprite;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	public Entity() {
		
	}
	
	public Entity(int x, int y, Sprite sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	public void update() {
		
	}
	
	public void render(Screen screen) {
		
	}
	
	public void remove() {
		//Remove from level later
		removed = true;
	}

	public boolean isRemoved() {
		return removed;
	}
	
	public void init(Level level) {
		this.level = level;
	}
}
