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
	public boolean isAlive;
	
	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	void update(String keyPressed) {
		
	if(keyPressed.equals("up")) {
	y-=speed;
	} else if(keyPressed.equals("down")) {
	y+=speed;	
	} else if(keyPressed.equals("left")) {
	x-=speed;
	} else if(keyPressed.equals("right")) {
	x+=speed;
	} else if(keyPressed.equals("upRight")) {
		y-=speed;
		x+=speed;
	} else if(keyPressed.equals("upLeft")) {
		y-=speed;
		x-=speed;
	} else if(keyPressed.equals("downRight")) {
		y+=speed;
		x+=speed;
	} else if(keyPressed.equals("downLeft")) {
		y+=speed;
		x-=speed;
	}
	}
		
		

	void draw(Graphics g) {

		g.setColor(Color.BLUE);

		g.fillRect(x, y, width, height);

	}

}
