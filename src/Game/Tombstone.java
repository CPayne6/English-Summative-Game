package Game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.geom.*;

public class Tombstone {
	
	private float x,y;
	
	private Image i;
	
	private Shape circle;
	
	public Tombstone(float xPos,float yPos) throws SlickException{
		x = xPos;
		y = yPos;
		i = new Image("res/tombstone.png");
		circle = new Circle(x, y, i.getWidth()/2);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g){
		circle.setLocation(x,y);
		i.draw(x,y);
		g.draw(circle);
	}
	
	public void moveUp(){
		y+=0.3;
	}
	
	public void moveDown(){
		y-=0.3;
	}
	
	public void moveRight(){
		x-=0.3;
	}
	
	public void moveLeft(){
		x+=0.3;
	}
	
	public Shape getCircle(){
		return circle;
	}
}
