package pt.upskills.projeto.objects;

import pt.upskills.projeto.game.FireBallThread;
import pt.upskills.projeto.gui.FireTile;
import pt.upskills.projeto.gui.ImageMatrixGUI;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.set.Fireball;
import pt.upskills.projeto.objects.set.Room;
import pt.upskills.projeto.rogue.utils.Direction;
import pt.upskills.projeto.rogue.utils.Position;
import pt.upskills.projeto.rogue.utils.Vector2D;

import javax.sound.midi.Soundbank;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static pt.upskills.projeto.objects.set.Room.stats;

public class Hero implements ImageTile, Observer {

    ImageMatrixGUI gui = ImageMatrixGUI.getInstance();

    private List<ImageTile> tiles = new ArrayList<>();

    private Position position;
    int p = 1;
    Game game;
    public static int key = 0;
    int health = 100;
    int damage = 10;
    int highscore = 200;
    public static ArrayList<Integer> fireball = new ArrayList<>();




    public Hero(Position position, Game game) {
        this.position = position;
        this.key = key;
        this.game = game ;
        this.health = health;
        this.damage = damage;
        this.fireball = fireball;
        this.highscore = highscore;
    }


//-----------------------------------------------------------------------------



    @Override
    public void update(Observable o, Object arg) {
        Integer keyCode = (Integer) arg;
        for (int i = 0; i < 50; ++i) System.out.println();
        System.out.println("=========History===========");
        double p1 = getGame().currentRoom.getNr_sala();
        Direction dir;

        if (keyCode == KeyEvent.VK_W){
            try {
                dir = Direction.UP;
                String a = getGame().currentRoom.isPositionfree(getPosition(), new Vector2D(0, -1));
                if (a == "true"){
                    getPosition().plus(new Vector2D(0, -1));
                }
                if ((a == "Next Level") && (getKey() == 1)){
                    setKey(0);

                    for (ImageTile x : getGame().currentRoom.tiles){
                        gui.removeImage(x);
                    }

                    getGame().currentRoom.clearAll();
                    getGame().currentRoom.setNr_sala(getGame().getNr_sala() + p );
                    getGame().currentRoom.sala();
                    gui.newImages(getGame().currentRoom.create_room());

                    p++;

                }
                if ((a == "Up")){
                    setKey(0);

                    for (ImageTile x : getGame().currentRoom.tiles){
                        gui.removeImage(x);
                    }
                    p1 = p1 + 0.1;
                    getGame().currentRoom.clearAll();
                    getGame().currentRoom.setNr_sala(getGame().getNr_sala() + p1 );
                    getGame().currentRoom.sala();
                    gui.newImages(getGame().currentRoom.create_room());

                }
                if ((a == "Down")){
                    setKey(0);

                    for (ImageTile x : getGame().currentRoom.tiles){
                        gui.removeImage(x);
                    }
                    p1 = p1 - 0.1;
                    getGame().currentRoom.clearAll();
                    getGame().currentRoom.setNr_sala(getGame().getNr_sala() + p1 );
                    getGame().currentRoom.sala();
                    gui.newImages(getGame().currentRoom.create_room());

                }
                else {
                    System.out.println(a);
                }
            }
            catch(IndexOutOfBoundsException e ) {
                System.out.println("Out of bounds");
            }
        }

        if (keyCode == KeyEvent.VK_S){
            try {
                dir = Direction.UP;
                String a = getGame().currentRoom.isPositionfree(getPosition(), new Vector2D(0, 1));
                if (a.contains("true")){
                    getPosition().plus(new Vector2D(0, 1));
                }
                if (a == "Next Level"){
                    setKey(0);


                    for (ImageTile x : getGame().currentRoom.tiles){
                        gui.removeImage(x);
                    }
                    getGame().currentRoom.clearAll();
                    getGame().currentRoom.setNr_sala(getGame().getNr_sala() + p );
                    getGame().currentRoom.sala();
                    gui.newImages(getGame().currentRoom.create_room());

                    p++;

                }
                if ((a == "Up")){
                    setKey(0);

                    for (ImageTile x : getGame().currentRoom.tiles){
                        gui.removeImage(x);
                    }
                    p1 = p1 + 0.1;
                    getGame().currentRoom.clearAll();
                    getGame().currentRoom.setNr_sala(getGame().getNr_sala() + p1 );
                    getGame().currentRoom.sala();
                    gui.newImages(getGame().currentRoom.create_room());

                }
                if ((a == "Down")){
                    setKey(0);

                    for (ImageTile x : getGame().currentRoom.tiles){
                        gui.removeImage(x);
                    }
                    p1 = p1 - 0.1;
                    getGame().currentRoom.clearAll();
                    getGame().currentRoom.setNr_sala(getGame().getNr_sala() + p1 );
                    getGame().currentRoom.sala();
                    gui.newImages(getGame().currentRoom.create_room());

                }
                else {
                    System.out.println(a);
                }
            }
            catch(IndexOutOfBoundsException e ) {
                System.out.println("Out of bounds");
            }
        }

        if (keyCode == KeyEvent.VK_A){
            try {
                dir = Direction.UP;
                String a = getGame().currentRoom.isPositionfree(getPosition(), new Vector2D(-1, 0));
                if (a == "true"){
                    getPosition().plus(new Vector2D(-1, 0));
                }
                if (a == "Next Level"){
                    setKey(0);

                    for (ImageTile x : getGame().currentRoom.tiles){
                        gui.removeImage(x);
                    }

                    getGame().currentRoom.clearAll();
                    getGame().currentRoom.setNr_sala(getGame().getNr_sala() + p );
                    getGame().currentRoom.sala();
                    gui.newImages(getGame().currentRoom.create_room());

                    p++;
                }
                if ((a == "Up")){
                    setKey(0);

                    for (ImageTile x : getGame().currentRoom.tiles){
                        gui.removeImage(x);
                    }
                    p1 = p1 + 0.1;
                    getGame().currentRoom.clearAll();
                    getGame().currentRoom.setNr_sala(getGame().getNr_sala() + p1 );
                    getGame().currentRoom.sala();
                    gui.newImages(getGame().currentRoom.create_room());

                }
                if ((a == "Down")){
                    setKey(0);

                    for (ImageTile x : getGame().currentRoom.tiles){
                        gui.removeImage(x);
                    }
                    p1 = p1 - 0.1;
                    getGame().currentRoom.clearAll();
                    getGame().currentRoom.setNr_sala(getGame().getNr_sala() + p1 );
                    getGame().currentRoom.sala();
                    gui.newImages(getGame().currentRoom.create_room());

                }
                else {
                    System.out.println(a);
                }            }

            catch(IndexOutOfBoundsException e ) {
                System.out.println("Out of bounds");
            }
        }

        if (keyCode == KeyEvent.VK_D){
            try {
                dir = Direction.UP;
                String a = getGame().currentRoom.isPositionfree(getPosition(), new Vector2D(1, 0));
                if (a == "true"){
                    getPosition().plus(new Vector2D(1, 0));
                }
                if (a == "Next Level"){
                    setKey(0);

                    for (ImageTile x : getGame().currentRoom.tiles){
                        gui.removeImage(x);
                    }
                    getGame().currentRoom.clearAll();
                    getGame().currentRoom.setNr_sala(getGame().getNr_sala() + p );
                    getGame().currentRoom.sala();
                    gui.newImages(getGame().currentRoom.create_room());

                    p++;
                }
                if ((a == "Up")){
                    setKey(0);

                    for (ImageTile x : getGame().currentRoom.tiles){
                        gui.removeImage(x);
                    }
                    p1 = p1 + 0.1;
                    getGame().currentRoom.clearAll();
                    getGame().currentRoom.setNr_sala(getGame().getNr_sala() + p1 );
                    getGame().currentRoom.sala();
                    gui.newImages(getGame().currentRoom.create_room());

                }
                if ((a == "Down")){
                    setKey(0);

                    for (ImageTile x : getGame().currentRoom.tiles){
                        gui.removeImage(x);
                    }
                    p1 = p1 - 0.1;
                    getGame().currentRoom.clearAll();
                    getGame().currentRoom.setNr_sala(getGame().getNr_sala() + p1 );
                    getGame().currentRoom.sala();
                    gui.newImages(getGame().currentRoom.create_room());

                }
                else {
                    System.out.println(a);
                }            }

            catch(IndexOutOfBoundsException e ) {
                System.out.println("Out of bounds");
            }

        }

        if (keyCode == KeyEvent.VK_N){
            System.out.println("are you cheating???");
        }

        List<ImageTile> tile = new ArrayList<>();
        if (keyCode == KeyEvent.VK_B){
            //Fireball a = new Fireball(new Position(-2, -2));
            //tile.add(a);
            if (fireball.size() > 0){
                System.out.println("Kill them all");
                fireball.remove(fireball.size() -1 );
                //FireBallThread t = new FireBallThread(Direction.UP, tile.);
                //t.start();
            }
            else {
                System.out.println("No balls my friend.");
            }

        }

        if (stats.containsKey("Health")){
            setHealth(stats.get("Health"));
        }
        if (stats.containsKey("Key")){
            setKey(stats.get("Key"));
        }
        if (stats.containsKey("Damage")){
            setDamage(stats.get("Damage"));
        }

        highscore--;
        getGame().currentRoom.enemyMovement(getPosition());

        if (getHealth() < 0) {

            /*
            File save = new File("C:/Users/" + getName());
            try {
                FileWriter myWriter = new FileWriter(save);
                myWriter.write(String.valueOf(getHighscore()));
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
             */

            int final_highscore = (getHighscore() + getGame().currentRoom.getScore());
            System.out.println("YOU DEAD SON GAME OVER");

            // throw our custom exception
        }
        else {
            System.out.println("========Hero Stats=========");
            System.out.println("Damage - " + getDamage());
            System.out.println("Health - " + getHealth());
            System.out.println("Key - " + getKey());
            System.out.println("Fireballs - " + getFireball());
            System.out.println("HighScore - " + (getHighscore() + getGame().currentRoom.getScore()));
        }


    }

    //------------------------------------------------------------------------------
    @Override
    public String getName() {
        return "Hero";
    }

    @Override
    public Position getPosition() {
        return position;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Game getGame() {
        return game;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = getHealth() + health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = getDamage() + damage;
    }

    public static ArrayList<Integer> getFireball() {
        return fireball;
    }

    public int getHighscore() {
        return highscore;
    }

}