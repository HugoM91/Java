package pt.upskills.projeto.objects.items;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class Fireball implements ImageTile {


	Position position;

	public Fireball( Position position) {
		this.position = position;
	}

	@Override
	public String getName() {
		return "Fire";
	}



	@Override
	public Position getPosition() {
		return position;
	}

}
