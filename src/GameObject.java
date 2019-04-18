import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class GameObject {
	int x;
	int y;
	int width;
	int height;

	GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	void update() {

	}

	void draw(Graphics g) {
	}

}

class Alien extends GameObject {

	int speed = 5;
	boolean isAlive = true;

	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	void update() {
		y += speed;
		if (y > LeagueInvaders.height) {
			isAlive = false;
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
}

class Rocketship extends GameObject {
	public int speed = 5;
	public boolean isAlive;

	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	void update(String keyPressed) {

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

		g.setColor(Color.BLUE);

		g.fillRect(x, y, width, height);

	}

}
///////////////////

class Projectile extends GameObject {
	Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	boolean isAlive = true;
	int x;
	int y;
	int width;
	int height;
	int speed = 10;

	void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}

	void update() {
		y -= speed;

		if (y < 0) {
			isAlive = false;
		}
	}

}
