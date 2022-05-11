package pt.upskills.projeto.game;

import pt.upskills.projeto.objects.Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Funcoes {


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





}
