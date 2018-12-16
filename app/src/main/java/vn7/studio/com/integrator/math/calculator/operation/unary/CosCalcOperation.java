package vn7.studio.com.integrator.math.calculator.operation.unary;

public class CosCalcOperation extends UnaryCalcOperation {

    @Override
    protected Double solve(Double argument) {
        return Math.cos(argument);
    }

    @Override
    public String getRegex() {
        return "-?cos\\([^()]*\\)";
    }
}