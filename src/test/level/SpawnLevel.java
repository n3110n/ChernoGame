package test.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpawnLevel extends Level {

	public SpawnLevel(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();

			tiles = new int[w * h];

			image.getRGB(0, 0, w, h, tiles, 0, w);

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception! Level file could not load Level!");
		}
	}

	// 0x00FF00 Grass
	// 0xFFFF00 Flower
	// 0x7F7F00 Rock
	protected void generateLevel() {

	}

}
