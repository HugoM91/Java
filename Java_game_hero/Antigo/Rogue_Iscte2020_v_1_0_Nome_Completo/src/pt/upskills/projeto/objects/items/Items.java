package pt.upskills.projeto.objects.items;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public class Items implements ImageTile {

		Position position;

	public Items( Position position) {
			this.position = position;
		}

		public String getName() {
			return "Items";
		}

		public Position getPosition() {
			return position;
		}
}
