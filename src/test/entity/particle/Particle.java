package test.entity.particle;

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
		
		this.xa = random.nextGaussian() + 1.8;
		this.ya = random.nextGaussian();
		this.zOffset = random.nextFloat() + 2.0;
		this.zz = zOffset;
		
		if(this.xa < 0) xa = 0.1;
		
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
	
		this.xx += xa;
		this.yy += ya;
		this.zz += za;
	}
	
	public void render(Screen screen) {
		screen.renderSprite((int)xx - 4, (int)yy - (int)zz + (int) zOffset, sprite, true);
		
	}
}