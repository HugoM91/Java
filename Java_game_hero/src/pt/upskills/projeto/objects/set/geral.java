package pt.upskills.projeto.objects.set;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public abstract class geral implements ImageTile {

	Position position;

	int health;
	int damage;

	public geral(Position position) {
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = getHealth() - health ;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = getDamage() + damage;
	}
}
