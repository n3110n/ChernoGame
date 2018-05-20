package test.graphics;

import java.util.Random;

public class Screen {

	private int width, height;
	//int tileSize = 16; //tilesize (width and height) in pixels on Screen
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int[] pixels;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	
	private Random random = new Random();
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width*height];
		
		for(int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void render(int xOffset, int yOffset) {
		for(int y = 0; y < height; y++){
			int yy = y + yOffset;
			//if(yy < 0 || yy >= height) break; //prevent out of bounds
			for(int x = 0; x < width; x++){
				int xx = x + xOffset;
				//if(xx < 0 || xx >= width) break; // prevent out of bounds
				int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE; 
				// >> right shift by number on the right, divided by 2 ^x  bitwise operation
				
				pixels[x + y * width] = tiles[tileIndex];	
				
			}
		}
	}
	
	public void clear() {
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = 0x000000; // or = 0
		}
	}
	
}
