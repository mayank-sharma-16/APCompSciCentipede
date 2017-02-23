import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class CentipedeGameMap extends GameMap {

	private int LIMIT = 300;
	Player player;
	
	public CentipedeGameMap() {
		initializeMushrooms();
		initializePlayer();
		initializeCentipede();
		
	}

	
	private void initializeMushrooms() {
		int numb = 0;
		while(numb <= 35){
			//set a limit here so that player does not spawn on mushroom
			int x = (int)(Math.random()*40);
			int y = (int)(Math.random()*30);
			
			add(new Mushroom(x*20,y*20,20,20));
			numb++;
		}
	}
	
	private void initializePlayer(){
		player = new Player(400, 500, 20, 20, 0, 1);
	}
	
	private void initializeCentipede(){
		add(new Centipede(20, 20, 20, 20, 1, -1));
	}

	public void draw(Graphics g){
		super.draw(g);
	}
	
	@Override
	public void openBackgroundImage() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void playerMove(int i){
		
	}

}
