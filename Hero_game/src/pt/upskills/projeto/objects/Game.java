package pt.upskills.projeto.objects;

import pt.upskills.projeto.gui.ImageMatrixGUI;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.set.Room;
import pt.upskills.projeto.rogue.utils.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {


	Room currentRoom;
	double nr_sala = 0;

	public Game(double nr_sala) {
		this.nr_sala = nr_sala;
	}

	public Room sala(){
		Room o = new Room(getNr_sala());
		currentRoom = o;
		return o;
	}

	public double getNr_sala() {
		return nr_sala;
	}

	public void setNr_sala(double nr_sala2) {
		this.nr_sala = nr_sala2;
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}
}
