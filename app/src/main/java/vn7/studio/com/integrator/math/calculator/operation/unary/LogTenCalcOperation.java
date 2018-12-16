package vn7.studio.com.integrator.math.calculator.operation.unary;

public class LogTenCalcOperation  extends UnaryCalcOperation {

    @Override
    protected Double solve(Double argument) {
        return Math.log10(argument);
    }

    @Override
    public String getRegex() {
        return "-?lg\\([^()]*\\)";
    }
}