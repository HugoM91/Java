package pt.upskills.projeto.objects.Colours;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class Green implements ImageTile {


	Position position;

	public Green( Position position) {
		this.position = position;
	}

	@Override
	public String getName() {
		return "Green";
	}



	@Override
	public Position getPosition() {
		return position;
	}

}
