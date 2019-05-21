package vn7.studio.com.integrator.math.calculator.cord;

public class CordExtreme2D {
    private Cord2D min, max;

    public CordExtreme2D(Cord2D min, Cord2D max) {
        this.min = min;
        this.max = max;
    }

    public Cord2D getMin() {
        return min;
    }

    public void setMin(Cord2D min) {
        this.min = min;
    }

    public Cord2D getMax() {
        return max;
    }

    public String getMinAsString() {
        return Cord2D.getAsString(min);
    }

    public String getMaxAsString(){
        return Cord2D.getAsString(max);
    }

    public void setMax(Cord2D max) {
        this.max = max;
    }
}
