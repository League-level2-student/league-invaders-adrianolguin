import java.awt.Dimension;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LeagueInvaders {

JFrame frame = new JFrame();	
static GamePanel panel = new GamePanel();


final int width = 500;
final int height = 800;

void setup() {
frame.add(panel);
frame.setVisible(true);
frame.addKeyListener(panel);
frame.getContentPane().setPreferredSize(new Dimension(width,height));
frame.pack();
frame.setSize(width,height);



}

public static void main(String[] args) {
	
	LeagueInvaders main = new LeagueInvaders();
	main.setup();

	panel.startGame();
	
	
	
	
	
	
}
}
