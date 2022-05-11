package pt.upskills.projeto.objects.set;

import javafx.geometry.Pos;
import pt.upskills.projeto.game.Engine;
import pt.upskills.projeto.gui.ImageMatrixGUI;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Colours.Black;
import pt.upskills.projeto.objects.Colours.Green;
import pt.upskills.projeto.objects.Colours.Red;
import pt.upskills.projeto.objects.Game;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.set.*;
import pt.upskills.projeto.rogue.utils.Position;
import pt.upskills.projeto.rogue.utils.Vector2D;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static pt.upskills.projeto.game.Funcoes.abrir_ficheiro;
import static pt.upskills.projeto.objects.Hero.fireball;

public class Room extends Game {

	ImageMatrixGUI gui = ImageMatrixGUI.getInstance();

	public static List<ImageTile> tiles = new ArrayList<>();
	List<ImageTile> tiles_status = new ArrayList<>();

	String filename;
	Hero hero;
	int score;
	public static HashMap<String, Integer> stats = new HashMap<String, Integer>();
	HashMap<Position, String > h_posicoes = new HashMap<Position, String>();
	HashMap<Position, String > h_posicoes2 = new HashMap<Position, String>();
	HashMap<String, Integer > hero_stats = new HashMap<String, Integer>();

	public Room(double nr_sala) {
		super(nr_sala);
	}

	//------------------------------------------------------------------------

	public static Door a1;
	public static Skeleton a12;
	public static Bat a13;
	public static BadGuy a14;
	public static Thief a11;

	public void clearAll(){
		tiles.clear();
		stats.clear();
		h_posicoes.clear();
		h_posicoes2.clear();
	}
	// criar a sala
	public List<ImageTile> create_room() {

		for (int i = 0; i < 10; i++) {
			System.out.println(abrir_ficheiro(getFilename()).get(i));
			for (int j = 0; j < 10; j++) {
				char x = abrir_ficheiro(getFilename()).get(j).charAt(i);

				switch (x) {
					case 'W':
						Wall a = new Wall(new Position(i, j));
						getTiles().add(a);
						break;
					case 'D':
						a1 = new Door(new Position(i, j));
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
						a11 = new Thief(new Position(i, j));
						getTiles().add(a11);
						break;
					case 'k':
						a12 = new Skeleton(new Position(i, j));
						getTiles().add(a12);
						//enemies.put("Skeleton", a12);
						break;
					case 'B':
						a13 = new Bat(new Position(i, j));
						getTiles().add(a13);
						break;
					case 'e':
						a14 =new BadGuy(new Position(i, j));
						getTiles().add(a14);
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


	// para o heroi
	public String isPositionfree(Position hero_position, Vector2D vector) {

		stats.put(" ", 0);
		hero_stats.put("Damage", 10);
		hero_stats.put("Health", 25);

		for (ImageTile x : tiles) {
			h_posicoes.put(x.getPosition(), x.getName());
		}

		if (h_posicoes.get((hero_position.plus2(vector))) == "Wall"){
			return "Cant move there Spidey!!!";
		}
		else if (h_posicoes.get((hero_position.plus2(vector))) == "DoorClosed"){
			return "You need a key!!!";
		}
		else if (h_posicoes.get((hero_position.plus2(vector))) == "DoorOpen"){
			return "Next Level";
		}
		else if (h_posicoes.get((hero_position.plus2(vector))) == "StairsUp") {
			System.out.println("ola");
			return "Up";
		}
		else if (h_posicoes.get((hero_position.plus2(vector))) == "StairsDown") {
			return "Down";
		}


		else if (h_posicoes.get((hero_position.plus2(vector))) == "Key"){
			for (int i = 0; i < getTiles().size(); i++){
				if (getTiles().get(i).getPosition().equals(hero_position.plus2(vector)) == true){
					score = score + 10;
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
		else if (h_posicoes.get((hero_position.plus2(vector))) == "Sword"){
			for (int i = 0; i < getTiles().size(); i++){
				if (getTiles().get(i).getPosition().equals(hero_position.plus2(vector)) == true){
					score = score + 5;
					System.out.println("Excalibur");
					stats.clear();
					stats.put("Damage", 3);
					hero_stats.put("Damage", hero_stats.get("Damage")+3 );
					tiles_status.add(new Sword(new Position(7,0)));
					gui.newStatusImages(tiles_status);
					tiles.get(i).getPosition().setY(-1);
					tiles.get(i).getPosition().setX(-1);
				}
			}
			return "true";
		}
		else if (h_posicoes.get((hero_position.plus2(vector))) == "Hammer"){
			for (int i = 0; i < getTiles().size(); i++){
				if (getTiles().get(i).getPosition().equals(hero_position.plus2(vector)) == true){
					score = score + 7;
					System.out.println("Thor would be proud");
					stats.clear();
					stats.put("Damage", 7);
					hero_stats.put("Damage", hero_stats.get("Damage")+3 );

					tiles_status.add(new Hammer(new Position(8,0)));
					gui.newStatusImages(tiles_status);
					tiles.get(i).getPosition().setY(-1);
					tiles.get(i).getPosition().setX(-1);
				}

			}
			return "true";
		}
		else if (h_posicoes.get((hero_position.plus2(vector))) == "GoodMeat"){
			for (int i = 0; i < getTiles().size(); i++){
				if (getTiles().get(i).getPosition().equals(hero_position.plus2(vector)) == true){
					System.out.println("Yummy Yummy !!!");
					score = score + 5;
					stats.clear();
					stats.put("Health", 7);
					tiles.get(i).getPosition().setY(-1);
					tiles.get(i).getPosition().setX(-1);
					hero_stats.put("Health", hero_stats.get("Health")+3 );

				}
				else{
					int h = 0;
				}
			}
			return "true";
		}
		else if (h_posicoes.get((hero_position.plus2(vector))) == "Fire"){
			for (int i = 0; i < getTiles().size(); i++){
				if (getTiles().get(i).getPosition().equals(hero_position.plus2(vector)) == true){
					score = score + 5;

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
						fireball.add(1);

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

		
		else if (h_posicoes.get((hero_position.plus2(vector))) == "Skeleton") {
			for (int i = 0; i < getTiles().size(); i++) {
				if (getTiles().get(i).getPosition().equals(hero_position.plus2(vector)) == true){
					a12.setHea(hero_stats.get("Damage"));

					if (a12.getHea() < 0){
						score = score + 4;
						a12.getPosition().setX(-2);
						a12.getPosition().setY(-2);

						System.out.println("Q: How did the skeleton know it was going to rain on Halloween?" );
						System.out.println("A: He could feel it in his bones!");
						return "true";
					}

					else {
						if (hero_stats.get("Health") < 25) {
							gui.addStatusImage(new Red(new Position(7,1)));
						}
						if (hero_stats.get("Health") < 20) {
							gui.addStatusImage(new Red(new Position(6,0)));
						}
						if (hero_stats.get("Health") < 15){
							gui.addStatusImage(new Red(new Position(5,0)));
						}
						if (hero_stats.get("Health") < 10){
							gui.addStatusImage(new Red(new Position(4,0)));
						}

						gui.update();

						stats.clear();
						stats.put("Health", -a12.getDam());
						hero_stats.put("Health", hero_stats.get("Health") - a12.getDam() );
						System.out.println("Lets go, almost there");

						return "Lets go, almost there";

					}
				}
			}

		}
		else if (h_posicoes.get((hero_position.plus2(vector))) == "Bat") {
			for (int i = 0; i < getTiles().size(); i++) {
				if (getTiles().get(i).getPosition().equals(hero_position.plus2(vector)) == true) {
					a13.setHea(hero_stats.get("Damage"));
					if (a13.getHea() < 0) {
						score = score + 4;
						a13.getPosition().setX(-2);
						a13.getPosition().setY(-2);

						System.out.println("Q: What’s the first thing bats learn at school?");
						System.out.println("A: The alpha-bat.");
						return "true";
					} else {
						stats.clear();
						stats.put("Health", -3);
						hero_stats.put("Health", hero_stats.get("Health") - a13.getDam());
						System.out.println("Lets go, almost there");

						return "Lets go, almost there";

					}

				}
			}
		}
		else if (h_posicoes.get((hero_position.plus2(vector))) == "Thief") {
			for (int i = 0; i < getTiles().size(); i++) {
				if (getTiles().get(i).getPosition().equals(hero_position.plus2(vector)) == true){

					a11.setHea(hero_stats.get("Damage"));
					if (a11.getHea() < 0){
						score = score + 7;
						a11.getPosition().setX(-8);
						a11.getPosition().setY(-8);

						System.out.println("Q: Whats the difference between an amateur thief and a professional thief?" );
						System.out.println("A: An amateur thief says, Give me all your money!");
						System.out.println("A professional thief says, Sign here please.");
						return "true";
					}

					else {
						stats.clear();
						stats.put("Health", -3);
						hero_stats.put("Health", hero_stats.get("Health") - - a11.getDam() );
						System.out.println("Lets go, almost there");

						return "Lets go, almost there";

					}

				}
			}

		}
		else if (h_posicoes.get((hero_position.plus2(vector))) == "BadGuy") {

			for (int i = 0; i < getTiles().size(); i++) {
				if (getTiles().get(i).getPosition().equals(hero_position.plus2(vector)) == true){


					a14.setHea(hero_stats.get("Damage"));
					if (a14.getHea() < 0){
						score = score + 10;

						a14.getPosition().setX(-8);
						a14.getPosition().setY(-8);

						System.out.println("Big Boss is dead" );
						System.out.println("Congrats!!!");
						return "true";
					}

					else {
						stats.clear();
						stats.put("Health", -3);
						hero_stats.put("Health", hero_stats.get("Health") - a14.getDam()  );
						System.out.println("Lets go, almost there");

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

	// para os inimigos
	public int isPositionfree2(Position hero_import, Position hero_position, Vector2D vector) {

		h_posicoes2.put(hero_import, "Hero");

		for (ImageTile x : tiles) {
			h_posicoes2.put(x.getPosition(), x.getName());
		}

		if (h_posicoes2.get((hero_position.plus2(vector))) == "Wall"){
			return 0;
		}
		else if (h_posicoes2.get((hero_position.plus2(vector))) == "Key"){
			return 0;
		}
		else if (h_posicoes2.get((hero_position.plus2(vector))) == "Hero"){
			return 0;
		}
		else if (h_posicoes2.get((hero_position.plus2(vector))) == "Sword"){
			return 0;
		}
		else if (h_posicoes2.get((hero_position.plus2(vector))) == "Hammer"){
			return 0;
		}
		else if (h_posicoes2.get((hero_position.plus2(vector))) == "GoodMeat"){
			return 0;
		}
		else if (h_posicoes2.get((hero_position.plus2(vector))) == "Fire"){
			return 0;
		}
		else if (h_posicoes2.get((hero_position.plus2(vector))) == "Skeleton") {
			return 0;
		}


		else {
			return 1;
		}
	}

	// mexe os inimigos
	public void enemyMovement(Position hero_import){
		Random rand = new Random();
		for (int i = 0; i < getTiles().size(); i++) {

			if (getTiles().get(i).getName() == "Skeleton") {
					int rand1 = rand.nextInt(4 - 1) + 1;
					if (rand1 == 0) {
						if (isPositionfree2(hero_import,getTiles().get(i).getPosition(), new Vector2D(0, 0)) != 0) {
							 getTiles().get(i).getPosition().plus(new Vector2D(0, 0));
						}
					}
					if (rand1 == 1) {
						if (isPositionfree2(hero_import,getTiles().get(i).getPosition(), new Vector2D(0, -1)) != 0) {
							getTiles().get(i).getPosition().plus(new Vector2D(0, -1));
						}
					}
					if (rand1 == 2) {
						if (isPositionfree2(hero_import,getTiles().get(i).getPosition(), new Vector2D(0, 1)) != 0) {
							getTiles().get(i).getPosition().plus(new Vector2D(0, 1));
						}
					}
				}
			if (getTiles().get(i).getName() == "Bat") {
					int rand1 = rand.nextInt(4 - 1) + 1;

					if (rand1 == 0) {
						if (isPositionfree2(hero_import,getTiles().get(i).getPosition(), new Vector2D(0, 0)) != 0) {
							getTiles().get(i).getPosition().plus(new Vector2D(0, 0));
						}
					}
					if (rand1 == 1) {
						if (isPositionfree2(hero_import,getTiles().get(i).getPosition(), new Vector2D(-1, 0)) != 0) {
							getTiles().get(i).getPosition().plus(new Vector2D(-1, 0));
						}
					}
					if (rand1 == 2) {
						if (isPositionfree2(hero_import,getTiles().get(i).getPosition(), new Vector2D(1, 0)) != 0) {
							getTiles().get(i).getPosition().plus(new Vector2D(1, 0));
						}
					}
				}
			if (getTiles().get(i).getName() == "Thief") {
					int rand1 = rand.nextInt(5) + 1;
					if (rand1 == 0) {
						if (isPositionfree2(hero_import, getTiles().get(i).getPosition(), new Vector2D(0, 0)) != 0) {
							getTiles().get(i).getPosition().plus(new Vector2D(0, 0));
						}
					}
					if (rand1 == 1) {
						if (isPositionfree2(hero_import,getTiles().get(i).getPosition(), new Vector2D(-1, -1)) != 0) {
							getTiles().get(i).getPosition().plus(new Vector2D(-1, -1));
						}
					}
					if (rand1 == 2) {
						if (isPositionfree2(hero_import,getTiles().get(i).getPosition(), new Vector2D(1, -1)) != 0) {
							getTiles().get(i).getPosition().plus(new Vector2D(1, -1));
						}
					}
					if (rand1 == 3) {
						if (isPositionfree2(hero_import,getTiles().get(i).getPosition(), new Vector2D(1, 1)) != 0) {
							getTiles().get(i).getPosition().plus(new Vector2D(1, 1));
						}
					}
					if (rand1 == 4) {
						if (isPositionfree2(hero_import,getTiles().get(i).getPosition(), new Vector2D(-1, 1)) != 0) {
							getTiles().get(i).getPosition().plus(new Vector2D(-1, 1));
						}
					}
				}
			if (getTiles().get(i).getName() == "BadGuy") {
					int rand1 = rand.nextInt(7) + 1;
					if (rand1 == 0) {
						if (isPositionfree2(hero_import,getTiles().get(i).getPosition(), new Vector2D(0, 0)) != 0) {
							getTiles().get(i).getPosition().plus(new Vector2D(0, 0));
						}
					}
					if (rand1 == 5) {
						if (isPositionfree2(hero_import,getTiles().get(i).getPosition(), new Vector2D(0, -1)) != 0) {
							getTiles().get(i).getPosition().plus(new Vector2D(0, -1));
						}
					}
					if (rand1 == 6) {
						if (isPositionfree2(hero_import,getTiles().get(i).getPosition(), new Vector2D(0, 1)) != 0) {
							getTiles().get(i).getPosition().plus(new Vector2D(0, 1));
						}
					}

					if (rand1 == 1) {
						if (isPositionfree2(hero_import,getTiles().get(i).getPosition(), new Vector2D(-1, -1)) != 0) {
							getTiles().get(i).getPosition().plus(new Vector2D(-1, -1));
						}
					}
					if (rand1 == 2) {
						if (isPositionfree2(hero_import,getTiles().get(i).getPosition(), new Vector2D(1, -1)) != 0) {
							getTiles().get(i).getPosition().plus(new Vector2D(1, -1));
						}
					}
					if (rand1 == 3) {
						if (isPositionfree2(hero_import,getTiles().get(i).getPosition(), new Vector2D(1, 0)) != 0) {
							getTiles().get(i).getPosition().plus(new Vector2D(1, 0));
						}
					}
					if (rand1 == 4) {
						if (isPositionfree2(hero_import,getTiles().get(i).getPosition(), new Vector2D(-1, 0)) != 0) {
							getTiles().get(i).getPosition().plus(new Vector2D(-1, 0));
						}
					}
				}

			gui.update();

		}
	}


	//--------------------------------------------------------------------------
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
		return "./rooms/room" + super.getNr_sala() + ".txt";
	}

	public void setFilename(Integer filename) {
		this.filename =  String.valueOf(filename+1);
	}

	@Override
	public Room sala() {
		return super.sala();
	}

	public int getScore() {
		return score;
	}
}
