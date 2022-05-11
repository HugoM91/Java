package pt.upskills.projeto.objects.enemy;

import pt.upskills.projeto.rogue.utils.Position;

public class Bat extends geral_enemy {

	public Bat(Position position) {
		super(position);
	}

	@Override
	public String getName() {
		return "Bat";
	}
}
