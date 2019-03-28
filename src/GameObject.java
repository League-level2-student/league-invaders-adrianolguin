import java.awt.Color;
import java.awt.Graphics;

public class GameObject {
	int x;
    int y;
    int width;
    int height;
	
	GameObject(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	 
	void update() {
	
		y += 10;
		
	}
	
	void draw(Graphics g) {
	g.setColor(Color.DARK_GRAY);
	g.fillRect(x, y, width, height);
	}
	
	
}
