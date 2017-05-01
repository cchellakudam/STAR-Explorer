package screens;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Chris on 28.03.2017.
 */
public class StageScreen extends BasicGameState{
    Image background;
    public static final int ID=4;
    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        background = new Image("img/bgs.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {
       background.draw();

        g.drawString("Stage1",gameContainer.getWidth()-450,175);
        g.drawString("Stage2",gameContainer.getWidth()-350,175);
        g.drawString("Stage3",gameContainer.getWidth()-250,175);
        g.drawString("Stage4",gameContainer.getWidth()-450,225);
        g.drawString("Stage5",gameContainer.getWidth()-350,225);
        g.drawString("Stage6",gameContainer.getWidth()-250,225);
        g.drawString("Stage7",gameContainer.getWidth()-450,275);
        g.drawString("Stage8",gameContainer.getWidth()-350,275);
        g.drawString("Stage9",gameContainer.getWidth()-250,275);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }
}
