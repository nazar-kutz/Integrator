package vn7.studio.com.integrator.math.calc.operation.unary;

public class CosCalcOperation extends UnaryCalcOperation {

    @Override
    protected Double solve(Double arg) {
        return Math.cos(arg);
    }
}