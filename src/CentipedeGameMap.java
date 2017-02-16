import java.awt.Graphics;

public class CentipedeGameMap extends GameMap {

	private int LIMIT = 300;
	
	public CentipedeGameMap() {
		initializeMushrooms();
	}
	
	private void initializeMushrooms() {
		// TODO Auto-generated method stub
		int numb = 0;
		while(numb <= 35){
			int x = (int)(Math.random()*800);
			int y = (int)(Math.random()*500);
			while(y < LIMIT){
				y = (int)(Math.random()*500);
			}
			add(new Mushroom(x,y,20,20));
		}
	}
	
	private void initializePlayer(){
		//add()
	}

	public void draw(Graphics g){
		super.draw(g);
		//g.drawRect(0, 0, arg2, arg3);
	}
	
	@Override
	public void openBackgroundImage() {
		// TODO Auto-generated method stub
		
	}

}
