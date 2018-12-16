package vn7.studio.com.integrator.math.calculator.operation.unary;

public class AtanCalcOpeation extends UnaryCalcOperation {

    @Override
    protected Double solve(Double argument) {
        return Math.atan(argument);
    }

    @Override
    public String getRegex() {
        return "-?atan\\([^()]*\\)";
    }
}
