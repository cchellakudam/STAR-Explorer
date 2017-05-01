package objects;

import java.util.LinkedList;
import java.util.List;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import screens.Game;
import screens.VARS;

public class PlayerObject extends GameObject{
	protected long time_shot;
	public PlayerObject(Image img, int pos_x, int pos_y, int speed_x, int hitbox_x, int hitbox_y) {
		super(img, pos_x, pos_y, speed_x, hitbox_x, hitbox_y);
		
	}
	public void update(Input in){

		if(!VARS.game_over){
		if( in.isKeyDown(in.KEY_A)&&this.pos_x>20){
			this.pos_x--;
			
		}
		if( in.isKeyDown(in.KEY_D)&&this.pos_x<620){
			this.pos_x++;
			
		}
		if( in.isKeyDown(in.KEY_W)&&this.pos_y>20){
			this.pos_y--;
			
		}
		if( in.isKeyDown(in.KEY_S)&&this.pos_y<460){
			this.pos_y++;
			
		}
		if( in.isKeyDown(in.KEY_SPACE)){
			if(System.currentTimeMillis()-time_shot>400){
			GameObject shot;
			Game.shoot.play(1f, 0.2f);
			shot =(new GameObject(Game.shot_img,this.pos_x+16,this.pos_y+4,2,this.hitbox_x,this.hitbox_y));
				VARS.shot_list.add(shot);
				VARS.main_list.add(shot);
			time_shot = System.currentTimeMillis();
			
			}
		}
		}
		this.hitbox.setLocation(this.pos_x,this.pos_y);
	}
	public void setX(int pos_x){
		this.pos_x=pos_x;
	}
	public void setY(int pos_y){
		this.pos_y=pos_y;
	}

}
