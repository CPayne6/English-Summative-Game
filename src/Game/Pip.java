package Game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.geom.*;

public class Pip {

	private Image pipDown,pipUp,pipRight,pipLeft, pip;

	private Shape circle;

	private float x,y;

	public Pip(float xPos, float yPos) throws SlickException{
		pipDown = new Image("res/pipFront.png");
		pipUp = new Image("res/pipBack.png");
		pipRight = new Image("res/pipRight.png");
		pipLeft = new Image("res/pipLeft.png");
		pip = pipDown;
		x = xPos;
		y = yPos;
		circle = new Circle(x, y, pip.getWidth()/2);
	}

	public void move(GameContainer gc, StateBasedGame sbg, float bX, float bY, Chapter c) throws SlickException{

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g){
		g.setColor(Color.white);
		circle.setLocation(x - pip.getWidth()/2, y - pip.getHeight()/2);
		pip.drawCentered(x, y);
		g.draw(circle);
		g.drawString("Pip X: "+x+"\n    Y: "+y, 0,50);
	}

	public float getX(){
		return x;
	}

	public float getY(){
		return y;
	}
	
	public Shape getCircle(){
		return circle;
	}

	public void moveUp(boolean move){
		pip = pipUp;
		if(move && y > pip.getHeight()/2)
			y -= 0.3;
	}

	public void moveDown(boolean move){
		pip = pipDown;
		if(move && y < Game.windowHeight - pip.getHeight()/2)
			y+= 0.3;
	}

	public void moveRight(boolean move){
		pip = pipRight;
		if(move && x < Game.windowWidth - pip.getWidth()/2)
			x+=0.3;
	}

	public void moveLeft(boolean move){
		pip = pipLeft;
		if(move &&  x > pip.getWidth()/2)
			x-= 0.3;
	}


}
