package pt.upskills.projeto.objects.items;

import pt.upskills.projeto.rogue.utils.Position;

public class Sword extends geral_item {

	private static int health = 0;
	private static int damage = 3;
	char symbol = 'E';


	private Position position;

	public Sword(Position position) {
		super(position);
		this.damage = damage;
		this.health = health;
		this.symbol = symbol;
	}

	public int getDamage() {
		return damage;
	}

	public String getName() {
		return "Sword";
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}
