package vn7.studio.com.integrator.math.calc.operation.binary;

public class MultiplyCalcOperation extends BinaryCalcOperation {

    @Override
    protected Double solve(Double arg1, Double arg2) {
        return arg1 * arg2;
    }
}
