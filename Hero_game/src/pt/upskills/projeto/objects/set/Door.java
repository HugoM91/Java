package pt.upskills.projeto.objects.set;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.rogue.utils.Position;

public class Door  implements ImageTile {

	private Position position;
	Boolean key = false;

	public Door(Position position) {
		this.position = position;
		this.key = key;
	}

	@Override
	public String getName() {
		if (Hero.key == 1) {
			return "DoorOpen";
		}
		else {
			return "DoorClosed";
		}
	}

	@Override
	public Position getPosition() {
		return position;
	}

}
