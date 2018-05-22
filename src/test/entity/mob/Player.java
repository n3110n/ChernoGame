package test.entity.mob;

import test.graphics.Screen;
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
		int xcenter = x - sprite.player0.getSIZE();
		int ycenter = y - sprite.player0.getSIZE();
		
		screen.renderPlayer(xcenter, ycenter,  sprite.player0);
		screen.renderPlayer(xcenter + sprite.player0.getSIZE(), ycenter,  sprite.player1);
		screen.renderPlayer(xcenter, ycenter + sprite.player0.getSIZE(),  sprite.player2);
		screen.renderPlayer(xcenter + sprite.player0.getSIZE(), ycenter + sprite.player0.getSIZE(),  sprite.player3);
	}
	
}
