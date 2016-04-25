package Game;

import org.newdawn.slick.Image;
import org.newdawn.slick.state.BasicGameState;

public abstract class Chapter extends BasicGameState{

	private float bX,bY;
	
	private Image i;
	
	public Chapter(float bx,float by){
		super();
		bX = bx;
		bY = by;
	}
	
	public float getBX(){
		return bX;
	}
	
	public float getBY(){
		return bY;
	}
	
	public int getImageWidth(){
		return i.getWidth();
	}
	
	public int getImageHeight(){
		return i.getHeight();
	}
	
	public void moveUp(){
		bY += 0.3;
	}
	
	public void moveRight(){
		bX -= 0.3;
	}
	
	public void moveDown(){
		bY -= 0.3;
	}
	
	public void moveLeft(){
		bX += 0.3;
	}
	
	public Image getImage(){
		return i;
	}
	
	public void setImage(Image image){
		i = image;
		System.out.println(i.getWidth()+ " x "+i.getHeight());
	}
}
