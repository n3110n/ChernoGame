package test.entity.mob;

import test.entity.Entity;
import test.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 2; // direction
	protected boolean moving = false;

	public void move(int xa, int ya) {
		// 0 north, 1 east, 2 south, 3 west
		if (xa > 0)
			dir = 1;
		if (xa < 0)
			dir = 3;
		if (ya > 0)
			dir = 2;
		if (ya < 0)
			dir = 0;

		// -1, 0, 1
		if (!collision()) {
			x += xa;
			y += ya;
		}

	}

	public void update() {

	}

	private boolean collision() {
		return false;
	}

	public Sprite getSprite() {
		return sprite;
	}

}
