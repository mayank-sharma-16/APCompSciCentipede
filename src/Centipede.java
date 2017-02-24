import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Centipede extends GameObject
{

	private boolean isLeft;
	private int previousRow;
	
	public Centipede(int x, int y, int wid, int ht, int speed, int health)
	{
		super(x, y, wid, ht, speed, health);
		openImage("centipede");
		isLeft = false;
		direction = new Vec2(1, 0);
		
	}
	
	@Override
	public void tick()
	{
		super.tick();
		if (direction.equals(new Vec2(0, 1)));
		{
			if (y / height == previousRow + 1)
			{
				y = (y / height) * height;
				if (isLeft)
				{
					direction = new Vec2(-1, 0);
				}
				else
				{
					direction = new Vec2(1, 0);
				}

			}
		}
		
	}

	@Override
	protected void onCollide(GameObject go)
	{
		if (go instanceof Mushroom || go instanceof Border)
		{
			direction = new Vec2(0, 1);
			isLeft = !isLeft;
			previousRow = y / height;
		}
	}
	

}
