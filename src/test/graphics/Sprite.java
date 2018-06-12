package test.graphics;

public class Sprite {

	private final int SIZE;
	private int width, height;
	private int x, y;

	public int[] pixels;
	private SpriteSheet sheet;

	public static Sprite rock = new Sprite(16, 3, 0, SpriteSheet.tiles);

	//proj
	public static Sprite projTri = new Sprite(16, 0, 0, SpriteSheet.proj);
	public static Sprite projBall = new Sprite(16, 1, 1, SpriteSheet.proj);
	
	// voidsprite
	public static Sprite voidSprite = new Sprite(16, 0x1b87e0);

	// sprites
	public static Sprite grass0 = new Sprite(16, 0, 0, SpriteSheet.tile_level);
	public static Sprite grass1 = new Sprite(16, 0, 1, SpriteSheet.tile_level);
	public static Sprite grass2 = new Sprite(16, 0, 2, SpriteSheet.tile_level);
	public static Sprite grass3 = new Sprite(16, 0, 3, SpriteSheet.tile_level);
	public static Sprite grass4 = new Sprite(16, 0, 4, SpriteSheet.tile_level);
	public static Sprite grass5 = new Sprite(16, 1, 0, SpriteSheet.tile_level);
	public static Sprite fire0 = new Sprite(16, 1, 1, SpriteSheet.tile_level);
	public static Sprite fire1 = new Sprite(16, 1, 2, SpriteSheet.tile_level);
	public static Sprite firered = new Sprite(16, 3, 1, SpriteSheet.tile_level);
	public static Sprite rockybright = new Sprite(16, 1, 3, SpriteSheet.tile_level);
	public static Sprite rockygrass = new Sprite(16, 1, 4, SpriteSheet.tile_level);
	public static Sprite rockydark = new Sprite(16, 2, 4, SpriteSheet.tile_level);
	public static Sprite waterdark = new Sprite(16, 2, 0, SpriteSheet.tile_level);
	public static Sprite waterbright = new Sprite(16, 2, 1, SpriteSheet.tile_level);
	public static Sprite watermedium = new Sprite(16, 2, 2, SpriteSheet.tile_level);
	public static Sprite wallrock = new Sprite(16, 2, 3, SpriteSheet.tile_level);
	public static Sprite wallbrick0 = new Sprite(16, 3, 4, SpriteSheet.tile_level);
	public static Sprite wallbrick1 = new Sprite(16, 3, 3, SpriteSheet.tile_level);
	public static Sprite wallbrickred = new Sprite(16, 4, 0, SpriteSheet.tile_level);
	public static Sprite wallbrickorange = new Sprite(16, 4, 1, SpriteSheet.tile_level);
	public static Sprite wallbrickblue = new Sprite(16, 4, 2, SpriteSheet.tile_level);
	public static Sprite wallbrickmixed = new Sprite(16, 4, 3, SpriteSheet.tile_level);
	public static Sprite wallbrickwhite = new Sprite(16, 4, 4, SpriteSheet.tile_level);
	public static Sprite wallwood = new Sprite(16, 3, 2, SpriteSheet.tile_level);
	public static Sprite floormarmor = new Sprite(16, 3, 0, SpriteSheet.tile_level);
	public static Sprite floorwood = new Sprite(16, 5, 5, SpriteSheet.tile_level);
	public static Sprite grassmy = new Sprite(16, 5, 0, SpriteSheet.tile_level);
	public static Sprite grasscherno = new Sprite(16, 5, 1, SpriteSheet.tile_level);
	public static Sprite flower0 = new Sprite(16, 5, 2, SpriteSheet.tile_level);
	public static Sprite flower1 = new Sprite(16, 5, 3, SpriteSheet.tile_level);
	public static Sprite flowermario = new Sprite(16, 5, 4, SpriteSheet.tile_level);
	public static Sprite rockmy = new Sprite(16, 0, 5, SpriteSheet.tile_level);
	public static Sprite rockcherno = new Sprite(16, 1, 5, SpriteSheet.tile_level);

	// Playersprites
	public static Sprite playerDown0 = new Sprite(32, 0, 5, SpriteSheet.tiles);
	public static Sprite playerDown1 = new Sprite(32, 0, 6, SpriteSheet.tiles);
	public static Sprite playerDown2 = new Sprite(32, 0, 7, SpriteSheet.tiles);

	public static Sprite playerUp0 = new Sprite(32, 1, 5, SpriteSheet.tiles);
	public static Sprite playerUp1 = new Sprite(32, 1, 6, SpriteSheet.tiles);
	public static Sprite playerUp2 = new Sprite(32, 1, 7, SpriteSheet.tiles);

	public static Sprite playerSide0 = new Sprite(32, 2, 5, SpriteSheet.tiles);
	public static Sprite playerSide1 = new Sprite(32, 2, 6, SpriteSheet.tiles);
	public static Sprite playerSide2 = new Sprite(32, 2, 7, SpriteSheet.tiles);

	// Particles
	public static Sprite particle_normal = new Sprite(2, 0xaaaaaa);
	
	// old player graphics deprecated
	public static Sprite player0 = new Sprite(16, 10, 0, SpriteSheet.tiles);
	public static Sprite player1 = new Sprite(16, 10, 1, SpriteSheet.tiles);
	public static Sprite player2 = new Sprite(16, 11, 0, SpriteSheet.tiles);
	public static Sprite player3 = new Sprite(16, 11, 1, SpriteSheet.tiles);

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		this.width = size;
		this.height = size;
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		pixels = new int[SIZE * SIZE];

		load();
	}
	
	public Sprite(int width, int height, int color) {
		SIZE = -1;
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		setColor(color);
	}

	public Sprite(int size, int color) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}

	private void setColor(int color) {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = color;
		}
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(this.x + x) + (this.y + y) * sheet.SIZE];
			}
		}
	}

	public int getSIZE() {
		return SIZE;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
