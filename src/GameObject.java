import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;


public abstract class GameObject implements MovingObject {
	private int speed, x,y,width, height, health;
	//public static final int NORTH = 1, SOUTH = 3, EAST = 2,WEST = 4;
	
	private int direction;//clockwise from 0 being north
	private Color color;
	private Image img;
	
	public GameObject(int x, int y, int wid, int ht, int speed, int health) {
		this.x = x;
		this.y = y;
		width = wid;
		height = ht;
		this.speed = speed;
		this.health = health;
	}
	
	@Override
	public void move() {
			x += (int) (Math.sin(direction)*(speed));
			y += (int) (Math.cos(direction)*(speed));
	}
	protected void openImage(String imageName) {
		Image myImage = null;
		if (img == null){
			try {
				URL url = getClass().getResource("res/images/" + imageName+ ".jpeg");
				myImage = ImageIO.read(url);
				System.out.println(myImage);
			} catch (IOException e) {
				System.out.println("Problem opening the "+imageName+ ".jpeg");
				e.printStackTrace();
			}
		}
		img = myImage;
	}

	@Override
	public Rectangle getCollisionBox() {
		// TODO Auto-generated method stub
		Rectangle rect = new Rectangle(width, height);
		return rect;
	}

	public void draw(Graphics g){
		g.drawImage(img, x, y, width, height, null);
	}
	
	public void die(){
		//if (health = 0)
	}

}
