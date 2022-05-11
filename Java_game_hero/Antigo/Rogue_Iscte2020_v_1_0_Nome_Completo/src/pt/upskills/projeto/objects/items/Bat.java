package pt.upskills.projeto.objects.items;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class Bat extends Items implements ImageTile {

	private Position position;


	public Bat( Position position) {
		super(position);
	}



	@Override
	public String getName() {
		return "Bat";
	}

	@Override
	public Position getPosition() {
		return position;
	}


}
