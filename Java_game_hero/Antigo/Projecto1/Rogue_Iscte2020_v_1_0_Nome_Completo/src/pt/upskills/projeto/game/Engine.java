package pt.upskills.projeto.game;

import pt.upskills.projeto.gui.ImageMatrixGUI;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Floor;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.Room;
import pt.upskills.projeto.rogue.utils.Position;

import java.util.ArrayList;
import java.util.List;

import static pt.upskills.projeto.game.funcoes.inputMovimento;


public class Engine {
    public void init(int nr_sala){

        //cria interface
        ImageMatrixGUI gui = ImageMatrixGUI.getInstance();

        //cria um chao da sala com dimensoes (xy)
        //abrir ficheiro retorna um vetor [1,10] para o eixo Vertical

        List<ImageTile> tiles = new ArrayList<>();

        String nome_ficheiro = "room" + String.valueOf(nr_sala) + ".txt";

        Hero licious = new Hero(new Position(1, 1), "licious");


        Room zero = new Room(nome_ficheiro);
        zero.create_room(licious);


        while (inputMovimento(licious, nome_ficheiro) == true) {
            gui.update();
        }
    }


    public static void main(String[] args){

        Engine engine = new Engine();
        engine.init(0);
        //abrir_ficheiro();
        //inputMovimento();


    }

}
