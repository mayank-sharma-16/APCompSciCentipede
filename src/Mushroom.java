import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Mushroom extends GameObject {
	
	
	boolean poison = false;
	
	public Mushroom(int x, int y, int wid, int ht) {
		super(x, y, wid, ht, 0, 1);
		// TODO Auto-generated constructor stub
		if (poison){
			openImage("poisonMushroom");
		}
		else{
			openImage("mushroom");
		}
	}

	@Override
	public void move() {
		return;
	}
	
	public void makePoisonous(){
		poison = true;
	}
	
}