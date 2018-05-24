package test.entity.mob;

import test.Game;
import test.graphics.Screen;
import test.graphics.Sprite;
import test.input.Keyboard;
import test.input.Mouse;

public class Player extends Mob {

	private Keyboard input;
	private int animate = 0;
	private boolean walking = false;
 
	public Player(Keyboard input) {
		this.input = input;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}

	public void update() {

		int xa = 0;
		int ya = 0;
		if (animate < 8000)
			animate++;
		else
			animate = 0;

		if (input.up)
			ya--;
		if (input.down)
			ya++;
		if (input.left)
			xa--;
		if (input.right)
			xa++;
		
		updateShooting();

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
	}

	private void updateShooting() {
		if(Mouse.getButton() == 1) {
			double dx = (Mouse.getX() - Game.width * Game.scale / 2);
			double dy = (Mouse.getY() - Game.height * Game.scale / 2);			
			double dir = Math.atan2(dy, dx);
			
			shoot(x, y, dir);
		}
		
	}

	public void render(Screen screen) {
		int flip = 0; // if flipped in no way stays 0;
		int xcenter = x - (sprite.playerUp0.getSIZE() / 2);
		int ycenter = y - (sprite.playerUp0.getSIZE() / 2);

		int frequency = 24;

		Sprite sprite = Sprite.playerDown0;

		if (dir == 0) {
			if (walking) {
				if (animate % frequency < frequency / 4 * 1)
					sprite = Sprite.playerUp0;
				else if (animate % frequency < frequency / 4 * 2)
					sprite = Sprite.playerUp1;
				else if (animate % frequency < frequency / 4 * 3)
					sprite = Sprite.playerUp0;
				else if (animate % frequency < frequency / 4 * 4)
					sprite = Sprite.playerUp2;
			} else
				sprite = Sprite.playerUp0;
		}

		if (dir == 1) {
			flip = 1;
			if (walking) {
				if (animate % frequency < frequency / 4 * 1)
					sprite = Sprite.playerSide0;
				else if (animate % frequency < frequency / 4 * 2)
					sprite = Sprite.playerSide1;
				else if (animate % frequency < frequency / 4 * 3)
					sprite = Sprite.playerSide0;
				else if (animate % frequency < frequency / 4 * 4)
					sprite = Sprite.playerSide2;
			} else
				sprite = Sprite.playerSide0;
		}

		if (dir == 2) {
			if (walking) {
				if (animate % frequency < frequency / 4 * 1)
					sprite = Sprite.playerDown0;
				 if (animate % frequency < frequency / 4 * 2)
					sprite = Sprite.playerDown1;
				else if (animate % frequency < frequency / 4 * 3)
					sprite = Sprite.playerDown0;
				else if (animate % frequency < frequency / 4 * 4)
					sprite = Sprite.playerDown2;
			} else
				sprite = Sprite.playerDown0;
		}

		if (dir == 3) {
			if (walking) {
				if (animate % frequency < frequency / 4 * 1)
					sprite = Sprite.playerSide0;
				else if (animate % frequency < frequency / 4 * 2)
					sprite = Sprite.playerSide1;
				else if (animate % frequency < frequency / 4 * 3)
					sprite = Sprite.playerSide0;
				else if (animate % frequency < frequency / 4 * 4)
					sprite = Sprite.playerSide2;
			} else
				sprite = Sprite.playerSide0;
		}

		screen.renderPlayer(xcenter, ycenter, sprite, flip);

	}

}
