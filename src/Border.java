
public class Border extends GameObject
{

	public Border(int x, int y, int width, int height)
	{
		super(x, y, width, height, 0, Integer.MAX_VALUE);
	}

	@Override
	protected void onCollide(GameObject go)
	{
	}
}
