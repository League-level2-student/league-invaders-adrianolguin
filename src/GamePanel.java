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

	int CURRENT_STATE = MENU_STATE;
	Font titleFont;
	Timer timer;
	GameObject object;

	GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		
		timer = new Timer(1000 / 60, this);
		object = new GameObject(10, 10, 100, 100);
	}

	void startGame() {
		timer.start();
	}

	//////////////////////////////////////////////

	void updateMenuState() {

	}

	void updateGameState() {

	}

	void updateEndState() {

	}

	//////////////////////////////////////////////

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		
		g.setFont(titleFont);
        g.drawString("Start", LeagueInvaders.width, LeagueInvaders.height);

	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
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

	////////////////////////////////////////////////////////////

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyPressed = e.getKeyCode();

		// System.out.println("The keytext is: " + idk);

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
