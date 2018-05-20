package test.graphics;

import java.util.Random;

public class Screen {

	private int width, height;
	int map_width = 64;
	int map_height = 64;
	//int tileSize = 16; //tilesize (width and height) in pixels on Screen
	private int map_size = map_width * map_height;
	public int[] pixels;
	public int[] tiles = new int[map_size];
	
	private Random random = new Random();
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width*height];
		
		for(int i = 0; i < map_size; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void render() {
		for(int y = 0; y < height; y++){
			if(y < 0 || y >= height) break; //prevent out of bounds
			for(int x = 0; x < width; x++){
				if(x < 0 || x >= width) break; // prevent out of bounds
				int tileIndex = (x >> 4) + (y >> 4) * map_width; // >> right shift by number on the right, divided by 2 ^x  bitwise operation
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
