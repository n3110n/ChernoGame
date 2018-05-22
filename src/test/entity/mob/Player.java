package test.entity.mob;

import test.graphics.Screen;
import test.graphics.Sprite;
import test.input.Keyboard;

public class Player extends Mob {
	
	private Keyboard input;
	
	public Player(Keyboard input) {
		this.input = input;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}
	
	public void update() {
		//EP 44 movement redone
		/*
		if(input.up)	y--;
		if(input.down)	y++;
		if(input.left)	x--;
		if(input.right)	x++;
		*/
		
		int xa = 0;
		int ya = 0;
		if(input.up)	ya--;
		if(input.down)	ya++;
		if(input.left)	xa--;
		if(input.right)	xa++;
		
		if(xa != 0 || ya != 0) {
			move(xa, ya);
		}
	}
	
	public void render(Screen screen) {
		int flip = 0; //if flipped in no way stays 0;
		int xcenter = x - (sprite.playerUp0.getSIZE() / 2);
		int ycenter = y - (sprite.playerUp0.getSIZE() / 2);
		
		Sprite sprite = Sprite.playerDown0;
		if(dir == 0) sprite = Sprite.playerUp0;
		if(dir == 1) {
			flip = 1;
			sprite = Sprite.playerSide0;
		}
		if(dir == 2) sprite = Sprite.playerDown0;
		if(dir == 3) sprite = Sprite.playerSide0;
		
		screen.renderPlayer(xcenter,  ycenter, sprite, flip);
			
	}
	
}
