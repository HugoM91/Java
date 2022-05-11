package pt.upskills.projeto.objects.enemy;

import pt.upskills.projeto.rogue.utils.Position;

public class Thief extends geral_enemy {

	public Thief(Position position) {
		super(position);
	}

	@Override
	public String getName() {
		return "Thief";
	}

}


