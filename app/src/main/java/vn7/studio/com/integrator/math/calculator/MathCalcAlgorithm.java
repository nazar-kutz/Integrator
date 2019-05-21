package vn7.studio.com.integrator.math.calculator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import vn7.studio.com.integrator.math.calculator.cord.Cord2D;
import vn7.studio.com.integrator.math.calculator.cord.CordExtreme2D;
import vn7.studio.com.integrator.math.calculator.operation.CalcOperation;
import vn7.studio.com.integrator.math.calculator.operation.CalcOperationHolder;

public class MathCalcAlgorithm {

    private MathCalcAlgorithm() {
    }

    public static Double calculate(String function) {
        CalcOperationHolder holder = new CalcOperationHolder();
        CalcOperation f = holder.findOperation(function);
        return f.execute();
    }

    public static Double findFunctionForArgument(String function, Double arg) {
        StringBuilder sb = new StringBuilder();
        char[] chars = function.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'x') {
                //start
                if (i == 0 && (i == chars.length - 1 || !Character.isLetter(chars[i + 1]))) {
                    sb.append(arg);
                }
                //end
                else if (i == chars.length - 1 && !Character.isLetter(chars[i - 1])) {
                    sb.append(arg);
                }
                //medium
                else if (!Character.isLetter(chars[i - 1]) && !Character.isLetter(chars[i + 1])) {
                    sb.append(arg);
                } else {
                    sb.append(chars[i]);
                }
            } else {
                sb.append(chars[i]);
            }
        }
        return calculate(sb.toString());
    }

    public static List<Cord2D> findFunctionOnRange(String function, Double start, Double end, Integer pointsNumber) {
        ArrayList<Cord2D> list = new ArrayList<>();
        double step = (end - start) / pointsNumber;
        for (double x = start, s = 0; s <= pointsNumber; x += step, s++) {
            Cord2D c2d = new Cord2D(x, findFunctionForArgument(function, x));
            list.add(c2d);
        }
        return list;
    }

    public static CordExtreme2D findMinMax(String function, Double fromX, Double toX, Integer pointsNumber) {
        double xMin, yMin, xMax, yMax;
        double step = (toX - fromX) / pointsNumber;

        double x = fromX;

        xMin = xMax = x;
        yMax = Double.NEGATIVE_INFINITY;
        yMin = Double.POSITIVE_INFINITY;

        for (int s = 0; s <= pointsNumber; x += step, s++) {
            double y = findFunctionForArgument(function, x);
            if (!Double.isInfinite(y)) {
                if (y < yMin) {
                    yMin = y;
                    xMin = x;
                }
                if (y > yMax) {
                    yMax = y;
                    xMax = x;
                }
            }
        }

        Cord2D min = new Cord2D(xMin, yMin);
        Cord2D max = new Cord2D(xMax, yMax);

        return new CordExtreme2D(min, max);
    }

    public static Cord2D findMaxY(List<Cord2D> coords) {
        return Collections.max(coords, new Comparator<Cord2D>() {
            @Override
            public int compare(Cord2D cord2D1, Cord2D cord2D2) {
                if (cord2D1.getY() > cord2D2.getY()) {
                    return 1;
                } else if (cord2D1.getY() > cord2D2.getY()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }

    public static Cord2D findMinY(List<Cord2D> list) {
        return Collections.min(list, new Comparator<Cord2D>() {
            @Override
            public int compare(Cord2D cord2D1, Cord2D cord2D2) {
                if (cord2D1.getY() > cord2D2.getY()) {
                    return -1;
                } else if (cord2D1.getY() > cord2D2.getY()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

    public static Double findFunctionRootOnRangeDichotomy(String function, Double start, Double end, Integer pointsNumber) {
        double accuracy = Math.abs((end - start) / pointsNumber);
        if (findFunctionForArgument(function, start) * findFunctionForArgument(function, end) < 0) {
            while (Math.abs(end - start) > accuracy) {
                Double medium = (start + end) / 2;
                if (findFunctionForArgument(function, start) * findFunctionForArgument(function, medium) > 0) {
                    start = medium;
                } else {
                    end = medium;
                }
            }
            return start;
        }
        return null;
    }

    public static Double progressionSum(String function, Integer from, Integer to) {
        Double result = 0.0;
        for (int i = from; i <= to; i++) {
            Double current = findFunctionForArgument(function, (double) i);
            if (current != null && !Double.isInfinite(current)) {
                result += current;
            }
        }
        return result;
    }

    public static Double progressionMultiply(String function, Integer from, Integer to) {
        Double result = 1.0;
        for (int i = from; i <= to; i++) {
            Double current = findFunctionForArgument(function, (double) i);
            if (current != null && !Double.isInfinite(current)) {
                if (current != 0) {
                    result *= current;
                }
            }
        }
        return result;
    }
}
