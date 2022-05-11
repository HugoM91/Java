package pt.upskills.projeto.objects;

import pt.upskills.projeto.game.Engine;
import pt.upskills.projeto.gui.ImageMatrixGUI;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.items.Sword;
import pt.upskills.projeto.rogue.utils.Position;

import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;



public class Hero  implements ImageTile, Observer {

    private final String nome;
    private Position position;
    int health = 20;
    int damage = 4;
    Boolean key = false;
    int[] fireball = {0,0,0};
    private int nr_sala = 0;


    public Hero(Position position, String nome) {
        this.position = position;
        this.health = health;
        this.damage = damage;
        this.key = key;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String getName() {
        return "Hero";
    }

    @Override
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position, char x) {

        switch (x) {
            case 'W':
                System.out.println("You are not Peter Parker!!! shhhhhhh");
                break;
            case 'E':
                System.out.println("This Sword is good for you");
                setDamage(3);
                this.position = position;
                Room.removeTiles(getPosition());
                break;
            case 'H':

                System.out.println("Thor would be proud ");
                setDamage(7);
                this.position = position;
                Room.removeTiles(getPosition());
                break;
            case 'K':

                System.out.println("You have a key that maybe will take you to WONDERLAND, maybe not");
                setKey(true);
                this.position = position;
                Room.removeTiles(getPosition());
                break;
            case 'M':
                System.out.println("Yummy Yummy!!!");
                setHealth(3);
                this.position = position;
                Room.removeTiles(getPosition());
                break;
            case 'F':
                System.out.println("The almighty Gods left this here for you. Use it well young warrior");

                for (int i = 0; i < fireball.length; i++)
                if (fireball[i] == 0){
                 fireball[i] = 1;
                 }
                setHealth(3);
                this.position = position;
                Room.removeTiles(getPosition());
                break;

            case 'e':
                System.out.println("BadGuy - 'Hey are you ready to be destroyed'");
                setHealth(-5);
                //If defeated // this.position = position;
                Room.removeTiles(getPosition());
                break;
            case 'B':
                System.out.println("Nananananananananana");
                setHealth(-2);
                //If defeated //this.position = position;
                Room.removeTiles(getPosition());
                break;
            case 'k':
                System.out.println("Sticks and stones, oh upss");
                setHealth(-3);
                //If defeated // this.position = position;
                Room.removeTiles(getPosition());
                break;
            case 't':
                System.out.println("Sneaky sneaky, you lost someting");
                // Remove Items and remove thief // this.position = position;
                Room.removeTiles(getPosition());
                break;
            case 'T':
                System.out.println("Watch your feet");
                setHealth(-3);
                this.position = position;
                Room.removeTiles(getPosition());
                break;
            case'O':
                System.out.println("Congrats lets change go to the next room");
                Engine engine = new Engine();
                nr_sala++;
                engine.init(nr_sala);
                break;
                // Criar sala novo no engine

            case 'o':
                this.position = position;
                if (getKey() == true){
                    System.out.println("You have opened the door");
                }
                Room.removeTiles(getPosition());
                // after removing change the tile to door open
                break;
            case ' ':
                this.position = position;
                break;
        }
        }



    /**
     * This method is called whenever the observed object is changed. This function is called when an
     * interaction with the graphic component occurs {{@link ImageMatrixGUI}}
     * @param o
     * @param arg
     */

    @Override
    public void update(Observable o, Object arg) {
        Integer keyCode = (Integer) arg;
        if (keyCode == KeyEvent.VK_DOWN){
            // do something
        }
        if (keyCode == KeyEvent.VK_UP){
            // do something
        }
        if (keyCode == KeyEvent.VK_LEFT){
            // do something
        }
        if (keyCode == KeyEvent.VK_RIGHT){
            // do something
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = this.health + health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = this.damage + damage;
    }

    public Boolean getKey() {
        return key;
    }

    public void setKey(Boolean key) {
        this.key = key;
    }


}
