package test.level.tile;

import test.graphics.Screen;
import test.graphics.Sprite;

public class SolidTile extends Tile {

	public SolidTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this); // << 4 is multiply 16
	}

	public boolean solid() {
		return true;
	}

}
