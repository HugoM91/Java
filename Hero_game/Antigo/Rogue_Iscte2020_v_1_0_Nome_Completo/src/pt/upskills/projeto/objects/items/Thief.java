package pt.upskills.projeto.objects.items;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class Thief extends Items implements ImageTile {

	private Position position;


	public Thief( Position position) {
		super(position);
	}



	@Override
	public String getName() {
		return "Thief";
	}

	@Override
	public Position getPosition() {
		return position;
	}


}
