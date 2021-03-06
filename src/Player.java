import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Player extends GameObject
{

	public Player(int x, int y, int wid, int ht, int speed, int health)
	{
		super(x, y, wid, ht, speed, health);
		openImage("player");
	}

	public void setMoving(Vec2 direction, int speed)
	{
		this.direction = direction;
		this.speed = speed;
	}

	@Override
	protected void onCollide(GameObject go)
	{
		if (go instanceof Mushroom || go instanceof Border)
		{
			speed = 0;
		}
	}
	
	
}
