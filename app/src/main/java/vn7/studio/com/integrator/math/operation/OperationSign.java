package vn7.studio.com.integrator.math.operation;

public enum OperationSign {
    POSITIVE(1), NEGATIVE(-1);

    OperationSign(int m){
        multiplier = m;
    }

    int multiplier;

    public int getMultiplier() {
        return multiplier;
    }
}
