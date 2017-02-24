import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public abstract class GameObject implements MovingObject
{
	protected int speed, x, y, width, height, health;
	// public static final int NORTH = 1, SOUTH = 3, EAST = 2,WEST = 4;

	protected int direction;// clockwise from 0 degree being north
	private Color color;
	private Image img;

	public GameObject(int x, int y, int wid, int ht, int speed, int health)
	{
		this.x = x;
		this.y = y;
		width = wid;
		height = ht;
		this.speed = speed;
		this.health = health;
	}

	public void tick()
	{
		this.move();
	}
	
	@Override
	public void move()
	{
		x += (int) (Math.sin(Math.toRadians(direction)) * speed);
		y -= (int) (Math.cos(Math.toRadians(direction)) * speed);
	}
	
	protected abstract void onCollide(GameObject go);

	protected void openImage(String imageName)
	{
		Image myImage = null;
		if (img == null)
		{
			try
			{
				URL url = getClass().getResource("images/" + imageName + ".jpg");
				myImage = ImageIO.read(url);
			}
			catch (IOException e)
			{
				System.out.println("Problem opening the " + imageName + ".jpg");
				e.printStackTrace();
			}
		}
		img = myImage;
	}

	@Override
	public Rectangle getCollisionBox()
	{
		Rectangle rect = new Rectangle(x + (int) (Math.sin(Math.toRadians(direction)) * speed),
				y - (int) (Math.cos(Math.toRadians(direction)) * speed), width, height);
		return rect;
	}
	
	public boolean checkCollision(GameObject go)
	{
		return (getCollisionBox().intersects(go.getCollisionBox()));
	}

	public void draw(Graphics g)
	{
		g.drawImage(img, getX(), y, width, height, null);
	}

	public int getX()
	{
		return x;
	}


	public int getY()
	{
		return y;
	}

	public int getSpeed()
	{
		return speed;
	}

	public int getHealth()
	{
		return health;
	}
	
}
