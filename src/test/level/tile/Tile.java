package test.level.tile;

import test.graphics.Screen;
import test.graphics.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;
	boolean solid = false;;

	// voidTile
	public static Tile voidTile = new Tile(Sprite.voidSprite);

	// Tiles
	public static Tile grass0 = new Tile(Sprite.grass0);
	public static Tile grass1 = new Tile(Sprite.grass1);
	public static Tile grass2 = new Tile(Sprite.grass2);
	public static Tile grass3 = new Tile(Sprite.grass3);
	public static Tile grass4 = new Tile(Sprite.grass4);
	public static Tile grass5 = new Tile(Sprite.grass5);
	public static Tile fire0 = new Tile(Sprite.fire0);
	public static Tile fire1 = new Tile(Sprite.fire1);
	public static Tile firered = new Tile(Sprite.firered);
	public static Tile rockybright = new Tile(Sprite.rockybright);
	public static Tile rockygrass = new Tile(Sprite.rockygrass);
	public static Tile rockydark = new Tile(Sprite.rockydark);
	public static Tile waterdark = new Tile(Sprite.waterdark);
	public static Tile waterbright = new Tile(Sprite.waterbright);
	public static Tile watermedium = new Tile(Sprite.watermedium);
	public static Tile wallrock = new Tile(Sprite.wallrock);
	public static Tile wallbrick0 = new Tile(Sprite.wallbrick0);
	public static Tile wallbrick1 = new Tile(Sprite.wallbrick1);
	public static Tile wallbrickred = new Tile(Sprite.wallbrickred);
	public static Tile wallbrickorange = new Tile(Sprite.wallbrickorange);
	public static Tile wallbrickblue = new Tile(Sprite.wallbrickblue);
	public static Tile wallbrickmixed = new Tile(Sprite.wallbrickmixed);
	public static Tile wallbrickwhite = new Tile(Sprite.wallbrickwhite);
	public static Tile wallwood = new Tile(Sprite.wallwood);
	public static Tile floormarmor = new Tile(Sprite.floormarmor);
	public static Tile floorwood = new Tile(Sprite.floorwood);
	public static Tile grassmy = new Tile(Sprite.grassmy);
	public static Tile grasscherno = new Tile(Sprite.grasscherno);
	public static Tile flower0 = new Tile(Sprite.flower0);
	public static Tile flower1 = new Tile(Sprite.flower1);
	public static Tile flowermario = new Tile(Sprite.flowermario);
	public static Tile rockmy = new Tile(Sprite.rockmy);
	public static Tile rockcherno = new Tile(Sprite.rockcherno);

	public Tile(Sprite sprite) {
		this.sprite = sprite;

	}

	public Tile(Sprite sprite, boolean solid) {
		this.sprite = sprite;
		this.solid = solid;

	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this); // << 4 is multiply 16
	}

	public void setSolid(boolean solid) {
		this.solid = solid;
	}

	public boolean getSolid() {
		return false;
	}

}
