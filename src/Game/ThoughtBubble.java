package Game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.geom.*;


public class ThoughtBubble extends Bubble{
	
	private Circle c1,c2;
	
	private String s;
	
	private float x,y;
	
	public ThoughtBubble(float xPos, float yPos){
		x = xPos;
		y = yPos;
		c1 = new Circle(x+10,y-10,2);
		c2 = new Circle(x+20,y-20,5);
		s = "I need to find my\n parent's Tombstone";
	}

	@Override
	public float getX() {
		return x;
		
	}

	@Override
	public float getY() {
		return y;
	}
	
	public void setX(float xPos){
		x = xPos;
	}
	
	public void setY(float yPos){
		y = yPos;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		g.setColor(Color.white);
		c1.setLocation(x+10, y-10);
		g.fill(c1);
		c2.setLocation(x+20, y-20);
		g.fill(c2);
		g.fillOval(x, y-100, s.length()*6, 75);
		g.setColor(Color.black);
		g.drawString(s, x+20, y-85);
	}
	
	public void setString(String str){
		s = str;
	}
	
}
