package vn7.studio.com.integrator.operation;

import java.util.ArrayList;

import vn7.studio.com.integrator.OperationExtremeFragment;
import vn7.studio.com.integrator.OperationFunctionInPointFragment;
import vn7.studio.com.integrator.OperationFunctionRootFragment;
import vn7.studio.com.integrator.OperationGraphFragment;
import vn7.studio.com.integrator.OperationInputCalculatorFragment;
import vn7.studio.com.integrator.OperationInputFunctionFragment;
import vn7.studio.com.integrator.OperationRowsFragment;

public enum IntegratorOperationType {
    CALCULATOR          ("calc",        "Калькулятор",          OperationInputCalculatorFragment.class, false),
    FUNCTION_INPUT      ("func",        "Function",             OperationInputFunctionFragment.class,   true),
    FUNCTION_IN_POINT   ("f_in_point",  "Функція в точці",      OperationFunctionInPointFragment.class, false),
    EXTREME             ("extreme",     "Екстремуми функції",   OperationExtremeFragment.class,         false),
    FUNCTION_ROOT       ("f_root",      "Корінь функції",       OperationFunctionRootFragment.class,    false),
    GRAPH               ("graph",       "Графік функції",       OperationGraphFragment.class,           true),
    ROWS                ("rows",        "Ряди",                 OperationRowsFragment.class,            false);

    IntegratorOperationType(String key, String name, Class fragmentClass, boolean isIgnored) {
        this.key = key;
        this.name = name;
        this.fragmentClass = fragmentClass;
        this.isIgnored = isIgnored;
    }

    public static IntegratorOperationType[] getValuesWithoutIgnored(){
        ArrayList<IntegratorOperationType> vals = new ArrayList<>();
        for (IntegratorOperationType op : IntegratorOperationType.values()){
            if(!op.isIgnored) vals.add(op);
        }

        IntegratorOperationType[] values = new IntegratorOperationType[vals.size()];
        for (int i = 0; i < vals.size(); i++) {
            values[i] = vals.get(i);
        }
        return values;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public Class getFragmentClass() {
        return fragmentClass;
    }

    public boolean isIgnored() {
        return isIgnored;
    }

    private String key;
    private String name;
    private Class fragmentClass;
    private boolean isIgnored;
}
