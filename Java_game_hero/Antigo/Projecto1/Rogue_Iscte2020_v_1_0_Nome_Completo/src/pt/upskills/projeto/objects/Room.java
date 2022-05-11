package pt.upskills.projeto.objects;

import pt.upskills.projeto.gui.ImageMatrixGUI;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Colours.Black;
import pt.upskills.projeto.objects.Colours.Green;
import pt.upskills.projeto.objects.Colours.Red;
import pt.upskills.projeto.objects.enemy.*;
import pt.upskills.projeto.objects.items.GoodMeat;
import pt.upskills.projeto.objects.items.Hammer;
import pt.upskills.projeto.objects.items.Sword;
import pt.upskills.projeto.objects.set.*;
import pt.upskills.projeto.rogue.utils.Position;

import java.util.*;

import static pt.upskills.projeto.game.funcoes.abrir_ficheiro;


public class Room implements ImageTile, Observer  {

	ImageMatrixGUI gui = ImageMatrixGUI.getInstance();

	@Override
	public String toString() {
		return "Room{" +
				"position=" + position +
				", nome='" + nome + '\'' +
				", formato_sala=" + formato_sala +
				", tiles=" + tiles +
				'}';
	}

	//  ---- Construtor
	private Position position;
	String nome;
	ArrayList<String> formato_sala = new ArrayList<String>();
	private static List<ImageTile> tiles = new ArrayList<>();

	public Room(String nome) {
		this.position = position;
		this.nome = nome;
		this.formato_sala = formato_sala;
		this.tiles = tiles;
	}

	//  ----

	public void create_room(Hero name){

		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				tiles.add(new Floor(new Position(i, j)));
			}
		}

		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				char x = abrir_ficheiro(getNome()).get(j).charAt(i);
				switch (x){
					case 'W':
						tiles.add(new Wall(new Position(i, j)));
						break;
					case 'S':
						tiles.add(new StairsUp(new Position(i, j)));
						break;
					case 's':
						tiles.add(new StairsDown(new Position(i, j)));
						break;
					case 'K':
						tiles.add(new Key(new Position(i, j)));
						break;
					case 'G':
						tiles.add(new Grass(new Position(i, j)));
						break;
					case 'O':
						tiles.add(new DoorOpen(new Position(i, j)));
						break;
					case 'o':
						tiles.add(new DoorClosed(new Position(i, j)));
						break;
					case 'w':
						tiles.add(new DoorWay(new Position(i, j)));
						break;
					case 'M':
						tiles.add(new GoodMeat(new Position(i, j)));
						break;
					case 'H':
						tiles.add(new Hammer(new Position(i, j)));
						break;
					case 'E':
						tiles.add(new Sword(new Position(i, j)));
						break;
					case 'T':
						tiles.add(new Trap(new Position(i, j)));
						break;
					case 't':
						tiles.add(new Thief(new Position(i, j)));
						break;
					case 'k':
						tiles.add(new Skeleton(new Position(i, j)));
						break;
					case 'F':
						tiles.add(new Fire(new Position(i, j)));
						break;
					case 'B':
						tiles.add(new Bat(new Position(i, j)));
						break;
					case 'e':
						tiles.add(new BadGuy(new Position(i, j)));
						break;
					case 'r':
						tiles.add(new Red(new Position(i, j)));
						break;
					case 'g':
						tiles.add(new Green(new Position(i, j)));
						break;
					case 'b':
						tiles.add(new Black(new Position(i, j)));
						break;
					case ' ':
						break;
				}
			}
		}

		tiles.add(name);
		gui.addObserver(name);
		gui.newImages(tiles);
		gui.newImages(getTiles());
		gui.go();
	}

	//  ----    Override dos outros objectos

	public void setTiles(List<ImageTile> tiles) {
		this.tiles = tiles;
	}

	public static List<ImageTile> getTiles() {
		return tiles;
	}

	public static void removeTiles(Position name) {
		for (int i =0 ; i < getTiles().size(); i++){
			if (name.equals(getTiles().get(i).getPosition())){
				System.out.println(getTiles().get(i).getName());
				//tiles.remove(i);
				}
			}
	}

	@Override
	public String getName() {
		return getName() ;
	}   // O nome aqui e o nome da imagem que ele vai buscar para o tile

	@Override
	public Position getPosition() {
		return position;
	}  // a posicao (x: horizontal , y:vertical) deve ser inserida com isto


	@Override
	public void update(Observable o, Object arg) {
	}
	//  ----  Getters e Setters


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPosition(Position position) {
		this.position = position;
	}



}
