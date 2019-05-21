package vn7.studio.com.integrator;

import java.util.List;

import vn7.studio.com.integrator.math.calculator.cord.Cord2D;
import vn7.studio.com.integrator.math.calculator.operation.CalcOperationHolder;
import vn7.studio.com.integrator.math.operation.Operation;
import vn7.studio.com.integrator.math.operation.OperationType;

public class Tester {
    final static public String BIG_FUNCTION = "-(22-45*sin(24)/ln(20*14)+15/44-22/cos(20*sin(20)))+44-24/cos(48/14)+22*(549-tan(25)*23425)-25*cos(2452)+sin(((34*22)-25))+49-14*fac(2)^2";
    final static public String BIG_FUNCTION_X = "-(x-45*sin(24)/ln(x*14)+15/44-22/cos(x*sin(20)))+x*2-24/cos(x/14)+22*(x-tan(25)*23425)-25*cos(2452)+sin(((34*22)-25))+x-14*fac(2)^2";

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

        /*MathCalcAlgorithm mca = new MathCalcAlgorithm();
        //System.out.println(mca.findFunctionForArgument("sqrt(x)", 25));

        List<Cord2D> coords = mca.findFunctionOnRange("x+1",-5.0, 5.0, 5000.0);
        showOnDiapason( coords);

        CordExtremum2D extremum = mca.findMinMax(coords);
        System.out.println(" min: "+extremum.getMin() + " max: " + extremum.getMax());*/

        String[] operations = OperationType.DIVIDE.getDescriptions();
        for(String op : operations){
            System.out.println(op);
        }
    }

    private static void doMegaOperation(CalcOperationHolder holder){
        Operation operation = holder.findOperation("-(22-45*sin(24)/ln(20*14)+15/44-22/cos(20*sin(20)))+44-24/cos(48/14)+22*(549-tan(25)*23425)-25*cos(2452)+sin(((34*22)-25))+49-14*fac(2)^2");
        System.out.println(operation.execute());
    }

    public static void showOnDiapason(List<Cord2D> list){
        for (int i = 0; i < list.size(); i++) {
            Cord2D c2d = list.get(i);
            System.out.println("(x = " + c2d.getX() + " ; " + "y = " + c2d.getY() + ")");
        }
    }
}
