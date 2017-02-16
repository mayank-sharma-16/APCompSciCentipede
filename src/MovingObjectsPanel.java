import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.color.*;

import javax.swing.JPanel;


public class MovingObjectsPanel extends JPanel {
	
	private final Dimension defaultDim;// = new Dimension(800,600);
	private GameMap gm;
	private Color backg = new Color(0,0,0);
	
	public MovingObjectsPanel() {
		this(new Dimension(800,600));
	}
	
	public MovingObjectsPanel(Dimension dim) {
		defaultDim = dim;
		this.setPreferredSize(defaultDim);
		this.setBackground(backg);
		makeGameMap();
	}
	
	private void makeGameMap() {
		gm = new CentipedeGameMap();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		gm.draw(g);
	}
	

}
