import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Flea extends GameObject{

	public Flea(int x, int y, int wid, int ht, int speed, int health) {
		super(x, y, wid, ht, speed, health);
		openImage("flea");
		direction = new Vec2(0, 1);
	}

	@Override
	protected void onCollide(GameObject go) {

	}

}
