import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Centipede extends GameObject{

	private boolean isLeft;
	
	public Centipede(int x, int y, int wid, int ht, int speed, int health) {
		super(x, y, wid, ht, speed, health);
		// TODO Auto-generated constructor stub
		openImage("centipede");
		isLeft = false;
		direction = 90;
		
	}
	
	@Override
	public void tick(){
		super.tick();
		if (direction == 180) {
			if (y % height == 0) {
				if (isLeft) {
					direction = 270;
				} else {
					direction = 90;
				}
					
			}
		}
		
	}

	@Override
	protected void onCollide(GameObject go) {
		direction = 180;
		isLeft = !isLeft;
		y += 1;
	}
	

}
