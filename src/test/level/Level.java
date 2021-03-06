package test.level;

import java.util.ArrayList;
import java.util.List;

import test.Game;
import test.entity.Entity;
import test.entity.particle.Particle;
import test.entity.projectile.Projectile;
import test.graphics.Screen;
import test.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	
	private List<Entity> entities = new ArrayList<Entity>();
	private List<Projectile> projectiles = new ArrayList<Projectile>();
	private List<Particle> particles = new ArrayList<Particle>();
	
	public static Level spawn = new SpawnLevel("/level/spawn.png");

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];

		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
		
		
	}

	protected void loadLevel(String path) {

	}

	protected void generateLevel() {

	}
	
	public boolean tileCollision(int x, int y, int width, int height, int xOffset, int yOffset) {  // x Offset from the right, y Offset from top
		boolean solid = false;
		
		for(int c = 0; c < 4; c++) {			
			int xt = (x - c % 2 * width + xOffset + 1) / Game.TILE_SIZE;
			int yt = (y + c / 2 * height + yOffset - 1) / Game.TILE_SIZE;
			if(this.getTile(xt, yt).getSolid()) {
				solid = true;
			}
		}
		return solid;
	}
	
	public boolean tileCollision(int x, int y, int size, int xOffset, int yOffset) {
		return tileCollision(x, y, size, size, xOffset, yOffset);
	}
	
	
	private void remove() {
		for(int i = 0; i < entities.size(); i++) {
			if(entities.get(i).isRemoved()) entities.remove(i);
		}
		
		for(int i = 0; i < projectiles.size(); i++) {
			if(projectiles.get(i).isRemoved()) projectiles.remove(i);
		}
		
		for(int i = 0; i < particles.size(); i++) {
			if(particles.get(i).isRemoved()) particles.remove(i);
		}
		
	}

	public void update() {
		for(int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
		
		for(int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		
		for(int i = 0; i < particles.size(); i++) {
			particles.get(i).update();
		}
		remove();
	}		

	public void render(int xScroll, int yScroll, Screen screen) {

		screen.setOffset(xScroll, yScroll);

		int x0 = xScroll >> 4; // >> 4 = / 16
		int x1 = (xScroll + screen.width + Tile.voidTile.sprite.getSIZE()) >> 4;
		int y0 = yScroll >> 4; // >> 4 = / 16
		int y1 = (yScroll + screen.height + Tile.voidTile.sprite.getSIZE()) >> 4;

		// System.out.println(x0 + " " + x1 + " " + y0 + " " + y1);

		for (int y = y0; y < y1; y++) { // from top to bottom border of the screen
			for (int x = x0; x < x1; x++) { // from left to right on the Screen
				// System.out.println(x + " " + y);
				getTile(x, y).render(x, y, screen);

			}
		}
		for(int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
		
		for(int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).render(screen);
		}
		
		for(int i = 0; i < particles.size(); i++) {
			particles.get(i).render(screen);
		}
		
	}

	// 0xff00FF00 Grass
	// 0xffFFFF00 Flower
	// 0xff7F7F00 Rock
	public Tile getTile(int x, int y) {
		if (x + y * width < 0 || x + y * width >= tiles.length)
			return Tile.voidTile;

		if(tiles[x + y * width] == Tile.col_grass0) return Tile.grass0;
		if(tiles[x + y * width] == Tile.col_grass1) return Tile.grass1;
		if(tiles[x + y * width] == Tile.col_grass2) return Tile.grass2;
		if(tiles[x + y * width] == Tile.col_grass3) return Tile.grass3;
		if(tiles[x + y * width] == Tile.col_grass4) return Tile.grass4;
		if(tiles[x + y * width] == Tile.col_grass5) return Tile.grass5;
		if(tiles[x + y * width] == Tile.col_fire0) return Tile.fire0;
		if(tiles[x + y * width] == Tile.col_fire1) return Tile.fire1;
		if(tiles[x + y * width] == Tile.col_firered) return Tile.firered;
		if(tiles[x + y * width] == Tile.col_rockybright) return Tile.rockybright;
		if(tiles[x + y * width] == Tile.col_rockygrass) return Tile.rockygrass;
		if(tiles[x + y * width] == Tile.col_rockydark) return Tile.rockydark;
		if(tiles[x + y * width] == Tile.col_waterdark) return Tile.waterdark;
		if(tiles[x + y * width] == Tile.col_waterbright) return Tile.waterbright;
		if(tiles[x + y * width] == Tile.col_watermedium) return Tile.watermedium;
		if(tiles[x + y * width] == Tile.col_wallrock) return Tile.wallrock;
		if(tiles[x + y * width] == Tile.col_wallbrick0) return Tile.wallbrick0;
		if(tiles[x + y * width] == Tile.col_wallbrick1) return Tile.wallbrick1;
		if(tiles[x + y * width] == Tile.col_wallbrickred) return Tile.wallbrickred;
		if(tiles[x + y * width] == Tile.col_wallbrickorange) return Tile.wallbrickorange;
		if(tiles[x + y * width] == Tile.col_wallbrickblue) return Tile.wallbrickblue;
		if(tiles[x + y * width] == Tile.col_wallbrickmixed) return Tile.wallbrickmixed;
		if(tiles[x + y * width] == Tile.col_wallbrickwhite) return Tile.wallbrickwhite;
		if(tiles[x + y * width] == Tile.col_wallwood) return Tile.wallwood;
		if(tiles[x + y * width] == Tile.col_floormarmor) return Tile.floormarmor;
		if(tiles[x + y * width] == Tile.col_floorwood) return Tile.floorwood;
		if(tiles[x + y * width] == Tile.col_grassmy) return Tile.grassmy;
		if(tiles[x + y * width] == Tile.col_grasscherno) return Tile.grasscherno;
		if(tiles[x + y * width] == Tile.col_flower0) return Tile.flower0;
		if(tiles[x + y * width] == Tile.col_flower1) return Tile.flower1;
		if(tiles[x + y * width] == Tile.col_flowermario) return Tile.flowermario;
		if(tiles[x + y * width] == Tile.col_rockmy) return Tile.rockmy;
		if(tiles[x + y * width] == Tile.col_rockcherno) return Tile.rockcherno;
                                        	
		return Tile.voidTile;
	}

	public void add(Entity e) {
		// TODO Auto-generated method stub
		e.init(this);
		if(e instanceof Particle) {
			particles.add((Particle) e);
		}
		else if(e instanceof Projectile) {
			projectiles.add((Projectile) e);
		}
		else {
		entities.add(e);	
		}
	}
	
	
	public List<Projectile> getProjectiles() {
		return projectiles;
	}
}
