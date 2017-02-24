import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Scorpion extends GameObject {

	public Scorpion(int x, int y, int wid, int ht, int speed, int health) {
		super(x, y, wid, ht, speed, health);
		openImage("scorpion");
		
		direction = new Vec2(1, 0);
		
	}

	@Override
	protected void onCollide(GameObject go) {

	}

}
