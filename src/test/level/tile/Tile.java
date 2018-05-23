package test.level.tile;

import test.graphics.Screen;
import test.graphics.Sprite;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower1 = new FlowerTile(Sprite.flower1);
	public static Tile flower2 = new FlowerTile(Sprite.flower2);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
		
	}
	
	public void render(int x, int y, Screen screen) {
		
	}
	
	public boolean solid() {
		return false;
	}

}
