package pt.upskills.projeto.objects.set;

import pt.upskills.projeto.rogue.utils.Position;

public class DoorClosed extends geral_set {

	public DoorClosed(Position position) {
		super(position);
	}

	@Override
	public String getName() {
		return "DoorClosed";
	}
}
