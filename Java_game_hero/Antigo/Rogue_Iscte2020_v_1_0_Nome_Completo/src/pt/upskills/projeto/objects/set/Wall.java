package pt.upskills.projeto.objects.set;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.Room;
import pt.upskills.projeto.rogue.utils.Position;

public class Wall implements ImageTile {

	private Position position;


	public Wall( Position position) {
		this.position = position;
	}


	@Override
	public String getName() {
		return "Wall";
	}

	@Override
	public Position getPosition() {
		return position;
	}


}
