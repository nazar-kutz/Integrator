package vn7.studio.com.integrator.math.calc.operation.unary;

public class ExpCalcOperation extends UnaryCalcOperation {
    @Override
    protected Double solve(Double arg) {
        return Math.exp(arg);
    }
}
