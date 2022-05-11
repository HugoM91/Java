package pt.upskills.projeto.rogue.utils;

/**
 * @author POO2016
 * 
 * Cardinal directions
 *
 */
public enum Direction {
	LEFT, UP, RIGHT, DOWN;

	public Vector2D asVector() {
		if (this == Direction.UP) {
			Vector2D dir = new Vector2D(-1,0);
			return dir;
		}
		if (this == Direction.DOWN) {
			Vector2D dir = new Vector2D(1,0);
			return dir;
		}
		if (this == Direction.LEFT) {
			Vector2D dir = new Vector2D(0,-1);
			return dir;
		}
		if (this == Direction.RIGHT) {
			Vector2D dir = new Vector2D(0 ,1);
			return dir;
		}

		return null;
	}
}



















