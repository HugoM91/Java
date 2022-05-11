package pt.upskills.projeto.objects.Colours;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class Black implements ImageTile {


	Position position;

	public Black( Position position) {
		this.position = position;
	}

	@Override
	public String getName() {
		return "Black";
	}



	@Override
	public Position getPosition() {
		return position;
	}

}

