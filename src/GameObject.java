import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class GameObject {

	Rectangle collisionBox;

	int x;
	int y;
	int width;
	int height;
	boolean isAlive = true;
	int speed;

	GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.collisionBox = new Rectangle(x, y, width, height);
	}

	void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	void draw(Graphics g) {
	}

}

class Alien extends GameObject {

	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
	}

	void update() {
		super.update();
		y += speed;
		if (y > LeagueInvaders.height) {
			isAlive = false;
		}
	}

	void draw(Graphics g) {

		g.drawImage(GamePanel.alienImg, x, y, width, height, null);

	}
}

class Rocketship extends GameObject {
	public int speed = 5;

	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		isAlive = true;
	}

	void update(String keyPressed) {

		super.update();

		if (keyPressed.equals("up")) {
			y -= speed;
		} else if (keyPressed.equals("down")) {
			y += speed;
		} else if (keyPressed.equals("left")) {
			x -= speed;
		} else if (keyPressed.equals("right")) {
			x += speed;
		} else if (keyPressed.equals("upRight")) {
			y -= speed;
			x += speed;
		} else if (keyPressed.equals("upLeft")) {
			y -= speed;
			x -= speed;
		} else if (keyPressed.equals("downRight")) {
			y += speed;
			x += speed;
		} else if (keyPressed.equals("downLeft")) {
			y += speed;
			x -= speed;
		}
	}

	void draw(Graphics g) {

		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);

	}

}

///////////////////
