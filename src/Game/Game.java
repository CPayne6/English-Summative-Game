package Game;

import org.newdawn.slick.state.*;
import org.newdawn.slick.*;

public class Game extends StateBasedGame{
	
	private static final String gameName = "Graphic Expectations";
	
	public static final int windowHeight = 600;
	public static final int windowWidth = 600;
	
	public static final int MenuID = 0;
	public static final int Chapter1ID = 1;
	public static final int Chapter2ID = 2;
	public static final int Chapter3ID = 3;
	public static final int Chapter4ID = 4;
	
	
	public Game(String name) throws SlickException {
		super(name);
		this.addState(new Menu(MenuID));
		this.addState(new Chapter_1(Chapter1ID));
		this.addState(new Chapter_2(Chapter2ID));
		this.addState(new Chapter_3(Chapter3ID));
		this.addState(new Chapter_4(Chapter4ID));
	}

	public static void main(String[] args) throws SlickException{
		AppGameContainer agc = new AppGameContainer(new Game(gameName));
		agc.setDisplayMode(windowWidth,windowHeight,false);
		agc.start();
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(MenuID).init(gc, this);
		this.getState(Chapter1ID).init(gc, this);
		this.getState(Chapter2ID).init(gc, this);
		this.getState(Chapter3ID).init(gc, this);
		this.getState(Chapter4ID).init(gc, this);
		this.enterState(MenuID);
	}

}
