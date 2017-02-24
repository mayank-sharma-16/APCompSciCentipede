import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Map;

import javax.swing.JFrame;


public class MovingObjectsGameLauncher
{

	public static void main(String[] args)
	{
		JFrame gameFrame = new JFrame();
		Map<String, String> environMap = System.getenv();
		System.out.println(environMap.keySet());
		
		//Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension d = new Dimension(1280, 720);
		MovingObjectsPanel mop = new MovingObjectsPanel(d);
		gameFrame.add(mop);
		gameFrame.pack();
		gameFrame.setVisible(true);
		gameFrame.setSize(d);
		gameFrame.setDefaultCloseOperation(gameFrame.EXIT_ON_CLOSE);
	}

}
