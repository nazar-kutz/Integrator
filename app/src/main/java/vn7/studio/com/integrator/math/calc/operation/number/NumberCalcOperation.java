package vn7.studio.com.integrator.math.calc.operation.number;

import vn7.studio.com.integrator.math.calc.operation.CalcOperation;

public class NumberCalcOperation extends CalcOperation {
    private String arg;

    @Override
    public Double execute() {
        return Double.valueOf(arg);
    }

    public String getArg() {
        return arg;
    }

    public void setArg(String arg) {
        this.arg = arg;
    }
}
