package pt.upskills.projeto.objects.items;

import pt.upskills.projeto.rogue.utils.Position;

public class GoodMeat extends geral_item {


	private static int health = 3;
	private static int damage = 3;
	private Position position;


	public GoodMeat(Position position) {
		super(position);
		this.damage = damage;
		this.health = health;
	}

	public int getDamage() {
		return damage;
	}

	public  int getHealth() {
		return health;
	}

	@Override
	public String getName() {
		return "GoodMeat";
	}

}