package pt.upskills.projeto.objects.items;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class Sword extends Items implements ImageTile {


	Position position;

	public Sword( Position position) {
		super(position);
	}

	@Override
	public String getName() {
		return "Sword";
	}



	@Override
	public Position getPosition() {
		return position;
	}

}

