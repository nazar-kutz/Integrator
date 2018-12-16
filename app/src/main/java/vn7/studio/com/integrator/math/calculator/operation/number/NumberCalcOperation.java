package vn7.studio.com.integrator.math.calculator.operation.number;

import vn7.studio.com.integrator.math.calculator.operation.CalcOperation;

public class NumberCalcOperation extends CalcOperation {
    private String argument;

    @Override
    public Double execute() {
        return Double.valueOf(argument);
    }

    @Override
    public String getRegex() {
        return null;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String arg) {
        this.argument = arg;
    }
}
