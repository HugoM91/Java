package pt.upskills.projeto.objects.items;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class Hammer extends Items implements ImageTile {


	Position position;

	public Hammer( Position position) {
		super(position);
	}

	@Override
	public String getName() {
		return "Hammer";
	}



	@Override
	public Position getPosition() {
		return position;
	}

}

