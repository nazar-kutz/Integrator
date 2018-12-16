package vn7.studio.com.integrator.math.calculator.operation.unary;

public class AsinCalcOpearion extends UnaryCalcOperation {

    @Override
    protected Double solve(Double argument) {
        return Math.asin(argument);
    }

    @Override
    public String getRegex() {
        return "-?asin\\([^()]*\\)";
    }
}
