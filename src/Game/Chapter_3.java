package Game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Chapter_3 extends Chapter{

private int ID;
	
	public Chapter_3(int id) throws SlickException{
		super(0,0);
		ID = id;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}
	
	public void setImage() throws SlickException{
		super.setImage(new Image("res/Swamp.png"));
	}

}
