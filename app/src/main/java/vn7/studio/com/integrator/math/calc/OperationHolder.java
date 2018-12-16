package vn7.studio.com.integrator.math.calc;

import vn7.studio.com.integrator.math.operation.Operation;

public abstract class OperationHolder<T> {
    public static <T extends Operation> T findOperation(String arg){
        return null;
    }
}
