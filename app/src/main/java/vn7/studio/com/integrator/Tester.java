package vn7.studio.com.integrator;

import java.util.Calendar;

import vn7.studio.com.integrator.math.calculator.factory.CalcOperationFactory;
import vn7.studio.com.integrator.math.calculator.operation.CalcOperation;
import vn7.studio.com.integrator.math.calculator.operation.CalcOperationHolder;
import vn7.studio.com.integrator.math.calculator.operation.binary.BinaryCalcOperation;
import vn7.studio.com.integrator.math.operation.Operation;
import vn7.studio.com.integrator.math.operation.OperationType;

public class Tester {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        CalcOperationHolder holder = new CalcOperationHolder();
        //Operation operation = holder.findOperation("4+(cos(15*2)-ln(15)/(12*4))");
        //Operation operation = holder.findOperation("cos(15*2)-ln(15)/(12*4)");
        //Operation operation = holder.findOperation("3-2+(19*4)-(2+12)");
        //Operation operation = holder.findOperation("-3-2+(19*4)-(2+12)");
        //Operation operation = holder.findOperation("22-45*sin(24)/ln(20*14)+15/44-22/cos(20)");
        /*Operation operation = holder.findOperation("549-tan((25)*23425)");
        System.out.println(operation.execute());*/

        //doMegaOperation(holder);
    }

    private static void doMegaOperation(CalcOperationHolder holder){
        Operation operation = holder.findOperation("-(22-45*sin(24)/ln(20*14)+15/44-22/cos(20*sin(20)))+44-24/cos(48/14)+22*(549-tan(25)*23425)-25*cos(2452)+sin(((34*22)-25))+49-14*fac(2)^2");
        System.out.println(operation.execute());
    }
}
