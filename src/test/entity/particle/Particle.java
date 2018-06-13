package test.entity.particle;

import test.Game;
import test.entity.Entity;
import test.graphics.Screen;
import test.graphics.Sprite;

public class Particle extends Entity{
	
	//private static List<Particle> particles = new ArrayList<Particle>();
	private Sprite sprite;
	
	private int life;
	//private int time = 0; //chernos way see episode 79
	
	protected double xx, xa, yy, ya;
	protected double zz, za, zOffset;
	
	public Particle(int x, int y, int life) {
		this.x = x;
		this.xx = x;
		this.y = y;
		this.yy = y;
		this.life = life / 2 + random.nextInt(life);
		sprite = Sprite.particle_normal;
		
		this.xa = random.nextGaussian();
		this.ya = random.nextGaussian();
		this.zOffset = random.nextFloat() + 2.0;
		this.zz = zOffset;
		
		
	}
	
	
	public void update() {
		life--;
		if(life <= 0) remove();
		
		this.za -= 0.1; // drop rate addition
		if(this.zz <= 0){
			zz = 0;
			za *= 0.5;
			xa *= 0.4;
			ya *= 0.4;
		}
	
		move(xx + xa, yy + ya + zz + za);
	}

	public boolean collision(double x, double y, Sprite sprite) {  // x Offset from the right, y Offset from top
		boolean solid = false;
		
		for(int yi = 0; yi < sprite.getHeight(); yi++) {
			for(int xi = 0; xi < sprite.getWidth(); xi++) {
				if(sprite.pixels[yi * sprite.getWidth() + xi] != 0xffff00ff && level.getTile((int)((x + xi + 1) / 16), ((int)(y + yi - 1) / 16)).getSolid())  return true;
			
			}
		}
		return solid;
	}
	
	public boolean collision(double x, double y) {  // x Offset from the right, y Offset from top
		boolean solid = false;
		
		for(int c = 0; c < 4; c++) {			
			double xt = (x - c % 2 * 16);
			double yt = (y + c / 2 * 16);
			int xi = (int) Math.ceil(xt / Game.TILE_SIZE);
			int yi = (int) Math.ceil(yt / Game.TILE_SIZE);
			if(level.getTile(xi, yi).getSolid()) {
				solid = true;
			}
		}
		return solid;
	}
	
	private void move(double x, double y) {
		
		if(collision(x, y)) {
			this.xa *= -.5;
			this.ya *= -.5;
			this.za *= -.5;
		}
		
		this.xx += xa;
		this.yy += ya;
		this.zz += za;
		

	}


	public void render(Screen screen) {
		screen.renderSprite((int)xx, (int)yy - (int)zz + (int) zOffset, sprite, true);
		
	}
}