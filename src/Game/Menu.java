package Game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState{

	private Image playNow, title, welcome;
	
	private int ID;
	
	public Menu(int id){
		ID = id;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		title = new Image("res/Title.png");
		playNow = new Image("res/playNow.png");
		welcome = new Image("res/Welcome to.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		float wWidth = Game.windowWidth;
		float wHeight = Game.windowHeight;
		
		g.setColor(Color.white);
		g.fillRect(0, 0, wWidth, wHeight);
		title.drawCentered(wWidth/2, (float) (wHeight/2.5));
		welcome.drawCentered(wWidth/2, wHeight/4);
		playNow.drawCentered(wWidth/2, (float) (wHeight/1.5));
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		Input i = gc.getInput();
		
		if(i.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			float mY = i.getMouseY();
			float mX = i.getMouseX();
			float xPos = Game.windowWidth/2 - playNow.getWidth()/2;
			float yPos = (float) (Game.windowHeight/1.5 - playNow.getHeight()/2);
			if(mX < xPos + playNow.getWidth() && mX > xPos && mY < yPos + playNow.getHeight() && mY > yPos){
				sbg.enterState(Game.Chapter1ID);
				System.out.println("It Works");
			}
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

}
