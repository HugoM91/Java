package pt.upskills.projeto.objects.items;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class GoodMeat extends Items implements ImageTile {


	Position position;

	public GoodMeat( Position position) {
		super(position);
	}

	@Override
	public String getName() {
		return "GoodMeat";
	}



	@Override
	public Position getPosition() {
		return position;
	}

}

