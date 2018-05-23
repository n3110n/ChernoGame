package test.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import test.level.tile.Tile;

public class SpawnLevel extends Level {

	private int[] levelPixels;

	public SpawnLevel(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();

			tiles = new Tile[w * h];

			image.getRGB(0, 0, w, h, levelPixels, 0, w);

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception! Level file could not load Level!");
		}
	}

	// 0x00FF00 Grass
	// 0xFFFF00 Flower
	// 0x7F7F00 Rock
	protected void generateLevel() {
		for (int i = 0; i < levelPixels.length; i++) {
			if (levelPixels[i] == 0x00FF00)
				tiles[i] = Tile.grass;
			if (levelPixels[i] == 0xFFFF00)
				tiles[i] = Tile.flower1;
			if (levelPixels[i] == 0x7F7F00)
				tiles[i] = Tile.rock;
		}

	}

}
