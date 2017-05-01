package  objects;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class GameObject {
protected Image img;
protected int pos_x;
protected int pos_y;
protected int speed_x;
protected Shape hitbox ; 
protected int hitbox_x;
protected int hitbox_y;

public GameObject(Image img, int pos_x, int pos_y, int speed_x, int hitbox_x,int hitbox_y) {
	super();
	this.img = img;
	this.pos_x = pos_x;
	this.pos_y = pos_y;
	this.speed_x = speed_x;
	this.hitbox_x = hitbox_x;
	this.hitbox_x = hitbox_y;
	
	this.hitbox = new Rectangle(pos_x,pos_y,hitbox_x,hitbox_y);
	
		
}
public void update(){
	this.pos_x += this.speed_x;
	this.hitbox.setLocation(this.pos_x,this.pos_y);
	
}
public Image getImg(){
	return this.img;
}
public Shape getHitbox(){
	return this.hitbox;
}
public int getX(){
	return this.pos_x;
}
public int getY(){
	return this.pos_y;
}
public int getPos_y() {
	return pos_y;
}
public void setPos_y(int pos_y) {
	this.pos_y = pos_y;
}
}
