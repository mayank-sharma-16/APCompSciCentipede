import java.awt.Graphics;
import java.awt.Rectangle;


public interface MovingObject {

	void move();
	void draw(Graphics g);
	Rectangle getCollisionBox();
}
