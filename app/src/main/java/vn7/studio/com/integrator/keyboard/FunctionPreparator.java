package vn7.studio.com.integrator.keyboard;

import java.util.ArrayList;

import vn7.studio.com.integrator.math.operation.OperationType;

public class FunctionPreparator {
    private ArrayList<String> functionFragments;
    private ArrayList<String> tempFragments;

    private FunctionPreparator() {
        functionFragments = new ArrayList<>();
        tempFragments = new ArrayList<>();
    }

    public static FunctionPreparator getInstance(){
        return InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder{
        private final static FunctionPreparator INSTANCE = new FunctionPreparator();
    }

    public void addElement(String input) {
        if (OperationType.isBinary(input)) {
            if (tempFragments.size() == 0) {
                if (!input.equals("-")) {
                    return;
                }
            } else if (tempFragments.size() == 1 && tempFragments.get(0).equals("-")) {
                if(!input.equals("-")) {
                    removeLastInput();
                }
                return;
            } else {
                String lastOperation = tempFragments.get(tempFragments.size() - 1);
                if (OperationType.isBinary(lastOperation)) {
                    removeLastInput();
                }
            }
        } else if (input.equals(".")) {
            if (tempFragments.size() == 0) {
                return;
            } else {
                String lastOperation = tempFragments.get(tempFragments.size() - 1);
                if (!OperationType.isNumber(lastOperation)) {
                    input = "";
                }
            }
        }
        tempFragments.add(input);
    }

    public boolean lastElementIs(String text) {
        return (tempFragments.get(tempFragments.size() - 1).equals(text));
    }

    public void removeLastInput() {
        if (tempFragments.size() > 0) {
            tempFragments.remove(tempFragments.size() - 1);
        }
    }

    public void confirmChanges() {
        functionFragments = (ArrayList<String>) tempFragments.clone();
    }

    public void refreshTmp(){
        tempFragments = (ArrayList<String>) functionFragments.clone();
    }

    public void startEditing(){
        tempFragments.clear();
        tempFragments = (ArrayList<String>) functionFragments.clone();
    }

    public String getFunction() {
        return prepareFunciton(functionFragments);
    }

    public String getTmpFunction() {
        return prepareFunciton(tempFragments);
    }

    private String prepareFunciton(ArrayList<String> fElements){
        StringBuilder sb = new StringBuilder();
        for (String fragment : fElements) {
            sb.append(fragment);
        }
        return sb.toString();
    }
}