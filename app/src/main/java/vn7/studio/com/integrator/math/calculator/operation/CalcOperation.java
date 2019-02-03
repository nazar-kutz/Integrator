package vn7.studio.com.integrator.math.calculator.operation;

import vn7.studio.com.integrator.math.operation.Operation;
import vn7.studio.com.integrator.math.operation.OperationSign;

public abstract class CalcOperation implements Operation<Double> {
    protected OperationSign sign = OperationSign.POSITIVE;
    public abstract Double execute();

    public OperationSign getSign() {
        return sign;
    }

    public void setSign(OperationSign sign) {
        this.sign = sign;
    }
}
