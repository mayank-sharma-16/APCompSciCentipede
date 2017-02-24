import java.awt.Graphics;

public class CentipedeGameMap extends GameMap
{

	public static final int GRID_SIZE = 20;
	public static final int GRID_HEIGHT = 30;
	public static final int GRID_WIDTH = 60;
	public static final int GAME_WIDTH = GRID_WIDTH * GRID_SIZE;
	public static final int GAME_HEIGHT = GRID_HEIGHT * GRID_SIZE;

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

		Vec2 dir = Vec2.zero();

		if (im.getInput("up"))
		{
			dir.addLocal(0, -1);
		}
		if (im.getInput("right"))
		{
			dir.addLocal(1, 0);
		}
		if (im.getInput("down"))
		{
			dir.addLocal(0, 1);
		}
		if (im.getInput("left"))
		{
			dir.addLocal(-1, 0);
		}

		if (dir.equals(Vec2.zero()))
		{
			player.setMoving(Vec2.zero(), 0);
		}
		else
		{
			player.setMoving(dir.normalize(), 5);
		}
		
		
		if (im.getInput("shoot"))
		{
			im.setInput("shoot", false);
			gameObjects.add(new Bullet(player.getX(), player.getY(), 2, 5, 5, 1));
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
