package Game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public abstract class Bubble {

	public abstract float getX();
	
	public abstract float getY();
	
	public abstract void render(GameContainer gc, StateBasedGame sbg, Graphics g);
	
}
