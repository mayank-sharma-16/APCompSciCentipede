import java.awt.Rectangle;


public interface MovingObject {

	void move();
	void draw();
	Rectangle getCollisionBox();
}
