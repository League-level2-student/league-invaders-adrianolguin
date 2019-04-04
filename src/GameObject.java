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

class Rocketship extends GameObject {
	public int speed = 5;
	
	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	void update(KeyEvent e) {
		
	int keyPressed = e.getKeyCode();
		
		if(keyPressed == KeyEvent.VK_UP) {
			y-=speed;
		} else if(keyPressed == KeyEvent.VK_DOWN) {
			y+=speed;
		} else if(keyPressed == KeyEvent.VK_LEFT) {
			x-=speed;
		} else if(keyPressed == KeyEvent.VK_RIGHT) {
			x+=speed;
		} else {
			
		}
		
	}

	void draw(Graphics g) {

		g.setColor(Color.BLUE);

		g.fillRect(x, y, width, height);

	}

}
