package test.level.tile;

import test.graphics.Screen;
import test.graphics.Sprite;

public class GrassTile extends Tile{

	public GrassTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);  // << 4 is multiply 16
		//x, y will probably need to be manipulated, because we probably count in tiles before( given x and y)
	}
	
}
