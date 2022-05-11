package pt.upskills.projeto.objects.set;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.Room;
import pt.upskills.projeto.rogue.utils.Position;

import java.awt.image.ImageConsumer;

public class Key implements ImageTile {


	Position position;

	public Key( Position position) {
		this.position = position;
	}

	@Override
	public String getName() {
		return "Key";
	}



	@Override
	public Position getPosition() {
		return position;
	}

}
