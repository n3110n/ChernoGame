package test.entity.mob;

import java.util.ArrayList;
import java.util.List;

import test.Game;
import test.entity.Entity;
import test.entity.projectile.Projectile;
import test.entity.projectile.WizProj;
import test.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 2; // direction
	protected boolean moving = false;
	
	protected List<Entity> entities = new ArrayList<Entity>();

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
	
	protected void shoot(int x, int y, double dir) {

		//System.out.println(Math.atan(dir));
		Projectile p = new WizProj(x, y, dir);
		entities.add(p);
		level.add(p);


		//System.out.println(Math.atan(dir));

	}

	public void update() {

	}

	private boolean collision(int xa, int ya) {
		boolean solid = false;
		
		for(int c = 0; c < 4; c++) {
			
			int xcollision_size = 12;
			int xcollision_offset = 6;
			
			int ycollision_size = 12;
			int ycollision_offset = -3;
			
			int xt = ((x + xa) + c % 2 * xcollision_size - xcollision_offset) / Game.TILE_SIZE;
			int yt = ((y + ya) + c / 2 * ycollision_size - ycollision_offset) / Game.TILE_SIZE;
			if(level.getTile(xt, yt).getSolid()) solid = true;
		}
		

		return solid;
	}


	public Sprite getSprite() {
		return sprite;
	}

}
