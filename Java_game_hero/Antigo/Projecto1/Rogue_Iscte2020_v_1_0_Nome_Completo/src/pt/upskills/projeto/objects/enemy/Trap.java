package pt.upskills.projeto.objects.enemy;

import pt.upskills.projeto.rogue.utils.Position;

public class Trap extends geral_enemy {

	public Trap(Position position) {
		super(position);
	}

	@Override
	public String getName() {
		return "Trap";
	}
}

