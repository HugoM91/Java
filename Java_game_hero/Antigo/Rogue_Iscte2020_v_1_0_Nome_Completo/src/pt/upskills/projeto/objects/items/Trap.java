package pt.upskills.projeto.objects.items;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class Trap extends Items implements ImageTile {

	private Position position;


	public Trap( Position position) {
		super(position);
	}



	@Override
	public String getName() {
		return "Trap";
	}

	@Override
	public Position getPosition() {
		return position;
	}


}
