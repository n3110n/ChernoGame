package test.level.tile;

import test.graphics.Sprite;

public class NonSolidTile extends Tile {

	public NonSolidTile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}

	public boolean solid() {
		return false;
	}

}
