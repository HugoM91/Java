package pt.upskills.projeto.objects.enemy;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class geral_enemy implements ImageTile {

	private Position position;

	public geral_enemy(Position position) {
		this.position = position;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public Position getPosition() {
		return position;
	}

}
