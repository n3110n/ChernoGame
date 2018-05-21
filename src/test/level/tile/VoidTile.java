package test.level.tile;

import test.graphics.Screen;
import test.graphics.Sprite;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x, y, this); 
		//x, y will probably need to be manipulated, because we probably count in tiles before( given x and y)
	}
	
}
