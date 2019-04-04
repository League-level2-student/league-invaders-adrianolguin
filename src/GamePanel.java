import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	final int MENU_STATE = 0;

	final int GAME_STATE = 1;

	final int END_STATE = 2;

	boolean pressed = false;
	int CURRENT_STATE = MENU_STATE;
	Timer timer;
	GameObject object;
	Rocketship rocket;
	Font titleFont;
	Font subFont1;
	Font subFont2;
	
	GamePanel() {
		subFont1 = new Font("Arial", Font.PLAIN, 24);
		subFont2 = new Font("Arial", Font.PLAIN, 24);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		timer = new Timer(1000 / 60, this);
		object = new GameObject(10, 10, 100, 100);
		rocket = new Rocketship(250,700,50,50);
	}

	void startGame() {
		timer.start();
	}

	//////////////////////////////////////////////

	void updateMenuState() {

	}

	void updateGameState() {
	rocket.update();
	}

	void updateEndState() {

	}

	//////////////////////////////////////////////

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		
		g.setFont(titleFont);
		g.setColor(Color.yellow);
        g.drawString("LEAGUE INVADERS", 25, 200);

		g.setFont(subFont1);
		g.setColor(Color.yellow);
		g.drawString("Press ENTER to continue", 120, 350);
		
		g.setFont(subFont2);
		g.setColor(Color.yellow);
		g.drawString("Press SPACE for instructions", 85, 500);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		
		rocket.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
	}

	//////////////////////////////////////////////////////////

	public void actionPerformed(ActionEvent arg0) {
		if (CURRENT_STATE == MENU_STATE) {
			updateMenuState();
		} else if (CURRENT_STATE == GAME_STATE) {
			updateGameState();
		} else if (CURRENT_STATE == END_STATE) {
			updateEndState();
		}

		repaint();

	}

	@Override
	public void paintComponent(Graphics g) {

		if (CURRENT_STATE == MENU_STATE) {
			drawMenuState(g);
		} else if (CURRENT_STATE == GAME_STATE) {
			drawGameState(g);
		} else if (CURRENT_STATE == END_STATE) {
			drawEndState(g);
		}

	}

	///////////////////////////////////////////////////////////

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		int keyPressed = e.getKeyCode();

		if(keyPressed != KeyEvent.VK_ENTER) {
		pressed = true;
		}
		
		if(CURRENT_STATE == GAME_STATE) {
			rocket.update(e);
			}
		
		if (keyPressed == KeyEvent.VK_ENTER) {
			CURRENT_STATE++;
			System.out.println("Current State has been updated to: " + CURRENT_STATE);
			if (CURRENT_STATE > END_STATE) {
				CURRENT_STATE = MENU_STATE;
			}
		}
		
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
