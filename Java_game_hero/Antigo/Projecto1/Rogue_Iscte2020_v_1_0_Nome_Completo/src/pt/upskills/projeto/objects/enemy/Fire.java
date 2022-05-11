package pt.upskills.projeto.objects.enemy;

import pt.upskills.projeto.rogue.utils.Position;

public class Fire extends geral_enemy {

	public Fire(Position position) {
		super(position);
	}

	@Override
	public String getName() {
		return "Fire";
	}
}

