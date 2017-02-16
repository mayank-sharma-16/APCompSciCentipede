import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;


public abstract class GameObject implements MovingObject {
	private int speed, x,y,width, height, health;
	//public static final int NORTH = 1, SOUTH = 3, EAST = 2,WEST = 4;
	
	private double direction;
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
		
		// there should be some checking that takes place
		
		
	}

	@Override
	public Rectangle getCollisionBox() {
		// TODO Auto-generated method stub
		Rectangle rect = new Rectangle(width, height);
		return rect;
	}
	
	public void draw(){
		
	}
}
