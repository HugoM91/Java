package pt.upskills.projeto.objects;

import pt.upskills.projeto.gui.ImageMatrixGUI;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Colours.Black;
import pt.upskills.projeto.objects.Colours.Green;
import pt.upskills.projeto.objects.Colours.Red;
import pt.upskills.projeto.objects.items.*;
import pt.upskills.projeto.objects.set.*;
import pt.upskills.projeto.rogue.utils.Position;
import pt.upskills.projeto.rogue.utils.Vector2D;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static pt.upskills.projeto.game.funcoes.abrir_ficheiro;
import static pt.upskills.projeto.objects.Hero.fireball;


public class Room {
	ImageMatrixGUI gui = ImageMatrixGUI.getInstance();

	//  ---- Construtor

	private static List<ImageTile> tiles = new ArrayList<>();
	List<ImageTile> tiles_status = new ArrayList<>();

	String filename;
	Hero hero;
	HashMap<Position, String> hashMap_posicoes = new HashMap<Position, String>();
	public static HashMap<String, Integer> stats = new HashMap<String, Integer>();

	HashMap<String, Items> enemies = new HashMap<String, Items>();


	private static int l;


	public Room(String filename) {
		this.filename = filename;
	}

	//  ----

	public String isPositionfree(Position hero_position, Vector2D vector) {

		stats.put(" ", 0);

		for (ImageTile x : tiles) {
			hashMap_posicoes.put(x.getPosition(), x.getName());
		}

		if (hashMap_posicoes.get((hero_position.plus2(vector))) == "Wall"){
			return "Cant move there Spidey!!!";
		}
		else if (hashMap_posicoes.get((hero_position.plus2(vector))) == "Key"){
			for (int i = 0; i < getTiles().size(); i++){
				if (getTiles().get(i).getPosition().equals(hero_position.plus2(vector)) == true){
					System.out.println("You got a key");
					stats.clear();
					stats.put("Key", 1);
					tiles_status.add(new Key(new Position(9,0)));
					gui.newStatusImages(tiles_status);
					tiles.get(i).getPosition().setY(-1);
					tiles.get(i).getPosition().setX(-1);
				}
				else{
					int h = 0;
				}
			}
			return "true";
		}
		else if (hashMap_posicoes.get((hero_position.plus2(vector))) == "Sword"){
			for (int i = 0; i < getTiles().size(); i++){
				if (getTiles().get(i).getPosition().equals(hero_position.plus2(vector)) == true){
					System.out.println("Excalibur");
					stats.clear();
					stats.put("Damage", 3);
					tiles_status.add(new Sword(new Position(7,0)));
					gui.newStatusImages(tiles_status);
					tiles.get(i).getPosition().setY(-1);
					tiles.get(i).getPosition().setX(-1);
				}
			}
			return "true";
		}
		else if (hashMap_posicoes.get((hero_position.plus2(vector))) == "Hammer"){
			for (int i = 0; i < getTiles().size(); i++){
				if (getTiles().get(i).getPosition().equals(hero_position.plus2(vector)) == true){
					System.out.println("Thor would be proud");
					stats.clear();
					stats.put("Damage", 7);
					tiles_status.add(new Hammer(new Position(8,0)));
					gui.newStatusImages(tiles_status);
					tiles.get(i).getPosition().setY(-1);
					tiles.get(i).getPosition().setX(-1);
				}

			}
			return "true";
		}
		else if (hashMap_posicoes.get((hero_position.plus2(vector))) == "GoodMeat"){
			for (int i = 0; i < getTiles().size(); i++){
				if (getTiles().get(i).getPosition().equals(hero_position.plus2(vector)) == true){
					System.out.println("Yummy Yummy !!!");
					stats.clear();
					stats.put("Health", 3);
					tiles.get(i).getPosition().setY(-1);
					tiles.get(i).getPosition().setX(-1);
				}
				else{
					int h = 0;
				}
			}
			return "true";
		}
		else if (hashMap_posicoes.get((hero_position.plus2(vector))) == "Fire"){
			for (int i = 0; i < getTiles().size(); i++){
				if (getTiles().get(i).getPosition().equals(hero_position.plus2(vector)) == true){
					if (fireball.size() == 0) {
						fireball.add(1);
						System.out.println("Please be carefull!!! Dont get burned");
						tiles_status.add(new Fireball(new Position(0, 0)));
						gui.newStatusImages(tiles_status);
					}
					else if (fireball.size() == 1) {
						fireball.add(1);
						System.out.println("Please be carefull!!! Dont get burned");
						tiles_status.add(new Fireball(new Position(1, 0)));
						gui.newStatusImages(tiles_status);
					}
					else if (fireball.size() == 2) {
						System.out.println("Please be carefull!!! Dont get burned");
						tiles_status.add(new Fireball(new Position(2, 0)));
						gui.newStatusImages(tiles_status);
					}
					else {
						System.out.println("I dont think you can fit more fireball with you. Maybe somewhere where the sun doesnt shine???");
					}
					tiles.get(i).getPosition().setY(-1);
					tiles.get(i).getPosition().setX(-1);

				}
				else{
					int h = 0;
				}
			}
			return "true";
		}
		else if (hashMap_posicoes.get((hero_position.plus2(vector))) == "Skeleton") {
			for (int i = 0; i < getTiles().size(); i++) {
				if (getTiles().get(i).getPosition().equals(hero_position.plus2(vector)) == true){
					System.out.println("Q: How did the skeleton know it was going to rain on Halloween?" );
					System.out.println("A: He could feel it in his bones!");
					stats.clear();
					stats.put("Health", -3);

					if (10 > 0){
						tiles.get(i).getPosition().setY(-1);
						tiles.get(i).getPosition().setX(-1);
						return "true";

					}
					else {
						//Skeleton.setHealth(getHero().getDamage());
						return "Lets go, almost there";

					}

				}
			}

		}
		else {
			stats.clear();
			return "true";
		}
		return "true";
	}

	public List<ImageTile> create_room() {

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				char x = abrir_ficheiro(getFilename()).get(j).charAt(i);
				switch (x) {
					case 'W':
						Wall a = new Wall(new Position(i, j));
						getTiles().add(a);
						break;
					case 'D':
						Door a1 = new Door(new Position(i, j), false);
						getTiles().add(a1);
						break;
					case 'K':
						Key a2 = new Key(new Position(i, j));
						getTiles().add(a2);
						break;
					case 'M':
						GoodMeat a3 = new GoodMeat(new Position(i, j));
						getTiles().add(a3);
						//enemies.put("GoodMeat", a3);
						break;
					case 'H':
						Hammer a4 = new Hammer(new Position(i, j));
						getTiles().add(a4);
						//enemies.put("Hammer", a4);
						break;
					case 'E':
						Sword a5 = new Sword(new Position(i, j));
						getTiles().add(a5);
						//enemies.put("Sword", a5);
						break;
					case 'F':
						Fireball a6 = new Fireball(new Position(i,j));
						getTiles().add(a6);
						//enemies.put("Fireball", a6);
						break;
					case 'S':
						StairsUp a7 = new StairsUp(new Position(i, j));
						getTiles().add(a7);
						break;
					case 's':
						StairsDown a8 = new StairsDown(new Position(i, j));
						getTiles().add(a8);
						break;
					case 'G':
						Grass a9 = new Grass(new Position(i, j));
						getTiles().add(a9);
						//enemies.put("Grass", a9);
						break;
					case 'T':
						getTiles().add(new Trap(new Position(i, j)));
						break;
					case 't':
						getTiles().add(new Thief(new Position(i, j)));
						break;
					case 'k':
						Skeleton a12 = new Skeleton(new Position(i, j));
						getTiles().add(a12);
						//enemies.put("Skeleton", a12);
						break;
					case 'B':
						getTiles().add(new Bat(new Position(i, j)));
						break;
					case 'e':
						getTiles().add(new BadGuy(new Position(i, j)));
						break;
					case 'r':
						getTiles().add(new Red(new Position(i, j)));
						break;
					case 'g':
						getTiles().add(new Green(new Position(i, j)));
						break;
					case 'b':
						getTiles().add(new Black(new Position(i, j)));
						break;
					case ' ':
						break;
				}
			}
		}
		return getTiles();

	}


	public void deleteStatusimage(String item, Position position){
		System.out.println("posicao a apagar " + position);

		if (fireball.size() >= 0) {
			for (int i = 0; i < tiles_status.size(); i++) {
				System.out.println(tiles_status.get(i).getPosition());
				if (tiles_status.get(i).getName() == item){
					if (tiles_status.get(i).getPosition().equals(position)) {
						gui.removeStatusImage(tiles_status.get(i));
						gui.update();
					}
				}
			}
		}
	}

	//  ----
	public String getName() {
		return filename;
	}

	public static List<ImageTile> getTiles() {
		return tiles;
	}

	public Hero getHero() {
		return hero;
	}

	public String getFilename() {
		return "C:/Users/hugom/Desktop/Upskill/Rogue_Iscte2020_v_1_0_Nome_Completo/rooms/" + filename;
	}

	public static void setTiles(List<ImageTile> tiles) {
		Room.tiles = tiles;
	}




}
