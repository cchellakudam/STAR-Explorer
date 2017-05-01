package objects;

import org.newdawn.slick.Image;

public class SpikeObject extends GameObject {

	public SpikeObject(Image img, int pos_x, int pos_y, int speed_x, int hitbox_x, int hitbox_y) {
		super(img, pos_x, pos_y, speed_x, hitbox_x, hitbox_y);
		// TODO Auto-generated constructor stub
	}
	public void update(){
		this.pos_x += this.speed_x;
		this.hitbox.setLocation(this.pos_x, this.pos_y);
		this.img.rotate(0.1f);;
		
	}
}
