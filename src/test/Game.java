package test;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import javax.swing.JFrame;

import test.entity.mob.Player;
import test.graphics.Screen;
import test.graphics.Sprite;
import test.input.Keyboard;
import test.input.Mouse;
import test.level.Level;
import test.level.TileCoordinate;

public class Game extends Canvas implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 4;
	
	public static final int TILE_SIZE = 16;

	public static String title = "Bullethell";

	private Thread thread;
	private JFrame frame;
	private Keyboard key;
	private Mouse mouse;
	private Level level;
	private Player player;

	private boolean running = false;

	private Screen screen;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();

		level = Level.spawn;
		TileCoordinate player_spawn = new TileCoordinate(20, 53);
		player = new Player(player_spawn.x(), player_spawn.y(), key);
		player.init(level);

		this.addKeyListener(key);
		
		mouse = new Mouse();
		
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0; // 1 billion
		double delta = 0;
		int frames = 0;
		int updates = 0;

		requestFocus();

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while (delta >= 1) { // happens 60 times a second
				update();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer >= 1000) {
				timer += 1000;
				frame.setTitle(title + " | " + updates + " ups | " + frames + " fps");
				frames = 0;
				updates = 0;
			}
		}
	}

	public void update() {
		key.update();
		player.update();
		level.update();

	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		screen.clear();
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);
		
		int barHUDSize = 60;
		Sprite sprite = new Sprite(barHUDSize, height, 0x0000ff);
		screen.renderSprite(width - barHUDSize, 0, sprite, false);
		
		Sprite particle = new Sprite(2, 2, 0xff0011);
		Random random = new Random();
		for(int i = 0; i < 25; i++) {
			int x = random.nextInt(15);
			int y = random.nextInt(15);
			screen.renderSprite(100 + x, 100 + y, particle, false); 
		}
		

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null); // draws every single pixel
		g.setColor(Color.RED);
		g.setFont(new Font("Verdana", 0, 32));
		//g.drawString("Button: " + Mouse.getButton(), 80, 80);
		//g.fillRect(Mouse.getX() - 32, Mouse.getY() - 32, 64, 64);
		g.dispose();
		bs.show();

	}

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();
	}

}
