package vn7.studio.com.integrator.math.calculator.cord;

public class Cord2D extends Cord {
    private Double x, y;

    public Cord2D(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Cord2D(" +
                "x = " + x +
                "; y = " + y +
                ')';
    }

    public static String getAsString(Cord2D cord2D) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(cord2D.getX());
        sb.append(";");
        sb.append(cord2D.getY());
        sb.append(")");
        return sb.toString();
    }
}
