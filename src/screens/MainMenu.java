package screens;



import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import screens.stages.Stage1;

/**
 * Created by Kithu on 12.02.2017.
 */
public class MainMenu extends BasicGameState {
	public static final int ID =1;
	public static int points=0;
	private Image background;

	public static int getPoints() {
		return points;
	}

	public static void setPoints(int points) {
		MainMenu.points +=  points;
	}

	@Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
    	background = new Image("img/MainMenu.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
    	background.draw();

		graphics.drawString("Points "+getPoints(), 500, 00);
    	//graphics.drawString("PLAY", 300, 200);
    	//graphics.drawString("EXIT", 300, 250);
    	//graphics.drawString("SHOP", 300, 300);
    	
    	int posX = Mouse.getX();
    	int posY = Mouse.getY();
    	//System.out.println("X:"+posX+" Y:"+posY);
    	if((posX>111&&posY>236)&&(posX<218&&posY<276)){
    		if(Mouse.isButtonDown(0))
    		stateBasedGame.enterState(Stage1.ID);
    		
    	}
    	if((posX>111&&posY>182)&&(posX<218&&posY<220)){
    		if(Mouse.isButtonDown(0))

			stateBasedGame.enterState(Shop.ID);
    		
    	}
    	if((posX>111&&posY>128)&&(posX<218&&posY<166)){

    		
    		if(Mouse.isButtonDown(0)){
				System.exit(0);
    	}

    	}

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    	VARS.game_over=false;

		VARS.player.setX(100);
		VARS.player.setY(256);
		VARS.score=0;

    }
}
