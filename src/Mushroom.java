import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Mushroom extends GameObject
{
	
	public Mushroom(int x, int y, int width, int height, int health)
	{
		super(x, y, width, height, 0, health);
		openImage("mushroom");
	}

	public void move()
	{
		return;
	}

	@Override
	protected void onCollide(GameObject go)
	{
	}
	
}