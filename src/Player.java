import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Player extends GameObject{

	public Player(int x, int y, int wid, int ht, int speed, int health) {
		super(x, y, wid, ht, speed, health);
		// TODO Auto-generated constructor stub
		openImage("player");
	}

	@Override
	protected void onCollide(GameObject go) {
		// TODO Auto-generated method stub
		
	}
	
	

}
