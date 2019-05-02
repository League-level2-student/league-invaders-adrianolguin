import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	Projectile test = new Projectile(LeagueInvaders.width, LeagueInvaders.height / 2, 10, 10);

	final int MENU_STATE = 0;

	final int GAME_STATE = 1;

	final int END_STATE = 2;

	final int projSize = 10;

	public static BufferedImage alienImg;

	public static BufferedImage rocketImg;

	public static BufferedImage bulletImg;

	public static BufferedImage spaceImg;

	boolean left;
	boolean right;
	boolean up;
	boolean down;

	int CURRENT_STATE = MENU_STATE;
	Timer timer;
	GameObject object;
	Rocketship rocket;
	ObjectManager manager;
	Font titleFont;
	Font subFont1;
	Font subFont2;

	Font score;

	Font endFont;
	Font endSubFont1;
	Font endSubFont2;

	GamePanel() {

		try {
			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
			spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		subFont1 = new Font("Arial", Font.PLAIN, 24);
		subFont2 = new Font("Arial", Font.PLAIN, 24);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		timer = new Timer(1000 / 60, this);
		object = new GameObject(10, 10, 100, 100);
		rocket = new Rocketship(250, 700, 50, 50);
		manager = new ObjectManager(rocket);
		score = new Font("Arial", Font.PLAIN, 36);
		endFont = new Font("Arial", Font.BOLD, 48);
		endSubFont1 = new Font("Arial", Font.PLAIN, 24);
		endSubFont2 = new Font("Arial", Font.PLAIN, 24);
	}

	void startGame() {
		timer.start();

	}

	//////////////////////////////////////////////

	void updateMenuState() {

	}

	void updateGameState() {

		if (!up && !down && !left && !right) {

		} else if (up && left) {
			rocket.update("upLeft");
		} else if (up && right) {
			rocket.update("upRight");
		} else if (down && left) {
			rocket.update("downLeft");
		} else if (down && right) {
			rocket.update("downRight");
		} else if (up) {
			rocket.update("up");
		} else if (down) {
			rocket.update("down");
		} else if (left) {
			rocket.update("left");
		} else if (right) {
			rocket.update("right");
		}

		manager.manageEnemies();

		manager.update();

		manager.purgeObjects();
		if (!rocket.isAlive) {
			CURRENT_STATE = END_STATE;
		}

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

		g.drawImage(GamePanel.spaceImg, 0, 0, LeagueInvaders.width, LeagueInvaders.height, null);

		g.setColor(Color.WHITE);
		g.drawString("Score: " + manager.getScore(), 10, 15);

		manager.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);

		g.setFont(endFont);
		g.setColor(Color.BLACK);
		g.drawString("You Have Died", 55, 100);

		g.setFont(endSubFont1);
		g.setColor(Color.BLACK);
		g.drawString("You Killed " + manager.getScore() + " Aliens", 130, 250);

		g.setFont(endSubFont2);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to Play Again", 85, 340);

	}

	//////////////////////////////////////////////////////////

	public void actionPerformed(ActionEvent arg0) {

		if (CURRENT_STATE == MENU_STATE) {
			rocket.isAlive = true;
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

		if (keyPressed == KeyEvent.VK_ENTER) {

			if (CURRENT_STATE == END_STATE) {
				rocket = new Rocketship(250, 700, 50, 50);
				manager = new ObjectManager(rocket);
				right = left = up = down = false;
			}

			CURRENT_STATE++;

			if (CURRENT_STATE > END_STATE) {
				CURRENT_STATE = MENU_STATE;
			}

		}

		if (CURRENT_STATE == GAME_STATE) {

			if (keyPressed == KeyEvent.VK_UP) {
				up = true;
			} else if (keyPressed == KeyEvent.VK_DOWN) {
				down = true;
			} else if (keyPressed == KeyEvent.VK_LEFT) {
				left = true;
			} else if (keyPressed == KeyEvent.VK_RIGHT) {
				right = true;
			} else if (keyPressed == KeyEvent.VK_SPACE) {
				manager.addProjectile(new Projectile(rocket.x + rocket.width / 2 - projSize / 2,
						rocket.y + rocket.height / 2 - projSize / 2, projSize, projSize));
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

		int keyPressed = e.getKeyCode();

		if (CURRENT_STATE == GAME_STATE) {

			if (keyPressed == KeyEvent.VK_UP) {
				up = false;
			} else if (keyPressed == KeyEvent.VK_DOWN) {
				down = false;
			} else if (keyPressed == KeyEvent.VK_LEFT) {
				left = false;
			} else if (keyPressed == KeyEvent.VK_RIGHT) {
				right = false;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

}
