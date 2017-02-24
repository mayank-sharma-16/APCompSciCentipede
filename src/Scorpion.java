import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Scorpion extends GameObject {

	public Scorpion(int x, int y, int wid, int ht, int speed, int health) {
		super(x, y, wid, ht, speed, health);
		// TODO Auto-generated constructor stub
		openImage("scorpion");
		
		direction = 90;
		
	}

	@Override
	protected void onCollide(GameObject go) {
		// TODO Auto-generated method stub
		
	}

}
