package vn7.studio.com.integrator.math.calc.operation.binary;

public class PowerCalcOpearation extends BinaryCalcOperation {
    @Override
    protected Double solve(Double arg1, Double arg2) {
        return Math.pow(arg1, arg2);
    }
}
