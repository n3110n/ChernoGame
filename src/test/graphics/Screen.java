package test.graphics;

import java.util.Random;

import test.entity.mob.Player;
import test.level.tile.Tile;
import test.level.tile.VoidTile;

public class Screen {

	public int width, height;
	//int tileSize = 16; //tilesize (width and height) in pixels on Screen
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int[] pixels;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	
	public int xOffset, yOffset;
	
	private Random random = new Random();
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width*height];
		
		for(int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	//not needed anymore
	/**
	public void render(int xOffset, int yOffset) {
		for(int y = 0; y < height; y++){
			int yp = y + yOffset;
			if(yp < 0 || yp >= height) continue;
			for(int x = 0; x < width; x++){	
				int xp = x + xOffset;
				if(xp < 0 || xp >= width) continue;		
				pixels[xp + yp * width] = Sprite.grass.pixels[(x & 15) + (y & 15) * Sprite.grass.getSIZE()];
	
			}
		}
	}
	*/
	
	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < tile.sprite.getSIZE(); y++) {
			int ya = y + yp;
			for(int x = 0; x < tile.sprite.getSIZE(); x++) {
				int xa = x + xp;
				
				if(xa < 0 - tile.sprite.getSIZE() || xa >= width || ya < 0 || ya >= height)  break;
				if(xa < 0)  xa = 0;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.getSIZE()];
			}
		}
	}
	
	public void renderPlayer(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < sprite.getSIZE(); y++) {
			int ya = y + yp;
			for(int x = 0; x < sprite.getSIZE(); x++) {
				int xa = x + xp;
				
				if(xa < 0 - sprite.getSIZE() || xa >= width || ya < 0 || ya >= height)  break;
				if(xa < 0)  xa = 0;
				pixels[xa + ya * width] = sprite.pixels[x + y * sprite.getSIZE()];
			}
		}
		
	}
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	
	public void clear() {
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = 0x000000; // or = 0
		}
	}
	
}
