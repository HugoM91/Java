package pt.upskills.projeto.objects.items;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class BadGuy extends Items implements ImageTile {

	private Position position;


	public BadGuy( Position position) {
		super(position);
	}



	@Override
	public String getName() {
		return "BadGuy";
	}

	@Override
	public Position getPosition() {
		return position;
	}


}
