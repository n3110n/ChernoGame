package test.entity.particle;

import java.util.ArrayList;
import java.util.List;

import test.entity.Entity;
import test.graphics.Screen;
import test.graphics.Sprite;

public class Particle extends Entity{
	
	private List<Particle> particles = new ArrayList<Particle>();
	private Sprite sprite;
	
	private int life;
	
	public Particle(int x, int y, int life) {
		sprite = Sprite.particle_normal;
		this.life = life;
		this.x = x;
		this.y = y;
		particles.add(this);
		
	}
	
	public Particle(int x, int y, int life, int amount) {
		this(x, y, life);
	
		for(int i = 0; i < amount - 1; i++) {
			particles.add(new Particle(x, y, life));
		}
	}
	
	public void update() {
		
	}
	
	public void render(Screen screen) {
		
	}
}