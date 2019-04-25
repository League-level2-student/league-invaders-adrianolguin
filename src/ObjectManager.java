import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	
	Rocketship rocket;
	
 ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	
 ArrayList<Alien> aliens = new ArrayList<Alien>();

 
ObjectManager(Rocketship rocket){
	this.rocket = rocket;
}
	
void addProjectile(Projectile p) {
	projectiles.add(p);
}

void addAlien(Alien a) {
aliens.add(a);
}

void update() {
		
	rocket.update();
	for(int x = 0; x < projectiles.size(); x++) {
	projectiles.get(x).update();
	}
	
	for(int x = 0; x < aliens.size(); x++) {
	aliens.get(x).update();
	}
	
	checkCollision();
	
}

void draw(Graphics g) {
	
	for(int x = 0; x < projectiles.size(); x++) {
	projectiles.get(x).draw(g);
	}
	
	rocket.draw(g);

	for(int x = 0; x < aliens.size(); x++) {
	aliens.get(x).draw(g);
	}
	
}


void manageEnemies() {
	if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
        addAlien(new Alien(new Random().nextInt(LeagueInvaders.width - 50), 0, 50, 50));
enemyTimer = System.currentTimeMillis();
}

}

void purgeObjects() {

	
	for(int x = 0; x < projectiles.size(); x++) {
		if(projectiles.get(x).isAlive == false) {
			projectiles.remove(x);
		}
		}

	for(int x = 0; x < aliens.size(); x++) {
	if(aliens.get(x).isAlive == false) {
		aliens.remove(x);
	}
	}
	
}


void checkCollision() {
	for(Alien a : aliens){
		if(rocket.collisionBox.intersects(a.collisionBox)){
			rocket.isAlive = false;
		
		}
		for(int x = 0; x < projectiles.size();x++) {
			if(a.collisionBox.intersects(projectiles.get(x).collisionBox)){
			a.isAlive = false;
			projectiles.get(x).isAlive = false;
			}
		}
	}
	
	
	
}
}
