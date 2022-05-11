package pt.upskills.projeto.objects.set;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class Key extends geral {

	private Position position;

	public Key( Position position) {
		super(position);
		this.position = position;
	}


	@Override
	public String getName() {
		return "Key";
	}

	@Override
	public Position getPosition() {
		return position;
	}
}
