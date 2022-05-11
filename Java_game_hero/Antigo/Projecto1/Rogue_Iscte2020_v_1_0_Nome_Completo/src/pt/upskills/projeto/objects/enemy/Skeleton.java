package pt.upskills.projeto.objects.enemy;

import pt.upskills.projeto.rogue.utils.Position;

public class Skeleton extends geral_enemy {

	public Skeleton(Position position) {
		super(position);
	}

	@Override
	public String getName() {
		return "Skeleton";
	}
}
