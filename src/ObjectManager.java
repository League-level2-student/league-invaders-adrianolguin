import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {

	Rocketship rocket;
	
 ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	
ObjectManager(Rocketship rocket){
	this.rocket = rocket;
}
	
void addProjectile(Projectile p) {
	projectiles.add(p);
}

void update() {
	rocket.update();
	for(int x = 0; x < projectiles.size(); x++) {
	projectiles.get(x).update();
	}
}

void draw(Graphics g) {
	rocket.draw(g);
	for(int x = 0; x < projectiles.size(); x++) {
	projectiles.get(x).draw(g);
	}
}

}
