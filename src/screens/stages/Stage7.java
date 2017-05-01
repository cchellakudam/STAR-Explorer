package screens.stages;

import objects.AsteroidObject;
import objects.GameObject;
import objects.PlayerObject;
import objects.SpikeObject;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import screens.MainMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Chris on 29.03.2017.
 */
public class Stage7 extends BasicGameState {
    final static int ID=17;
    @Override
    public int getID() {
        return ID;
    }

    //Input(Buttons,Keys,Mouse...)
    public static Input in;

    //Images
    public static Image player_img;
    public static Image spike_img;
    public static Image background_img;
    public static Image asteroid_img;
    public static Image shot_img;

    //Score
    public static int score=0;

    //Objects
    public static PlayerObject player;

    //Times
    public static long time_spawn= System.currentTimeMillis();
    public static long time_spawn2= System.currentTimeMillis();
    public static long time_death= System.currentTimeMillis();
    //Lists
    public static List<SpikeObject> spike_list = new LinkedList<>();;
    public static List<GameObject> shot_list = new LinkedList<>();
    public static List<GameObject> main_list=  new LinkedList<>();
    public static List<AsteroidObject> asteroid_list=  new LinkedList<>();
    //Music
    public static Music bg_music;
    public static Sound explosion;
    public static Sound shoot;

    boolean pause =false;
    public static boolean music_start;

    //Vars
    public static boolean game_over=false;

    @Override
    public void init(GameContainer gc, StateBasedGame stateBasedGame) throws SlickException {

        player_img = new Image("img/spaceship.png");
        spike_img = new Image("img/strudel.png");
        asteroid_img = new Image("img/asteroid.png");
        background_img = new Image("img/Stage7.png");
        shot_img = new Image("img/bullet.png");


        bg_music = new Music("sounds/bgsong.wav");
        bg_music.loop();
        bg_music.setVolume(0.1f);



        explosion = new Sound("sounds/explosion.wav");
        shoot = new Sound("sounds/shoot.wav");

        in= gc.getInput();
        player = new PlayerObject(player_img,100,256,0, player_img.getWidth(), player_img.getHeight());

        File f = new File("Highscore.txt");
        try {
            PrintWriter pw = new PrintWriter(f);
            pw.write("Player1: "+score);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void render(GameContainer gr, StateBasedGame sbg, Graphics g) throws SlickException {
        background_img.draw();
        g.drawString("Score:"+score,10,20 );

        player.getImg().draw(player.getX(),player.getY());
        //g.draw(player.getHitbox());
        for(SpikeObject spike : spike_list){
            spike.getImg().draw(spike.getX(), spike.getY());
            //g.draw(spike.getHitbox());
        }
        for(GameObject shot : shot_list){
            shot.getImg().draw(shot.getX(), shot.getY());
            //g.draw(shot.getHitbox());
        }
        for(AsteroidObject asteroid : asteroid_list){
            asteroid.getImg().draw(asteroid.getX(), asteroid.getY());
            //g.draw(asteroid.getHitbox());
        }

        //GAME OVER
        if(game_over){
            spike_list.clear();
            asteroid_list.clear();
            main_list.clear();
            shot_list.clear();
            in.pause();

            g.drawString("GAME OVER", 300, 220);
            if(System.currentTimeMillis()-time_death>1000){

                sbg.enterState(MainMenu.ID);

            }

        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame stateBasedGame, int i) throws SlickException {
        player.update(in);



        for(GameObject go:main_list)
            go.update();
        boolean jump_out= false;

        for(SpikeObject spike : spike_list){
            spike.update();
            if(player.getHitbox().intersects(spike.getHitbox())){
                game_over=true;
            }
            for(GameObject shot: shot_list)
                if(shot.getHitbox().intersects(spike.getHitbox())){
                    explosion.play(1f,0.1f);
                    shot_list.remove(shot);
                    spike_list.remove(spike);
                    main_list.remove(shot);
                    main_list.remove(spike);
                    score += 10;
                    MainMenu.setPoints(score);
                    jump_out=true;
                    break;
                }

            if(jump_out) break;

        }
        for(AsteroidObject asteroid : asteroid_list){

            if(player.getHitbox().intersects(asteroid.getHitbox())){
                game_over=true;
            }
            for(GameObject shot:shot_list)
                if(shot.getHitbox().intersects(asteroid.getHitbox()))
                {
                    //explosion.play(1f,0.1f);
                    shot_list.remove(shot);
                    main_list.remove(shot);
                    jump_out = true;
                    break;
                }
            if(jump_out) break;

        }

        //Memory Clear
        for(GameObject go: main_list){
            if(go.getX()>640){
                spike_list.remove(go);
                asteroid_list.remove(go);
                main_list.remove(go);
                break;
            }
        }
        for(GameObject go: main_list){
            if(go.getX()< -20 ){
                spike_list.remove(go);
                asteroid_list.remove(go);
                main_list.remove(go);
                break;
            }
        }
        //Enemy Generator

        if(System.currentTimeMillis()-time_spawn>600){
            SpikeObject spike=( new SpikeObject(spike_img,640,(int)(Math.random()*460),-1, spike_img.getWidth(),spike_img.getHeight()));
            spike_list.add(spike);
            main_list.add(spike);
            time_spawn=System.currentTimeMillis();
        }
        if(System.currentTimeMillis()-time_spawn2>1000){
            AsteroidObject asteroid=( new AsteroidObject(asteroid_img,640,(int)(Math.random()*460),-1, asteroid_img.getWidth(),asteroid_img.getHeight()));
            asteroid_list.add(asteroid);
            main_list.add(asteroid);
            time_spawn2=System.currentTimeMillis();
        }

        if(pause){

            gc.setPaused(pause);

            System.out.println(pause);

        }
        if( in.isKeyPressed(in.KEY_P))
            pause =!pause;

    }
}
