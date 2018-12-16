package vn7.studio.com.integrator.math.calculator.operation;

import vn7.studio.com.integrator.math.operation.Operation;

public abstract class CalcOperation implements Operation<Double> {
    public abstract Double execute();

    public abstract String getRegex();
}
