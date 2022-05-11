package pt.upskills.projeto.objects.set;

import pt.upskills.projeto.rogue.utils.Position;

public class Wall extends geral_set {

	public Wall(Position position) {
		super(position);
	}

	@Override
	public String getName() {
		return "Wall";
	}


}
