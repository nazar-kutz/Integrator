package vn7.studio.com.integrator.math.calc.operation.unary;

public class LogTenCalcOperation  extends UnaryCalcOperation {

    @Override
    protected Double solve(Double arg) {
        return Math.log10(arg);
    }
}