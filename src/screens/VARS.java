package screens;

import objects.AsteroidObject;
import objects.GameObject;
import objects.PlayerObject;
import objects.SpikeObject;
import org.newdawn.slick.Music;
import org.newdawn.slick.Sound;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Chris on 26.04.2017.
 */
public class VARS {
    public static boolean game_over=false;
    public static List<SpikeObject> spike_list = new LinkedList<>();;
    public static List<GameObject> shot_list = new LinkedList<>();
    public static List<GameObject> main_list=  new LinkedList<>();
    public static List<AsteroidObject> asteroid_list=  new LinkedList<>();

    public static Music bg_music;
    public static Sound explosion;
    public static Sound shoot;

    boolean pause =false;

    public static long time_spawn= System.currentTimeMillis();
    public static long time_spawn2= System.currentTimeMillis();
    public static long time_death= System.currentTimeMillis();

    public static PlayerObject player;

    public static int score=0;
}
