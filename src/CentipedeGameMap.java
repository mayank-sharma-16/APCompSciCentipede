import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class CentipedeGameMap extends GameMap
{

	public static final int GRID_SIZE = 20;
	public static final int GRID_HEIGHT = 30;
	public static final int GRID_WIDTH = 60;
	public static final int GAME_WIDTH = GRID_WIDTH * GRID_SIZE;
	public static final int GAME_HEIGHT = GRID_HEIGHT * GRID_SIZE;

	private int LIMIT = 300;
	private Player player;
	
	public CentipedeGameMap(InputManager inputManager)
	{
		super(inputManager);
		initBorder();
		initMushrooms();
		initPlayer();
		initCentipede();
	}

	
	private void initMushrooms()
	{

		final int NUM_MUSH = (int) (Math.sqrt(GRID_WIDTH * GRID_HEIGHT));

		for (int i = 0; i < NUM_MUSH; i++)
		{
			int x = (int) (Math.random() * GRID_WIDTH);
			int y = (int) (Math.random() * GRID_HEIGHT);
			
			add(new Mushroom(x * GRID_SIZE, y * GRID_SIZE, GRID_SIZE, GRID_SIZE, 1));
		}
	}

	private void initBorder()
	{
		add(new Border(-10, 0, 10, GAME_HEIGHT)); // Left border
		add(new Border(GAME_WIDTH, 0, 10, GAME_HEIGHT)); // Right border

		add(new Border(0, -10, GAME_WIDTH, 10)); // Top border
		add(new Border(0, GAME_HEIGHT, GAME_WIDTH, 10)); // Bottom border
	}

	private void initPlayer()
	{
		player = new Player(GAME_WIDTH / 2, GAME_HEIGHT - GRID_SIZE, GRID_SIZE, GRID_SIZE, 0, 1);
		add(player);
	}
	
	private void initCentipede()
	{
		for (int i = 0; i < 10; i++)
		{
			add(new Centipede(GRID_SIZE * (i + GRID_WIDTH / 2), GRID_SIZE, GRID_SIZE, GRID_SIZE, 5, 1));
		}

	}

	@Override
	public void tick()
	{
		super.tick();

		int angle = 0;
		int num = 0;

		if (inputManager.getInput("up"))
		{
			angle += 0;
			num++;
		}
		if (inputManager.getInput("right"))
		{
			angle += 90;
			num++;
		}
		if (inputManager.getInput("left"))
		{
			angle -= 90;
			num++;
		}
		if (inputManager.getInput("down"))
		{
			if (angle > 0)
				angle += 180;
			else
				angle -= 180;
			num++;
		}

		if (num == 1)
		{
			player.setMoving(angle, 5);
		}
		else if (num == 2)
		{
			player.setMoving(angle / 2, 5);
		}
		else
		{
			player.setMoving(0, 0);
		}

	}

	public void draw(Graphics g)
	{
		super.draw(g);
	}
	
	@Override
	public void openBackgroundImage()
	{

	}
	
}
