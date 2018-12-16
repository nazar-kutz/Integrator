package vn7.studio.com.integrator.math.calculator.operation.unary;

public class AcosCalcOperation extends UnaryCalcOperation {

    @Override
    protected Double solve(Double argument) {
        return Math.acos(argument);
    }

    @Override
    public String getRegex() {
        return null;
    }
}
