package test.graphics;

public class Sprite {
	
	private final int SIZE;
	private int x, y;
	
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite water = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x1b87e0);
	
	public static Sprite playerDown0 = new Sprite(32, 5, 0, SpriteSheet.tiles);
	public static Sprite playerDown1 = new Sprite(32, 6, 0, SpriteSheet.tiles);
	public static Sprite playerDown2 = new Sprite(32, 7, 0, SpriteSheet.tiles);
	
	public static Sprite playerUp0 = new Sprite(32, 5, 1, SpriteSheet.tiles);
	public static Sprite playerUp1 = new Sprite(32, 6, 1, SpriteSheet.tiles);
	public static Sprite playerUp2 = new Sprite(32, 7, 1, SpriteSheet.tiles);
	
	public static Sprite playerLeft0 = new Sprite(32, 5, 2, SpriteSheet.tiles);
	public static Sprite playerLeft1 = new Sprite(32, 6, 2, SpriteSheet.tiles);
	public static Sprite playerLeft2 = new Sprite(32, 7, 2, SpriteSheet.tiles);
	
	public static Sprite playerRight0 = new Sprite(32, 5, 3, SpriteSheet.tiles);
	public static Sprite playerRight1 = new Sprite(32, 6, 3, SpriteSheet.tiles);
	public static Sprite playerRight2 = new Sprite(32, 7, 3, SpriteSheet.tiles);
	
	public static Sprite player0 = new Sprite(16, 10, 0, SpriteSheet.tiles);
	public static Sprite player1 = new Sprite(16, 10, 1, SpriteSheet.tiles);
	public static Sprite player2 = new Sprite(16, 11, 0, SpriteSheet.tiles);
	public static Sprite player3 = new Sprite(16, 11, 1, SpriteSheet.tiles);
	
	public Sprite(int size, int y, int x, SpriteSheet sheet) {
		SIZE = size;
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		pixels = new int[SIZE * SIZE];
		
		load();
	}
	
	public Sprite(int size, int color) {
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setColor(color);
	}
	
	private void setColor(int color) {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = color;
		}
	}
	
	private void load() {
		for(int y = 0; y < SIZE; y++) {
			for(int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(this.x + x) + (this.y + y) * sheet.SIZE];
			}
		}
	}
	
	public int getSIZE() {
		return SIZE;
	}
	
}
