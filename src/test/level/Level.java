package test.level;

import test.graphics.Screen;
import test.level.tile.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
	}
	
	private void loadLevel(String path) {
		
	}
	
	protected void generateLevel() {
		
	}
	
	public void update() {
		
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4; // >> 4 = / 16
		int x1 = (xScroll + screen.width) >> 4;
		int y0 = yScroll >> 4; // >> 4 = / 16
		int y1 = (yScroll + screen.height) >> 4;
	}
	
	public Tile getTile(int x, int y) {		
		if(tiles[x + y * width] == 0) return Tile.grass;
		//if(tiles[x + y * width] == 1) return Tile.water;
		
		return Tile.voidTile; //dangerous:D
	}
}
