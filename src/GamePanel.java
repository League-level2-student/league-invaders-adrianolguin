import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener,KeyListener{

	Timer timer;
	GameObject object;
	GameObject background;
	
	GamePanel(){
	timer = new Timer(1000/60, this);
	object = new GameObject(10,10,100,100);
	background = new GameObject(0,0,500,800);
	}
	
	void startGame() {	
	timer.start();
	}
	
	public void actionPerformed(ActionEvent arg0) {
	background.update();
	object.update();
	repaint();
	
	}
	
	 @Override
	 public void paintComponent(Graphics g){
		 background.draw(g);
		 object.draw(g);
	         }

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
