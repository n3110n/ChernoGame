package test.entity.mob;

import test.Game;
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
		
		if(xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}

		// -1, 0, 1
		if (!collision(xa, ya))  {
			x += xa;
			y += ya;
		}


	}

	public void update() {

	}

	private boolean collision(int xa, int ya) {
		boolean solid = false;
		
		if(level.getTile((x + xa) / Game.TILE_SIZE, (y + ya) / Game.TILE_SIZE).getSolid()) solid = true;

		return solid;
	}


	public Sprite getSprite() {
		return sprite;
	}

}
