package pt.upskills.projeto.rogue.utils;


public class Position {

    private int x;
    private int y;


    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Position other = (Position) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    public Position plus(Vector2D vector2d) {
        setX(getX() + vector2d.getX());
        setY(getY() + vector2d.getY());
        return null;
    }
    public Position plus2(Vector2D vector2d) {
        int a = getX() + vector2d.getX();
        int b = getY() + vector2d.getY();
        return new Position(a,b);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
