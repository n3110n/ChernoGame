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
	
	public Particle(int x, int y, int life) {
		this.x = x;
		this.xx = x;
		this.y = y;
		this.yy = y;
		this.life = life / 2 + random.nextInt(life);
		sprite = Sprite.particle_normal;
		
		this.xa = random.nextGaussian();
		this.ya = random.nextGaussian();
		
	}
	
	
	public void update() {
		life--;
		if(life <= 0) remove();
		this.xx += xa;
		this.yy += ya;
	}
	
	public void render(Screen screen) {
		screen.renderSprite((int)xx, (int)yy, sprite, true);
		
	}
}