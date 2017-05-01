package objects;

import org.newdawn.slick.Image;

import screens.Game;

public class AsteroidObject extends GameObject{

	public AsteroidObject(Image img, int x, int y, int speed_x, int hitbox_x, int hitbox_y) {
		super(img, x, y, speed_x, hitbox_x, hitbox_y);
		// TODO Auto-generated constructor stub
	}
	public void update(){
		this.pos_x += this.speed_x;
		this.hitbox.setLocation(this.pos_x,this.pos_y);
		this.img.rotate(0.05f);
	}


}
