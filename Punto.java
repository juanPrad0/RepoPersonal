public class Punto {
    int x = 1, y = 1;

    public Punto() {}

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(x = " + x + " , y = " + y + ")";
    }
}