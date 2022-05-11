package pt.upskills.projeto.game;

import pt.upskills.projeto.gui.ImageMatrixGUI;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Colours.Black;
import pt.upskills.projeto.objects.Colours.Green;
import pt.upskills.projeto.objects.Game;
import pt.upskills.projeto.objects.set.Floor;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.set.Room;
import pt.upskills.projeto.rogue.utils.Position;

import java.util.ArrayList;
import java.util.List;

public class Engine {

    public void init(){

        ImageMatrixGUI gui = ImageMatrixGUI.getInstance();

        List<ImageTile> tiles = new ArrayList<>();
        List<ImageTile> tiles_stats = new ArrayList<>();
        List<ImageTile> tiles2 = new ArrayList<>();



        for(int i=0; i<10; i++){
            if (i < 3 || i>6) {
                tiles_stats.add((new Black(new Position(i, 0))));
            }
            else{
                tiles_stats.add((new Green(new Position(i, 0))));
            }

            for(int j=0; j<10; j++){
                tiles.add(new Floor(new Position(i, j)));
            }
        }

        Game um = new Game(0);
        um.sala();

        Hero licious = new Hero( new Position(1, 1), um);

        tiles2.add(licious);  // adiciona o heroir

        gui.newImages(tiles); /// adiciona o chao
        gui.newImages(um.getCurrentRoom().create_room());
        gui.newStatusImages(tiles_stats);
	    gui.addObserver(licious); // fica a observar os movimentos do heroi
        gui.newImages(tiles2);
        gui.go(); // comeca
	    //gui.removeImage();
	    //gui.addImage();
	    //gui.

        while (true){
            gui.update();
        }
    }

    public static void main(String[] args){

        Engine engine = new Engine();
        engine.init();
    }
}
