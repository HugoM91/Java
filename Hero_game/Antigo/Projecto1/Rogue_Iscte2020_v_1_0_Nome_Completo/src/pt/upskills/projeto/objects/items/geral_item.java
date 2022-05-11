package pt.upskills.projeto.objects.items;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.Room;
import pt.upskills.projeto.rogue.utils.Position;


abstract class geral_item extends Hero implements ImageTile {


	private static final Room sala = null;
	private static final String nome = null;

	public geral_item(Position position) {
		super(position, nome);
	}

}
