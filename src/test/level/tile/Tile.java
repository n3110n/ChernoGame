package test.level.tile;

import test.graphics.Screen;
import test.graphics.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;

	public static Tile grass = new NonSolidTile(Sprite.grass);
	public static Tile flower1 = new NonSolidTile(Sprite.flower1);
	public static Tile flower2 = new NonSolidTile(Sprite.flower2);
	public static Tile rock = new SolidTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);

	public Tile(Sprite sprite) {
		this.sprite = sprite;

	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this); // << 4 is multiply 16
	}

	public boolean solid() {
		return false;
	}

}
