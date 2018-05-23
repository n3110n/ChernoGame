package test.level.tile;

import test.graphics.Screen;
import test.graphics.Sprite;

public class RockTile extends Tile {

	public RockTile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);  // << 4 is multiply 16
		//x, y will probably need to be manipulated, because we probably count in tiles before( given x and y)
	}
	
	public boolean solid() {
		return true;
	}

}
