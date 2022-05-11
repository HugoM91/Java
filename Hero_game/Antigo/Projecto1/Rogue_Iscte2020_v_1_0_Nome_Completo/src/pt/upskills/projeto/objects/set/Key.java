package pt.upskills.projeto.objects.set;

import pt.upskills.projeto.rogue.utils.Position;

public class Key extends geral_set {

	public Key(Position position) {
		super(position);
	}

	@Override
	public String getName() {
		return "Key";
	}
}