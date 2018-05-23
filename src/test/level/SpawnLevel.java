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
			width = image.getWidth();
			height = image.getHeight();

			tiles = new int[width * height];

			image.getRGB(0, 0, width, height, tiles, 0, width);

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
