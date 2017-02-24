import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class CentipedeGameMap extends GameMap
{

	public static final int GRID_SIZE = 20;

	private int LIMIT = 300;
	Player player;
	
	public CentipedeGameMap()
	{
		initializeMushrooms();
		initializePlayer();
		initializeCentipede();
	}

	
	private void initializeMushrooms()
	{

		final int NUM_MUSH = (int) (Math.sqrt(MovingObjectsPanel.dimension.getHeight() * MovingObjectsPanel.dimension.getHeight()) * 0.1);

		for (int i = 0; i < NUM_MUSH; i++)
		{
			int x = (int) (Math.random() * (MovingObjectsPanel.dimension.getWidth() / GRID_SIZE));
			int y = (int) (Math.random() * (MovingObjectsPanel.dimension.getHeight() / GRID_SIZE));
			
			add(new Mushroom(x * GRID_SIZE, y * GRID_SIZE, GRID_SIZE, GRID_SIZE, 1));
		}
	}
	
	private void initializePlayer()
	{
		// player = new Player(400, 500, 20, 20, 0, 1);
	}
	
	private void initializeCentipede()
	{
		add(new Centipede(20, 20, 20, 20, 2, -1));
	}

	public void draw(Graphics g)
	{
		super.draw(g);
	}
	
	@Override
	public void openBackgroundImage()
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void playerMove(int i)
	{
		
	}

}
