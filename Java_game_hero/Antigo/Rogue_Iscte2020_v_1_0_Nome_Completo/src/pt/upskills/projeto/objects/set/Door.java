package pt.upskills.projeto.objects.set;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.Room;
import pt.upskills.projeto.rogue.utils.Position;

public class Door implements ImageTile {

	private Position position;
	Boolean key = false;

	public Door(Position position, Boolean key ) {
		this.key = key;
		this.position = position;

	}

	@Override
	public String getName() {
		if (getKey() == true) {
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

	public Boolean getKey() {
		return key;
	}

	public void setKey(Boolean key) {
		this.key = key;
	}
}
