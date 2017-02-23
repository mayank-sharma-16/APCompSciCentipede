import java.awt.Image;

import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;


public class Spiders extends GameObject{

	private static Image img;
	
	public Spiders(int x, int y, int wid, int ht, int speed, int health) {
		super(x, y, wid, ht, speed, health);
		// TODO Auto-generated constructor stub
		openImage("spider");
	}

	@Override
	protected void onCollide() {
		// TODO Auto-generated method stub
		
	}
}
