package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import screens.*;
import screens.stages.*;

/**
 * Created by Kithu on 12.02.2017.
 */
public class Main extends StateBasedGame {
    // Game state identifiers
    public static final int SPLASHSCREEN = 0;
    public static final int MAINMENU     = 1;
    public static final int GAME         = 2;
    public static final int SHOP         = 3;
    public static final int STAGESCREEN  = 4;
    //Stages
    public static final int STAGE1=11;
    public static final int STAGE2=12;
    public static final int STAGE3=13;
    public static final int STAGE4=14;
    public static final int STAGE5=15;
    public static final int STAGE6=16;
    public static final int STAGE7=17;
    public static final int STAGE8=18;
    public static final int STAGE9=19;

    // Application Properties
    public static final int WIDTH   = 640;
    public static final int HEIGHT  = 480;
    public static final int FPS     = 60;
    public static final double VERSION = 1.0;
 
    
    // Class Constructor
    public Main(String appName) {
        super(appName);
    }
   
    // Initialize your game states (calls init method of each gamestate, and set's the state ID)
    public void initStatesList(GameContainer gc) throws SlickException {
        // The first state added will be the one that is loaded first, when the application is launched
        this.addState(new SplashScreen()); 
        this.addState(new MainMenu());
        this.addState(new Game());
        this.addState(new Shop());
        this.addState(new StageScreen());
        this.addState(new Stage1());
        this.addState(new Stage2());
        this.addState(new Stage3());
        this.addState(new Stage4());
        this.addState(new Stage5());
        this.addState(new Stage6());
        this.addState(new Stage7());
        this.addState(new Stage8());
        this.addState(new Stage9());
    }

    // Main Method
    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new Main("SpaceGame" + VERSION));
            app.setDisplayMode(WIDTH, HEIGHT, false);
            app.setTargetFrameRate(FPS);
        	app.setVSync(true);
			app.setShowFPS(false);
			app.start();
			
        } catch(SlickException e) {
            e.printStackTrace();
        }
    }
}
