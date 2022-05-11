package pt.upskills.projeto.objects;

import pt.upskills.projeto.gui.ImageMatrixGUI;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;
import pt.upskills.projeto.rogue.utils.Vector2D;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import static pt.upskills.projeto.objects.Room.stats;


public class Hero implements ImageTile, Observer {

    ImageMatrixGUI gui = ImageMatrixGUI.getInstance();

    private List<ImageTile> tiles = new ArrayList<>();

    String filename;
    private Position position;

    Room room;
    int key = 0;
    public static int health;
    public static int damage;
    public static ArrayList<Integer> fireball = new ArrayList<>();


    public Hero(Position position, Room room) {
        this.position = position;
        this.filename = "room0.txt";
        this.key = key;
        this.room = room;
        this.health = 15;
        this.damage = 3;
        this.fireball = fireball;
    }

    
//-----------------------------------------------------------------------------

    @Override
    public void update(Observable o, Object arg) {
        Integer keyCode = (Integer) arg;

        if (keyCode == KeyEvent.VK_W){
            try {
                String a = room.isPositionfree(getPosition(), new Vector2D(0, -1));
	            if (a == "true"){
                    getPosition().plus(new Vector2D(0, -1));
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
                String a = room.isPositionfree(getPosition(), new Vector2D(0, 1));
                if (a.contains("true")){
                    getPosition().plus(new Vector2D(0, 1));
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
                String a = room.isPositionfree(getPosition(), new Vector2D(-1, 0));
                if (a == "true"){
                    getPosition().plus(new Vector2D(-1, 0));
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
                String a = room.isPositionfree(getPosition(), new Vector2D(1, 0));
                if (a == "true"){
                    getPosition().plus(new Vector2D(1, 0));
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

        if (keyCode == KeyEvent.VK_B){

            System.out.println("Fireball size " + fireball.size());
            if (fireball.size() > 0){
                System.out.println("Kill them all");
                //room.deleteStatusimage("Fire", new Position(fireball.size()-1,0));
                fireball.remove(fireball.size() -1 );
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


        //System.out.println(getDamage());
        //System.out.println(getHealth());
        //System.out.println(getKey());
        //System.out.println(getFireball());



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


}
