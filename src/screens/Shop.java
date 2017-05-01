package screens;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import javax.swing.*;

/**
 * Created by Chris on 21.03.2017.
 */
public class Shop extends BasicGameState

{
    private Image shop;
    public static final int ID =3;



    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        shop= new Image("img/shop.png");




    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        shop.draw();
        graphics.drawString("Back",100,50);
        int posX = Mouse.getX();
        int posY = Mouse.getY();
        //System.out.println("X:"+posX+" Y:"+posY);
        if((posX>100&&posY>415)&&(posX<140&&posY<430)){
            if(Mouse.isButtonDown(0))
                stateBasedGame.enterState(MainMenu.ID);

        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
       // System.out.println(stateBasedGame.getCurrentStateID());
        //if(stateBasedGame.getCurrentStateID()==ID){
           // int eingabe = JOptionPane.showConfirmDialog(null,"Sind Sie sicher?","",JOptionPane.YES_NO_OPTION);
            //System.out.println(eingabe);
        //}
    }
}
