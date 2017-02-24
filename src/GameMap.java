import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;


public abstract class GameMap
{

	private List<GameObject> gameObjects;

	private Image backgroundImage;
	
	public GameMap()
	{
		gameObjects = new ArrayList();
		openBackgroundImage();
	}
	
	public abstract void openBackgroundImage();

	public void setImage(Image img)
	{
		backgroundImage = img;
	}
	
	public Image getImage()
	{
		return backgroundImage;
	}
	
	public void tick()
	{
		// Checks collision between every pair of objects
		for (int i = 0; i < gameObjects.size(); i++)
		{
			for (int j = i + 1; j < gameObjects.size(); j++)
			{
				GameObject go1 = gameObjects.get(i);
				GameObject go2 = gameObjects.get(j);
				if (go1.checkCollision(go2))
				{
					go1.onCollide(go2);
					go2.onCollide(go1);
				}
			}
		}

		for (GameObject go : gameObjects)
		{
			go.tick();
		}
	}
	
	public void draw(Graphics g)
	{
		for (GameObject go : gameObjects)
		{
			go.draw(g);
		}
	}
	
	public void add(GameObject go)
	{
		gameObjects.add(go);
	}

	public void playerMove(int i)
	{
		
	}

	public void shoot()
	{
		System.out.println("working");
	}
	
	public void clean()
	{
		for (int i = gameObjects.size() - 1; i >= 0; i--)
		{
			if (gameObjects.get(i).getHealth() == 0)
			{
				gameObjects.remove(i);
			}
		}
	}
}
