package pt.upskills.projeto.objects.items;

import pt.upskills.projeto.rogue.utils.Position;

public class Hammer extends geral_item {

	public Hammer(Position position) {
		super(position);
	}

	@Override
	public String getName() {
		return "Hammer";
	}
}
