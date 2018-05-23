package test.level;

import test.graphics.Screen;
import test.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tilesInt;
	protected Tile[] tiles;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];

		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
	}

	protected void loadLevel(String path) {

	}

	protected void generateLevel() {

	}

	public void update() {

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
				// getTile(x, y).render(x, y, screen); //old version for randomlevel generation
				if (x < 0 || y < 0 || x >= width || y >= height)
					Tile.voidTile.render(x, y, screen);
				else
					tiles[x + y * 16].render(x, y, screen);
			}
		}
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.voidTile;
		if (tilesInt[x + y * width] == 0)
			return Tile.grass;
		if (tilesInt[x + y * width] == 1)
			return Tile.flower1;
		if (tilesInt[x + y * width] == 2)
			return Tile.rock;

		return Tile.voidTile;
	}
}
