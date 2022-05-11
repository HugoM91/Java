package pt.upskills.projeto.game;

import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.rogue.utils.Direction;
import pt.upskills.projeto.rogue.utils.Position;
import pt.upskills.projeto.rogue.utils.Vector2D;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class funcoes {

	public static ArrayList<String> abrir_ficheiro(String ficheiro) {

		ArrayList<String> sala = new ArrayList<String>();


		try {
			Scanner fileScanner = new Scanner(new File(ficheiro));
			while (fileScanner.hasNextLine()) {
				String primeiraLinha = fileScanner.nextLine();
				sala.add(primeiraLinha);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return sala;
	}

	public static Boolean inputMovimento() {


		System.out.println("Input direction you want to go:");
		Scanner input = new Scanner(System.in);
		String mov = input.nextLine();

		switch (mov) {

			case " ":
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
