import java.awt.Graphics;

public class Projectile {

int x;
int y;
int width;
int height;
int speed = 10;
	
Projectile(int x, int y, int width, int height){
this.x = x;
this.y = y;
this.width = width;
this.height = height;
}

void draw(Graphics g) {
	
}

void update() {
y-=speed;

if(y < 0) {
//GameObject.
}

}
}
