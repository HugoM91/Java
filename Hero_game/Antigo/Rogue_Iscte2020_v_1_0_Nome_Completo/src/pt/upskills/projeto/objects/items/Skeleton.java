package pt.upskills.projeto.objects.items;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class Skeleton extends Items implements ImageTile {

	private Position position;
	public static int health;
	public static int damage;


	public Skeleton( Position position) {
		super(position);
		this.health = health;
		this.damage = damage;
	}



	@Override
	public String getName() {
		return "Skeleton";
	}

	@Override
	public Position getPosition() {
		return position;
	}

	public static int getHealth() {
		setHealth(15);
		return health;
	}

	public static void setHealth(int health) {
		Skeleton.health = health;
	}

	public static int getDamage() {
		return damage;
	}
}
