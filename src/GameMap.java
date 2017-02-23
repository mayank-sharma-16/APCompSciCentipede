import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;


public abstract class GameMap {

	private List<GameObject> gameObjects;

	private Image backgroundImage;
	private int[][] coordinateGrid;
	
	public GameMap() {
		gameObjects = new ArrayList();
		openBackgroundImage();
	}
	
	public abstract void openBackgroundImage();
		
	public void setImage(Image img){
		backgroundImage = img;
	}
	
	protected void setCoordSize(int a, int b){
		coordinateGrid = new int[a][b];
	}
	
	public Image getImage(){
		return backgroundImage;
	}
	
	public void draw(Graphics g){
		for(GameObject go : gameObjects){
			go.draw(g);
		}
	}
	
	public void add(GameObject go){
		gameObjects.add(go);
	}

	public void playerMove(int i) {
		// TODO Auto-generated method stub
		
	}

	public void shoot() {
		// TODO Auto-generated method stub
		System.out.println("working");
	} 	
	
	public void clean(){
		for ( int i = 0; i < gameObjects.size(); i++){
			if (gameObjects.get(i).getHealth() == 0){
				gameObjects.remove(i);
				i--;
			}
		}
	}
}
