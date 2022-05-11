package pt.upskills.projeto.objects.set;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class Trap extends geral {


	public Trap( Position position) {
		super(position);
	}


	@Override
	public String getName() {
		return "Trap";
	}


}
