import java.awt.Graphics;

public class CentipedeGameMap extends GameMap {

	
	public CentipedeGameMap() {
		initializeMushrooms();
		add(new Mushroom((int)(Math.random()*100), 0, 0, 0));
	}
	
	private void initializeMushrooms() {
		// TODO Auto-generated method stub
		int numb = 0;
		while(numb <= 35){
			int x = (int)(Math.random()*800);
			int y = (int)(Math.random()*500);
			add(new Mushroom(x,y,20,20));
		}
	}
	
	private void initializePlayer(){
		//add()
	}

	public void draw(Graphics g){
		super.draw(g);
	}
	
	@Override
	public void openBackgroundImage() {
		// TODO Auto-generated method stub
		
	}

}
