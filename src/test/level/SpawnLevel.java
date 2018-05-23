package test.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import test.level.tile.Tile;

public class SpawnLevel extends Level {

	private Tile[] tiles;
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
			image.getRGB(0, 0, w, h, levelPixels, 0, w);

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception! Level file could not load Level!");
		}
	}

	protected void generateLevel() {

	}

}
