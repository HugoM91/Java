package pt.upskills.projeto.objects.set;

import pt.upskills.projeto.rogue.utils.Position;

public class DoorOpen extends geral_set {

	public DoorOpen(Position position) {
		super(position);
	}

	@Override
	public String getName() {
		return "DoorOpen";
	}
}
