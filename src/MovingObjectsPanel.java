import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;


public class MovingObjectsPanel extends JPanel
{
	public static Dimension dimension;// = new Dimension(800,600);

	private GameMap gm;
	private Color background = new Color(0, 0, 0);
	private Timer timer;
	private InputManager inputManager;

	public MovingObjectsPanel(Dimension dim)
	{
		this.dimension = dim;

		this.setPreferredSize(dimension);
		this.setBackground(background);

		inputManager = new InputManager();

		setUpKeyMappings();
		setUpMouseListener();
		makeGameMap();
		setupTimer();

	}

	private void makeGameMap()
	{
		gm = new CentipedeGameMap(inputManager);
	}

	private void setupTimer()
	{
		timer = new Timer(1000 / 30, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				gm.tick();
				repaint();
			}
		});
		timer.start();
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		gm.draw(g);
	}



	private void setUpKeyMappings()
	{
		// maps keys with actions...
		//  The code below maps a KeyStroke to an action to be performed
		// In this case I mapped the space bar key to the action named "shoot"
		// Whenever someone hits the Space Bar the action shoot is sent out

		String[] inputNames = {"shoot", "up", "down", "left", "right"};

		this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "shoot");

		this.getInputMap().put(KeyStroke.getKeyStroke("UP"), "up");
		this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "down");
		this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "left");
		this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "right");

		this.getInputMap().put(KeyStroke.getKeyStroke("released UP"), "released up");
		this.getInputMap().put(KeyStroke.getKeyStroke("released DOWN"), "released down");
		this.getInputMap().put(KeyStroke.getKeyStroke("released LEFT"), "released left");
		this.getInputMap().put(KeyStroke.getKeyStroke("released RIGHT"), "released right");

		for (String name : inputNames)
		{
			inputManager.addInput(name);
		}

		//  This associates the command shoot with some action.  In this 
		// case, the action triggers a shoot command invoked on my GameMap.  In general, whatever 
		// goes in the actionPerformed method will be executed when a shoot command
		// is sent...

		// Shoot
		this.getActionMap().put("shoot", new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				inputManager.setInput("shoot", true);
			}
		});

		for (String name : inputNames)
		{
			this.getActionMap().put(name, new AbstractAction()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					inputManager.setInput(name, true);
				}
			});

			this.getActionMap().put("released " + name, new AbstractAction()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					inputManager.setInput(name, false);
				}
			});
		}

		this.requestFocusInWindow();
	}

	private void setUpMouseListener()
	{
		// DEBUG ONLY
		this.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e)
			{
				int x = e.getX() / CentipedeGameMap.GRID_SIZE;
				int y = e.getY() / CentipedeGameMap.GRID_SIZE;

				gm.add(new Mushroom(x * CentipedeGameMap.GRID_SIZE, y * CentipedeGameMap.GRID_SIZE, CentipedeGameMap.GRID_SIZE, CentipedeGameMap.GRID_SIZE, 1));
			}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
	}
	

}
