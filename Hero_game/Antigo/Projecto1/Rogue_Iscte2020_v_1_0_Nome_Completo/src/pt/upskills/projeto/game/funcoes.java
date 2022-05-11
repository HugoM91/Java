package pt.upskills.projeto.game;

import pt.upskills.projeto.objects.Colours.Black;
import pt.upskills.projeto.objects.Colours.Green;
import pt.upskills.projeto.objects.Colours.Red;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.Room;
import pt.upskills.projeto.objects.enemy.*;
import pt.upskills.projeto.objects.items.GoodMeat;
import pt.upskills.projeto.objects.items.Hammer;
import pt.upskills.projeto.objects.items.Sword;
import pt.upskills.projeto.objects.set.*;
import pt.upskills.projeto.rogue.utils.Direction;
import pt.upskills.projeto.rogue.utils.Position;
import pt.upskills.projeto.rogue.utils.Vector2D;

import javax.swing.text.StyledEditorKit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class funcoes {


	public static ArrayList<String> abrir_ficheiro(String ficheiro) {
		int i = 0;
		ArrayList<String> sala = new ArrayList<String>();
		ArrayList<Character> sala_vertical = new ArrayList<>();
		ArrayList<Character> sala_horizontal = new ArrayList<>();


		try {
			Scanner fileScanner = new Scanner(new File(ficheiro));
			while (i < 10) {
				String primeiraLinha = fileScanner.nextLine();
				// System.out.println(primeiraLinha);  ==============  Imprime o mapa
				sala.add(primeiraLinha);
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		char[] chars = sala.toString().toCharArray();

		for (int i3 = 0; i3 < sala.size(); i3++) {
			int i4 = 0;
			sala_vertical.add(sala.get(i3).charAt(0));
			while (i4 < 9) {
				sala_horizontal.add(sala.get(i3).charAt(i4 + 1));
				i4++;
			}
			sala_horizontal.add('/');
		}
/*
		for (int k = 0; k < sala.size(); k++) {
			System.out.println(sala.get(k));
		}


		System.out.println("=============");
		System.out.println(sala_horizontal);
		System.out.println("----------");
		System.out.println(sala_vertical);
*/
		return sala;
	}

	public static Boolean inputMovimento(Hero name, String ficheiro) {


		System.out.println("Input direction you want to go : Up(U) Down(D) Left(L) Right(R)");
		Scanner input = new Scanner(System.in);
		String mov = input.nextLine();

		switch (mov) {
			case "U": case"u": case"8":
				Vector2D v = Direction.UP.asVector();
				char a1 = abrir_ficheiro(ficheiro).get(name.getPosition().getY() - 1).charAt(name.getPosition().getX());
				name.setPosition(new Position( name.getPosition().getX()  ,name.getPosition().getY()- 1), a1);
				break;

			case "D": case "d":case"2":
				Vector2D v2 = Direction.DOWN.asVector();
				char a2 = abrir_ficheiro(ficheiro).get(name.getPosition().getY() + 1).charAt(name.getPosition().getX());
				name.setPosition(new Position( name.getPosition().getX()  ,name.getPosition().getY()+ 1) , a2);
				break;

			case "L": case "l":case"4":
				Vector2D v3 =Direction.LEFT.asVector();
				char a3 = abrir_ficheiro(ficheiro).get(name.getPosition().getY()).charAt(name.getPosition().getX() -1 );
				name.setPosition(new Position( name.getPosition().getX() -1,name.getPosition().getY()), a3);
				break;

			case "R": case "r":case"6":
				Vector2D v4 =Direction.RIGHT.asVector();
				char a4 = abrir_ficheiro(ficheiro).get(name.getPosition().getY()).charAt(name.getPosition().getX() +1 );
				name.setPosition(new Position( name.getPosition().getX()+1 ,name.getPosition().getY()), a4);
				break;

			case " ":
				//Atacar
				break;
			case "exit":
				System.out.println("Thank you for playing \uD83D\uDC8B\uD83D\uDC8B\uD83D\uDC8B  ");
				System.exit(0);
			case "Next Level":
				System.out.println("Are you cheating ???");
				break;
			case "Previous Level":
				System.out.println("You liked it that much ???");
				break;
			default:
				System.out.println("Invalid Move !!!");
		}

		return true;
	}


}

