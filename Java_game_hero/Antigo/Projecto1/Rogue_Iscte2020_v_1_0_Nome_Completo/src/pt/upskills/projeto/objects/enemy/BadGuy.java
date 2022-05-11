package pt.upskills.projeto.objects.enemy;

import pt.upskills.projeto.rogue.utils.Position;

public class BadGuy extends geral_enemy {

	public BadGuy(Position position) {
		super(position);
	}

	@Override
	public String getName() {
		return "BadGuy";
	}
}

