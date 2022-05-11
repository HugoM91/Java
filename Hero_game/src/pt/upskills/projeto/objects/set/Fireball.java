package pt.upskills.projeto.objects.set;

import pt.upskills.projeto.game.FireBallThread;
import pt.upskills.projeto.gui.FireTile;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class Fireball extends geral implements ImageTile {


	public Fireball( Position position) {
		super(position);
	}


	@Override
	public String getName() {
		return "Fire";
	}


}
