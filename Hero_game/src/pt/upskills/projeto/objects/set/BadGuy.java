package pt.upskills.projeto.objects.set;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class BadGuy extends geral  {


	int dam = 8;
	int hea = 40;

	public BadGuy( Position position) {
		super(position);
		this.hea = hea;
		this.dam = dam;
	}

	@Override
	public String getName() {
		return "BadGuy";
	}

	@Override
	public int getDamage() {
		return super.getDamage() + dam;
	}

	@Override
	public void setHealth(int dam) {
		setHea(getHea() - dam);
	}

	public int getDam() {
		return dam;
	}

	public int getHea() {
		return hea + super.health;
	}

	public void setHea(int hea) {
		this.hea = getHea() - hea;
	}
}