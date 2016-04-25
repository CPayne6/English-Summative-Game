package Game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import Game.Game;

public class Chapter_1 extends Chapter{

	private Pip pip;

	private Tombstone t;

	private int ID;

	private ThoughtBubble tBubble;

	int counter,stall;

	private boolean storyTelling;

	private boolean beginning;

	public Chapter_1(int id){
		super(0, 0);
		ID = id;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		pip = new Pip(Game.windowWidth/2, Game.windowHeight/2);	
		setImage();
		counter = 0;
		stall = 0;
		storyTelling = true;
		beginning = true;
		t = new Tombstone(super.getImageWidth() - 200,super.getImageHeight()- 200);
		tBubble = new ThoughtBubble(pip.getX(),pip.getY());
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		if(beginning){
			Input i = gc.getInput();
			if(i.isKeyPressed(Input.KEY_SPACE)){
				beginning = false;
			}
			g.setColor(Color.black);
			g.fillRect(0, 0, Game.windowWidth, Game.windowHeight);
			g.setColor(Color.white);
			g.drawString("       Chapter 1 \n\n\nPress Space To Continue", Game.windowWidth/2-100,Game.windowHeight/2-100);
		}
		else if(storyTelling){
			getImage().draw(getBX(), getBY());
			pip.render(gc, sbg, g);
			tBubble.render(gc, sbg, g);
			tBubble.setX(pip.getX());
			tBubble.setY(pip.getY());
			t.render(gc, sbg, g);
		}
		else{
			getImage().draw(getBX(), getBY());
			pip.render(gc, sbg, g);
			t.render(gc, sbg, g);
		}

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input i = gc.getInput();
		if(!beginning){
			pip.move(gc, sbg, getBX(), getBY(), this);
			if(i.isKeyDown(Input.KEY_UP)){
				if(!pip.getCircle().intersects(t.getCircle())){
					if(getBY() < 0 && pip.getY() < Game.windowHeight/2){
						moveUp();
						pip.moveUp(false);
					}
					else{
						pip.moveUp(true);
					}
				}
				else{
					pip.moveDown(true);
					pip.moveDown(true);
					pip.moveUp(false);
					storyTelling = true;
				}
			}
			else if(i.isKeyDown(Input.KEY_RIGHT)){
				if(!pip.getCircle().intersects(t.getCircle())){
					if(getBX() > Game.windowWidth - getImageWidth()&& pip.getX() > Game.windowWidth/2){
						pip.moveRight(false);
						moveRight();
					}
					else{
						pip.moveRight(true);
					}
				}
				else{
					pip.moveLeft(true);
					pip.moveLeft(true);
					pip.moveRight(false);
					storyTelling = true;
				}
			}
			else if(i.isKeyDown(Input.KEY_LEFT)){
				if(!pip.getCircle().intersects(t.getCircle())){
					if(getBX() < 0 && pip.getX() < Game.windowWidth/2){
						pip.moveLeft(false);
						moveLeft();
					}
					else{
						pip.moveLeft(true);
					}
				}
				else{
					pip.moveRight(true);
					pip.moveRight(true);
					pip.moveLeft(false);
					storyTelling = true;
				}
			}
			else if(i.isKeyDown(Input.KEY_DOWN)){
				if(!pip.getCircle().intersects(t.getCircle())){
					if(getBY() > Game.windowHeight - getImageHeight() && pip.getY() > Game.windowHeight/2){
						pip.moveDown(false);
						moveDown();
					}
					else{
						pip.moveDown(true);
					}
				}
				else{
					pip.moveUp(true);
					pip.moveUp(true);
					pip.moveDown(false);
					storyTelling = true;
				}
			}
		}
		if(stall > 4000){
			storyTelling = false;
			stall = 0;
		}
		if(!beginning){
			stall++;
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

	public void setImage() throws SlickException{
		super.setImage(new Image("res/Swamp.png"));
	}

	public void moveUp(){
		super.moveUp();
		t.moveUp();
	}

	public void moveDown(){
		super.moveDown();
		t.moveDown();
	}

	public void moveRight(){
		super.moveRight();
		t.moveRight();
	}

	public void moveLeft(){
		super.moveLeft();
		t.moveLeft();
	}

}
