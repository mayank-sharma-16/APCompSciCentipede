import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


public abstract class GameMap {

	private List<MovingObject> movers;
	Image backgroundImage;
	
	public GameMap() {
		movers = new ArrayList();
		openBackgroundImage();
	}
	
	public abstract void openBackgroundImage();
	
	public void setImage(Image img){
		backgroundImage = img;
	}
	
	public Image getImage(){
		return backgroundImage;
	}
	
	public void draw(Graphics g){
		for(MovingObject mover : movers){
			mover.draw();
		}
	}
	
	public void add(GameObject go){
		movers.add(go);
	} 	
}
