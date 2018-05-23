package test.level;

import test.graphics.Screen;
import test.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;

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
				getTile(x, y).render(x, y, screen);

			}
		}
	}

	// 0xff00FF00 Grass
	// 0xffFFFF00 Flower
	// 0xff7F7F00 Rock
	public Tile getTile(int x, int y) {
		if (x + y * width < 0 || x + y * width >= tiles.length)
			return Tile.voidTile;
		if (tiles[x + y * width] == 0xff00FF00)
			return Tile.grass;
		if (tiles[x + y * width] == 0xffFFFF00)
			return Tile.flower1;
		if (tiles[x + y * width] == 0xff7F7F00)
			return Tile.rock;

		return Tile.voidTile;
	}
}
