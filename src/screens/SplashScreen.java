package screens;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Kithu on 12.02.2017.
 */
public class SplashScreen extends BasicGameState {
    //ID we return to class 'Main*
    public static final int ID =0;
    private SpriteSheet splashSheet;
    private Animation splashAnimation;
    public static long time = System.currentTimeMillis();
    
    
    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
    	
        splashSheet = new SpriteSheet("img/splashsprite.png",640,480);
        splashAnimation = new Animation(splashSheet,1000);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
       splashAnimation.draw();
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
    	splashAnimation.update(delta);
    	if(System.currentTimeMillis()-time>2000){
    		stateBasedGame.enterState(MainMenu.ID);
    	}
    	
    }
}
