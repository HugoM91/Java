package pt.upskills.projeto.objects.set;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.items.Items;
import pt.upskills.projeto.rogue.utils.Position;

public class Grass extends Items implements ImageTile {

	private Position position;


	public Grass( Position position) {
		super(position);
	}



	@Override
	public String getName() {
		return "Grass";
	}

	@Override
	public Position getPosition() {
		return position;
	}


}
